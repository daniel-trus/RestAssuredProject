import io.restassured.response.Response;

public class PetStore {

    PetService petService = new PetService();

    public void petStoreGet() {
        System.out.println("--- GET pet by ID ---");
        Response petById = petService.getPetById(188);
        System.out.println(petById.getStatusCode());
        System.out.println(petById.getBody().asString());

        System.out.println("--- GET quantity by ID ---");
        Response inventory = petService.petStoreQuantity(2);
        System.out.println(inventory.getStatusCode());
        System.out.println(inventory.getBody().asString());

        System.out.println("--- GET user by name ---");
        Response user = petService.getPetByName("Mikołaj");
        System.out.println(user.getStatusCode());
        System.out.println(user.getBody().asString());
    }

    public void petStorePost() {
        System.out.println("--- POST new pet ---");
        Response addPet = petService.addPet("""
                {
                  "id": 189,
                  "category": {
                    "id": 0,
                    "name": "Lumia"
                  },
                  "name": "kot",
                  "photoUrls": [
                    "catfoto"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "Lumia"
                    }
                  ],
                  "status": "available"
                }
                """);
        System.out.println(addPet.getStatusCode());
        System.out.println(addPet.getBody().asString());

        System.out.println("--- POST order pet ---");
        Response order = petService.orderPet("""
                {
                  "id": 8,
                  "petId": 8,
                  "quantity": 0,
                  "shipDate": "2025-03-07T20:10:45.867Z",
                  "status": "placed",
                  "complete": true
                }
                """);
        System.out.println(order.getStatusCode());
        System.out.println(order.getBody().asString());
    }

    public void petStorePut() {
        System.out.println("--- PUT update pet ---");
        Response updatePet = petService.updatePet("""
                {
                    "id": 188,
                    "category": {
                        "id": 0,
                        "name": "Chałka123"
                    },
                    "name": "kot",
                    "photoUrls": [
                        "catfoto2"
                    ],
                    "tags": [
                        {
                            "id": 0,
                            "name": "Chałka222"
                        }
                    ],
                    "status": "available"
                }
                """);
        System.out.println(updatePet.getStatusCode());
        System.out.println(updatePet.getBody().asString());
    }

    public void petStoreDelete() {
        System.out.println("--- DELETE pet by ID ---");
        Response deletePet = petService.deletePetById(189);
        System.out.println(deletePet.getStatusCode());
        System.out.println(deletePet.getBody().asString());
    }

    public void testCreateAndVerifyPet() {
        System.out.println("--- TEST create and verify pet ---");
        boolean result = petService.createAndVerifyPet("""
                {
                    "id": 188,
                    "category": {
                        "id": 0,
                        "name": "Chałka123"
                    },
                    "name": "kot",
                    "photoUrls": [
                        "catfoto2"
                    ],
                    "tags": [
                        {
                            "id": 0,
                            "name": "Chałka222"
                        }
                    ],
                    "status": "available"
                }
                """, 188, "kot");
        System.out.println("Wynik testu: " + result);
    }
}
