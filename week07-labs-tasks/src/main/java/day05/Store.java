package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        validateProduct(product);
        products.add(product);
    }

    public void writeProductsSoldToFileByMonth(Path path, Month month) {
        writeProductsToFile(path, getProductsSoldByMonth(month));
    }

    private List<Product> getProductsSoldByMonth(Month month) {
        List<Product> productsByMonth = new ArrayList<>();
        for (Product product : products) {
            if (product.getDateSold().getMonth() == month) {
                productsByMonth.add(product);
            }
        }
        return productsByMonth;
    }

    private void writeProductsToFile(Path path, List<Product> products) {
        List<String> lines = new ArrayList<>();
        for (Product product : products) {
            lines.add(product.getName() + ';' + product.getDateSold().toString() + ';' + product.getPrice());
        }
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateProduct(Product product) {
        if (product.getDateSold().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date sold cannot be after current date.");
        }
    }
}
