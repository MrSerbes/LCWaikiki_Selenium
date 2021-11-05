package com.emre.lcwaikiki.pages;

import com.emre.lcwaikiki.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

import static com.emre.lcwaikiki.constants.ConstantsHomePage.LOG_IN_PAGE;
import static com.emre.lcwaikiki.constants.ConstantsProductPage.*;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        //System.out.println(getProductTitle()+" == "+ getPrice());
        chooseRandomSize();
        addToChart();
        clickChartPage();
    }

    public String getPrice(){
        return getText(PRICE_AREA,PRICE);
    }

    //we can add other methods, for example getProductTitle or getSizes

    public String getProductTitle() {
        return getText(TITLE_INFO,PRODUCT_TITLE);
    }

    public void chooseRandomSize(){
        List<WebElement> sizes=findElements(OPTION_SIZE,TAG_A);
        for(WebElement size:sizes){
            System.out.println(size.getText());
        }
        WebElement temp=sizes.get(new SecureRandom().nextInt(sizes.size()));
        System.out.println("random size  " +temp.getText());
       // scrollIntoView(temp);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        click(temp);
    }

    public void addToChart(){
        //scrollIntoView(findElement(ADD_TO_CART_BUTTON));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        click(ADD_TO_CART_BUTTON);
       /* try {
            Thread.sleep(3000);
            //click(ADD_TO_CART_BUTTON);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
    }

    public ChartPage clickChartPage(){
        //scrollIntoView(findElement(HEADER_CART));

        click(HEADER_CART);
        return  new ChartPage(getWebDriver());
    }

}
