package by.tc.library.bean;

import java.util.Objects;

public class UserInfo {
    private String username;
    private String telephone;
    private String password;
    private String email;
    private String name;
    private String surname;
    private boolean isAdmin;

    public UserInfo(String username, String telephone, String password,
                    String email, String name, String surname, boolean isAdmin) {
        this.username = username;
        this.telephone = telephone;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }
    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return isAdmin == userInfo.isAdmin && username.equals(userInfo.username) && telephone.equals(userInfo.telephone) && password.equals(userInfo.password) && email.equals(userInfo.email) && name.equals(userInfo.name) && surname.equals(userInfo.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, telephone, password, email, name, surname, isAdmin);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
