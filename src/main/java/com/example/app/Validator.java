package com.example.app;

import java.io.File;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.chaijs.com/api/assert/
// https://phpunit.de/manual/6.5/en/appendixes.assertions.html
// https://symfony.com/doc/current/reference/constraints.html
// https://www.npmjs.com/package/validator
class Validator {

    boolean isBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    boolean isBooleanTrue(String str) {
        return Boolean.parseBoolean(str);
    }

    boolean isBooleanFalse(String str) {
        return !Boolean.parseBoolean(str);
    }

    boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean isEmpty(String str) {
        return str.trim().length() == 0;
    }

    boolean isLowercase(String str) {
        return str.toLowerCase().equals(str);
    }

    boolean isUppercase(String str) {
        return str.toUpperCase().equals(str);
    }

    boolean hasSpecialChar(String str) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    boolean isEmail(String str) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]{3}$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    boolean isInIntRange(int someNumber, int min, int max) {
        return someNumber >= min && someNumber <= max;
    }

    boolean isAlpha(String str) {
        return str.matches("^[a-zA-Z]+$");
    }

    boolean isAlphaNum(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        boolean strFound = pattern.matcher(str).find();

        Pattern intP = Pattern.compile("[0-9]");
        boolean intFound = intP.matcher(str).find();

        return strFound && intFound;
    }

    boolean isDigit(String str) {
        return str.matches("\\d+");
    }

    boolean hasLength(String str, int length) {
        return str.length() == length;
    }

    // The .equals() method will check if the two strings have the same value
    boolean equalTo(String str1, String str2) {
        return str1.equals(str2);
    }

    // The == operator checks to see if the two strings are exactly the same object
    boolean strictlyEqualTo(String str1, String str2) {
        return str1 == str2;
    }

    boolean isUrl(String url) {
        String regex = "^(http(s)?:\\/\\/)?www.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.find();
    }

    boolean isSpace(String string) {
        return string.trim().equals("");
    }

    boolean isDivisibleBy(int target, int num) {
        return target % num == 0;
    }

    boolean is12HourTime(String time) {
        String[] hourAndMin = time.split(":");
        if (hourAndMin.length != 2) {
            return false;
        }

        if (!hourAndMin[1].contains("am")) {
            return false;
        }

        // hour
        if (hourAndMin[0].substring(0, 1).equals("0")) {
            String hour = hourAndMin[0].substring(0, 2);
            if (!hour.matches("0[0-9]")) {
                return false;
            }
        }

        if (Integer.parseInt(hourAndMin[0].substring(0, 1)) == 1) {
            String hour = hourAndMin[0].substring(1, 2);
            if (!hour.matches("[0-2]")) {
                return false;
            }
        }


        // minutes
        String[] minParts = hourAndMin[1].split("\\s");
        if (minParts[0].length() != 2) {
            return false;
        }

        if (Integer.parseInt(hourAndMin[1].substring(0, 1)) > 6) {
            return false;
        }

        if (Integer.parseInt(hourAndMin[1].substring(0, 1)) == 6 && Integer.parseInt(hourAndMin[1].substring(0, 1)) != 0) {
            return false;
        }

        if (hourAndMin[1].substring(0, 1).equals("0")) {
            String min2ndPart = hourAndMin[1].substring(1, 2);
            if (!min2ndPart.matches("[0-9]")) {
                return false;
            }

            return true;
        }

        return true;
    }

    /*
    public boolean isUnicode(String str) {

    }

    public boolean isInCharRange() {

    }

    public boolean isCtrl() {

    }

    // ctype_graph ?
    public boolean isGraph() {

    }

    public boolean isPrint() {

    }

    public boolean isPunct() {

    }

    // ctype_xdigit ?
    public boolean isXDigit() {

    }

    public boolean hasLength() {

    }

    public boolean regexMatch(String inputString, String regex) {

    }

    public boolean isIp() {

    }

    public boolean isJson() {

    }

    public boolean isUuid() {

    }

    public boolean isPositiveInt() {

    }

    public boolean isNegativeInt() {

    }
    public boolean isBase32() {

    }
    public boolean isBase64() {

    }

    public boolean isAscii() {

    }

    public boolean lessThan() {

    }

    public boolean greaterThan() {

    }

    public boolean isPositiveInt() {

    }

    public boolean isDate() {

    }


    public boolean isDateTime() {

    }

    public boolean isTimezone() {

    }

    // take from wiki
    public boolean isLanguageCode() {

    }

    // a string (or object with a __toString() method) path to an existing file;
    public boolean isFile() {

    }

    public boolean isImage() {

    }

    public boolean isMimeType() {

    }

    public boolean isCurrency() {

    }

    public boolean isIban() {

    }*/

    // isCreditCard
    // isDecimal
    // isHexColor
    // isHexadecimal
    // isIdentityCard
    // isISBN
    // isISO8601
    // isRFC3339
    // isJWT
    // isLatLong
    // isMACAddress
    // isMimeType
    // isMultibyte(str)


    public boolean isInstanceOf(Object object, Object instanceClass) {
        // ...
        return true;
    }

    boolean isObject(Object someObject) {
        System.out.println(someObject.getClass().getName() instanceof String);
        // ...
        return true;
    }

    public boolean isJSON(String json) {
        // ...
        return true;
    }

    boolean objectPropertyExists(Object obj, String property) throws NoSuchFieldException {
        try {
            obj.getClass().getDeclaredField(property);
        } catch (NoSuchFieldException noSuchFieldException) {
            return false;
        }

        return true;
    }

    boolean arrayListHasValue(ArrayList list, String value) {

        return list.contains(value);
    }

    boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException dateTimeException) {
            return false;
        }

        return true;
    }

    boolean fileExists(String absolutePath) {
        var file = new File(absolutePath);

        return file.exists() && file.isFile();
    }
}
