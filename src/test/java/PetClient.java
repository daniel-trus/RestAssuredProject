import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetClient {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";

    public Response addPet(String requestBody) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(BASE_URL);
    }

    public Response getPetById(int id) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/" + id);
    }

    public Response deletePetById(int id) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete(BASE_URL + "/" + id);
    }

    public Response updatePet(String requestBody) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(BASE_URL);
    }
}
