package com.example1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws InterruptedException {
        // ?Comment
        // !Comment
        // TODO:
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://letcode.in/test");
        driver.manage().window().maximize();
        Inputs.input(driver);
        Buttons.button(driver);
        DropDown.dropDowns(driver);
        Alerts.alerts(driver);
        RadioButton.radioButton(driver);
        MulitSelect.multiSelect(driver);
        Drop.drag(driver);
        Drag.drag(driver);
        Frames.frames(driver);
    }
}

class DropDown {
    static void dropDowns(WebDriver driver) {
        driver.findElement(By.xpath("//*[text()='Drop-Down']")).click();
        WebElement dropValues = driver.findElement(By.xpath("//*[@id='fruits']"));
        Select dropDown = new Select(dropValues);
        dropDown.selectByVisibleText("Banana");
        String result = driver.findElement(By.xpath("//*[@class='subtitle']")).getText();
        System.out.println(result);

        WebElement multiSelect = driver.findElement(By.xpath("//*[@id='superheros']"));
        Select mcqSelect = new Select(multiSelect);
        boolean mcq = mcqSelect.isMultiple();
        if (mcq == true) {
            System.out.println("MCQ");
        } else {
            System.out.println("Not an MCQ");
        }
        mcqSelect.selectByIndex(3);
        String dropDownValue = driver.findElement(By.xpath("(//*[@class='subtitle'])[2]")).getText();
        System.out.println(dropDownValue);

        WebElement program = driver.findElement(By.xpath("//*[@id='lang']"));
        Select prgm = new Select(program);
        prgm.selectByValue("sharp");
        List<WebElement> prgmlist = prgm.getOptions();
        for (WebElement i : prgmlist) {
            String values = i.getText();
            System.out.println(values);
        }

        WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
        Select Country = new Select(country);
        Country.selectByValue("India");
        WebElement selectedCountry = Country.getFirstSelectedOption();
        System.out.println(selectedCountry.getText());
        driver.navigate().back();
        System.out.println("------------------------------------------->>>DropDowns");

    }

}

class RadioButton {
    static void radioButton(WebDriver driver) {
        driver.findElement(By.xpath("(//*[@class='card-footer-item'])[6]")).click();
        driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
        WebElement radio1 = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        radio1.click();
        WebElement radio2 = driver.findElement(By.xpath("(//*[@type='radio'])[4]"));
        radio2.click();
        boolean value1 = radio1.isSelected();
        boolean value2 = radio2.isSelected();
        if (value1 && value2 == true) {
            System.err.println("Both the buttons are selected");
        } else {
            System.out.println("Only one button is selected");
        }
        WebElement radio3 = driver.findElement(By.xpath("(//*[@type='radio'])[5]"));
        radio3.click();
        WebElement radio4 = driver.findElement(By.xpath("(//*[@type='radio'])[6]"));
        radio4.click();
        boolean value3 = radio3.isSelected();
        boolean value4 = radio4.isSelected();
        if (value3 && value4 == true) {
            System.err.println("ERROR OCCURED: Both the buttons are selected");
        } else {
            System.out.println("Only one button is selected");
        }

        WebElement value5 = driver.findElement(By.xpath("(//*[@type='radio'])[7]"));
        if (value5.isSelected()) {
            System.out.println("Foo is selected");
        } else {
            System.out.println("Bar is selected");
        }

        WebElement value7 = driver.findElement(By.xpath("(//*[@type='radio'])[11]"));
        boolean returnValue = value7.isEnabled();
        if (returnValue == true) {
            System.out.println("Condition fail the button is enabled");
        } else {
            System.out.println("Condition passed the button is in disable state");
        }
        WebElement checkbox = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        boolean checked = checkbox.isSelected();
        if (checked == true) {
            System.out.println("Checked");
        } else {
            System.out.println("Not Checked");
        }
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        boolean checked1 = checkbox1.isSelected();
        if (checked1 == true) {
            System.out.println("Checked");
        } else {
            System.out.println("Not Checked");
        }
        driver.navigate().back();
        System.out.println("------------------------------------------->>>RadioButtons");
    }

}

class Buttons {
    static void button(WebDriver driver) {
        driver.findElement(By.xpath("//*[text()='Click']")).click();
        driver.findElement(By.id("home")).click();
        String h1Tag = driver.findElement(By.xpath("/html/body/app-root/app-main/section[1]/div/div/div[1]/div/h1"))
                .getText();
        System.out.println(h1Tag);
        driver.navigate().back();
        Point size = driver.findElement(By.id("position")).getLocation();
        System.out.println(size);
        String BackGroundColor = driver.findElement(By.id("color")).getCssValue("background-color");
        System.out.println(BackGroundColor);
        Dimension Dimension = driver.findElement(By.id("property")).getSize();
        System.out.println(Dimension);
        boolean ButtonState = driver.findElement(By.id("isDisabled")).isEnabled();
        System.out.println(ButtonState);
        WebElement button = driver.findElement(By.id("isDisabled"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(button).pause(2000).release().perform();
        WebElement h2Text = driver.findElement(By.id("isDisabled"));
        String h2 = h2Text.getText();
        System.out.println(h2);
        driver.navigate().back();
        System.out.println("------------------------------------------->>>Buttons");
    }

}

class Alerts {
    static void alerts(WebDriver driver) {
        driver.findElement(By.xpath("(//*[@class='card-footer-item'])[4]")).click();
        driver.findElement(By.xpath("//*[@id='accept']")).click();
        Alert accept = driver.switchTo().alert();
        accept.accept();
        driver.findElement(By.xpath("//*[@id='confirm']")).click();
        Alert dismiss = driver.switchTo().alert();
        String alertMessage = dismiss.getText();
        dismiss.dismiss();
        System.out.println(alertMessage);
        driver.findElement(By.xpath("//*[@id='prompt']")).click();
        Alert sendKeys = driver.switchTo().alert();
        sendKeys.sendKeys("testMessage");
        sendKeys.accept();
        String retuenMessage = driver.findElement(By.xpath("//*[@id='myName']")).getText();
        System.out.println(retuenMessage);
        driver.findElement(By.xpath("//*[@id='modern']")).click();
        String modernAlert = driver.findElement(By.xpath("//*[@class='title']")).getText();
        System.out.println(modernAlert);
        driver.findElement(By.xpath("//*[@class='modal-close is-large']")).click();
        driver.navigate().back();
        System.out.println("------------------------------------------->>>Alerts");
    }
}

class Inputs {
    static void input(WebDriver driver) {
        driver.findElement(By.className("card-footer-item")).click();
        driver.findElement(By.id("fullName")).sendKeys("Full Name");
        driver.findElement(By.id("join")).sendKeys(" Appended at the end of the text");
        WebElement value = driver.findElement(By.id("getMe"));
        String textvalue = value.getAttribute("value");
        System.out.println(textvalue);
        driver.findElement(By.id("clearMe")).clear();
        boolean returntype = driver.findElement(By.id("noEdit")).isEnabled();
        System.out.println(returntype);
        boolean values = driver.findElement(By.id("dontwrite")).getAttribute("readonly") != null;
        System.out.println(values);
        driver.navigate().back();
        System.out.println("------------------------------------------->>>Inputs");
    }

}

class MulitSelect {

    static void multiSelect(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement selectable = driver.findElement(By.xpath("(//*[@class='card-footer-item'])[12]"));
        selectable.click();
        List<WebElement> programmingLanguages = driver.findElements(By.xpath("//*[@id='selectable']"));
        // !Recheck this loop
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL);
        for (int i = 0; i < programmingLanguages.size(); i++) {
            WebElement lang = programmingLanguages.get(i);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(lang));
            actions.click(lang);
        }
        actions.keyUp(Keys.CONTROL).build().perform();

        // for (WebElement webElement : programmingLanguages) {
        // Actions actions = new Actions(driver);
        // actions.keyDown(Keys.CONTROL).click();
        // System.out.println(webElement.getText());
        // actions.keyUp(Keys.CONTROL).perform();
        // }

        // driver.navigate().back();
        System.out.println("------------------------------------------->>>MultiSelect");

    }
}

class Drop {
    static void drag(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement dragpath = driver.findElement(By.xpath("(//*[@class='card-footer-item'])[10]"));
        dragpath.click();
        WebElement draggable = driver.findElement(By.xpath("//*[@id='text']"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        // actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        actions.dragAndDrop(draggable, droppable).release().build().perform();
        WebElement text = driver.findElement(By.xpath("//*[@id='droppable']/p"));
        String result = text.getText();
        System.out.println(result);
        System.out.println("------------------------------------------->>>Drop");
    }

}

class Frames {
    static void frames(WebDriver driver) {
        driver.findElement(By.xpath("(//*[@class='card-footer-item'])[5]")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@name='fname']")).sendKeys("First Name Test");
        driver.findElement(By.xpath("//*[@name='lname']")).sendKeys("Last Name Test");
        String name1 = driver.findElement(By.xpath("//*[@class='title has-text-info']")).getText();
        System.out.println(name1);
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("email");
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//*[@name='lname']")).sendKeys(" Last Name");
        String name2 = driver.findElement(By.xpath("//*[@class='title has-text-info']")).getText();
        System.out.println(name2);
        System.out.println("------------------------------------------->>>Frame");
        driver.navigate().back();
    }
}

class Drag {
    static void drag(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement dragpath = driver.findElement(By.xpath("(//*[@class='card-footer-item'])[9]"));
        dragpath.click();
        // driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.id("sample-box"));
        Actions actions = new Actions(driver);
        int x = drag.getLocation().getX();
        int y = drag.getLocation().getY();
        System.out.println(x + ", " + y);
        // actions.clickAndHold(drag);
        actions.dragAndDropBy(drag, 350, 300).perform();
        System.out.println("------------------------------------------->>>Drag");
        driver.navigate().back();
    }
}
