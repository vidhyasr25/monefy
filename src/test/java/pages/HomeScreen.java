package pages;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.CommonMethods.waitForAnExplicitElement;
import static pages.CommonVariables.androidDriver;

public class HomeScreen {

    AndroidDriver<WebElement> driver;


    public HomeScreen(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }
    //Locators
    By continueBtn =By.xpath("//*[contains(@resource-id,'buttonContinue')]");
    By claimBtn = By.xpath("//*[contains(@text,'CLAIM')]");
    By closeBtn= By.id("buttonClose");
    By expenseBtn = By.id("expense_button_title");
    By incomeBtn = By.id("income_button_title");
    By amountVal =By.id("amount_text");
    By chooseCategory =By.id("keyboard_action_button");
    By salary = By.xpath("//*[contains(@resource-id,\"textCategoryName\") and @text=\"Salary\"]");
    By bills = By.xpath("//*[contains(@resource-id,\"textCategoryName\") and @text=\"Bills\"]");
    By threeBtn=By.xpath("//*[contains(@resource-id,\"buttonKeyboard\") and @text=\"3\"]");
    By zeroBtn=By.xpath("//*[contains(@resource-id,\"buttonKeyboard\") and @text=\"0\"]");
    By balanceBtn=By.id("balance_container");
    By firstRecord = By.id("transaction_group_header");
    By recordDetail = By.id("textViewTransactionAmount");
    By deleteBtn = By.id("delete");

    public void navigateHomeScreen() throws InterruptedException {
        waitForAnExplicitElement(androidDriver,continueBtn);
        int noOfScreen = 3;
        for (int screen=0; screen<=noOfScreen; screen++){;
            waitForAnExplicitElement(androidDriver,continueBtn);
            androidDriver.findElement(continueBtn).click();
            System.out.println("User is moved on to the next screen");
        }
        waitForAnExplicitElement(androidDriver,claimBtn);
        androidDriver.findElement(closeBtn).click();
        waitForAnExplicitElement(androidDriver,incomeBtn);
    }

    /**
     * this method adds a new income
     */
    public void addNewIncome(){
        androidDriver.findElement(incomeBtn).click();
        waitForAnExplicitElement(androidDriver,amountVal);
        androidDriver.findElement(amountVal).click();
        waitForAnExplicitElement(androidDriver,threeBtn);
        androidDriver.findElement(threeBtn).click();
        for(int i=0;i<3;i++){
            androidDriver.findElement(zeroBtn).click();
        }
        androidDriver.findElement(chooseCategory).click();
        System.out.println("User selects the Category as Salary");
        waitForAnExplicitElement(androidDriver,salary);
        androidDriver.findElement(salary).click();
        waitForAnExplicitElement(androidDriver,incomeBtn);
        if(androidDriver.findElement(expenseBtn).isDisplayed()){
            System.out.println("Salary has been successfully added");
        }else{
            System.out.println("Salary has not been successfully added");
        }

    }

    /**
     * this method adds a new expense
     */
    public void addNewExpense(){
        androidDriver.findElement(expenseBtn).click();
        waitForAnExplicitElement(androidDriver,amountVal);
        androidDriver.findElement(amountVal).click();
        waitForAnExplicitElement(androidDriver,threeBtn);
        androidDriver.findElement(threeBtn).click();
        for(int i=0;i<2;i++){
            androidDriver.findElement(zeroBtn).click();
        }
        androidDriver.findElement(chooseCategory).click();
        System.out.println("User selects the Category as Bills");
        waitForAnExplicitElement(androidDriver,bills);
        androidDriver.findElement(bills).click();
        waitForAnExplicitElement(androidDriver,incomeBtn);
        if(androidDriver.findElement(incomeBtn).isDisplayed()){
            System.out.println("Bill expense has been successfully added");
        }else {
            System.out.println("Bill expense has not been successfully added");
        }

    }

    /**
     * this method deletes an expense
     */
    public void deleteARecord(){
        waitForAnExplicitElement(androidDriver,balanceBtn);
        androidDriver.findElement(balanceBtn).click();
        waitForAnExplicitElement(androidDriver,firstRecord);
        androidDriver.findElement(firstRecord).click();
        androidDriver.findElement(recordDetail).click();
        waitForAnExplicitElement(androidDriver,deleteBtn);
        androidDriver.findElement(deleteBtn).click();
        waitForAnExplicitElement(androidDriver,incomeBtn);
        Assert.assertTrue(androidDriver.findElement(incomeBtn).isDisplayed());
        System.out.println("Record has been deleted successfully");
    }
}
