import actions.base.TwoParamsAction;
import actions.base.Value;
import actions.basic.Div;
import actions.basic.Mul;
import actions.basic.Sub;
import actions.basic.Sum;
import equation.parser.EquationParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
class EquationParserTest {

    @BeforeAll
    static void startTests(){
        log.info("Started equationParser Tests");
    }

    @AfterAll
    static void endTests(){
        log.info("Finished equationParser Tests");
    }

    @Test
    void sumTest(){
        TwoParamsAction out = EquationParser.parse("5 + 12");
        assertEquals(out, new Sum(new Value(5L), new Value(12L)));
    }

    @Test
    void divTest(){
        TwoParamsAction out = EquationParser.parse("82  /7");
        assertEquals(out, new Div(new Value(82L), new Value(7L)));
    }

    @Test
    void mulTest(){
        TwoParamsAction out = EquationParser.parse("3 * 97");
        assertEquals(out, new Mul(new Value(3L), new Value(97L)));
    }

    @Test
    void subTest(){
        TwoParamsAction out = EquationParser.parse("21- 32");
        assertEquals(out, new Sub(new Value(21L), new Value(32L)));
    }
}
