package com.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCloseWeb {
    WebDriver driver = new ChromeDriver();

    public void open(){
        driver.get("https://www.beymen.com/");
    }
    

    public void close(){
        driver.quit();   
    }
}


