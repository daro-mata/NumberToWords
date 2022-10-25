package pl.learing.numberToWords.proposition;

import pl.learing.numberToWords.proposition.printer.StringConverter;
import pl.learing.numberToWords.proposition.service.NumberService;
import pl.learing.numberToWords.proposition.validator.NumberValidator;

import java.util.List;

public class NumberToStringService {

    private final NumberService numberService;
    private final StringConverter converter;
    private final NumberValidator numberValidator;

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
