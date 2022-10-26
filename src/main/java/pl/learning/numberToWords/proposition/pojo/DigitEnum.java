package pl.learning.numberToWords.proposition.pojo;

import java.util.Arrays;

/**
 * Class created to represent any digit as pair of String value and name to represent
 */
public enum DigitEnum {
    ZERO("0", "Zero"),
    ONE("1", "One"),
    TWO("2", "Two"),
    THREE("3", "Three"),
    FOUR("4", "Four"),
    FIVE("5", "Five"),
    SIX("6", "Six"),
    SEVEN("7", "Seven"),
    EIGHT("8", "Eight"),
    NINE("9", "Nine");

    private final String digit;
    private final String name;

    DigitEnum(String digit, String name) {
        this.digit = digit;
        this.name = name;
    }

    public static DigitEnum fromValue(String s) {
        DigitEnum[] enums = DigitEnum.values();
        for (DigitEnum value : enums) {
            if (value.getDigit().equals(s)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Unknown digit provided! Given value: " + s + ", available values: " + Arrays.toString(enums));
    }

    public String getDigit() {
        return digit;
    }

    public String getName() {
        return name;
    }
}
