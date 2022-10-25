package pl.learing.numberToWords.proposition.service;

public class NumberStandardizer {

    private static final int ACCEPTED_NUMBER_LENGTH = 4;
    private static final String FOUR_DIGIT_FORMAT = "%04d";

    /**
     * It converts and standardizes given number to String type.
     * Example:
     * 0 -> 0000
     * 1 -> 0001
     * 1234 -> 1234
     *
     * @param number - given number
     * @return standardized String (with leading zeros if necessary)
     */
    public String standardize(int number) {
        int numberLength = String.valueOf(number).length();

        String toReturn;
        if (numberLength < ACCEPTED_NUMBER_LENGTH) {
            toReturn = String.format(FOUR_DIGIT_FORMAT, number);
        } else if (numberLength == ACCEPTED_NUMBER_LENGTH) {
            toReturn = String.valueOf(number);
        } else {
            throw new IllegalArgumentException("Illegal number length! Given number length: " + numberLength + " (" + number + "), accepted number length: " + ACCEPTED_NUMBER_LENGTH);
        }

        return toReturn;
    }
}
