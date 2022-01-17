package model;

public class Employee extends Person {
    private long id;
    private String department;
    private long salaryGrape;
    private String timeIn = "";
    private String timeOut = "";
    private long hour;
    private double salary;
    private String feedback;
    private String writeAt;
    private String more;
    private String reason;
    private double number;
    private String timeSent;

    public Employee() {
    }

    public Employee(long id, String department, long salaryGrape, long hour) {
        this.id = id;
        this.department = department;
        this.salaryGrape = salaryGrape;
        this.hour = hour;
    }

    public Employee(long id, String fullName, String date, String address, String hometown, String nation, String department, long salaryGrape, long hour) {
        super(fullName, date, address, hometown, nation);
        this.id = id;
        this.department = department;
        this.salaryGrape = salaryGrape;
        this.hour = hour;
    }
    public Employee(String feedback, String writeAt) {
        this.feedback = feedback;
        this.writeAt = writeAt;
    }
    public Employee(long id, String fullName, String feedback, String writeAt) {
        super(fullName);
        this.id = id;
        this.feedback = feedback;
        this.writeAt = writeAt;
    }
    public Employee(long id, String fullName, String department, String reason, double number, String timeSent) {
        super(fullName);
        this.id = id;
        this.department = department;
        this.reason = reason;
        this.number = number;
        this.timeSent = timeSent;
    }
    public Employee(long id, String timeIn, String timeOut) {
        this.id = id;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalaryGrape() {
        return salaryGrape;
    }

    public void setSalaryGrape(long salaryGrape) {
        this.salaryGrape = salaryGrape;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getWriteAt() {
        return writeAt;
    }

    public void setWriteAt(String writeAt) {
        this.writeAt = writeAt;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public void OutputEmployee() {
        System.out.printf("| %10s", getId());
        super.OutputPerson();
        System.out.printf("%25s %15s %6s |", getDepartment(), getSalaryGrape(), getHour());
    }
    public void OutputEmployeeSumary() {
        System.out.printf("| %10s", getId());
        super.OutputPerson();
        System.out.printf("%25s %15s %6s", getDepartment(), getSalaryGrape(), getHour());
    }
    public void OutputEmployee1() {
        System.out.println("\t\tId: " + getId());
        super.OutputPerson1();
        System.out.println("\t\tDepartment: " + getDepartment());
        System.out.println("\t\tSalary Grape: " + getSalaryGrape());
        System.out.println("\t\tHour: " + getHour());
    }
    public void OutputEmployeeTree() {
        System.out.println("\t\tId: " + getId());
        super.OutputPersonTree();
        System.out.println("\t\tDepartment: " + getDepartment());
        System.out.println("\t\tSalary Grape: " + getSalaryGrape());
        System.out.println("\t\tHour: " + getHour());
    }
    public void OutputMessage() {
        System.out.println("\tId: " + getId());
        System.out.println("\tFullname: " + getFullName());
        System.out.println("\tReason: " + getReason());
        System.out.println("\tNumber: " + getNumber());
        System.out.println("\tTime sent: " + getTimeSent());
        System.out.println("-------------------------------------");
    }
    public void OutputFeedbackPublic() {
        System.out.println("\tId: " + getId());
        System.out.println("\tFullname: " + getFullName());
        System.out.println("\tFeedback: " + getFeedback());
        System.out.println("\tWrite at: " + getWriteAt());
        System.out.println("-------------------------------------");
    }
    public void OutputFeedbackPrivate() {
        System.out.println("\tFeedback: " + getFeedback());
        System.out.println("\tWrite at: " + getWriteAt());
        System.out.println("-------------------------------------");
    }
}


