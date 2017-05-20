package com.github.mikan;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class HelloWorldTest {

    @BeforeClass
    public static void beforeClass() {
        Configuration.browser = WebDriverRunner.CHROME;
        System.setProperty("webdriver.chrome.driver", "C:/opt/bin/chromedriver.exe");
        Configuration.timeout = 10;
        VaadinSpringDemoApplication.main(new String[]{"--server.port=8080", "--spring.profiles.active=test"});
    }

    @Test
    public void すごーいボタンがある() {
        open("http://localhost:8080/");
        $("#selenide-amazing-button").should(appear);
        $("#selenide-amazing-button").shouldHave(text("すごーい!"));
        $("#selenide-amazing-button").click();
        screenshot("すごーいボタンがある");
        $(".v-Notification-caption").should(appear);
        $(".v-Notification-caption").shouldHave(text("たーのしー!"));
        screenshot("すごーいボタンを押した");
    }
}
