package ss16_io_text_file.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndDisplayCountry {
    public List<Country> readFile(String filePath) {
        List<Country> countries = new ArrayList<>();
        File file = new File(filePath);
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String line;
            String[] data;
            Country country;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                country = new Country(Integer.parseInt(data[0]),data[1],data[2]);
                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Read file error");;
        }
        return countries;
    }
    public void displayCountries(List<Country> countries) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-3s %-5s %-20s\n", "ID", "Code", "Name"));
        sb.append("--------------------------\n");

        for (Country country : countries) {
            sb.append(String.format("%-3s %-5s %-20s\n",
                    country.getId(),
                    country.getCode(),
                    country.getName()));
        }

        System.out.println(sb);
    }

    static void main() {
        ReadAndDisplayCountry readCountry = new ReadAndDisplayCountry();
        List<Country> countryList = readCountry.readFile("src/ss16_io_text_file/bai_tap/country.csv");
        System.out.println("Display countries:");
        readCountry.displayCountries(countryList);
    }
}
