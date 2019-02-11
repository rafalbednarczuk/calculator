package equation.parser;

import actions.base.TwoParamsAction;
import actions.base.Value;
import actions.basic.Sum;
import actions.basic.Sub;
import actions.basic.Mul;
import actions.basic.Div;
import lombok.NoArgsConstructor;

import static java.lang.Double.parseDouble;

//Parsing String equation to TwoParamsAction
@NoArgsConstructor
public class EquationParser {

    public static TwoParamsAction parse(String _equation){
        Equation equation = new Equation(_equation);

        return parseRecursivly(equation);

    }

    private static TwoParamsAction parseRecursivly(Equation equation) {
        if(equation.isSimple()){
            return equation.toTwoParamsAction();
        }

        return null;
    }


}
