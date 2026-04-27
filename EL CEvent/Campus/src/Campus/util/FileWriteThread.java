package Campus.util;

public class FileWriteThread extends Thread {

    String fileName, data;

    public FileWriteThread(String fileName, String data) {
        this.fileName = fileName;
        this.data = data;
    }

    public void run() {
        FileUtil.writeToFile(fileName, data);
        System.out.println("(Saved in background...)");
    }
}