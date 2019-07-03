package model;

import java.util.List;

public class User {
    private String name;
    private String email;

    private List<Address> addressList;
    private Qualification qualification;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addressList=" + addressList +
                ", qualification=" + qualification +
                '}';
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public User(String name, String email, List<Address> addressList, Qualification qualification) {
        this.name = name;
        this.email = email;
        this.addressList = addressList;
        this.qualification = qualification;
    }
}
