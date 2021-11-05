package com.emre.lcwaikiki.base;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public WebElement findElementInWebElement(@NotNull WebElement we, By searchBy) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchBy));
        return we.findElement(searchBy);
    }

    public String getTextInWebElement(WebElement we, By searchBy) {
        return findElementInWebElement(we,searchBy).getAttribute("textContent");
    }

    public List<WebElement> findElements(By by, By searchBy) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchBy));
        return findElement(by).findElements(searchBy);
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public boolean isDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    public void click(By by) {

       /* wait.until(ExpectedConditions.visibilityOf(findElement(by)));
        wait.until(ExpectedConditions.elementToBeClickable(by));*/
      //  wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();


    }

    public void click(WebElement we){
        wait.until(ExpectedConditions.elementToBeClickable(we));
        we.click();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public String getText(By by, By searchBy) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchBy));
        return findElement(by).findElement(searchBy).getAttribute("textContent");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isEmpty(@NotNull WebElement we, By searchBy) {
        return we.findElements(searchBy).isEmpty();
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}