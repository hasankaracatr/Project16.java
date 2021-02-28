package Project16;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project16 {
    //  Note-1: Use TestNG for your tests
    //  Note-2: Do not forget to delete whatever you have created manually if needed in order to keep the data clean for other testers please.
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        //  Setup for your test cases:
        System.setProperty("webdriver.chrome.driver", StudentConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);

//  Open a browser and navigate to https://test.campus.techno.study/
        driver.get("https://test.campus.techno.study/");

//  Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(Selectors.cookie).click();

//  Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
    }
       @Test
    public void Test1_login() {
        driver.findElement(Selectors.username).sendKeys("daulet2030@gmail.com");
        driver.findElement(Selectors.password).sendKeys("TechnoStudy123@");
        driver.findElement(Selectors.loginButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Selectors.menu));
    }
//  Navigate to HumanResources > Employees through the left menu

    @Test(dependsOnMethods = "Test1_login")
    public void Test2_Navigate() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.HumanResources)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.Employees)).click();
    }
    //  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
    @Test(dependsOnMethods = "Test2_Navigate")
    public void Test3_creatingAnEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.addButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.firstName)).sendKeys("Hasan");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.lastName)).sendKeys("Karaca");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeId)).sendKeys("132754");
        driver.findElement(Selectors.documentType).click();
        driver.findElement(Selectors.documentType2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.documentNumber)).sendKeys("S132754");
                driver.findElement(Selectors.saveButton).click();
        }
//  Test 2: Verify that an existing employee can be deleted

    @Test(dependsOnMethods = "Test3_creatingAnEmployee")
    public void Test4_deletableCreatedEmployee(){
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.HumanResources)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.Employees)).click();
        waitFor(ExpectedConditions.invisibilityOfElementLocated(Selectors.alert), "Alert didn't disappear");
        waitFor(ExpectedConditions.elementToBeClickable(Selectors.lastPageButton),"go to the last page element was not found");
        driver.findElement(Selectors.lastPageButton).click();
        System.out.println(driver.findElement(Selectors.verifyName).getText());
        String nameAfterChange = "Hasan Karaca";
        Assert.assertEquals(nameAfterChange, "Hasan Karaca");
    }
//  Test 3: Verify that the first name of an existing employee can be updated --> (passes)

    @Test(dependsOnMethods = "Test4_deletableCreatedEmployee")
    public void Test5_updatingEmployeeFirstName(){
        driver.findElement(By.xpath("//td[text()='Hasan  Karaca']//following::ms-edit-button")).click();
        String nameAfterChange = "HasanK";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ms-text-field-7>input"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ms-text-field-7>input"))).sendKeys(nameAfterChange);
        waitFor(ExpectedConditions.elementToBeClickable(Selectors.saveButton),"save button not clickable");
        driver.findElement(Selectors.saveButton).click();
    }
    //  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
    @Test(dependsOnMethods = "Test5_updatingEmployeeFirstName")
    public void Test6_updatingEmployeeLastName(){
        driver.findElement(By.xpath("//td[text()='HasanK  Karaca']//following::ms-edit-button")).click();
        String lastnameAfterChange = "KaracaH";
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ms-text-field-8>input")),"last name is not ready");
        driver.findElement(By.cssSelector("#ms-text-field-8>input")).clear();
        driver.findElement(By.cssSelector("#ms-text-field-8>input")).sendKeys(lastnameAfterChange);
        waitFor(ExpectedConditions.elementToBeClickable(Selectors.saveButton),"save button not clickable");
        driver.findElement(Selectors.saveButton).click();
    }

//  Test 5: Verify that the document number of an existing employee can be updated --> (passes)
//  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
//  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
//  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
//  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)

//  Use a data provider to do the Tests 10-15
//  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
//  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
//  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
//  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
//  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)
//  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)

//  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
//  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
//  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
//  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)

//  Write at least three different test cases for the search options of your own!

//  Close the browser

//  Good luck!
private <T> void waitFor(ExpectedCondition<T> condition) {
    waitFor(condition, condition.toString());
}

    private <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }
    }



