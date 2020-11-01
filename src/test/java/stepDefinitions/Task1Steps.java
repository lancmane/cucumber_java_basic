package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1Steps {

    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the enter number page$")
    public void iAmOnTheEnterNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter \"([^\"]*)\"$")
    public void iEnter(String value) throws Throwable {
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.clear();
        inputField.sendKeys(value);
    }

    @And("^I click submit")
    public void iClickSubmit() throws Throwable {
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submit.click();
    }

    @Then("^I should see error \"([^\"]*)\"$")
    public void iShouldSeeError(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSee(String result) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(result, alert.getText());
    }

    @When("^I enter (\\d+)$")
    public void iEnterNum(String number) throws Throwable {
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.clear();
        inputField.sendKeys(number);
    }
}

