import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com/");
            String title = driver.getTitle();
            if (title.contains("Swag Labs")) {
                System.out.println("Тест пройшов: заголовок Swag Labs");
            } else {
                System.out.println("Тест не пройдено: заголовок не Swag Labs");
            }
            //hw10 перевірка елементів
            WebElement passwordInput = driver.findElement(By.cssSelector("input[data-test='password']"));
            System.out.println("CSS Selector: Поле паролю знайдене");
        } finally {
            driver.quit();
        }
    }
}
