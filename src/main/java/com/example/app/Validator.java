package com.example.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern strP = Pattern.compile("[a-zA-Z]");
        Matcher strM = strP.matcher(str);
        boolean strFound = strM.find();

        Pattern intP = Pattern.compile("[0-9]");
        Matcher intM = intP.matcher(str);
        boolean intFound = intM.find();

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

    public boolean isSpace() {

    }

    // ctype_xdigit ?
    public boolean isXDigit() {

    }

    public boolean hasLength() {

    }

    public boolean isUrl() {

    }

    public boolean regexMatch() {

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

    public boolean divisibleBy() {

    }

    public boolean isPositiveInt() {

    }

    public boolean isDate() {

    }

    public boolean isTime() {

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

    public boolean isOneOfValues() {

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
}
