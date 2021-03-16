package by.tc.library.bean;

import java.util.Objects;

public class AdministratorInfo extends UserInfo{
    private int id;

    public AdministratorInfo(String username, String telephone, String password,
                             String email, String name, String surname, boolean isAdmin,int id) {
        super(username,telephone,password,email,name,surname,isAdmin);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministratorInfo that = (AdministratorInfo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
