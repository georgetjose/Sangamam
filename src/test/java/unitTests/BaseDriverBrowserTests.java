package unitTests;

import config.ConfigurationManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseDriverBrowserTests
{
    WebElement fakeElement;
    BaseDriverBrowserPirate baseDriverBrowserPirate;
    String fakeUrl, fakeValue ,fakeText, fakeAttribute;
    int fakeIndex;

    @BeforeEach
    public void captureWebElement()
    {
        //arrange
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(ConfigurationManager.configuration().baseUrl());
        fakeElement = driver.findElement(By.xpath("//html"));
        baseDriverBrowserPirate = new BaseDriverBrowserPirate();
        fakeUrl = "Chromium";
        fakeValue = "UnitTest2";
        fakeAttribute= "UnitTest3";
        fakeText = "positive";
        fakeIndex = 5;
    }
/*
    @Test
    public void should_able_to_append()
    {
        //act
        baseDriverElementPirate.append(fakeElement,fakeData);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
        Assertions.assertEquals(fakeData, baseDriverElementPirate.getRecentlyCalledWithS());
    }

    @Test
    public void should_return_element_text()
    {
        //act
        String fakeElementText = baseDriverElementPirate.getElementText(fakeElement);

        //assert
        Assertions.assertEquals("Test Passed",fakeElementText);
    }
*/
    @Test
    public void should_able_to_startApp()
    {
        //act
        baseDriverBrowserPirate.startApp(fakeUrl);

        //assert
        Assertions.assertEquals(1, baseDriverBrowserPirate.getTimesCalled());
        Assertions.assertEquals(fakeUrl, baseDriverBrowserPirate.getRecentlyCalledWithS1());
    }

    @Test
    public void should_able_to_startApp_with_browser()
    {
        //arrange
        String fakeBrowser = "Chromium";

        //act
        baseDriverBrowserPirate.startApp(fakeBrowser, fakeUrl);

        //assert
        Assertions.assertEquals(1, baseDriverBrowserPirate.getTimesCalled());
        Assertions.assertEquals(fakeUrl, baseDriverBrowserPirate.getRecentlyCalledWithS1());
        Assertions.assertEquals(fakeBrowser, baseDriverBrowserPirate.getRecentlyCalledWithS2());
    }
}
