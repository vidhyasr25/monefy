package pages.backendTests;

import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Collections;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PetStoreAPITests {
    String GET_PET_BY_AVAILABILITY = "https://petstore3.swagger.io/api/v3/pet/findByStatus";
    String POST_PUT_DELETE_PET = "https://petstore3.swagger.io/api/v3/pet";

    Pet petStoreAPIModel =new Pet();
    Category petCategory = new Category();
    Random random = new Random();
    Tags tags = new Tags(3+random.nextInt(6),RandomStringUtils.randomAlphabetic(5));

    /**
     * this methods sets the body of the add new request
     */
    public void addContent() {
        petStoreAPIModel.setId(RandomUtils.nextInt(2001,2500));
        petStoreAPIModel.setName("Animal" + RandomStringUtils.randomAlphabetic(3));
        petStoreAPIModel.setStatus("available");
        petCategory.setName(RandomStringUtils.randomAlphabetic(4));
        petCategory.setId(334+random.nextInt(4));
        petStoreAPIModel.setCategory(petCategory);
        petStoreAPIModel.setTags(Collections.singletonList(tags));
    }

    /**
     * this method sets the body for update request
     */
    public void updateContent() {
        petStoreAPIModel.setId(10);
        petStoreAPIModel.setName("GoatsDog");
        petStoreAPIModel.setStatus("available");
        petCategory.setName("abc"+RandomStringUtils.randomAlphabetic(4));
        petCategory.setId(RandomUtils.nextInt(300,550));
        petStoreAPIModel.setCategory(petCategory);
        petStoreAPIModel.setTags(Collections.singletonList(tags));
    }

    /**
     * this method adds new Pet
     * @return statusCode
     */
    public int addNewPet(){
        addContent();
        return given()
                .contentType(ContentType.JSON)
                .body(petStoreAPIModel)
                .log().all()
                .when()
                .post(POST_PUT_DELETE_PET)
                .then().log().all()
                .extract().statusCode();
    }

    /**
     * this method updates the existing pet
     * @return statusCode
     */
    public int updatePet(){
        updateContent();
        return given()
                .contentType(ContentType.JSON)
                .body(petStoreAPIModel)
                .log().all()
                .when()
                .put(POST_PUT_DELETE_PET)
                .then().log().all()
                .extract().statusCode();
    }

    /**
     * this method gets the pet details that are
     * in available status
     * @return statusCode
     */
    public int getPetByAvailability(){
        return given()
                .contentType(ContentType.JSON)
                .body(petStoreAPIModel)
                .queryParam("status","available")
                .log().all()
                .when()
                .get(GET_PET_BY_AVAILABILITY)
                .then().log().all()
                .extract().statusCode();
    }

    /**
     * this method deletes the existing pet
     * @return statusCode
     */
    public int deletePetByID(int id){
        return given()
                .contentType(ContentType.JSON)
                .body(petStoreAPIModel)
                .log().all()
                .when()
                .delete(POST_PUT_DELETE_PET+"/"+id)
                .then().log().all()
                .extract().statusCode();
    }
}
