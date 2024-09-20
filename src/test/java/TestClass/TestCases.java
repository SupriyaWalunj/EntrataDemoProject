package TestClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic.WebsitePages;
import Generic.InitiliazeEnvironment;

public class TestCases {
    
    private InitiliazeEnvironment objInitiliazeEnvironment;
    private WebsitePages objHomePage;

    public TestCases() {
        objInitiliazeEnvironment = new InitiliazeEnvironment();
    }
    
    @BeforeMethod
    public void OpenChrome() throws InterruptedException {
        // Description: This method is executed before each test method to launch the Chrome browser.
        objInitiliazeEnvironment.ChromeLaunch();
        objHomePage = new WebsitePages(objInitiliazeEnvironment.getDriver());
    }
    
    @AfterMethod
    public void CloseChrome() {
        // Description: This method is called after each test method to perform cleanup actions.
        // Here we have added code to close the browser.
        objInitiliazeEnvironment.closeChrome();
    }	

    @Test(priority = 1, description = "Verify homepage footer links are working", enabled = true)
    public void Validate_HomePage_Footer() {
        objHomePage.AcceptCookies();
        objHomePage.ValidateFooterLinks();
    }

    @Test(priority = 2, description = "Verify window handling concept", enabled = true)
    public void Validate_User_Is_Able_To_Navigate_FromHomePage_To_Summit_Page() {
        objHomePage.AcceptCookies();
        objHomePage.WindowHandling();
    }
    
    @Test(priority = 3, description = "Verify register form first name is mandatory (field is highlighted and error message is displayed)", enabled = true)
    public void Validate_User_First_Mandatory_Field_On_Registration_Page() {
        objHomePage.AcceptCookies();
        objHomePage.ValidateRegisterFormMandatoryField();
    }
}
