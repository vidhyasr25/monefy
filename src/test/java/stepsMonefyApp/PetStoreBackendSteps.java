package stepsMonefyApp;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.backendTests.PetStoreAPITests;

public class PetStoreBackendSteps {
    PetStoreAPITests petStoreAPITests =new PetStoreAPITests();
    @Given("user adds a new pet to the store")
    public void userAddsANewPetToTheStore() {
        Assert.assertEquals(200, petStoreAPITests.addNewPet());
        System.out.println("New pet has been added");

    }

    @Given("user updates a existing pet")
    public void userUpdatesAExistingPet() {
        Assert.assertEquals(200, petStoreAPITests.updatePet());
        System.out.println("Existing pet has been updated");
    }

    @Given("user fetches the pets by available status")
    public void userFetchesThePetsByAvailableStatus() {
        Assert.assertEquals(200, petStoreAPITests.getPetByAvailability());
        System.out.println("New pet has been added");
    }

    @Given("user deletes the pets by id {int}")
    public void userDeletesThePetsById(int id) {
        Assert.assertEquals(200, petStoreAPITests.deletePetByID(id));
        System.out.println("New pet has been added");
    }
}
