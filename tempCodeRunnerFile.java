import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommendationQuality;
import org.apache.mahout.cf.taste.impl.eval.CrossValidationRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

public class Evaluation {
    public static void main(String[] args) throws Exception {
        String dataFilePath = "user_product_ratings.csv"; 
        DataModel model = new FileDataModel(new File(dataFilePath));
        
       
        RecommenderEvaluator evaluator = new CrossValidationRecommenderEvaluator();
        
       
        double score = evaluator.evaluate(new GenericUserBasedRecommender(model, null, null), model, 10, 0.9);
        
        System.out.println("Model Evaluation Score: " + score);
    }
}
