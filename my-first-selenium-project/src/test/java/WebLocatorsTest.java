import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class WebLocatorsTest {

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("obs ytü", Keys.ENTER);
        driver.findElement(By.xpath("//h3")).click();
        driver.findElement(By.xpath("//a[2]")).click();
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(driver.findElement(By.name("txtSecCode")))).sendKeys("1234");


        driver.navigate().to("https://www.youtube.com/watch?v=jb-5_QZpZk0&list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH&index=3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("playlist-items")));
        List<WebElement> list = driver.findElements(By.id("playlist-items"));

        for (WebElement item : list) {
            System.out.println(item.getText());
        }
        driver.quit();
    }

}
