import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocalPage {
    public static void main(String[] args) {
        try {
            // Устанавливаем путь к ChromeDriver (важно!)
            System.setProperty("webdriver.chrome.driver", "C:\chromedriver\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            // Строим URL для локального сервера
            String url = "http://localhost:8000";

            // Открываем страницу
            driver.get(url);

            // Проверка: заголовок страницы
            String title = driver.getTitle();
            System.out.println("Page title: " + title);

            if (title == null || title.isEmpty()) {
                throw new RuntimeException("Page did NOT load correctly!");
            }

            System.out.println("SUCCESS: Page opened!");

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1); // Важно для Jenkins (падение билда)
        }
    }
}
