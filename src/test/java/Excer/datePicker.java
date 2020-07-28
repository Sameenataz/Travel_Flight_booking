package Excer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class datePicker {

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\Sameena_Automation_Files\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Sameena_Automation_Files\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://phptravels.net/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@data-name = 'flights']")).click();
        Thread.sleep(5000);

        //*[@id="datepickers-container"]/div[7]/div/div/div[2]/div[3]
        //*[@id="datepickers-container"]/div[7]/div/div/div[2]/div[34]
//
        String depart = "29-Aug-2020";
        System.out.println(depart);
        String month = depart.substring(3,6);
        String day = depart.substring(0,2);
        System.out.println("MOnth:"+month);
        System.out.println("MOnth:"+day);
        driver.findElement(By.xpath("//input[@id = 'FlightsDateStart']")).click();

        while(true){
            String defdate = driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[2]")).getText();
            System.out.println("month from page:"+defdate);
            System.out.println("month only:"+defdate.substring(0,3));
            if(defdate.substring(0,3).equals(month)){
                System.out.println("equal months");
                break;
            }
            driver.findElement(By.xpath("//div[@id = 'datepickers-container']/div[7]/nav/div[3]")).click();
            //driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[3]/svg/path")).click();
            //driver.findElement(By.cssSelector("#datepickers-container > div:nth-child(7) > nav > div:nth-child(3) > svg > path")).click();
        }
        Thread.sleep(5000);
        System.out.println("before selecting the date");
        String pageday ="";
        int m=1;

        while(m<42){
            pageday = driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div/div[2]/div["+m+"]")).getText();
            System.out.println(driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div/div[2]/div["+m+"]")).getText());
            //if(day.equals(pageday)){
            if(Integer.parseInt(day) == Integer.parseInt(pageday)){
                driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div/div[2]/div["+m+"]")).click();

                break;


            }
            m++;
        }
    Thread.sleep(5000);


    }
}

