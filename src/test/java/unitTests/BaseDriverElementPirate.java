package unitTests;

import design.Element;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class BaseDriverElementPirate implements Element
{
    int timesCalled=0;
    WebElement recentlyCalledWithWE = null;
    String recentlyCalledWithS = null;
    int recentlyCalledWithI = 0;
    WebElement ele = null;


    @Override
    public void click(WebElement ele)
    {
        recentlyCalledWithWE = ele;
        timesCalled++;
    }

    @Override
    public void append(WebElement ele, String data)
    {
        recentlyCalledWithWE = ele;
        recentlyCalledWithS = data;
        timesCalled++;
    }

    @Override
    public void clear(WebElement ele)
    {
        recentlyCalledWithWE = ele;
        timesCalled++;
    }

    @Override
    public void clearAndType(WebElement ele, String data)
    {
        recentlyCalledWithWE = ele;
        recentlyCalledWithS = data;
        timesCalled++;
    }

    @Override
    public String getElementText(WebElement ele) {
        return "Test Passed";
    }

    @Override
    public String getBackgroundColor(WebElement ele) {
        return "Test Passed";
    }

    @Override
    public String getTypedText(WebElement ele) {
        return "Test Passed";
    }

    @Override
    public void selectDropDownUsingText(WebElement ele, String value)
    {
        recentlyCalledWithWE = ele;
        recentlyCalledWithS = value;
        timesCalled++;
    }

    @Override
    public void selectDropDownUsingIndex(WebElement ele, int index)
    {
        recentlyCalledWithWE = ele;
        recentlyCalledWithI = index;
        timesCalled++;
    }

    @Override
    public void selectDropDownUsingValue(WebElement ele, String value) {
        recentlyCalledWithWE = ele;
        recentlyCalledWithS = value;
        timesCalled++;

    }

    @Override
    public boolean verifyExactText(WebElement ele, String expectedText) {
        if(expectedText.equals("positive"))
            return true;
        else
            return false;
    }

    @Override
    public boolean verifyPartialText(WebElement ele, String expectedText) {
        if(expectedText.equals("positive"))
            return true;
        else
            return false;
    }

    @Override
    public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
        if(value.equals("positive"))
            return true;
        else
            return false;
    }

    @Override
    public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
        if(value.equals("positive"))
            return true;
        else
            return false;
    }

    @Override
    public boolean verifyDisplayed(WebElement ele) {
        if(ele != null)
            return true;
        else
            return false;
    }

    @Override
    public boolean verifyDisappeared(WebElement ele) {
        if(ele != null)
            return true;
        else
            return false;
    }

    @Override
    public boolean verifyEnabled(WebElement ele) {
        if(ele != null)
            return true;
        else
            return false;
    }

    @Override
    public void verifySelected(WebElement ele) {
        recentlyCalledWithWE = ele;
        timesCalled++;
    }
}
