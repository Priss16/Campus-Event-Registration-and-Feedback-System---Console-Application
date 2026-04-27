package Campus.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtil {

    public static void writeToFile(String fileName, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("File Write Error");
        }
    }

    public static ArrayList<String> readFromFile(String fileName) {

    ArrayList<String> data = new ArrayList<>();

    try {
        File file = new File(fileName);

        if (!file.exists()) return data;

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            data.add(sc.nextLine());
        }

        sc.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return data;
}
}