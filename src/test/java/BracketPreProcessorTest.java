import equation.parser.BracketPreProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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
    void singleBracelet(){
        String out = BracketPreProcessor.preProcess("(5 + 12)");
        assertEquals(out, "5 + 12");
    }

    @Test
    void doubleBracelet(){
        String out = BracketPreProcessor.preProcess("((5 + 12))");
        assertEquals(out, "5 + 12");
    }

    @Test
    void nestedWithSingleBracelet(){
        String out = BracketPreProcessor.preProcess("(((5+12)+ 3*7) + 12)");
        assertEquals(out, "((5+12)+ 3*7) + 12");
    }

    @Test
    void nestedWithDoubleBracelet(){
        String out = BracketPreProcessor.preProcess("((5 + (13*(3+3+3+3)*(23*(2+2)))))");
        assertEquals(out, "5 + (13*(3+3+3+3)*(23*(2+2)))");
    }
}
