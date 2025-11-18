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
            try {
                WebElement usernameImput = driver.findElement(By.id("user-name"));
                System.out.println("ID: поле логіну знайдено");
            } catch (Exception e) {
                System.out.println("Не знайдено ID елемент");
            }

            try {
                WebElement loginBtn = driver.findElement(By.className("submit-button"));
                System.out.println("ClassName: Кнопка логіну знайдене");
            } catch (Exception e) {
                System.out.println("Не знайдено ClassName елемент");
            }
            try {
                WebElement credentialsBox = driver.findElement(By.xpath("//div[@id='login_credentials']"));
                System.out.println("Xpath: Блок логін даних знайдене");
            } catch (Exception e) {
                System.out.println("Не знайдено Xpath елемент");
            }

            try {
                WebElement passwordInput = driver.findElement(By.cssSelector("input[data-test='password']"));
                System.out.println("CSS Selector: Поле паролю знайдене");
            } catch (Exception e) {
                System.out.println("Не знайдено CSS елемент");
            }
        } finally {
            driver.quit();
        }
    }
}
