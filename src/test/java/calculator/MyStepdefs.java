package calculator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private double result;
    private String opt;
    private Exception error;

    @Before
    public void before() {
        calculator = new Calculator();
    }
    @Given("^Two input values, ([-+]?\\d+) and ([-+]?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }
    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
        System.out.print(result);
    }
    @Then("^I expect the result ([-+]?\\d+.?\\d*)$")
    public void iExpectTheResult(double arg0) {
        Assert.assertEquals(arg0, result, 0.001);
    }

    @Given("^Input value ([-+]?\\d+) and opt \"([^\"]*)\"$")
    public void inputValueAndOpt(int arg0, String arg1) {
        value1 = arg0;
        opt = arg1;
    }

    @When("^I run func$")
    public void iRunFunc() {
        try{
            result = calculator.func(value1, opt);
            System.out.print(result);
        } catch (Exception e){
            error = e;
        }
    }

    @Then("^I expect to get error$")
    public void iExpectToGetError() {
        Assert.assertNotNull(error);
    }
}
