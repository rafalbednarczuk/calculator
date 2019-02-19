import actions.base.TwoParamsAction;
import actions.base.Value;
import actions.basic.Div;
import actions.basic.Mul;
import actions.basic.Sub;
import actions.basic.Sum;
import equation.parser.EquationParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
public class EquationParserTest {

    @Before
    public void startTests(){
        log.info("Started equationParser Tests");
    }

    @After
    public void endTests(){
        log.info("Finished equationParser Tests");
    }

    @Test
    public void sumTest(){
        TwoParamsAction out = new EquationParser().parse("5 + 12");
        assertEquals(out, new Sum(new Value(5L), new Value(12L)));
    }

    @Test
    public void divTest(){
        TwoParamsAction out = new EquationParser().parse("82  /7");
        assertEquals(out, new Div(new Value(82L), new Value(7L)));
    }

    @Test
    public void mulTest(){
        TwoParamsAction out = new EquationParser().parse("3 * 97");
        assertEquals(out, new Mul(new Value(3L), new Value(97L)));
    }

    @Test
    public void subTest(){
        TwoParamsAction out = new EquationParser().parse("21- 32");
        assertEquals(out, new Sub(new Value(21L), new Value(32L)));
    }
}
