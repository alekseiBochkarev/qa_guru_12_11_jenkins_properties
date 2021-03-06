package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTestsJunit5 {
    @BeforeAll
    static void initDB () {
        System.out.println("### @BeforeAll");
    }

    @BeforeEach
    void openYaPage() {
        System.out.println("### @BeforeEach");
        Selenide.open("https://ya.ru");
    }

    @AfterEach
    void closeWindow () {
        System.out.println("### @AfterEach");
        WebDriverRunner.closeWindow();
    }

    @AfterAll
    static void cleanDB () {
        System.out.println("### @AfterAll");
    }


    @Test
    void assertTest () {
        System.out.println("###         first test");
    }

    @Test
    void assertTest2 () {
        System.out.println("###       second test");
    }

}
