import io.restassured.response.Response;

public class PetService {
    PetClient petClient = new PetClient();
    StoreClient storeClient = new StoreClient();
    UserClient userClient = new UserClient();

    public Response addPet(String jasonBody) {
        return petClient.addPet(jasonBody);
    }

    public Response getPetById(int id) {
        return petClient.getPetById(id);
    }

    public Response deletePetById(int id) {
        return petClient.deletePetById(id);
    }

    public Response updatePet(String jsonBody) {
        return petClient.updatePet(jsonBody);
    }

    public Response orderPet(String jsonBody) {
        return storeClient.orderPet(jsonBody);
    }

    public Response petStoreQuantity(int id) {
        return storeClient.petStoreQuantity(id);
    }

    public Response getPetByName(String name) {
        return userClient.getPetByName(name);
    }

    public boolean createAndVerifyPet(String jsonBody, int expectedId, String expectedName) {
        Response addResponse = petClient.addPet(jsonBody);
        if (addResponse.statusCode() != 200) {
            System.out.println("Nie udało się dodać peta. Status: " + addResponse.statusCode());
            return false;
        }

        Response getResponse = petClient.getPetById(expectedId);
        if (getResponse.statusCode() != 200) {
            System.out.println("Nie udało się pobrać peta po ID. Status: " + getResponse.statusCode());
            return false;
        }

        String responseBody = getResponse.getBody().asString();
        boolean nameMatches = responseBody.contains("\"name\":\"" + expectedName + "\"");

        System.out.println("Wynik weryfikacji: " + nameMatches);
        return nameMatches;
    }
}
