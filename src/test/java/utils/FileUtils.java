package utils;

import model.Product;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void writeProductToTxt(Product product) {

        try (FileWriter writer =
                     new FileWriter("target/selectedProduct.txt")) {

            writer.write("Product Name: " + product.getName() + "\n");
            writer.write("Price: " + product.getPrice());

        } catch (IOException e) {
            throw new RuntimeException("File yazılamadı");
        }
    }
}