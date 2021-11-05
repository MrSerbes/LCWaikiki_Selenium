package com.emre.lcwaikiki.pages;

import com.emre.lcwaikiki.base.BasePage;
import org.openqa.selenium.WebDriver;

import static com.emre.lcwaikiki.constants.ConstantsHomePage.*;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
         super(driver);
    }

/*    public void moveToLogin(){
        hoverElement(MOVE);
    }
*/
    public LoginPage clickLoginPage(){
        click(LOG_IN_PAGE);
        return  new LoginPage(getWebDriver());
    }

}
