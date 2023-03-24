package unitTests;

import config.ConfigurationManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseDriverElementTests
{
    WebElement fakeElement;
    BaseDriverElementPirate baseDriverElementPirate;
    String fakeData, fakeValue ,fakeText, fakeAttribute;
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
        baseDriverElementPirate = new BaseDriverElementPirate();
        fakeData = "UnitTest1";
        fakeValue = "UnitTest2";
        fakeAttribute= "UnitTest3";
        fakeText = "positive";
        fakeIndex = 0;
    }

    @Test
    public void should_able_to_click()
    {
        //act
        baseDriverElementPirate.click(fakeElement);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
    }

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
    public void should_able_to_clear()
    {
        //act
        baseDriverElementPirate.clear(fakeElement);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
    }

    @Test
    public void should_able_to_clear_and_type()
    {
        //act
        baseDriverElementPirate.clearAndType(fakeElement,fakeData);

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

    @Test
    public void should_return_background_color()
    {
        //act
        String fakeElementColor= baseDriverElementPirate.getBackgroundColor(fakeElement);

        //assert
        Assertions.assertEquals("Test Passed",fakeElementColor);
    }

    @Test
    public void should_return_typed_text()
    {
        //act
        String fakeTypedText= baseDriverElementPirate.getTypedText(fakeElement);

        //assert
        Assertions.assertEquals("Test Passed",fakeTypedText);
    }

    @Test
    public void should_able_to_select_dropdown_using_text()
    {
        //act
        baseDriverElementPirate.selectDropDownUsingText(fakeElement,fakeValue);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
        Assertions.assertEquals(fakeValue, baseDriverElementPirate.getRecentlyCalledWithS());
    }

    @Test
    public void should_able_to_select_dropdown_using_index()
    {
        //act
        baseDriverElementPirate.selectDropDownUsingIndex(fakeElement,fakeIndex);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
        Assertions.assertEquals(fakeIndex, baseDriverElementPirate.getRecentlyCalledWithI());
    }

    @Test
    public void should_able_to_select_dropdown_using_value()
    {
        //act
        baseDriverElementPirate.selectDropDownUsingValue(fakeElement,fakeValue);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
        Assertions.assertEquals(fakeValue, baseDriverElementPirate.getRecentlyCalledWithS());
    }

    @Test
    public void should_return_result_of_exact_text_match()
    {
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyExactText(fakeElement,fakeText);


        //assert
        Assertions.assertEquals(true,verificationResult);

        //arrange
        fakeText = "negative";

        //act
        verificationResult= baseDriverElementPirate.verifyExactText(fakeElement,fakeText);

        //assert
        Assertions.assertEquals(false,verificationResult);
    }

    @Test
    public void should_return_result_of_partial_text_match()
    {
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyPartialText(fakeElement,fakeText);

        //assert
        Assertions.assertEquals(true,verificationResult);

        //arrange
        fakeText = "negative";

        //act
        verificationResult= baseDriverElementPirate.verifyPartialText(fakeElement,fakeText);

        //assert
        Assertions.assertEquals(false,verificationResult);
    }

    @Test
    public void should_return_result_of_exact_attribute_match()
    {
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyExactAttribute(fakeElement,fakeAttribute,fakeText);

        //assert
        Assertions.assertEquals(true,verificationResult);

        //arrange
        fakeText = "negative";

        //act
        verificationResult= baseDriverElementPirate.verifyExactAttribute(fakeElement,fakeAttribute,fakeText);

        //assert
        Assertions.assertEquals(false,verificationResult);
    }

    @Test
    public void should_return_result_of_partial_attribute_match()
    {;
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyExactAttribute(fakeElement,fakeAttribute,fakeText);

        //assert
        Assertions.assertEquals(true,verificationResult);

        //arrange
        fakeText = "negative";

        //act
        verificationResult= baseDriverElementPirate.verifyExactAttribute(fakeElement,fakeAttribute,fakeText);

        //assert
        Assertions.assertEquals(false,verificationResult);
    }

    @Test
    public void should_return_result_of_element_is_displayed()
    {
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyDisplayed(fakeElement);

        //assert
        Assertions.assertEquals(true,verificationResult);
    }

    @Test
    public void should_return_result_of_element_is_disappeared()
    {
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyDisappeared(fakeElement);

        //assert
        Assertions.assertEquals(true,verificationResult);
    }

    @Test
    public void should_return_result_of_element_is_enabled()
    {
        //act
        Boolean verificationResult= baseDriverElementPirate.verifyEnabled(fakeElement);

        //assert
        Assertions.assertEquals(true,verificationResult);
    }

    @Test
    public void should_return_result_of_element_is_selected()
    {
        //act
        baseDriverElementPirate.verifySelected(fakeElement);

        //assert
        Assertions.assertEquals(1, baseDriverElementPirate.getTimesCalled());
        Assertions.assertEquals(fakeElement, baseDriverElementPirate.getRecentlyCalledWithWE());
    }


}
