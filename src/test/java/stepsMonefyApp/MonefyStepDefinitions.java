package stepsMonefyApp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.AndroidDriverCreation;
import pages.CommonVariables;
import pages.HomeScreen;

public class MonefyStepDefinitions extends CommonVariables {

    final String Monefy_Default_app_activity ="com.monefy.activities.main.MainActivity_";
    protected static AndroidDriverCreation androidDriverCreation = new AndroidDriverCreation(androidDriver);
    HomeScreen homeScreen = new HomeScreen(androidDriver);



    @Given("app is launched on the device using the package {string} and uuid of the device {string}")
    public void createDriverAndroid(String packageApp, String uuidOfTheDevice){
        try{
            System.out.println("Generate the driver for Android");
            androidDriver = androidDriverCreation.generateTheAndroidDriverForAndroidMobile(packageApp, uuidOfTheDevice, Monefy_Default_app_activity);
        }catch (Exception e){
            System.out.println("Unabe to launch the application due to : "+e);
        }


    }

    @And("user navigates to the home screen with pie chart")
    public void userNavigatesToTheHomeScreenWithPieChart() throws InterruptedException {
        homeScreen.navigateHomeScreen();
    }

    @And("user adds a new income")
    public void userAddsaNewIncome() {
        homeScreen.addNewIncome();
    }

    @And("user adds a new expense")
    public void userAddsANewExpense() {
        homeScreen.addNewExpense();
    }

    @And("user deletes a new expense")
    public void userDeletesANewExpense() {
        homeScreen.deleteARecord();
    }
}
