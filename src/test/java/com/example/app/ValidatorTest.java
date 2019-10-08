package com.example.app;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void isBoolean() {
        assertTrue(
                new Validator().isBoolean("true")
        );

        assertFalse(
                new Validator().isBoolean("false")
        );

        assertFalse(
                new Validator().isBoolean("123")
        );

        assertFalse(
                new Validator().isBoolean("0")
        );
    }

    @Test
    public void isBooleanTrue() {
        assertTrue(
                new Validator().isBooleanTrue("true")
        );

        assertFalse(
                new Validator().isBooleanTrue("1")
        );

        assertFalse(
                new Validator().isBooleanTrue("0")
        );

        assertTrue(
                new Validator().isBooleanTrue(String.valueOf(true))
        );
    }

    @Test
    public void isBooleanFalse() {
        assertTrue(
                new Validator().isBooleanFalse("false")
        );

        assertTrue(
                new Validator().isBooleanFalse("0")
        );

        assertTrue(
                new Validator().isBooleanFalse(String.valueOf(false))
        );
    }

    @Test
    public void isInt() {
        assertTrue(
                new Validator().isInt("123")
        );

        assertFalse(
                new Validator().isInt("a")
        );

        assertFalse(
                new Validator().isInt("#@1")
        );
    }

    @Test
    public void isEmpty() {
        assertTrue(
                new Validator().isEmpty("")
        );

        assertTrue(
                new Validator().isEmpty(" ")
        );

        assertTrue(
                new Validator().isEmpty("  ")
        );

        assertTrue(
                new Validator().isEmpty("\t")
        );

        assertTrue(
                new Validator().isEmpty("\t\t\t")
        );
    }

    @Test
    public void isLowercase() {
        assertTrue(
                new Validator().isLowercase("a")
        );

        assertFalse(
                new Validator().isLowercase("A")
        );
    }

    @Test
    public void isUppercase() {
        assertTrue(
                new Validator().isUppercase("A")
        );

        assertFalse(
                new Validator().isUppercase("a")
        );
    }

    @Test
    public void hasSpecialChar() {
        assertTrue(
                new Validator().hasSpecialChar("123%#@ABC)")
        );

        assertFalse(
                new Validator().hasSpecialChar("123")
        );

        assertFalse(
                new Validator().hasSpecialChar("abc")
        );
    }

    @Test
    public void isEmail() {
        assertTrue(
                new Validator().isEmail("test@yahoo.com")
        );

        assertTrue(
                new Validator().isEmail("first.last@yahoo.com")
        );

        assertTrue(
                new Validator().isEmail("first_last@yahoo.com")
        );

        assertTrue(
                new Validator().isEmail("abc1980@yahoo.com")
        );

        // starts with number
        assertFalse(
                new Validator().isEmail("123test@yahoocom")
        );

        // missing `@`
        assertFalse(
                new Validator().isEmail("testyahoo.com")
        );

        // missing `.`
        assertFalse(
                new Validator().isEmail("test@yahoocom")
        );

        //  ends with `.comorg`
        assertFalse(
                new Validator().isEmail("test@yahoo.comorg")
        );

        //  ends with `.com.org`
        assertFalse(
                new Validator().isEmail("test@yahoo.com.org")
        );

        assertFalse(
                new Validator().isEmail("first=last@yahoo.com")
        );
    }

    @Test
    public void isInIntRange() {
        assertTrue(
                new Validator().isInIntRange(5, 1, 10)
        );

        assertFalse(
                new Validator().isInIntRange(500, 1, 10)
        );

        assertFalse(
                new Validator().isInIntRange(-2, 1, 10)
        );
    }

    @Test
    public void isAlpha() {
        assertTrue(
                new Validator().isAlpha("abc")
        );

        assertFalse(
                new Validator().isAlpha("abc123")
        );

        assertFalse(
                new Validator().isAlpha("123")
        );
    }

    @Test
    public void isAlphaNum() {
        assertFalse(
                new Validator().isAlphaNum("abc")
        );

        assertTrue(
                new Validator().isAlphaNum("abc123")
        );

        assertFalse(
                new Validator().isAlphaNum("123")
        );
    }

    @Test
    public void isDigit() {
        assertFalse(
                new Validator().isDigit("abc")
        );

        assertTrue(
                new Validator().isDigit("123")
        );

        assertFalse(
                new Validator().isDigit("123_456")
        );

        assertFalse(
                new Validator().isDigit(".")
        );

        assertTrue(
                new Validator().isDigit("0")
        );
    }

    @Test
    public void hasLength() {
        assertTrue(
                new Validator().hasLength("abc", 3)
        );

        assertFalse(
                new Validator().hasLength("abc", 2)
        );
    }
}