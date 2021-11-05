package com.emre.lcwaikiki.constants;

import org.openqa.selenium.By;

public class ConstantsProductPage {
    public static final By PRICE_AREA = By.className("price-area");
    public static final By PRICE = By.className("price");
    public static final By TITLE_INFO = By.className("title-info");
    public static final By PRODUCT_TITLE = By.className("product-title");
    public static final By OPTION_SIZE = By.className("option-size");
    public static final By TAG_A = By.tagName("a");

    public static final By HEADER_CART = By.className("header-cart");
    public static final By SEARCH = By.id("search");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//*[@id=\"pd_add_to_cart\"]");
  //  public static final By ADD_TO_CART_BUTTON2 = By.className("add-to-cart-button");
    //public static final By ADD_TO_CART_BUTTON2 = By.xpath("//*[@id="pd_add_to_cart"]");

}
