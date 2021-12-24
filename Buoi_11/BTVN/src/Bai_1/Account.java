package Bai_1;

public class Account implements Comparable<Account> {
    private long id;
    private String fullName;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String creatAt;

    public Account() {
    }

    public Account(long id, String fullName, String userName, String password, String email, String phone, String creatAt) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.creatAt = creatAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public void Xuat() {
        System.out.printf("%5s %30s %20s %20s %15s %25s", getId(), getFullName(), getUserName(), getEmail(), getPhone(), getCreatAt());
        System.out.println();
    }
    public void Xuat1() {
        System.out.println("Id: " + getId());
        System.out.println("Full name: " + getFullName());
        System.out.println("Username: " + getUserName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Create at: " + getCreatAt());
    }

    @Override
    public int compareTo(Account o) {
        return getUserName().compareTo(o.getUserName());
    }
}
