package Campus.model;

public class Student extends User {
    private String regNo;
    private String dept;
    private String password;

    public Student(String name, String regNo, String dept, String phone, String password) {
        super(name, phone);
        this.regNo = regNo;
        this.dept = dept;
        this.password = password;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getPassword() {
        return password;
    }

    public void displayStudent() {
        System.out.println("RegNo: " + regNo +
                ", Name: " + name +
                ", Dept: " + dept +
                ", Phone: " + phone);
    }

    public String toFileString() {
    return "----- STUDENT -----\n" +
           "Name       : " + name + "\n" +
           "RegNo      : " + regNo + "\n" +
           "Department : " + dept + "\n" +
           "Phone      : " + phone + "\n" +
           "Password   : " + password + "\n" +
           "--------------------";
    }
}