package pl.learing.numberToWords.proposition.validator;

public class NumberValidator implements Validator {

    /**
     * Validates if given number is correct
     * In current version only numbers equal or greater than zero are accepted
     *
     * @param number - given number
     * @throws IllegalArgumentException when given number is less than zero
     */
    @Override
    public void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid Value");
        }
    }
}
