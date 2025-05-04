import io.restassured.response.Response;

public class Main {
    public static void main(String[] args) {
//        Education education = new Education();
        PetStore petStore = new PetStore();

//        education.Education();

        System.out.println("Postman PetStore Collection: ");
        petStore.petStoreGet();
        petStore.petStorePost();
        petStore.petStorePut();
        petStore.petStoreDelete();
        petStore.testCreateAndVerifyPet();




    }
}
