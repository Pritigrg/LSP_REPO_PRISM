package org.howard.edu.lsp.assignment2;
import java.io.*;
import java.util.Objects;

public class ETL {
    public static void main(String[] args) {
        String filePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))){
            String line;
            int countline = 0;
            while ((line = br.readLine()) != null) {
                countline++;

                if (countline == 1) {
                    writer.write( "ProductID" + ',' + "Name" +','+ "Price" + ','+  "Category" + ','+ "PriceRange" + "\n");
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(",");
                String category = values[3];
                String name = values[1];
                String priceRange;
                double price = Double.parseDouble(values[2]);
                if (category.equalsIgnoreCase("Electronics")) {
                    price = 0.9 * price;
                    price = Double.parseDouble(String.format("%.2f", price));
                }
                if (category.equals("Electronics") && price > 500) {
                    category = "Premium Electronics";
                }
                if (price <= 10) {
                    priceRange = "Low";
                } else if (price > 10 && price <= 100) {
                    priceRange = "Medium";
                } else if (price > 100 && price <= 500) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                name = name.toUpperCase();

                writer.write( values[0] + ',' + name +','+ price + ','+  category + ','+ priceRange + "\n");

                //System.out.println("Product [id= " + values[0] + ", name= " + name + ", price= " + price + ",Category=" + category + "+ PriceRange=" + priceRange + "]");


            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + filePath + "' was not found. Please check the file path.");
        }
        catch (IOException e) {
            System.out.println("Error: An issue occurred while reading the file.");
        }
    }
}
