package ss17_io_binary_file_serialization.bai_tap.view;

import ss17_io_binary_file_serialization.bai_tap.common.exception.IdDuplicatedException;
import ss17_io_binary_file_serialization.bai_tap.common.validate.Validate;
import ss17_io_binary_file_serialization.bai_tap.controller.ProductManagementController;
import ss17_io_binary_file_serialization.bai_tap.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static ProductManagementController controller = new ProductManagementController();

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ứng dụng quản lý sản phầm");
        while (true) {
            System.out.println("Nhập vào lựa chọn của bạn:");
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Hiển thị danh sách sản phẩm");
            System.out.println("3.Tìm kiếm thông tin sản phẩm");
            System.out.println("4. Tìm bằng tên sản phẩm");
            System.out.println("0.Kết thúc");

            int choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1:
                    Product product = inputProduct();
                    controller.addProduct(product);
                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 2:
                    List<Product> productList = controller.getAllProducts();
                    displayProductList(productList);
                    break;
                case 3:
                    int id = Validate.inputInteger("mã sản phẩm");
                    List<Product> products = new ArrayList<>();
                    Product productToFind = controller.findProductById(id);
                    if (productToFind == null) {
                        System.out.println("không tìm thấy sản phẩm");
                    }
                    else {
                        products.add(controller.findProductById(id));
                        displayProductList(products);
                    }
                    break;
                case 4:
                    System.out.print("Nhập vào tên muốn tìm:");
                    String findName = sc.next();
                    List<Product> found = controller.findByName(findName);
                    if (found.isEmpty()) {
                        System.out.println("Product not found");
                    } else {
                        System.out.println("Search result:");
                        displayProductList(found);
                    }
                    break;
                case 0:
                    System.out.println("Kết thúc");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Nhập không hợp lệ");
            }
        }
    }

    public static Product inputProduct() {
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            try {
                id = Validate.inputInteger("Mã sản phẩm");
                controller.IdCheckDuplicate(id);
                break;
            } catch (IdDuplicatedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập tên sản phẩm:");
        String name = sc.nextLine();
        double price = Validate.inputDouble("giá sản phẩm");
        System.out.println("Nhập hãng sản xuất:");
        String brand = sc.nextLine();
        System.out.println("Nhập mô tả sản phẩm:");
        String description = sc.nextLine();
        return new Product(id, name, price, brand, description);
    }

    public static void displayProductList(List<Product> productList) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-30s %-20s %-10s %-50s\n", "Mã sản phẩm", "Tên", "Giá", "Hãng", "Mô tả"));
        sb.append("--------------------------------------------------------------------------------------------\n");
        for (Product product : productList) {
            sb.append(String.format("%-15s %-30s %-20s %-10s %-50s\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getBrand(),
                    product.getDescription()
            ));
        }
        System.out.println(sb);
    }
}
