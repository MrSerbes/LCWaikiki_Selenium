package com.emre.lcwaikiki.tests;

import com.emre.lcwaikiki.base.BaseTest;
import com.emre.lcwaikiki.pages.HomePage;
import com.emre.lcwaikiki.configuration.BasicConfigurator;
//import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.*;

import static com.emre.lcwaikiki.collections.CollectionsHomePage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestScenario extends BaseTest {

    @BeforeAll
    public static void setup() {
            BasicConfigurator.configure();
            homePage = new HomePage(getWebDriver());
    }

    @Test
    @Order(1)
    public void tesHomePage_whenHomePageIsLoaded_shouldReturnLogo(){
        navigateURL(HOME_PAGE_URL);
        LOGGER.assertLog(homePage.getTitle().equals(HOME_TITLE),"Home page is doesn't loaded");
        assertEquals(HOME_TITLE, homePage.getTitle(),"Home page is doesn't loaded");
    }

    @Test
    @Order(2)
    public void tesLoginPage_whenUserNotExists_shouldReturnInvalidMessage(){
        loginPage = homePage.clickLoginPage();
        loginPage.loginUser("emre@gmail.com","123213");
        LOGGER.assertLog(loginPage.checkInvalidUser(), "Invalid user doesn't work");
        assertTrue(loginPage.checkInvalidUser(),"Invalid user doesn't work");
    }

    @Test
    @Order(3)
    public void testSearch(){
        searchPage = loginPage.clickSearchPage("pantolan");
        searchPage.scrollDown();
        searchPage.convertDTO();

    }

    @Test
    @Order(4)
    public void testSearchResult(){

        //searchPage = loginPage.clickSearchPage("pantolan");
        // searchPage.scrollDown();
        //searchPage.convertDTO();

    }

    @AfterAll
    static void tear_Down(){
       //tearDown();
    }

}
