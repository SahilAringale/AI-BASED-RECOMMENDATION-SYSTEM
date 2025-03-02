import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.model.Preference;

import java.io.File;
import java.io.IOException;

public class RecommendationSystem {

    
    public static DataModel loadData(String dataFilePath) throws IOException {
        
        File file = new File(dataFilePath);
        DataModel model = new FileDataModel(file);
        
        return model;
    }

    public static void main(String[] args) {
        try {
            
            String filePath = "myproject/user_product_interactions.csv";

           
            DataModel model = loadData(filePath);
            
            
            System.out.println("Number of users: " + model.getNumUsers());
            System.out.println("Number of items: " + model.getNumItems());

           
            PreferenceArray preferences = model.getPreferencesFromUser(1);
            for (Preference preference : preferences) {
                System.out.println("User 1 rated Product " + preference.getItemID() + " with rating " + preference.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
