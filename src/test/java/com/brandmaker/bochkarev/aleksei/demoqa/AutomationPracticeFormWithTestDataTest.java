package com.brandmaker.bochkarev.aleksei.demoqa;

import com.github.javafaker.Faker;
import config.BaseSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import utils.ToolsForTests;

import java.time.LocalDate;
import java.util.Locale;

import static java.lang.String.format;

public class AutomationPracticeFormWithTestDataTest extends BaseSetup {
    /** Pages **/
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    /** Test Data **/
    enum Gender {
        Male,
        Female,
        Other
    }
    public class TestDataForAPForm {
        Faker faker = new Faker(new Locale("en"));
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String expectedFullName = format("%s %s", name, lastName);
        String email = faker.internet().emailAddress();
        String gender = Gender.values()[ToolsForTests.randomIntWithInterval(0, 2)].toString();
        //System.out.println(gender);
        String mobilePhone = ToolsForTests.getRandomString(10, false, true);
        LocalDate birth = LocalDate.of(ToolsForTests.randomIntWithInterval(1950, 2000),
                ToolsForTests.randomIntWithInterval(1, 12),
                ToolsForTests.randomIntWithInterval(1, 28));
        String month = birth.getMonth().toString().charAt(0)                 //название месяца
                + birth.getMonth().toString().substring(1).toLowerCase();
        String day = String.valueOf(birth.getDayOfMonth());
        String year = String.valueOf(birth.getYear());

        public String getDay() {
            return day;
        }

        public String getYear() {
            return year;
        }

        String subject = "Accounting";
        String hobby = "Sports";
        String imgPath = "img/screenNinja.png";
        String address = faker.address().fullAddress();
        String state = "Haryana";
        String city = "Panipat";

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public String getExpectedFullName() {
            return expectedFullName;
        }

        public String getEmail() {
            return email;
        }

        public String getGender() {
            return gender;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public LocalDate getBirth() {
            return birth;
        }

        public String getMonth() {
            return month;
        }

        public String getSubject() {
            return subject;
        }

        public String getHobby() {
            return hobby;
        }

        public String getImgPath() {
            return imgPath;
        }

        public String getAddress() {
            return address;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }
    }

    @BeforeEach
    void openPage() {
        automationPracticeFormPage.openPage();
    }

    @Test
    void homeFormsTest() {
        TestDataForAPForm testDataForAPForm = new TestDataForAPForm();
        automationPracticeFormPage.fillForm(testDataForAPForm);
        /** Asserts **/
        automationPracticeFormPage.checkFormOfResult(testDataForAPForm);
    }
}