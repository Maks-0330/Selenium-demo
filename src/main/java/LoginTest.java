import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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
        } finally {//
            driver.quit();
        }
    }
}
