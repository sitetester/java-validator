package com.example.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean isBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    public boolean isBooleanTrue(String str) {
        boolean b = Boolean.parseBoolean(str);
        return b == true;
    }

    public boolean isBooleanFalse(String str) {
        boolean b = Boolean.parseBoolean(str);
        return b == false;
    }

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmpty(String str) {
        return str.trim().length() == 0;
    }

    public boolean isLowercase(String str) {
        return str.toLowerCase() == str;
    }

    public boolean isUppercase(String str) {
        return str.toUpperCase() == str;
    }

    public boolean hasSpecialChar(String str) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public boolean isEmail(String str) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]{3}$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public boolean isInIntRange(int someNumber, int min, int max) {
        return someNumber >= min && someNumber <= max;
    }

    public boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }

    /*
    public boolean isUnicode(String str) {

    }

    public boolean isInCharRange() {

    }

    public boolean isAlphaNum() {

    }

    public boolean isCtrl() {

    }

    public boolean isDigit() {

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

    public boolean equalTo() {

    }

    public boolean strictlyEqualTo() {

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
