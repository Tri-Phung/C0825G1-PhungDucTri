package ss16_io_text_file.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
    public List<String> readFile(String filePath) {
        List<String> content = new ArrayList<>();
        File file = new File(filePath);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            ;
        } catch (IOException e) {
            System.out.println("Read file error");
            ;
        }
        return content;
    }

    public void writeFile(String filePath, List<String> content) {
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw);) {
            for (String line : content) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Write file error");
        }
    }

    static void main() {
        CopyFile copyContent = new CopyFile();
        Scanner sc = new Scanner(System.in);
        String inputPath = "D:\\codegym\\C0825G1-PhungDucTri\\Module2\\src\\ss16_io_text_file\\bai_tap\\input.txt";
        String outputPath = "D:\\codegym\\C0825G1-PhungDucTri\\Module2\\src\\ss16_io_text_file\\bai_tap\\output.txt";
        List<String> content = copyContent.readFile(inputPath);
        if (new File(outputPath).exists()) {
            while(true) {
                System.out.println("File already exists. Do you want to overwrite it?");
                String choice = sc.nextLine();
                switch (choice) {
                    case "y":
                        System.out.println("Overwriting...");
                        copyContent.writeFile(outputPath, content);
                        break;
                    case "n":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        continue;
                }
                break;
            }
        }
        else {
            System.out.println("Writing...");
            copyContent.writeFile(outputPath, content);
        }
        System.out.println("Done");
    }
}