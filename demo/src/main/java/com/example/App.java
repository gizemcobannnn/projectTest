package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Beymen.com product project
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    OpenCloseWeb openCloseWeb = new OpenCloseWeb();
    openCloseWeb.open();
    Search search = new Search();
    search.searchFirst();
    search.submit();
    search.searchClear();
    search.searchSecond();
    search.selectProduct();
    search.productDetail();
    search.writeFile();
    search.addBasket();
    search.productPrice();
    search.myBasket();
    search.selectFromList();
    search.assertPrice();
    search.deleteBasket();
    search.emptyAssert();
    openCloseWeb.close();
  

    }
}
