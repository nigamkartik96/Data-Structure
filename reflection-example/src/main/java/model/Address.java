package model;

public class Address {

    private String street;
    private String houseNo;

    public Address(String street, String houseNo) {
        this.street = street;
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNo='" + houseNo + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public Address() {
    }
}
