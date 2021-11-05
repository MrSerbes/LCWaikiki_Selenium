package com.emre.lcwaikiki.pages;

import com.emre.lcwaikiki.base.BasePage;
import com.emre.lcwaikiki.dto.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class SearchPage extends BasePage {
    List<Product> products;
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void convertDTO(){
        products = new ArrayList<Product>();

        //scrollDown();
        //click(By.className("lazy-load-button"));
        //scrollDown();

        List<WebElement> productsElement = findElements(By.className("c-items"),By.className("a_model_item"));
        Product tempProduct;
        System.out.println("convert dto result"+productsElement.size());
        for (WebElement productElement:productsElement){
            tempProduct = new Product();
            WebElement tempProductInfoElement = findElementInWebElement(productElement,By.className("product-item-info"));
            //System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
            //System.out.println(productElement.getAttribute("innerHTML"));
            //System.out.println(findElementBy(productElement,By.className("title")).getAttribute("textContent") +"  == ");

            tempProduct.setTitle(getTextInWebElement(tempProductInfoElement,By.className("title")));
            tempProduct.setElement(productElement);
           if (isEmpty(tempProductInfoElement,By.className("old-price"))) {
               tempProduct.setPrice(getTextInWebElement(tempProductInfoElement,By.className("raw-price")));
           }else{
                //products.add(new Product(productElement.findElement(By.className("title")).getAttribute("textContent"),productElement.findElement(By.className("raw-price")).getAttribute("textContent")));
               tempProduct.setPrice(getTextInWebElement(tempProductInfoElement,By.className("discount-price")));
           }

           products.add(tempProduct);
           System.out.println(tempProduct.getTitle()+" == "+tempProduct.getPrice());
            //System.out.println(productElement.findElement(By.className("title")).getText() +"  == "+productElement.findElement(By.className("raw-price")).getText());
            // products.add(new Product(productElement.));

        }
        tempProduct=randomProduct();
        System.out.println("Random product ==  " +tempProduct.getTitle()+" == "+tempProduct.getPrice());
        //hoverElement();
        scrollIntoView(tempProduct.getElement().findElement(By.className("picture-box")));
        click(tempProduct.getElement());
        chooseProduct();

    }

    public ProductPage chooseProduct(){
        return  new ProductPage(getWebDriver());
    }

    public Product randomProduct(){
        return products.get(new SecureRandom().nextInt(products.size()));
    }
}
