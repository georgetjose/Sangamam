package unitTests;

import design.Browser;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class BaseDriverBrowserPirate implements Browser
{
    int timesCalled=0;
    WebElement recentlyCalledWithWE = null;
    String recentlyCalledWithS1 = null;
    String recentlyCalledWithS2 = null;
    int recentlyCalledWithI = 0;
    WebElement ele = null;

    @Override
    public void startApp(String url) {
        recentlyCalledWithS1 = url;
        timesCalled++;
    }

    @Override
    public void startApp(String browser, String url) {
        recentlyCalledWithS1 = browser;
        recentlyCalledWithS2 = url;
        timesCalled++;
    }

    @Override
    public WebElement locateElement(String locatorType, String value) {
        return null;
    }

    @Override
    public WebElement locateElement(String value) {
        return null;
    }

    @Override
    public List<WebElement> locateElements(String type, String value) {
        return null;
    }

    @Override
    public void switchToAlert() {

    }

    @Override
    public void acceptAlert() {

    }

    @Override
    public void dismissAlert() {

    }

    @Override
    public String getAlertText() {
        return null;
    }

    @Override
    public void typeAlert(String data) {

    }

    @Override
    public void switchToWindow(int index) {

    }

    @Override
    public void switchToWindow(String title) {

    }

    @Override
    public void switchToFrame(int index) {

    }

    @Override
    public void switchToFrame(WebElement ele) {

    }

    @Override
    public void switchToFrame(String idOrName) {

    }

    @Override
    public void defaultContent() {

    }

    @Override
    public boolean verifyUrl(String url) {
        return false;
    }

    @Override
    public boolean verifyTitle(String title) {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }
}
