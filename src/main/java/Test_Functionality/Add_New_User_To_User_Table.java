package Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.Runtime;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Add_New_User_To_User_Table {
    private WebDriver driver;
    public Add_New_User_To_User_Table(WebDriver driver)
    {
        this.driver=driver;
    }

    //Locating all the elements i will interact with
    @FindBy(xpath = "//button[contains(.,'Add User')]")
    private
    WebElement AddUserButton;

    @FindBy(xpath = "//input[contains(@name,'FirstName')]")
    private
    WebElement FirstName;

    @FindBy(xpath = "//input[contains(@name,'LastName')]")
    private
    WebElement LastName;

    @FindBy(xpath = "//input[contains(@name,'UserName')]")
    private
    WebElement UserName;

    @FindBy(xpath = "//input[contains(@name,'Password')]")
    private
    WebElement Password;

    @FindBy(xpath = "//label[contains(.,'Company BBB')]")
    private
    WebElement Customer;

    @FindBy(xpath = "//select[contains(@name,'RoleId')]")
    private
    WebElement Role;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    private
    WebElement Email;

    @FindBy(xpath = "//input[contains(@name,'Mobilephone')]")
    private
    WebElement MobilePhone;

    @FindBy(xpath = "//button[@ng-click='save(user)'][contains(.,'Save')]")
    private
    WebElement Button_Save;

    @FindBy(xpath = "(//td[contains(@class,'smart-table-data-cell')])[1]")
    private
    WebElement First_Row_Data;

    @FindBy(xpath = "(//td[@ng-hide='column.noList'])[2]")
    private
    WebElement Second_Record_Data;


  // This method will click the Add New User Button /Link from top right
    public void Click_Add_New_User_Button() {
        WebDriverWait wait_for_add_user_Button = new WebDriverWait(driver, 20);
        wait_for_add_user_Button.until(ExpectedConditions.visibilityOf(AddUserButton));
        AddUserButton.click();
    }
    //This method will populate the firtname using the value passed from excel data sheet
    //I used the FirstName.clear() so that when the second test run it does not append the firstname
    public void Add_First_Name(String fn) {
        WebDriverWait wait_for_firstname = new WebDriverWait(driver, 10);
        wait_for_firstname.until(ExpectedConditions.visibilityOf(FirstName));
        FirstName.clear();
        FirstName.sendKeys(fn);
    }
    //This method will populate last name
    public void Add_Last_Name(String ln) {
        WebDriverWait wait_for_lastname = new WebDriverWait(driver, 10);
        wait_for_lastname.until(ExpectedConditions.visibilityOf(LastName));
        LastName.clear();
        LastName.sendKeys(ln);
    }
    //This method will populate username , i used a certain logic inside to use current timestamp and append it to username from excel data sheet do that username is always unique
    public void Add_UserName(String un) {
        WebDriverWait wait_for_username = new WebDriverWait(driver, 10);
        wait_for_username.until(ExpectedConditions.visibilityOf(UserName));
        Runtime.Timestamp timestamp = new Runtime.Timestamp(System.currentTimeMillis());
        un+="_"+timestamp;
        UserName.clear();
        UserName.sendKeys(un);
    }
    //This method will populate password
    public void Add_Password(String pn) {
        WebDriverWait wait_for_password = new WebDriverWait(driver, 10);
        wait_for_password.until(ExpectedConditions.visibilityOf(Password));
        Password.clear();
        Password.sendKeys(pn);
    }
    //This method will click Customer BBB. For all my test i will always  select this ...its because of time contraints i will need more time to do logic for random customer selection
    public void Add_Customer() {
        WebDriverWait wait_for_customer = new WebDriverWait(driver, 10);
        wait_for_customer.until(ExpectedConditions.visibilityOf(Customer));
        Customer.click();
    }
    //This method will select the role based on the role that is populated on the excel sheet
    public void Select_Role(String r_Role) {
        WebDriverWait wait_for_role = new WebDriverWait(driver, 10);
        wait_for_role.until(ExpectedConditions.visibilityOf(Role));
        Role.sendKeys(r_Role);
    }
    //This method will add email
    public void Add_Email(String em) {
        WebDriverWait wait_for_email = new WebDriverWait(driver, 10);
        wait_for_email.until(ExpectedConditions.visibilityOf(Email));
        Email.clear();
        Email.sendKeys(em);
    }
    //This method is adding the mobile phone
    public void Add_Mobile_Phone(String pn) {
        WebDriverWait wait_for_cellphone = new WebDriverWait(driver, 10);
        wait_for_cellphone.until(ExpectedConditions.visibilityOf(MobilePhone));
        MobilePhone.clear();
        MobilePhone.sendKeys(pn);
    }
   // This method will click Save button
    public void Click_Button_Save()
    {
        WebDriverWait wait_for_save_Button= new WebDriverWait(driver,10);
        wait_for_save_Button.until(ExpectedConditions.visibilityOf(Button_Save));
        Button_Save.click();
    }
    //This method will read first row ,first column and second column and compare the firstname and lastname i got from excel to make sure i added the correct user
    public void Verify_Added_User(String saved_fn,String saved_ln) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        Assert.assertEquals(First_Row_Data.getText(),saved_fn);
        Assert.assertEquals(Second_Record_Data.getText(),saved_ln);
    }

}
