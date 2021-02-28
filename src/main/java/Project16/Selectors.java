package Project16;


import org.openqa.selenium.By;

public class Selectors {
    public static By cookie = By.cssSelector("a[aria-label='dismiss cookie message']");
    public static By username = By.cssSelector("input[data-placeholder='Username']");
    public static By password = By.cssSelector("input[formcontrolname='password']");
    public static By loginButton = By.cssSelector("button[aria-label='LOGIN']");
    public static By menu = By.cssSelector("svg[data-icon=\"bars\"]");
    public static By setupMenu = By.cssSelector(".group-items > :nth-child(1)");
    public static By HumanResources = By.xpath("//span[text()='Human Resources']");
    public static By Employees = By.xpath("//span[text()='Employees']");
    public static By addButton = By.cssSelector("ms-add-button[tooltip='EMPLOYEE.TITLE.ADD']");
    public static By firstName = By.cssSelector("ms-text-field[formcontrolname='firstName']>input");
    public static By lastName = By.cssSelector("ms-text-field[formcontrolname='lastName']>input");
    public static By employeeId = By.cssSelector("input[formcontrolname='employeeId']");
    public static By documentType = By.cssSelector("mat-form-field[formgroupname='documentInfo'] div div div div div");
    public static By documentType2 = By.xpath("//span[contains(text(),'Passport')]");
    public static By documentNumber = By.cssSelector("input[formcontrolname='documentNumber']");
    public static By saveButton = By.cssSelector("ms-save-button");
    public static By alert = By.cssSelector("div[role='alertdialog']");
    public static By lastPageButton = By.cssSelector("button[aria-label='Last Page']");
    public static By verifyName = By.xpath("//td[text()='Hasan  Karaca']");
    public static By updateFirstName = By.cssSelector("#ms-text-field-12>input");


    public static By deleteButton = By.cssSelector("button[class='mat-focus-indicator mat-tooltip-trigger mat-button mat-raised-button mat-button-base mat-warn ng-star-inserted']");


    public static By schoolSetupMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2)");
    public static By departmentMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2) > div > fuse-nav-vertical-item:nth-child(6) > a");
    public static By plusButton = By.cssSelector("ms-table-toolbar > div ms-add-button");
    public static By plusButtonOverlay = By.cssSelector(".cdk-overlay-pane ms-table-toolbar > div ms-add-button");
    public static By nameInput = By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input");
    public static By codeInput = By.cssSelector("[placeholder='GENERAL.FIELD.CODE']>input");
    public static By shortNameInput = By.cssSelector("[placeholder='GENERAL.FIELD.SHORTNAME']>input");
    public static By sectionTab = By.xpath("//div[text()='Section']");
    public static By addSectionButton = By.cssSelector("school-department-section ms-button");
    public static By sectionRows = By.cssSelector("school-department-section tr");
    //public static By saveButton = By.cssSelector("ms-save-button");
    public static By departmentRows = By.cssSelector("ms-browse-table tr");
    public static By trashButton = By.cssSelector("ms-delete-button");
    public static By confirmYes = By.cssSelector("button[type='submit']");

}
