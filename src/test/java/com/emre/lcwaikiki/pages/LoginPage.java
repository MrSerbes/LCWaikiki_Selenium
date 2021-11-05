package com.emre.lcwaikiki.pages;

import com.emre.lcwaikiki.base.BasePage;
import org.openqa.selenium.WebDriver;

import static com.emre.lcwaikiki.constants.ConstantsLoginPage.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String userName, String password) {
        sendKeys(EMAIL_INPUT, userName);
        sendKeys(PASSWORD_INPUT, password);
        click(LOG_IN_BUTTON);
    }

    /*
    page elements aren't same with home page. so  i created this method in LoginPage
     */

    public SearchPage clickSearchPage(String searchText) {
        sendKeys(SEARCH, searchText);
        click(SEARCH_BUTTON);
        return new SearchPage(getWebDriver());
    }


    public boolean checkInvalidUser(){
        return isDisplayed(ALERT_ERROR);
    }
}
