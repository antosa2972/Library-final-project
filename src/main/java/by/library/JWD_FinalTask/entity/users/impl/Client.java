package by.library.JWD_FinalTask.entity.users.impl;

import by.library.JWD_FinalTask.entity.users.User;

import java.util.Objects;

public class Client implements User {
    private String username;
    private String telephone;
    private String password;
    private String email;
    private String name;
    private String surname;

    public Client(String username, String telephone, String password, String email, String name, String surname) {
        this.username = username;
        this.telephone = telephone;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return username.equals(client.username) && telephone.equals(client.telephone) && password.equals(client.password) && email.equals(client.email) && name.equals(client.name) && surname.equals(client.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, telephone, password, email, name, surname);
    }
}