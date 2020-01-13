# ABSA_Assessment
Add_User_To_User_Table
Project Background

This is an automation project that navigates user to : http://www.way2automation.com/angularjs-protractor/webtables/

First it validates if user is on the correct user table using the created method : It will the add first user using the methods created on Add_New_User_To_User_Table class Next step is verifying that the first user was added correctly using method : Verify_Added_User

To verify if user is added correctly I use the Excel data sheet to read first line and user the firstname and lastname to verify if there we added 
Secondly it adds the second user from Excel name DataSheet same steps as above only difference is that it is reading the second row 
Functionality:
Unique UserName : I created a method below that will user half of the username from excel and current datetime to ensure username is always unique

/public void Add_UserName(String un) { WebDriverWait wait_for_username = new WebDriverWait(driver, 10); wait_for_username.until(ExpectedConditions.visibilityOf(UserName)); Runtime.Timestamp timestamp = new Runtime.Timestamp(System.currentTimeMillis()); un+="_"+timestamp; UserName.clear(); UserName.sendKeys(un);/

.Clear() I user variable/element.clear() as show below to ensure that before we send anything to that field that the field is empty

UserName.clear();

How to run the tests:

First your need to make sure that you have to rows on TestData.xlsx file You can either right click on testng.xml file and select run or right click on the class Add_And_Verify_User_Tests and run

NB: The tests class are extending the Report_Helper which i created to capture reports using extentreport4 that will logg all the actions taken and results

After running the test navgate to /Add_New_User_Test_Reports/AddAndVerifyUser.html file > right click Open in browser and select the browser of your choice
