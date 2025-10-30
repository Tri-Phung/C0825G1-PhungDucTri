package ss16_io_text_file.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("File not found or wrong path or content error");
        }
        return numbers;
    }
    public void writeFile(String filePath, int max) {
        try (FileWriter fw = new FileWriter(filePath,false);
            BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write("Max: " + max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers) {
        int max = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    static void main() {
        ReadAndWriteFile raf = new ReadAndWriteFile();
        List<Integer> numbers = raf.readFile("D:\\codegym\\C0825G1-PhungDucTri\\Module2\\src\\ss16_io_text_file\\thuc_hanh\\number.txt");
        int max = findMax(numbers);
        raf.writeFile("D:\\codegym\\C0825G1-PhungDucTri\\Module2\\src\\ss16_io_text_file\\thuc_hanh\\max.txt", max);
    }
}
