package Excer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Sameena_Automation_Files\\chromedriver_win32\\chromedriver.exe");


        WebDriver driver=new ChromeDriver();


        driver.get("https://www.irctc.co.in/");



        driver.manage().window().maximize();
        System.out.println("Header of the webpage is"+ driver.getTitle());
        driver.quit();

    }
}
