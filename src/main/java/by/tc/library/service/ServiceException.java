package by.tc.library.service;

public class ServiceException extends Exception{

    public ServiceException(){
        super();
    };
    public ServiceException(Throwable cause){
        super(cause);
    }
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
