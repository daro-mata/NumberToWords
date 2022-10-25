package pl.learing.numberToWords.proposition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToStringServiceTest {

    private NumberToStringService numberToStringService;

    @BeforeEach
    public void setup() {
        this.numberToStringService = new NumberToStringService();
    }

    @Test
    public void shouldMapGivenNumber1950ToString() {
        //given
        int number = 1950;
        String expected = "One Nine Five Zero";

        //when
        String returned = numberToStringService.getAsString(number);

        //then
        assertEquals(expected, returned);
    }

    @Test
    public void shouldMapGivenNumber0001ToString() {
        //given
        int number = 1;
        String expected = "Zero Zero Zero One";

        //when
        String returned = numberToStringService.getAsString(number);

        //then
        assertEquals(expected, returned);
    }

    /**
     * Instead of writing many tests for many different arguments (as I did above)
     * you can write one parameterized test which uses static method with the same name as test.
     * It generates a stream of two arguments - given & expected, which are handled to the test as you can see below.
     * It's simpler, cleaner solution for writing tests from the same group or if you want to test many values on written method
     *
     * @param given    - given number to be split and parsed to string representation
     * @param expected - expected string - i.e. expected value of 1234 is 'One Two Three Four'.
     */
    @ParameterizedTest
    @MethodSource
    public void shouldMapGivenNumberToString(int given, String expected) {
        //given
        //when
        String returned = numberToStringService.getAsString(given);

        //then
        assertEquals(expected, returned);
    }

    private static Stream<Arguments> shouldMapGivenNumberToString() {
        return Stream.of(
                Arguments.of(0, "Zero Zero Zero Zero"),
                Arguments.of(1, "Zero Zero Zero One"),
                Arguments.of(10, "Zero Zero One Zero"),
                Arguments.of(100, "Zero One Zero Zero"),
                Arguments.of(1234, "One Two Three Four"),
                Arguments.of(0000, "Zero Zero Zero Zero"),
                Arguments.of(9999, "Nine Nine Nine Nine")
        );
    }
}
