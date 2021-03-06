package day05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store = new Store();
    List<Product> products = Arrays.asList(
            new Product("apple", LocalDate.of(1990, 1, 1), 30),
            new Product("milk", LocalDate.of(1991, 2, 2), 40),
            new Product("bread", LocalDate.of(1992, 3, 3), 50),
            new Product("butter", LocalDate.of(1993, 2, 4), 60),
            new Product("coke", LocalDate.of(1994, 2, 5), 70),
            new Product("pepsi", LocalDate.of(1995, 3, 6), 80)
    );
    Month month = Month.FEBRUARY;
    String fileName = store.getMonthlyProductsFileName(month);

    @TempDir
    File tempDir;

    @Test
    void testAddProduct() {
        assertEquals(0, store.getProducts().size());
        store.addProduct(new Product("apple", LocalDate.now(), 30));
        assertEquals(1, store.getProducts().size());
    }

    @Test
    void testAddProductIllegalDateSold() {
        assertEquals(0, store.getProducts().size());
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> store.addProduct(new Product("apple", LocalDate.now().plusDays(1), 30)));
        assertEquals("Date sold cannot be after current date.", e.getMessage());
        assertEquals(0, store.getProducts().size());
    }

    @Test
    void testGetMonthlyProductsFileName() {
        assertEquals("products-february.csv", fileName);
    }

    @Test
    void testWriteProductsSoldToFileByMonth() throws IOException {
        for (Product product : products) {
            store.addProduct(product);
        }
        Path path = tempDir.toPath().resolve(fileName);
        store.writeProductsSoldToFileByMonth(path, month);
        List<String> lines = Files.readAllLines(path);
        assertEquals(Arrays.asList(
                "milk;1991-02-02;40",
                "butter;1993-02-04;60",
                "coke;1994-02-05;70"
        ), lines);
    }
}
