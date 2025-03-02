import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.*;

import java.io.File;
import java.io.IOException;

public class RecommendationSystem {

    public static void main(String[] args) throws Exception {
        String dataFilePath = "myproject/user_product_interactions.csv"; 
        DataModel model = new FileDataModel(new File(dataFilePath));
        
       
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, model);
        
        
        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        
        
        int userID = 1;
        List<RecommendedItem> recommendations = recommender.recommend(userID, 5);
        
      
        for (RecommendedItem item : recommendations) {
            System.out.println("Product ID: " + item.getItemID() + " | Recommendation: " + item.getValue());
        }
    }
}
