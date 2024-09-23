import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageLoadingTest {
    static ChromeOptions options = new ChromeOptions();
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        //driver.switchTo().activeElement().getAttribute()
        //driver.findElement(By.smth).isEnabled()
        //driver.findElement(By.smth).isSelected()

        //Actions actionProvider = new Actions(driver);
        //Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
        //keydown.perform();
        //.clear - .keyUp()

        //actionProvider.moveToElement(somewhere) - moving the cursor
        //actionProvider.clickAndHold()
        //actionProvider.release().perform()
        //actionProvider.contextClick() - right click
        //actionProvider.doubleClick() - double click
        //actionProvider.dragAndDrop(elem1, elem2) - drag from a place drop to somewhere

        //WebElement dropdown = driver.findElement(By.something)
        //Select selectObject = new Select(dropdown)
        //selectObject.selectByIndex(1)
        //selectObject.selectByValue("option 2")
        //selectObject.selectByVisibleText("option 3")

        //List<WebElement> allOptions = selectObject.getOptions();

    }

    @Test
    public void test() {
        driver.get("https://www.google.com");
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
