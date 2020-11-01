package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class Task2Steps {
    private WebDriver driver;
    static JobListPage jobListPage;
    static JobListAddPersonPage jobListAddPersonPage;
    public int x;
    public int y;



    @Before
    public void startingTests() throws Exception {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    public Task2Steps() {
        this.driver = Hooks.driver;
        jobListPage = PageFactory.initElements(Hooks.driver, JobListPage.class);
        jobListAddPersonPage = PageFactory.initElements(Hooks.driver, JobListAddPersonPage.class);
    }


    @Given("^I am on the people list page using PO$")
    public void iAmOnThePeopleListPage() throws Throwable {
        driver.get(jobListPage.pageUrl());
    }

    @Given("^I am on the add person page using PO$")
    public void iAmOnTheAddPersonPage() throws Throwable {
        driver.get(jobListAddPersonPage.pageUrl());
    }

    @When("^I click Add person using PO$")
    public void iClickAddPersonUsingPO() {
        jobListPage.addPersonButton.click();
    }

    @Then("^Add person page should open using PO$")
    public void addPersonPageShouldOpen() {
        assertEquals(jobListAddPersonPage.pageUrl(), driver.getCurrentUrl());
    }

    @And("^I enter name \"([^\"]*)\" using PO$")
    public void iEnterName(String arg0) throws Throwable {
        jobListAddPersonPage.inputName.clear();
        jobListAddPersonPage.inputName.sendKeys(arg0);
    }

    @And("^I enter job \"([^\"]*)\" using PO$")
    public void iEnterJob(String arg1) throws Throwable {
        jobListAddPersonPage.inputJob.clear();
        jobListAddPersonPage.inputJob.sendKeys(arg1);
    }

    @And("^I click Add using PO$")
    public void iClickAdd() {
        jobListAddPersonPage.addButton.click();
    }


    @Then("^Initial page should open using PO$")
    public void initialPageShouldOpen() {
        assertEquals(jobListPage.pageUrl(), driver.getCurrentUrl());
    }

    @When("^I open the add person page using PO$")
    public void iOpenTheAddPersonPageUsingPO() {
        driver.get(jobListAddPersonPage.pageUrl());
    }


    @And("^I click the Edit button$")
    public void iClickTheEditButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
    }

    @When("^I click remove by name \"([^\"]*)\"$")
    public void iClickRemoveByName(String arg0) throws Throwable {

System.out.println(driver.findElement(By.xpath(
        "//span[contains(@class, 'w3-xlarge name') and text() = '"+arg0+"']")).getAttribute("id") + "'");


    }


    @When("^I click reset button$")
    public void iClickResetButton() {
        jobListPage.resetButton.click();
    }

    @When("^I click clear button$")
    public void iClickClearButton() {
        jobListAddPersonPage.clearButton.click();
    }

    @Then("^Person name \"([^\"]*)\" and job \"([^\"]*)\" appear in the list using PO$")
    public void personNameAndJobAppearInTheList(String arg0, String arg1) throws Throwable {
        String name = "//span[contains(@class, 'w3-xlarge name') and text() = '" + arg0 + "']";
        String job = "//span[contains(@class, 'job') and text() = '" + arg1 + "']";
        assertTrue(driver.findElement(By.xpath(name)).isDisplayed());
        assertTrue(driver.findElement(By.xpath(job)).isDisplayed());
        assertEquals(arg0, driver.findElement(By.xpath(name)).getText());
        assertEquals(arg1, driver.findElement(By.xpath(job)).getText());

        boolean conditionName = false;
        if (driver.getPageSource().contains(arg0)) {
            conditionName = true;
        }
        assertTrue(conditionName);

        boolean conditionJob = false;
        if (driver.getPageSource().contains(arg1)) {
            conditionJob = true;
        }
        assertTrue(conditionJob);

    }


    @Then("^Person name \"([^\"]*)\" and job \"([^\"]*)\" do not appear in the list using PO$")
    public void personNameAndJobDoNotAppearInTheList(String arg0, String arg1) throws Throwable {
        boolean conditionName = false;
        if (driver.getPageSource().contains(arg0)) {
            conditionName = true;
        }
        assertFalse(conditionName);

        boolean conditionJob = false;
        if (driver.getPageSource().contains(arg1)) {
            conditionJob = true;
        }
        assertFalse(conditionJob);
    }


    @And("^I check initial list size$")
    public int iCheckInitialListSize() {
        List<WebElement> namesList = driver.findElements(By.xpath("//span[contains(@class, 'w3-xlarge name')]"));
        int x = namesList.size();
        System.out.println("List size before adding/removing a person = " + x);
        return x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }




    @And("^I check new list size$")
    public int iCheckNewListSize() {
        List<WebElement> namesListAfter = driver.findElements(By.xpath("//span[contains(@class, 'w3-xlarge name')]"));
        int y = namesListAfter.size();
        System.out.println("List size after adding/removing a person = " + y);
        return y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @And("^There is one person more in the list$")
    public void thereIsOnePersonMoreInTheList() {

        boolean condition = false;
        if(getY() == getX() + 1) { condition = true; }
        assertTrue(condition);
        System.out.println("List size before adding/removing a person = " + getX());
        System.out.println("List size after adding/removing a person = " + getY());
    }

    @When("^I enter new name \"([^\"]*)\" using PO$")
    public void iEnterNewNameUsingPO(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("#name")).clear();
        driver.findElement(By.cssSelector("#name")).sendKeys(arg0);

    }


    @And("^I enter new job \"([^\"]*)\" using PO$")
    public void iEnterNewJobUsingPO(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("#job")).clear();
        driver.findElement(By.cssSelector("#job")).sendKeys(arg0);
    }

    @And("^List size should be default$")
    public void listSizeShouldBeDefault() {
        List<WebElement> namesListAfter = driver.findElements(By.xpath("//span[contains(@class, 'w3-xlarge name')]"));
        assertEquals(3, namesListAfter.size());
    }

    @And("^Person names should be default$")
    public void personNamesShouldBeDefault() {
        assertTrue(jobListPage.defaultMike.isDisplayed());
        assertTrue(jobListPage.defaultJill.isDisplayed());
        assertTrue(jobListPage.defaultJane.isDisplayed());

    }

    @And("^All fields are clear$")
    public void allFieldsAreClear() {

        List<WebElement> inputFields = driver.findElements(By.xpath("//span[contains(@class, 'w3-input')]"));

        boolean condition = false;

        for (WebElement inputField : inputFields) {
            if (inputField.getAttribute("value").isEmpty()) {
                condition = true;
            }
            assertTrue(condition);
        }
    }

    @Then("^Name \"([^\"]*)\" and job \"([^\"]*)\" values appear in the fields$")
    public void nameAndJobValuesAppearInTheFields(String arg0, String arg1) throws Throwable {

        assertEquals(arg0, jobListAddPersonPage.inputName.getAttribute("value"));
        assertEquals(arg1, jobListAddPersonPage.inputJob.getAttribute("value"));


    }

    @When("^I click remove by ID \"([^\"]*)\"$")
    public void iClickRemoveByID(String arg0) throws Throwable {

        driver.findElement(By.cssSelector(
                "#"+arg0+">span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).click();
    }

    @When("^I click Edit by ID \"([^\"]*)\"$")
    public void iClickEditByID(String arg0) throws Throwable {
        driver.findElement(By.cssSelector(
                "#"+arg0+">span.w3-closebtn.editbtn.w3-padding.w3-margin-right.w3-medium>i.fa.fa-pencil")).click();
    }

    @Then("^Edit person page by ID value \"([^\"]*)\" should open using PO$")
    public void editPersonPageByIDValueShouldOpenUsingPO(String arg0) throws Throwable {
        String url = "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id="+arg0;
        assertEquals(url, driver.getCurrentUrl());
    }

}
