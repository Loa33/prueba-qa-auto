package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class Actions {

    public static void sendKeysWithWait(WebDriverWait wait, WebElement webElement, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            log.error("No se encontró el elemento {}.", e.getMessage());
        } catch (Exception e) {
            log.error("Ocurrió un error al interactuar con el elemento {}.", e.getMessage());
        }
    }

    public static void clickWithWait(WebDriverWait wait, WebElement webElement) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
            element.click();
        } catch (NoSuchElementException e) {
            log.error("No se encontró el elemento {}.", e.getMessage());
        } catch (Exception e) {
            log.error("Ocurrió un error al interactuar con el elemento {}.", e.getMessage());
        }
    }
}
