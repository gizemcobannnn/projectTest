package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import org.junit.Assert.assertEquals;
import net.bytebuddy.description.annotation.AnnotationList.Empty;


public class Search {
   
   WebDriver driver = new ChromeDriver();
   public void searchFirst(){
    WebElement searchBox =  driver.findElement(By.id("o-searchSuggestion__input"));
    searchBox.sendKeys("şort");
   }
   public void submit(){
    WebElement submitButton = driver.findElement(By.cssSelector("body > header > div.o-searchSuggestion > div.o-searchSuggestion__header > div > div > div.col-4.col-sm-4.col-md-4.col-lg-4.col-xl-6 > div > form > div > button.o-header__search--btn"));
    submitButton.click();
   }
   public void searchClear(){
    WebElement searchBox =  driver.findElement(By.id("o-searchSuggestion__input"));
    searchBox.clear();
   }
   public void searchSecond(){
   WebElement searchBox =  driver.findElement(By.id("o-searchSuggestion__input"));
    searchBox.sendKeys("gömlek");
    WebElement submitButton = driver.findElement(By.cssSelector("body > header > div.o-searchSuggestion > div.o-searchSuggestion__header > div > div > div.col-4.col-sm-4.col-md-4.col-lg-4.col-xl-6 > div > form > div > button.o-header__search--btn"));
    submitButton.sendKeys(Keys.ENTER);
   }
   public void selectProduct(){
    WebElement randomItem =  driver.findElement(By.xpath("//*[@id=\"productList\"]/div[6]/div/div"));
    randomItem.click();
    driver.get("https://www.beymen.com/p_beymen-club-mavi-logo-detayli-gomlek_1246550");
   }

    public void productDetail(){
    WebElement productDescription = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/div/div"));
    String productDetails = productDescription.getText();
    }
    public void writeFile(){
    File f = new File("procucttxt.txt");
      try{
         FileUtils.writeStringToFile(f, productDetails , Charset.defaultCharset());
      }catch(IOException exc){
         exc.printStackTrace();
      }

   }
   public void addBasket(){
      WebElement stickyAddBasket = driver.findElement(By.id("stickyAddBasket"));
      stickyAddBasket.click();
      WebElement largeProduct = driver.findElement(By.xpath("//*[@id=\"sizes\"]/div/span[4]"));
      largeProduct.click();
   }
   public  static String priceActual;

   public void productPrice(){
      WebElement productPriceReal = driver.findElement(By.id("priceNew"));
      priceActual = productPriceReal.getText();
      Assert.assertEquals(priceActual,"3.599 TL");
   }

    public void myBasket(){
      WebElement myBasket = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/a[3]"));
      myBasket.click();
    }


    public void selectFromList(){
      WebElement selectList =  driver.findElement(By.xpath("//*[@id=\"quantitySelect0-key-0\"]"));
      Select select = new Select(selectList);
      select.selectByVisibleText("2 adet");     
    }

    public void assertPrice(){
    WebElement selecttwo = driver.findElement(By.xpath("//*[@id=\"quantitySelect0-key-0\"]/option[2]"));
    String seltwo = selecttwo.getText();
    Assert.assertEquals(priceActual*2,seltwo);
    }

    public void deleteBasket(){
      WebElement delete = driver.findElement(By.xpath("//*[@id=\"removeCartItemBtn0-key-0\"]"));
      delete.click();
    }

    public void emptyAssert(){
      WebElement emptyCard = driver.findElement(By.className("m-empty__messageTitle"));
      Assert.assertEquals(emptyCard.getText(),"Sepetinizde Ürün Bulunmamaktadır");
    }
 
    
    };

