package equation.parser;

import actions.base.TwoParamsAction;
import actions.base.Value;
import actions.basic.Div;
import actions.basic.Mul;
import actions.basic.Sub;
import actions.basic.Sum;
import equation.parser.exception.EquationNotSimpleException;
import equation.parser.exception.WrongOperator;
import lombok.Builder;
import lombok.Data;

import static java.lang.Double.parseDouble;

@Data
@Builder
class Equation {

    boolean simple;

    String leftOperand;
    String rightOperand;

    Operator operator;

    Equation(String _equation) {

    }

    TwoParamsAction toTwoParamsAction() {
        if (!simple) {
            throw new EquationNotSimpleException("Trying to conver not Simple Equation to Two Params Equation");
        }

        switch (operator) {
            case SUM:
                return new Sum(new Value(parseDouble(leftOperand)), new Value(parseDouble(rightOperand)));
            case SUB:
                return new Sub(new Value(parseDouble(leftOperand)), new Value(parseDouble(rightOperand)));
            case MUL:
                return new Mul(new Value(parseDouble(leftOperand)), new Value(parseDouble(rightOperand)));
            case DIV:
                return new Div(new Value(parseDouble(leftOperand)), new Value(parseDouble(rightOperand)));
            default:
                throw new WrongOperator("Could not process operator while parsing Equation to Two Params Equation");
        }
    }
}
