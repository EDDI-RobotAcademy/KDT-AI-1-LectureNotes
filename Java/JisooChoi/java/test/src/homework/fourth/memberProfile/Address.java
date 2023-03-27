package homework.fourth.memberProfile;

public class Address {
    private String city;
    private String streetName;
    private String detailAdd;
    private String postalAdd;

    public Address(String city, String streetName, String detailAdd, String postalAdd) {
        this.city = city;
        this.streetName = streetName;
        this.detailAdd = detailAdd;
        this.postalAdd = postalAdd;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getDetailAdd() {
        return detailAdd;
    }

    public String getPostalAdd() {
        return postalAdd;
    }
}
