import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class HelloSeleniumTest {
    @BeforeClass
    public static void setupClass(){ WebDriverManager.chromedriver().setup(); }

    @Test
    public void firstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        String originalWindow = driver.getWindowHandle();

        synchronized (driver) {
            driver.wait(2000);
        }

        driver.navigate().to("https://obs.yildiz.edu.tr/");

        synchronized (driver) {
            driver.wait(2000);
        }

        Point obsPosition = driver.manage().window().getPosition();
        System.out.println("OBS Position: " + obsPosition.getX() + ", " + obsPosition.getY());
        Dimension obsSize = driver.manage().window().getSize();
        System.out.println("OBS Size: " + obsSize.getWidth() + ", " + obsSize.getHeight());

        driver.manage().window().minimize();
        synchronized (driver) {
            driver.wait(2000);
        }
        driver.manage().window().maximize();
        synchronized (driver) {
            driver.wait(2000);
        }
        driver.manage().window().fullscreen();
        synchronized (driver) {
            driver.wait(2000);
        }

        WebElement ytuLogo = driver.findElement(By.id("imgUniLogo"));
        File logoSrc = ytuLogo.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(logoSrc, new File("downloads/ytuLogo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        obsPosition = driver.manage().window().getPosition();
        System.out.println("NEW OBS Position: " + obsPosition.getX() + ", " + obsPosition.getY());
        obsSize = driver.manage().window().getSize();
        System.out.println("NEW OBS Size: " + obsSize.getWidth() + ", " + obsSize.getHeight());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.demoblaze.com/");

        synchronized (driver) {
            driver.wait(2000);
        }

        driver.manage().window().setSize(new Dimension(500, 333));

        synchronized (driver) {
            driver.wait(2000);
        }

        driver.manage().window().setPosition(new Point(150, 200));
        File srcSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcSS, new File("downloads/demoBlazeSS.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("console.log('Hello World!!!')");


        synchronized (driver) {
            driver.wait(2000);
        }

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.switchTo().window(originalWindow);

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        synchronized (driver) {
            driver.wait(5000);
        }

        driver.quit();
    }
}
