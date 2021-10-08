package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferFundsPage extends BasePage {

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tf_toAccountId")
    WebElement toAccountDropdown;

    @FindBy(css = "select[id=\"tf_toAccountId\"]>option[value=\"3\"]")
    WebElement toAccountDropdownOptionSecondSaving;

    public void clickToAccountDropdown() {
        toAccountDropdown.click();
    }

    public void clickToAccountOption() {
        toAccountDropdownOptionSecondSaving.click();
    }


}
