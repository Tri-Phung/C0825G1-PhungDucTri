package ss17_io_binary_file_serialization.bai_tap.copy_file_binary;

import java.io.*;
import java.util.Scanner;

public class CopyFileBinary {
    static int copyFile(File source, File destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            int totalByteCopied = 0;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
                totalByteCopied += length;
            }
            return totalByteCopied;
        }
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter source file: ");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file: ");
        String destPath = in.nextLine();
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            System.out.println("File not found");
            return;
        }
        File destFile = new File(destPath);
        if (destFile.exists()) {
            System.out.println("File already exists");
            return;
        }
        try {
            int totalByteCopied = copyFile(sourceFile, destFile);
            System.out.println("Copying successful");
            System.out.println("Total byte copied: " + totalByteCopied);
        } catch (IOException e) {
            System.out.println("Copying error");
        }
    }
}
