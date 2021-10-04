package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    public HomePage() {}

    @FindBy(className = "signin btn btn-info")
    private WebElement logInButton;

    public void clickElement() {
        logInButton.click();
    }

}
