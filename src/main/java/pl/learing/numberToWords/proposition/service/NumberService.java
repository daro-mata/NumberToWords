package pl.learing.numberToWords.proposition.service;

import pl.learing.numberToWords.proposition.pojo.DigitEnum;

import java.util.List;
import java.util.stream.Collectors;

public class NumberService {

    private final NumberStandardizer standardizer;

    public NumberService() {
        standardizer = new NumberStandardizer();
    }

    /**
     * Converts given number to the list of digits names.
     * Look at what Intellij is highlighting:
     * String.valueOf(c)
     * DigitEnum.fromValue(s)
     * String.valueOf(c)
     * digitEnum.getName()
     * Those methods are highlighted because in stream they can be replaced with method references.
     * I commented out code which is doing the same but using method references
     *
     * @param number - given number
     * @return list of digits names
     */
    public List<String> getAsList(int number) {
        String numberAsString = standardizer.standardize(number);

        return numberAsString.chars()
                .mapToObj(e -> (char) e)
                .map(c -> String.valueOf(c))
                .map(s -> DigitEnum.fromValue(s))
                .map(digitEnum -> digitEnum.getName())
                .collect(Collectors.toList());

//        return numberAsString.chars()
//                .mapToObj(e -> (char) e)
//                .map(String::valueOf)
//                .map(DigitEnum::fromValue)
//                .map(DigitEnum::getName)
//                .collect(Collectors.toList());
    }
}
