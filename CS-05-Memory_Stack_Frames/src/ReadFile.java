/*import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {

    public static void main(String[] args) throws Exception {
        String filePath = "users.json";
        double averageAge = calculateAverageAge(filePath);
        System.out.println("Average age: " + averageAge);

    }

    private static double calculateAverageAge(String filePath) throws Exception {
        List<Map<String,Object>> users = new ObjectMapper().readValue(
                Files.newInputStream(Paths.get(filePath)),
                new TypeReference<List<Map<String, Object>>>(){}
        );
        double totalAge = 0;
        for (Map<String, Object> user : users){
            totalAge += (int) user.get("age");
        }
        return totalAge / users.size();
    }
}

 */
