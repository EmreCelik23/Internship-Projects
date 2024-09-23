import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class AlertsTest {
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();
        assertTrue(driver.getPageSource().contains("You successfully clicked an alert"));

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        assertTrue(driver.getPageSource().contains("You clicked: Cancel"));

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/button[1]")).click();
        Alert alert3 = driver.switchTo().alert();
        String input = "Emre Çelik";
        System.out.println(alert3.getText());
        alert3.sendKeys(input);
        alert3.accept();
        assertTrue(driver.getPageSource().contains("You entered: %s".formatted(input)));

        driver.quit();
    }
}
