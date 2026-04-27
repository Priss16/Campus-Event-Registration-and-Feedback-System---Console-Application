package Campus.main;

import Campus.util.*;
import Campus.model.*;
import Campus.exception.*;

import java.util.*;

public class Main {

    static ArrayList<Student> studentList = new ArrayList<>();

    // ✅ ADDED HASHMAP (no change to existing logic)
    static HashMap<String, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {

        loadStudents();

        Admin admin = new Admin();
        StudentAuth studentAuth = new StudentAuth();

        while (true) {

            System.out.println("\n===== LOGIN MENU =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Student Sign Up"); 
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(InputOperations.sc.nextLine());
            
            switch (choice) {

                case 1:
                    if (admin.login()) {
                        adminMenu();
                    }
                    break;

                case 2:
                    // ✅ ONLY CHANGE HERE
                    Student s = studentAuth.login(studentMap);
                    if (s != null) {
                        studentMenu(s);
                    }
                    break;

                case 3:
                    studentSignUp(); 
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }

    // ================= STUDENT SIGN UP =================
    static void studentSignUp() {

        try {
            System.out.println("\n===== STUDENT SIGN UP =====");

            System.out.print("Enter Name: ");
            String name = InputOperations.sc.nextLine();

            System.out.print("Enter Register Number: ");
            String regNo = InputOperations.sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = InputOperations.sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = InputOperations.sc.nextLine();
            PhoneValidator.validate(phone);

            System.out.print("Create Password: ");
            String pass = InputOperations.sc.nextLine();

            Student s = new Student(name, regNo, dept, phone, pass);

            studentList.add(s);

            // ✅ ADDED
            studentMap.put(regNo, s);

            FileWriteThread t = new FileWriteThread("students.txt", s.toFileString());
            t.start();

            System.out.println("--Sign Up Successful! Now login.--");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= ADMIN MENU =================
    static void adminMenu() {

        while (true) {

            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Student Registration");
            System.out.println("2. View Registered Students");
            System.out.println("3. View Event Registrations");
            System.out.println("4. View Feedback");
            System.out.println("5. Generate Certificate");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(InputOperations.sc.nextLine());

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Student Name: ");
                        String name = InputOperations.sc.nextLine();

                        System.out.print("Enter Register Number: ");
                        String regNo = InputOperations.sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = InputOperations.sc.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phone = InputOperations.sc.nextLine();
                        PhoneValidator.validate(phone);

                        System.out.print("Enter Password: ");
                        String pass = InputOperations.sc.nextLine();

                        Student s = new Student(name, regNo, dept, phone, pass);
                        studentList.add(s);

                        // ✅ ADDED
                        studentMap.put(regNo, s);

                        FileWriteThread t = new FileWriteThread("students.txt", s.toFileString());
                        t.start();

                        System.out.println("--Student Registered Successfully!--");
                        break;

                    case 2:
                        System.out.println("\n--- Registered Students ---");
                        FileUtil.readFromFile("students.txt")
                                .forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("\n--- Event Registrations ---");
                        FileUtil.readFromFile("registrations.txt")
                                .forEach(System.out::println);
                        break;

                    case 4:
                        System.out.println("\n--- Feedback ---");
                        FileUtil.readFromFile("feedback.txt")
                                .forEach(System.out::println);
                        break;

                    case 5:
                        System.out.print("Enter Student Name: ");
                        String n = InputOperations.sc.nextLine();

                        System.out.print("Enter Event Name: ");
                        String e = InputOperations.sc.nextLine();

                        Certification.generate(n, e);
                        break;

                    case 6:
                        System.out.println("Logging out...");
                        return;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ================= STUDENT MENU =================
    static void studentMenu(Student student) {

        while (true) {

            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Event Registration");
            System.out.println("2. Submit Feedback");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(InputOperations.sc.nextLine());

            try {
                switch (choice) {

                    case 1:
                        System.out.println("\n--- Event Registration ---");
                        System.out.println("1. Technical\n2. Cultural\n3. Sports");
                        System.out.print("Enter your choice: ");

                        int typeChoice = InputOperations.sc.nextInt();
                        InputOperations.sc.nextLine();

                        String eventName = "";

                        // ✅ YOUR ORIGINAL LOGIC KEPT
                        if (typeChoice == 1) {
                            System.out.println("1. Workshop\n2. Hackathon\n3. Coding");
                            System.out.print("Enter your event choice: ");
                            int sub = InputOperations.sc.nextInt();
                            InputOperations.sc.nextLine();

                            if (sub == 1) eventName = "Workshop";
                            else if (sub == 2) eventName = "Hackathon";
                            else if (sub == 3) eventName = "Coding";
                        }
                        else if (typeChoice == 2) {
                            eventName = "Cultural Event";
                        }
                        else if (typeChoice == 3) {
                            eventName = "Sports Event";
                        }

                        System.out.print("Enter Event Date (dd-mm-yyyy): ");
                        String date = InputOperations.sc.nextLine();
                        DateValidator.validate(date);

                        Registration reg = new Registration(eventName, student.getRegNo(), date);

                        FileWriteThread t = new FileWriteThread("registrations.txt", reg.toFileString());
                        t.start();

                        System.out.println("--Event Registered Successfully!--");
                        break;

                    case 2:
                        System.out.print("Enter Event Name: ");
                        String en = InputOperations.sc.nextLine();

                        System.out.print("Enter Rating (1-5): ");
                        int rating = InputOperations.sc.nextInt();
                        InputOperations.sc.nextLine();

                        if (rating < 1 || rating > 5)
                            throw new InvalidRatingException("Rating must be between 1 and 5");

                        System.out.print("Enter Comments: ");
                        String comments = InputOperations.sc.nextLine();

                        Feedback f = new Feedback(en, rating, comments);

                        FileWriteThread t2 = new FileWriteThread("feedback.txt", f.toFileString());
                        t2.start();

                        System.out.println("--Feedback Submitted Successfully!--");
                        break;

                    case 3:
                        System.out.println("Logging out...");
                        return;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ================= LOAD =================
    static void loadStudents() {

        ArrayList<String> data = FileUtil.readFromFile("students.txt");

        String name = "", reg = "", dept = "", phone = "", pass = "";

        for (String line : data) {

            if (line.startsWith("Name"))
                name = line.split(":")[1].trim();

            else if (line.startsWith("RegNo"))
                reg = line.split(":")[1].trim();

            else if (line.startsWith("Department"))
                dept = line.split(":")[1].trim();

            else if (line.startsWith("Phone"))
                phone = line.split(":")[1].trim();

            else if (line.startsWith("Password"))
                pass = line.split(":")[1].trim();

            else if (line.contains("-----") && !reg.isEmpty()) {

                Student s = new Student(name, reg, dept, phone, pass);

                studentList.add(s);

                // ✅ ADDED
                studentMap.put(reg, s);

                name = reg = dept = phone = pass = "";
            }
        }
    }
}