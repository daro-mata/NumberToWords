package pl.learning.numberToWords.proposition;

import pl.learning.numberToWords.proposition.printer.StringConverter;
import pl.learning.numberToWords.proposition.service.NumberService;
import pl.learning.numberToWords.proposition.validator.NumberValidator;
import pl.learning.numberToWords.proposition.validator.Validator;

import java.util.List;

public class NumberToStringService {

    private final NumberService numberService;
    private final StringConverter converter;
    private final Validator numberValidator;

    public NumberToStringService() {
        this.numberService = new NumberService();
        this.converter = new StringConverter();
        this.numberValidator = new NumberValidator();
    }

    /**
     * Look at the accessor - only this method in whole package 'pl.learing.numberToWords.proposition' is public.
     * It's because that it's the only method we want to export to the world, we want others to use NumberToStringService only.
     * Other classes should not be visible to others.
     *
     * @param number - given number to be described by words
     * @return concatenated list of digits names
     */
    public String getAsString(int number) {
        numberValidator.validate(number);
        List<String> digitList = numberService.getAsList(number);
        return converter.joinListElements(digitList);
    }
}
