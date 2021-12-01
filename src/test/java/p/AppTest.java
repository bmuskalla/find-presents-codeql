package p;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
    hello world, 11
    JUnit 5,      7       
""")
    void calculatesPhraseLength(String phrase, int expectedLength) {
        Assertions.assertEquals(expectedLength, phrase.length());
    }
}
