package ss17_io_binary_file_serialization.thuc_hanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files (File source, File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter source file: ");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file: ");
        String destPath = in.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingStream(sourceFile,destFile);
            System.out.println("Copy completed");
        }
        catch (IOException e) {
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }
}
