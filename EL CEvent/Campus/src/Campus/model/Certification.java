package Campus.model;

public class Certification {

    public static void generate(String name, String event) {

        System.out.println("\n========= CERTIFICATE =========");
        System.out.println("This is to certify that");
        System.out.println(name);
        System.out.println("has successfully participated in");
        System.out.println(event);
        System.out.println("================================\n");
    }
}