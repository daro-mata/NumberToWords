package pl.learning.numberToWords.proposition.printer;

import java.util.List;

public class StringConverter {

    private static final String DIGIT_DELIMITER = " ";

    /**
     * Joins list elements into one string separated by defined delimiter
     *
     * @param listOfWords - given list of words
     * @return delimited list of elements
     */
    public String joinListElements(List<String> listOfWords) {
        return String.join(DIGIT_DELIMITER, listOfWords);
    }
}
