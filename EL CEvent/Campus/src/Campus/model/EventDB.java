package Campus.model;

import java.util.ArrayList;

public class EventDB {

    ArrayList<Student> studentList = new ArrayList<>();

    // Add Student
    public boolean addStudent(Student s) {
        return studentList.add(s);
    }

    // Delete Student
    public boolean deleteStudent(String regNo) {
        return studentList.removeIf(s -> s.getRegNo().equals(regNo));
    }

    // Display All Students
    public void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        for (Student s : studentList) {
            s.displayStudent();
        }
    }

    // Search Student
    public void searchStudent(String regNo) {
        for (Student s : studentList) {
            if (s.getRegNo().equals(regNo)) {
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found");
    }
}
