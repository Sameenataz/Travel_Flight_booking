package Excer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Excer.Xls_Reader;

import java.util.concurrent.TimeUnit;

public class fb1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Sameena_Automation_Files\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //Reading data from excel sheet
        Xls_Reader reader = new Xls_Reader("./src/main/java/booking.xlsx");
        String  sheetName = "data";
        String from1 = reader.getCellData(sheetName,0,2);
        String to = reader.getCellData(sheetName,1,2);
        String depart = reader.getCellData(sheetName,2,2);
        String sadult = reader.getCellData(sheetName,3,2);
        String schild = reader.getCellData(sheetName,4,2);
        String sinfant = reader.getCellData(sheetName,5,2);
        int adult = 0;
        int child = 0;
        int infant = 0;
        System.out.println("adult count string"+sadult);
        try {
//            adult = Integer.parseInt(sadult.trim());

            adult = Integer.parseInt(sadult.substring(0,1));
            child = Integer.parseInt(schild.substring(0,1));
            infant = Integer.parseInt(sinfant.substring(0,1));
            System.out.println("adult count integer"+adult);
        }catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        //flight Tab
        driver.findElement(By.xpath("//a[@data-name = 'flights']")).click();

        Thread.sleep(5000);
        //From field
        driver.findElement(By.cssSelector("#s2id_location_from")).click();

        driver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys(from1);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys(Keys.ENTER);
        //To Field
        driver.findElement(By.cssSelector("#s2id_location_to")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys(to);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        System.out.println("after from and to fields");
        int i=1;
        int j=1;
        int k=1;
        //traveller count
        while(i < adult) {
            driver.findElement(By.xpath("//input[@name = 'fadults']//following-sibling::span/button[contains(text(),'+')]")).click();
            i++;
        }
        while(j <= child){
            driver.findElement(By.xpath("//input[@name = 'fchildren']//following-sibling::span/button[contains(text(),'+')]")).click();
            j++;
        }
        while(k <= infant) {
            driver.findElement(By.xpath("//input[@name = 'finfant']//following-sibling::span/button[contains(text(),'+')]")).click();
            k++;
        }
        //travel date
        driver.findElement(By.id("FlightsDateStart")).click();
        Thread.sleep(5000);
        System.out.println("date field"+ depart);
       /////date field
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

        ////date field



        //Search Button

        driver.findElement(By.xpath("//form[@name = 'flightmanualSearch']/div/div/div[3]/div[4]/button[@type = 'submit']")).click();

        //Number of flights
        Thread.sleep(5000);
        String found = driver.findElement(By.xpath("//p[contains(text(),'listings')]")).getText();
        System.out.println(found);


    }
}
