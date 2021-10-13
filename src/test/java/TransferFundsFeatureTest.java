import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransferFundsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferFundsFeatureTest {

    ChromeOptions chromeOptions = new ChromeOptions();
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private TransferFundsPage transferFundsPage;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);
        transferFundsPage = new TransferFundsPage(driver);

        driver.get("http://zero.webappsecurity.com/login.html");

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();

        accountSummaryPage.clickTransferFundsButton();
    }

    @Test
    public void transferFundsTest() throws InterruptedException {
        transferFundsPage.clickToAccountDropdown();
        transferFundsPage.clickToAccountOption();
        transferFundsPage.enterAmount();
        transferFundsPage.enterDescription();
        transferFundsPage.clickSubmitButton();
        transferFundsPage.clickSubmitButton();

        String expectedToAccount = "Savings";
        String expectedAmmount = "$ 300";
        String expectedSuccessMessage = "You successfully submitted your transaction.";

        Assert.assertEquals(transferFundsPage.getSuccessfulMessageText(), expectedSuccessMessage);
        Assert.assertEquals(transferFundsPage.fromAccountText(), expectedToAccount);
        Assert.assertEquals(transferFundsPage.toAccountText(), expectedToAccount);
        Assert.assertEquals(transferFundsPage.amountText(), expectedAmmount);

    }

    @AfterClass
    public void afterClass() {
        driver.close();
        driver.quit();
    }
}
