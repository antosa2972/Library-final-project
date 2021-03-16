package by.tc.library.service.impl;

import by.tc.library.bean.UserInfo;
import by.tc.library.dao.DAOException;
import by.tc.library.dao.DAOProvider;
import by.tc.library.dao.DAOUser;
import by.tc.library.service.ServiceException;
import by.tc.library.service.UserService;
import by.tc.library.service.validator.UserValidator;
import by.tc.library.service.validator.ValidatorProvider;

public class UserServiceImpl implements UserService {
    @Override
    public boolean registration(UserInfo userInfo) throws ServiceException {
        ValidatorProvider validatorProvider = ValidatorProvider.getInstance();
        UserValidator userValidator = validatorProvider.getUserValidator();

        DAOProvider daoProvider = DAOProvider.getInstance();
        DAOUser daoUser = daoProvider.getDaoUser();

        try {
            if(userValidator.checkRegData(userInfo)){
                try {
                    boolean reg_success = daoUser.registration(userInfo);
                    return reg_success;
                }catch (DAOException e){
                    throw new ServiceException("Error while registration" + e.getMessage());
                }
            }
        }catch (ServiceException e){
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public UserInfo authorization(UserInfo userInfo) throws ServiceException {
        ValidatorProvider validatorProvider = ValidatorProvider.getInstance();
        UserValidator userValidator = validatorProvider.getUserValidator();

        DAOProvider daoProvider = DAOProvider.getInstance();
        DAOUser daoUser = daoProvider.getDaoUser();
        UserInfo authorizedUser = null;
        try{
            if(userValidator.checkAuthData(userInfo)){
                try {
                    authorizedUser = daoUser.authorization(userInfo);
                }catch (DAOException e){
                    throw new ServiceException("Error while authorization" + e.getMessage());
                }
                if (authorizedUser == null){
                    throw new ServiceException("Invalid login or password");
                }
            }
        }catch (ServiceException e){
            throw new ServiceException(e);
        }
        return authorizedUser;
    }
}
