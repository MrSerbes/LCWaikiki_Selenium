package com.emre.lcwaikiki.base;

import com.emre.lcwaikiki.pages.HomePage;
import com.emre.lcwaikiki.pages.LoginPage;
import com.emre.lcwaikiki.pages.SearchPage;
import com.emre.lcwaikiki.tests.TestScenario;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static SearchPage searchPage;
    public static WebDriver webDriver;

    public static final Logger LOGGER = Logger.getLogger(TestScenario.class);

    @BeforeAll
    static void setUp() {
      /*  FirefoxProfile testprofile = new FirefoxProfile();
        testprofile.setPreference("dom.webnotifications.enabled", false);
        testprofile.setPreference("dom.push.enabled", false);
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, testprofile);
        FirefoxOptions opt = new FirefoxOptions();
        opt.merge(dc);
        setWebDriver(new FirefoxDriver(opt));
        getWebDriver().manage().window().maximize();*/

       // System.setProperty("webdriver.chrome.driver","C:\\Users\\Steven\\Desktop\\LCWaikiki\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
       // options.setBinary("C:\\Users\\Steven\\Desktop\\LCWaikiki\\chromedriver.exe");
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("start-popup-blocking");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        setWebDriver(new ChromeDriver(options));

    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

    public static void tearDown(){
        getWebDriver().quit();
    }

    public static void navigateURL(String URL){
        webDriver.get(URL);
    }

}
