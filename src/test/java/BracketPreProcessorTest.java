import equation.parser.BracketPreProcessor;
import equation.parser.exception.WrongEquationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@Slf4j
class BracketPreProcessorTest {

    @BeforeAll
    static void startTests(){
        log.info("Started BracketPreProcessor Tests");
    }

    @AfterAll
    static void endTests(){
        log.info("Finished BracketPreProcessor Tests");
    }

    @Test
    void singleBracket(){
        String out = BracketPreProcessor.preProcess("(5 + 12)");
        assertEquals(out, "5 + 12");
    }

    @Test
    void doubleBracket(){
        String out = BracketPreProcessor.preProcess("((5 + 12))");
        assertEquals(out, "5 + 12");
    }

    @Test
    void nestedWithSingleBracket(){
        String out = BracketPreProcessor.preProcess("(((5+12)+ 3*7) + 12)");
        assertEquals(out, "((5+12)+ 3*7) + 12");
    }

    @Test
    void nestedWithDoubleBracket(){
        String out = BracketPreProcessor.preProcess("((5 + (13*(3+3+3+3)*(23*(2+2)))))");
        assertEquals(out, "5 + (13*(3+3+3+3)*(23*(2+2)))");
    }

    @Test
    void UnequalNumberOfBrackets() {
        try{
            BracketPreProcessor.preProcess("(123)))))");
            fail("Expected WrongEquationException");
        } catch (WrongEquationException exception){
            assertEquals(exception.getMessage(), "Unequal number of opening/closing brackets");
        }
    }
}
