package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefinitions.Hooks;
import java.util.List;
import static org.junit.Assert.*;

public class JobListPage {

    public String pageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }


    @FindBy(xpath = "//body/div[2]/button[1]")
    public WebElement addPersonButton;

    @FindBy(xpath = "//body/div[2]/button[2]")
    public WebElement resetButton;

    @FindBy(xpath = "//span[contains(text(),'Mike')]")
    public WebElement defaultMike;

    @FindBy(xpath = "//span[contains(text(),'Jill')]")
    public WebElement defaultJill;

    @FindBy(xpath = "//span[contains(text(),'Jane')]")
    public WebElement defaultJane;



}