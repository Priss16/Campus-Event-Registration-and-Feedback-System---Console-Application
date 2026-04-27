package Campus.model;

import java.util.HashMap;
import Campus.util.InputOperations;

public class StudentAuth {

    public Student login(HashMap<String, Student> studentMap) {

        System.out.println("===== STUDENT LOGIN =====");

        System.out.print("Enter RegNo: ");
        String regNo = InputOperations.sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = InputOperations.sc.nextLine();

        Student s = studentMap.get(regNo);

        if (s != null && s.getPassword().equals(pass)) {
            System.out.println("--Login Successful--");
            return s;
        }

        System.out.println("Invalid Credentials");
        return null;
    }
}