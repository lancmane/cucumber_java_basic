package pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class JobListAddPersonPage {

    public String pageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html";
    }

    @FindBy(id = "name")
    public WebElement inputName;

    @FindBy(id = "job")
    public WebElement inputJob;

    @FindBy(xpath = "//button[@id='addPersonBtn']")
    public WebElement clearButton;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    public WebElement addButton;



}
