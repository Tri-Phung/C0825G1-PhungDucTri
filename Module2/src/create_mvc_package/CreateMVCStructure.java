package create_mvc_package;

import java.io.File;
import java.util.Scanner;

public class CreateMVCStructure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập đường dẫn
        System.out.print("Nhập đường dẫn nơi bạn muốn tạo package: ");
        String path = scanner.nextLine();

        // Danh sách các package con cần tạo
        String[] subPackages = {
                "common", "controller", "data", "entity", "repository", "service", "view"
        };

        // Tạo các package
        for (String subPackage : subPackages) {
            createPackage(path, subPackage);
        }

        System.out.println("Đã tạo các package MVC thành công.");
    }

    // Hàm tạo package
    public static void createPackage(String basePath, String packageName) {
        // Tạo đường dẫn cho package
        String packagePath = basePath + File.separator + packageName;

        // Tạo thư mục package
        File packageDir = new File(packagePath);
        if (!packageDir.exists()) {
            if (packageDir.mkdirs()) {
                System.out.println("Đã tạo package: " + packageName);
            } else {
                System.out.println("Không thể tạo package: " + packageName);
            }
        } else {
            System.out.println("Package đã tồn tại: " + packageName);
        }
    }
}

