package Excer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class listBox {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Sameena_Automation_Files\\chromedriver_win32\\chromedriver.exe");


        WebDriver driver=new ChromeDriver();


        driver.get("https://techcanvass.com/Examples/multi-select.html");




        driver.manage().window().maximize();
        System.out.println("Header of the webpage is"+ driver.getTitle());
        Select listbox = new Select(driver.findElement(By.id("multiselect")));
        java.util.List<WebElement> options = listbox.getOptions();
        System.out.println("Dropdown values are :\n");
        for(WebElement item:options)
        {

            System.out.println(item.getText());
        }
        driver.quit();

    }

}
