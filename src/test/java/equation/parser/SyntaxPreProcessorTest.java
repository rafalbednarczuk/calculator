package equation.parser;

import equation.parser.exception.WrongEquationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@Slf4j
class SyntaxPreProcessorTest {

    @BeforeAll
    static void startTests(){
        log.info("Started SyntaxPreProcessor Tests");
    }

    @AfterAll
    static void endTests(){
        log.info("Finished SyntaxPreProcessor Tests");
    }

    @Test
    void wrongSyntaxCheck(){
        try {
            SyntaxPreProcessor.preProcess("12*t");
            fail("Expected WrongEquationException");
        } catch (WrongEquationException exception) {
            assertEquals(exception.getMessage(), "Equation contained invalid characters");
        }
    }

    @Test
    void correctSyntaxCheck(){
        try {
            SyntaxPreProcessor.preProcess("12*1 + ((21 / 7) - 3*8)/ 2");
        } catch (WrongEquationException exception) {
            fail("Expected no exception");
        }
    }
}
