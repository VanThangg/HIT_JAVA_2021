package model;

public class Person {
    private String fullName;
    private String name;
    private String date;
    private String address;
    private String hometown;
    private String nation;

    public Person() {
    }


    public Person(String fullName, String date, String address, String hometown, String nation) {
        this.fullName = fullName;
        this.date = date;
        this.address = address;
        this.hometown = hometown;
        this.nation = nation;
    }
    public Person(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void OutputPerson() {
        System.out.printf("%25s %15s %25s %25s %25s", getFullName(), getDate(), getAddress(), getHometown(), getNation());
    }
    public void OutputPerson1() {
        System.out.println("\t\tFullname: " + getFullName());
        System.out.println("\t\tDate: " + getDate());
        System.out.println("\t\tAddress: " + getAddress());
        System.out.println("\t\tHometown: " + getHometown());
        System.out.println("\t\tNation: " + getNation());
    }
    public void OutputPersonTree() {
        System.out.println("\t\tFullname: " + getFullName());
        System.out.println("\t\tDate: " + getDate());
        System.out.println("\t\tAddress: " + getAddress());
        System.out.println("\t\tHometown: " + getHometown());
        System.out.println("\t\tNation: " + getNation());
    }

}

