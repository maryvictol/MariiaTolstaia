package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.commonPackage.TestContext;

import static hw6.enums.ConnectConstants.CONNECT_URL;

public class GivenSteps extends BaseStep{

    @Given("I am on Home Page")
    public void iAmOnHomePage(){
        TestContext.getDriver().get(CONNECT_URL.getData());
    }




}
