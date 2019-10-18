package com.example.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    private Validator validator;

    @Before
    public void setUp() {
        this.validator = new Validator();
    }

    @Test
    public void listHasValue() {
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(this.validator.arrayListHasValue(list, "C"));
    }

    @Test
    public void isBoolean() {
        assertTrue(
                this.validator.isBoolean("true")
        );

        assertFalse(
                this.validator.isBoolean("false")
        );

        assertFalse(
                this.validator.isBoolean("123")
        );

        assertFalse(
                this.validator.isBoolean("0")
        );
    }

    @Test
    public void isBooleanTrue() {
        assertTrue(
                this.validator.isBooleanTrue("true")
        );

        assertFalse(
                this.validator.isBooleanTrue("1")
        );

        assertFalse(
                this.validator.isBooleanTrue("0")
        );

        assertTrue(
                this.validator.isBooleanTrue(String.valueOf(true))
        );
    }

    @Test
    public void isBooleanFalse() {
        assertTrue(
                this.validator.isBooleanFalse("false")
        );

        assertTrue(
                this.validator.isBooleanFalse("0")
        );

        assertTrue(
                this.validator.isBooleanFalse(String.valueOf(false))
        );
    }

    @Test
    public void isInt() {
        assertTrue(
                this.validator.isInt("123")
        );

        assertFalse(
                this.validator.isInt("a")
        );

        assertFalse(
                this.validator.isInt("#@1")
        );
    }

    @Test
    public void isEmpty() {
        assertTrue(
                this.validator.isEmpty("")
        );

        assertTrue(
                this.validator.isEmpty(" ")
        );

        assertTrue(
                this.validator.isEmpty("  ")
        );

        assertTrue(
                this.validator.isEmpty("\t")
        );

        assertTrue(
                this.validator.isEmpty("\t\t\t")
        );
    }

    @Test
    public void isLowercase() {
        assertTrue(
                this.validator.isLowercase("a")
        );

        assertFalse(
                this.validator.isLowercase("A")
        );
    }

    @Test
    public void isUppercase() {
        assertTrue(
                this.validator.isUppercase("A")
        );

        assertFalse(
                this.validator.isUppercase("a")
        );
    }

    @Test
    public void hasSpecialChar() {
        assertTrue(
                this.validator.hasSpecialChar("123%#@ABC)")
        );

        assertFalse(
                this.validator.hasSpecialChar("123")
        );

        assertFalse(
                this.validator.hasSpecialChar("abc")
        );
    }

    @Test
    public void isEmail() {
        assertTrue(
                this.validator.isEmail("test@yahoo.com")
        );

        assertTrue(
                this.validator.isEmail("first.last@yahoo.com")
        );

        assertTrue(
                this.validator.isEmail("first_last@yahoo.com")
        );

        assertTrue(
                this.validator.isEmail("abc1980@yahoo.com")
        );

        // starts with number
        assertFalse(
                this.validator.isEmail("123test@yahoocom")
        );

        // missing `@`
        assertFalse(
                this.validator.isEmail("testyahoo.com")
        );

        // missing `.`
        assertFalse(
                this.validator.isEmail("test@yahoocom")
        );

        //  ends with `.comorg`
        assertFalse(
                this.validator.isEmail("test@yahoo.comorg")
        );

        //  ends with `.com.org`
        assertFalse(
                this.validator.isEmail("test@yahoo.com.org")
        );

        assertFalse(
                this.validator.isEmail("first=last@yahoo.com")
        );
    }

    @Test
    public void isInIntRange() {
        assertTrue(
                this.validator.isInIntRange(5, 1, 10)
        );

        assertFalse(
                this.validator.isInIntRange(500, 1, 10)
        );

        assertFalse(
                this.validator.isInIntRange(-2, 1, 10)
        );
    }

    @Test
    public void isAlpha() {
        assertTrue(
                this.validator.isAlpha("abc")
        );

        assertFalse(
                this.validator.isAlpha("abc123")
        );

        assertFalse(
                this.validator.isAlpha("123")
        );
    }

    @Test
    public void isAlphaNum() {
        assertFalse(
                this.validator.isAlphaNum("abc")
        );

        assertTrue(
                this.validator.isAlphaNum("abc123")
        );

        assertFalse(
                this.validator.isAlphaNum("123")
        );
    }

    @Test
    public void isDigit() {
        assertFalse(
                this.validator.isDigit("abc")
        );

        assertTrue(
                this.validator.isDigit("123")
        );

        assertFalse(
                this.validator.isDigit("123_456")
        );

        assertFalse(
                this.validator.isDigit(".")
        );

        assertTrue(
                this.validator.isDigit("0")
        );
    }

    @Test
    public void hasLength() {
        assertTrue(
                this.validator.hasLength("abc", 3)
        );

        assertFalse(
                this.validator.hasLength("abc", 2)
        );
    }

    @Test
    public void equalTo() {
        assertTrue(
                this.validator.equalTo("abc", "abc")
        );
    }

    @Test
    public void strictlyEqualTo() {
        String s1 = "abc";
        String s2 = s1;
        assertTrue(
                this.validator.strictlyEqualTo(s1, s2)
        );

        this.validator.isObject("abc");
    }

    @Test
    public void objectPropertyExists() throws NoSuchFieldException {
        Temp temp = new Temp();
        assertTrue(this.validator.objectPropertyExists(temp, "someField"));
        assertFalse(this.validator.objectPropertyExists(temp, "someField123"));
    }

    @Test
    public void isUrl() {
        assertTrue(this.validator.isUrl("www.example.com"));
        assertTrue(this.validator.isUrl("http://www.example.com"));
        assertTrue(this.validator.isUrl("https://www.example.com"));
        assertFalse(this.validator.isUrl("htt://www.example.com")); // missing `p` in http
        assertFalse(this.validator.isUrl("bogus.com")); // missing http or www
    }

    @Test
    public void isSpace() {
        assertTrue(this.validator.isSpace(" "));
        assertTrue(this.validator.isSpace("           "));
        assertTrue(this.validator.isSpace("\t"));
    }

    @Test
    public void isDivisibleBy() {
        assertTrue(this.validator.isDivisibleBy(25, 5));
        assertFalse(this.validator.isDivisibleBy(19, 5));
    }

    @Test
    public void is12HourTime() {
        assertTrue(this.validator.is12HourTime("00:00 am"));
        assertTrue(this.validator.is12HourTime("10:00 am"));

        assertTrue(this.validator.is12HourTime("10:59 am"));
        assertFalse(this.validator.is12HourTime("10:79 am"));

        assertFalse(this.validator.is12HourTime("10:69 am"));
        assertFalse(this.validator.is12HourTime("10:510 am"));
    }

    @Test
    public void isValidDate() {
        assertTrue(this.validator.isValidDate(1990, 10, 20));
        assertFalse(this.validator.isValidDate(1990, 10, 40));
    }

    @Test
    public void fileExists() {
        assertTrue(this.validator.fileExists("src/test/resources/dummy.txt"));
        assertFalse(this.validator.fileExists("src/test/resources/dummy123.txt"));
    }
}