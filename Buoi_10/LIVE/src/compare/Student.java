package compare;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return getName().compareTo(o.getName());
//        return o.getName().compareTo(getName());
        //theo id

//        if(getId() > o.getId()) {
//            return -1;
//        } else if(getId() < o.getId()) {
//            return 1;
//        }
//        return 0;

//        return getId() - o.getId();
//        return o.getId() - getId();
        // Trả về giá trị dương thì swap
        // Trả về giá trị 0, âm thì không swap
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
