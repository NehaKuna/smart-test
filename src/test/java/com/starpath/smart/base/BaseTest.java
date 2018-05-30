package com.starpath.smart.base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/*
base class to hold locateElement method that is used by various junit test classes
 */
public class BaseTest{
    public WebElement locateElement(final WebDriver driver, final By byType, long timeout) throws TimeoutException, IllegalArgumentException {
        WebElement element = null;

        if (null == byType) {
            throw new IllegalArgumentException("byType is null");
        }

        element = (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(byType);
            }
        });
        return element;
    }

    public List<WebElement> locateElements(final WebDriver driver, final By byType, long timeout) throws TimeoutException, IllegalArgumentException {
        List<WebElement> elements = null;

        if (null == byType) {
            throw new IllegalArgumentException("byType is null");
        }

        elements = (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<java.util.List<WebElement>>() {
            public List<WebElement> apply(WebDriver d) {
                return d.findElements(byType);
            }
        });
        return elements;
    }
}
