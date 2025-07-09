package resuable;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseCode {

   public static WebDriver driver;
    public static void browserCall() throws IOException {

        File f = new File("src/main/resources/configuration/frameworkconfig.properties");
        FileInputStream fis = new FileInputStream(f);

        Properties prob = new Properties();
        prob.load(fis);


//        if(prob.getProperty("browser").equalsIgnoreCase("chrome")){
//            driver = new ChromeDriver();
//        }
//        else if(prob.getProperty("browser").equalsIgnoreCase("edge")){
//            driver = new EdgeDriver();
//        }
//        else if(prob.getProperty("browser").equalsIgnoreCase("safari")){
//            driver = new SafariDriver();
//        }
//        else{
//
//            throw new InvalidArgumentException("please enter correct browser");
//
//        }

        switch (prob.getProperty("browser").toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver();
            case "edge" -> driver = new EdgeDriver();
            case "safari" -> driver = new SafariDriver();
            default -> throw new InvalidArgumentException("enter thr browser name");
        }
           System.out.println("souja");
        driver.navigate().to(prob.getProperty("url"));
        driver.manage().window().maximize();
    }

}
