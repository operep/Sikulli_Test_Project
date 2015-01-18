package SikuliTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class DownloadSikuliTest {

    private WebDriver driver;
    public static final String BASE_URL = "http://andbook.anddev.org/files/andbook.pdf";
    public static final String IMAGES_URL = "E:\\Documents\\Projects\\SikulliTestProject\\img\\";
    public static final String DOWNLOAD_BUTTON = "download_button_2.png";
    public static final String DESKTOP_LINK = "desktop_link.png";
    public static final String SAVE_BUTTON = "save_button.png";
    public static final String DOWNLOADED_BOOK = "downloaded_book.png";
    public static final int DELAY = 7000;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (!(driver == null)) {
            driver.quit();
        }
    }

    @Test
    public void downloadTest() throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        screen.getRobot().delay(DELAY);

        screen.click(buildPathToFile(DOWNLOAD_BUTTON));
        screen.click(buildPathToFile(DESKTOP_LINK));
        screen.click(buildPathToFile(SAVE_BUTTON));
        screen.type("d", KeyModifier.WIN);
        screen.find(buildPathToFile(DOWNLOADED_BOOK));
    }

    private String buildPathToFile(String fileName) {
        return Paths.get(IMAGES_URL + fileName).toString();
    }
}
