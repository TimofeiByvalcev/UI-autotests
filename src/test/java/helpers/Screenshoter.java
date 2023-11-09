package helpers;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class Screenshoter {
    public static byte[] makeAScreenshot(WebDriver driver) {
        Screenshot screenshot = new AShot()
                .takeScreenshot(driver);
        ByteArrayOutputStream imageBufferedStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "png", imageBufferedStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageBufferedStream.toByteArray();
    }
}
