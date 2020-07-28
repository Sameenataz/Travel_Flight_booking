package Excer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class title {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Sameena_Automation_Files\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();
        System.out.println("Title of the web page is  :"+ driver.getTitle());

        Thread.sleep(5000);
        System.out.println("Header of the web page is: "+  driver.findElement(By.xpath("/html/body/nav/a[1]/span")).getText());

        Thread.sleep(5000);
        //driver.quit();

    }
}
