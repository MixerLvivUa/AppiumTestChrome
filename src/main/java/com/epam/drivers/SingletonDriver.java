package com.epam.drivers;

import com.epam.preferences.Preferences;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    private static Map<Long, AppiumDriver> drivers = new HashMap<>();

    private SingletonDriver() {
    }

    private static AppiumDriver newInstance() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 22");

        capability.setCapability("appPackage", "com.android.chrome");
        capability.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new AppiumDriver(url, capability);
        driver.manage().timeouts().implicitlyWait(Preferences.preferencesTestGmail.getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public static AppiumDriver getDriver() {
        return drivers.computeIfAbsent(Thread.currentThread().getId(), f -> newInstance());
    }

    public static void closeDriver() {
        getDriver().quit();
        drivers.remove(Thread.currentThread().getId());
    }
}