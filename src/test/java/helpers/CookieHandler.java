package helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CookieHandler {
    public static void writeCookiesToFile(WebDriver driver, String filename) {
        Set<Cookie> cookies = driver.manage().getCookies();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("PHPSESSID"))
                    writer.write(cookie.getName() + "=" +
                            cookie.getValue());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Cookie> readCookiesFromFile(String filename) {
        Set<Cookie> cookies = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cookieData = line.split("; ");
                String name = cookieData[0].split("=")[0];
                String value = cookieData[0].split("=")[1];
                Cookie cookie = new Cookie(name, value);
                cookies.add(cookie);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookies;
    }

    public static Boolean CheckFileExistence(String filename) {
        File file = new File(filename);
        return file.exists() && file.length() != 0;
    }

    public static void setCookieToDriver(WebDriver driver, String filename) {
        Set<Cookie> cookies = CookieHandler.readCookiesFromFile(filename);
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }
}


