package equation.parser;

import actions.base.TwoParamsAction;
import lombok.NoArgsConstructor;

//Parsing String equation to TwoParamsAction
@NoArgsConstructor
public class EquationParser {

    public TwoParamsAction parse(String _equation){
        Equation equation = new Equation(_equation);

        return parseRecursivly(equation);
    }

    private TwoParamsAction parseRecursivly(Equation equation) {
        if(equation.isSimple()){
            return equation.toTwoParamsAction();
        }

        return null;//todo
    }


}
