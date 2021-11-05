package com.emre.lcwaikiki.dto

import org.openqa.selenium.WebElement

data class Product(var title: String?, var price: String?, var element: WebElement?) {
    constructor() : this("","",null)
}