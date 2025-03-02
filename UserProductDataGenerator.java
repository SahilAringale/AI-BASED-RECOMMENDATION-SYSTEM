import java.io.FileWriter;
import java.io.IOException;

public class UserProductDataGenerator {

    public static void main(String[] args) {
        
        String filename = "user_product_interactions.csv";

        try (FileWriter writer = new FileWriter(filename)) {
           
            writer.append("user_id, product_id, rating\n");

           
            writer.append("1, 101, 5\n");
            writer.append("1, 102, 3\n");
            writer.append("2, 101, 4\n");
            writer.append("2, 103, 2\n");
            writer.append("3, 103, 5\n");
            writer.append("3, 102, 4\n");
            writer.append("4, 101, 2\n");
            writer.append("4, 102, 5\n");

            System.out.println("CSV file 'user_product_interactions.csv' has been created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
