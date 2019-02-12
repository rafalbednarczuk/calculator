package equation.parser;

import actions.base.TwoParamsAction;
import actions.base.Value;
import actions.basic.Div;
import actions.basic.Mul;
import actions.basic.Sub;
import actions.basic.Sum;
import equation.parser.exception.EquationNotSimpleException;
import equation.parser.exception.EquationWithoutOperatorException;
import equation.parser.exception.WrongOperator;
import lombok.Data;

import java.util.Arrays;
import java.util.stream.Collectors;

import static equation.parser.Operator.DIV;
import static equation.parser.Operator.MUL;
import static equation.parser.Operator.SUB;
import static equation.parser.Operator.SUM;
import static java.lang.Double.parseDouble;

@Data
class Equation {

    private boolean simple;
    private String leftOperand;
    private String rightOperand;
    private Operator operator;

    Equation(String _equation) {
        if(isSimple(_equation)){
            int operatorIndex = getOperatorIndex(_equation);

            simple = true;
            leftOperand = _equation.substring(0, operatorIndex - 1);
            rightOperand = _equation.substring(operatorIndex + 1, _equation.length() - 1);
            operator = parseOperator(_equation.charAt(operatorIndex));

        }else {
            //todo
        }
    }

    private Operator parseOperator(char operator) {
        switch(operator){
            case '+':
                return SUM;
            case '-':
                return SUB;
            case '*':
                return MUL;
            case '/':
                return DIV;
            default:
                throw new WrongOperator("Could not process operator while parsing char to enum");
        }
    }

    private int getOperatorIndex(String equation) {
        if(equation.indexOf('+') != -1)
            return equation.indexOf('+');
        if(equation.indexOf('-') != -1)
            return equation.indexOf('-');
        if(equation.indexOf('*') != -1)
            return equation.indexOf('*');
        if(equation.indexOf('/') != -1)
            return equation.indexOf('/');

        // todo dunno which one is better
        /* return equation.indexOf('+') != -1
                ? equation.indexOf('+')
                : equation.indexOf('-') != -1
                    ? equation.indexOf('-')
                    : equation.indexOf('*') != -1
                        ? equation.indexOf('*')
                        : equation.indexOf('/');*/

        throw new EquationWithoutOperatorException("Tried to get index of operator from equation that had none");
    }

    private boolean isSimple(String equation) {
        return 1 == equation.chars()
                        .mapToObj(i -> (char) i)
                        .filter(e -> Arrays.asList('+', '-', '*', '/').contains(e))
                        .collect(Collectors.toList())
                        .size();
    }

    TwoParamsAction toTwoParamsAction() {
        if (!simple) {
            throw new EquationNotSimpleException("Trying to parse not Simple Equation to Two Params Equation");
        }

        Value firstValue = new Value(parseDouble(leftOperand.trim()));
        Value secondValue = new Value(parseDouble(rightOperand.trim()));

        switch (operator) {
            case SUM:
                return new Sum(firstValue, secondValue);
            case SUB:
                return new Sub(firstValue, secondValue);
            case MUL:
                return new Mul(firstValue, secondValue);
            case DIV:
                return new Div(firstValue, secondValue);
            default:
                throw new WrongOperator("Could not process operator while parsing Equation to Two Params Equation");
        }
    }
}
