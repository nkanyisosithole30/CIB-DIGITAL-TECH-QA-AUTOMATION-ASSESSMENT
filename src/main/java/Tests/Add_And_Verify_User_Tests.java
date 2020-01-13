package Tests;

import Startup.Setup_Class;
import Test_Functionality.Add_New_User_To_User_Table;
import Test_Helpers.Report_Helper;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Add_And_Verify_User_Tests extends Report_Helper {

    private WebDriver driver;
    private static String dir = System.getProperty("user.dir");
    private static final String Chromedriver = dir + "/src/main/java/Test_Drivers/chromedriver.exe";
    private static final String excel = dir + "/src/main/java/TestData/TestData.xlsx";

    @BeforeTest(description = "Setup for test")
    public void setup_test()
    {
        System.setProperty("webdriver.chrome.driver", Chromedriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);

    }
    @Test(priority = 1,description = "Add the user to table")
    public void Add_First_User() throws IOException {
        test = extent.createTest("Add First User To User Table", "Add User To User Table");
        test.log(Status.PASS, "Add User To User Table Test Started");

        Add_New_User_To_User_Table add_user= PageFactory.initElements(driver, Add_New_User_To_User_Table.class);
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
        String user_name = sheet.getRow(1).getCell(2).getStringCellValue();
        String pass_word = sheet.getRow(1).getCell(3).getStringCellValue();
        String email = sheet.getRow(1).getCell(4).getStringCellValue();
        String cellphone = sheet.getRow(1).getCell(5).getStringCellValue();
        test.log(Status.PASS, "Click Add New User Button");
        add_user.Click_Add_New_User_Button();
        test.log(Status.PASS, "Populate First Name Field");
        add_user.Add_First_Name(first_name);
        test.log(Status.PASS, "Populate Last Name Field");
        add_user.Add_Last_Name(last_name);
        test.log(Status.PASS, "Populate User Name Field");
        add_user.Add_UserName(user_name);
        test.log(Status.PASS, "Populate Password Field");
        add_user.Add_Password(pass_word);
        test.log(Status.PASS, "Select Customer Radio Button");
        add_user.Add_Customer();
        test.log(Status.PASS, "Select Role From DropDown");
        add_user.Select_Role("Admin");
        test.log(Status.PASS, "Populate Email Field");
        add_user.Add_Email(email);
        test.log(Status.PASS, "Populate CellPhone Field");
        add_user.Add_Mobile_Phone(cellphone);
        test.log(Status.PASS, "Click Save Button");
        add_user.Click_Button_Save();
        test.log(Status.PASS, "Add User To User Table Test Completed Successfully");
    }
    @Test(priority = 3,description = "Add the user to table")
    public void Add_Second_User() throws IOException {
        test = extent.createTest("Add Second User To User Table", "Add User To User Table");
        test.log(Status.PASS, "Add User To User Table Test Started");

        Add_New_User_To_User_Table add_user= PageFactory.initElements(driver, Add_New_User_To_User_Table.class);
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String first_name = sheet.getRow(2).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(2).getCell(1).getStringCellValue();
        String user_name = sheet.getRow(2).getCell(2).getStringCellValue();
        String pass_word = sheet.getRow(2).getCell(3).getStringCellValue();
        String email = sheet.getRow(2).getCell(4).getStringCellValue();
        String cellphone = sheet.getRow(2).getCell(5).getStringCellValue();
        test.log(Status.PASS, "Click Add New User Button");
        add_user.Click_Add_New_User_Button();
        test.log(Status.PASS, "Populate First Name Field");
        add_user.Add_First_Name(first_name);
        test.log(Status.PASS, "Populate Last Name Field");
        add_user.Add_Last_Name(last_name);
        test.log(Status.PASS, "Populate User Name Field");
        add_user.Add_UserName(user_name);
        test.log(Status.PASS, "Populate Password Field");
        add_user.Add_Password(pass_word);
        test.log(Status.PASS, "Select Customer Radio Button");
        add_user.Add_Customer();
        test.log(Status.PASS, "Select Role From DropDown");
        add_user.Select_Role("Customer");
        test.log(Status.PASS, "Populate Email Field");
        add_user.Add_Email(email);
        test.log(Status.PASS, "Populate CellPhone Field");
        add_user.Add_Mobile_Phone(cellphone);
        test.log(Status.PASS, "Click Save Button");
        add_user.Click_Button_Save();
        test.log(Status.PASS, "Add User To User Table Test Completed Successfully");
    }
    @Test (description = "Verify that we are on the correct User Table")
    public void Verify_User_Table()
    {
        test = extent.createTest("Verify that we are on the correct user table ", "Verify User Table");
        test.log(Status.PASS, "Verify User Table Test Started");
        test.log(Status.PASS, "Launching Browser");

        Setup_Class setup_class =new Setup_Class(driver);
        test.log(Status.PASS, "Deleting all cookies");
        setup_class.driver.manage().deleteAllCookies();
        test.log(Status.PASS, "Verify Correct User Table");
        setup_class.Verify_Correct_User_Table();
        test.log(Status.PASS, "Verify User Table Test Completed");
    }

    @Test(priority = 2,description = "Verify that user is added correctly to the table")
    public void Verify_First_User() throws IOException, InterruptedException {
        test = extent.createTest("Test that first user was added to the table", "Verify User Added Correctly");
        test.log(Status.PASS, "Verify Correct USer Added Test Started");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Add_New_User_To_User_Table add_user= PageFactory.initElements(driver,Add_New_User_To_User_Table.class);
        String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
        test.log(Status.PASS, "Verify Correct User Added");
        add_user.Verify_Added_User(first_name,last_name);

        test.log(Status.PASS, "Verify Correct User Added Test Completed Successfully");
    }
    @Test(priority = 4,description = "Verify that second user is added correctly to the table")
    public void Verify_Second_User() throws IOException, InterruptedException {
        test = extent.createTest("Test that second user was added to the table ", "Verify User Added Correctly");
        test.log(Status.PASS, "Verify Correct USer Added Test Started");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Add_New_User_To_User_Table add_user= PageFactory.initElements(driver,Add_New_User_To_User_Table.class);
        String first_name = sheet.getRow(2).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(2).getCell(1).getStringCellValue();
        test.log(Status.PASS, "Verify Correct User Added");
        add_user.Verify_Added_User(first_name,last_name);

        test.log(Status.PASS, "Verify Correct User Added Test Completed Successfully");
    }
    @AfterTest(description = "This method will quit the driver after all the test")
    public void Exit_Test()
    {
        driver.quit();
    }
}
