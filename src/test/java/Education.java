import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Education {
    public void Education () {

        //tutaj mam przykład klasycznego GET-a
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/1");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());


        //POST
        Map<String, Object> petData = new HashMap<>();
        petData.put("id", 8);
        petData.put("name", "doggie");
        petData.put("status", "available");

        Gson gson = new Gson();
        String requestBody = gson.toJson(petData);

        String url = "https://petstore.swagger.io/v2/pet";

        Response response1 = RestAssured.given().contentType(ContentType.JSON)
                .body(requestBody)
                .when().post(url);

        System.out.println(response1.getStatusCode());
        System.out.println(response1.getBody().asString());

    }
}
