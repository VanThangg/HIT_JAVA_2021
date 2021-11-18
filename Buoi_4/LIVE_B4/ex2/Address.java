package ex2;

public class Address {
    private String ward;
    private String district;
    private String city;

    public Address() {
    }

    public Address(String ward, String district, String city) {
        this.ward = ward;
        this.district = district;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ward='" + ward + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
