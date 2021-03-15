package by.tc.library.bean;

import java.util.Objects;

public class ClientInfo extends UserInfo {
    private String photoAddress;

    public ClientInfo(String username, String telephone, String password,
                      String email, String name, String surname, boolean isAdmin,String photoAddress) {
        super(username,telephone,password,email,name,surname,isAdmin);
        this.photoAddress = photoAddress;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientInfo that = (ClientInfo) o;
        return photoAddress.equals(that.photoAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), photoAddress);
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "photoAddress='" + photoAddress + '\'' +
                '}';
    }
}
