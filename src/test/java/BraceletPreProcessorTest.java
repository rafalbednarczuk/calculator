import actions.base.BaseAction;
import actions.base.Value;
import actions.basic.Sum;
import equation.parser.BraceletPreProcessor;
import equation.parser.EquationParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
class BraceletPreProcessorTest {

    @BeforeAll
    static void startTests(){
        log.info("Started BraceletPreProcessor Tests");
    }

    @AfterAll
    static void endTests(){
        log.info("Finished BraceletPreProcessor Tests");
    }

    @Test
    void singleBracelet(){
        String out = BraceletPreProcessor.preProcess("(5 + 12)");
        assertEquals(out, "5 + 12");
    }

    @Test
    void doubleBracelet(){
        String out = BraceletPreProcessor.preProcess("((5 + 12))");
        assertEquals(out, "5 + 12");
    }

    @Test
    void nestedWithSingleBracelet(){
        String out = BraceletPreProcessor.preProcess("(((5+12)+ 3*7) + 12)");
        assertEquals(out, "((5+12)+ 3*7) + 12");
    }

    @Test
    void nestedWithDoubleBracelet(){
        String out = BraceletPreProcessor.preProcess("((5 + (13*(3+3+3+3)*(23*(2+2)))))");
        assertEquals(out, "5 + (13*(3+3+3+3)*(23*(2+2)))");
    }
}
