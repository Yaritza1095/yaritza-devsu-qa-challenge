package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndTest {
    public static void main(String[] args) throws InterruptedException{
        //Create the webdriver instance
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to Website
        driver.get("https://www.saucedemo.com/");


        //Login to the website

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement login_button = driver.findElement(By.id("login-button"));

        //Added sleep method for slow execution
        Thread.sleep(1000);
        login_button.click();


        //Selecting a product
        WebElement onesie = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        onesie.click();

        WebElement light = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        light.click();

        // go to cart page
        WebElement button_go_to_cart = driver.findElement(By.className("shopping_cart_link"));
        Thread.sleep(1000);
        button_go_to_cart.click();

        // click checkout button
        WebElement button_checkout = driver.findElement(By.id("checkout"));
        Thread.sleep(1000);
        button_checkout.click();

        // enter details and click continue
        String first_name = "Yaritza";
        String last_name = "Miranda";
        String zip = "10514";

        WebElement input_first_name = driver.findElement(By.id("first-name"));
        input_first_name.sendKeys(first_name);

        WebElement input_last_name = driver.findElement(By.id("last-name"));
        input_last_name.sendKeys(last_name);

        WebElement input_zip = driver.findElement(By.id("postal-code"));
        input_zip.sendKeys(zip);

        WebElement button_continue = driver.findElement(By.id("continue"));
        Thread.sleep(1000);
        button_continue.click();

        WebElement button_finish = driver.findElement(By.id("finish"));
        Thread.sleep(1000);
        button_finish.click();

        // verify
        String expected_msg = "Thank you for your order!";
        WebElement label_msg = driver.findElement(By.className("complete-header"));
        String actual_msg = label_msg.getText();

        if (expected_msg.equals(actual_msg)) {
            System.out.println("Success: Item checkout.");
        } else {
            System.out.println("Fail: Item checkout.");
        }

        Thread.sleep(1000);

        // close the WebDriver instance
        driver.close();

    }
}
