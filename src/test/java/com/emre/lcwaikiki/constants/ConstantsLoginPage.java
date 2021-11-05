package com.emre.lcwaikiki.constants;

import org.openqa.selenium.By;

public class ConstantsLoginPage {
    public static final By EMAIL_INPUT = By.id("LoginEmail");
    public static final By PASSWORD_INPUT = By.id("Password");
    public static final By LOG_IN_BUTTON = By.id("loginLink");
    public static final By ALERT_ERROR = By.xpath("/html/body/div[5]/div[3]/div[1]");
    public static final By SEARCH = By.id("search");
    public static final By SEARCH_BUTTON = By.className("search-button");

}
