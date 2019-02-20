package equation.parser;

import actions.base.BaseAction;
import actions.base.Value;
import actions.basic.Div;
import actions.basic.Mul;
import actions.basic.Sub;
import actions.basic.Sum;
import equation.parser.exception.EquationWithoutOperatorException;
import equation.parser.exception.WrongOperatorException;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static equation.parser.Operator.*;
import static java.lang.Double.parseDouble;

//Parsing String equation to TwoParamsAction
@NoArgsConstructor
public class EquationParser {

    public static BaseAction parse(String equation){
        equation = BraceletPreProcessor.preProcess(equation);

        if(isSimple(equation)){
            return new Value(parseDouble(equation.trim()));
        }

        int operatorIndex = getOperatorIndex(equation);
        Operator operator = parseOperator(equation.charAt(operatorIndex));

        String leftOperand = equation.substring(0, operatorIndex);
        String rightOperand = equation.substring(operatorIndex + 1);

        return toTwoParamsAction(operator, parse(leftOperand), parse(rightOperand));
    }

    private static BaseAction toTwoParamsAction(Operator operator, BaseAction leftOperand, BaseAction rightOperand) {
        switch (operator) {
            case SUM:
                return new Sum(leftOperand, rightOperand);
            case SUB:
                return new Sub(leftOperand, rightOperand);
            case MUL:
                return new Mul(leftOperand, rightOperand);
            case DIV:
                return new Div(leftOperand, rightOperand);
            default:
                throw new WrongOperatorException("Could not process operator while parsing equation to Two Params Equation");
        }
    }

    private static Operator parseOperator(char operator) {
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
                throw new WrongOperatorException("Could not process operator while parsing char to enum");
        }
    }

    private static boolean isSimple(@NotNull String equation) {
        return equation.chars()
                       .mapToObj(i -> (char) i)
                       .noneMatch(e -> Arrays.asList('+', '-', '*', '/').contains(e));
    }

    private static int getOperatorIndex(@NotNull String equation) {
        Integer operatorIndex;

        int sumIndex = equation.indexOf('+');
        int subIndex = equation.indexOf('-');

        operatorIndex = getFirstOccurenceOfOperator(sumIndex, subIndex);
        if (operatorIndex != -1) return operatorIndex;

        int mulIndex = equation.indexOf('*');
        int divIndex = equation.indexOf('/');

        operatorIndex = getFirstOccurenceOfOperator(mulIndex, divIndex);
        if (operatorIndex != -1) return operatorIndex;

        throw new EquationWithoutOperatorException("Getting index of operator from equation that had none");
    }

    private static Integer getFirstOccurenceOfOperator(int firstIndex, int secondIndex) {
        if(firstIndex != -1 || secondIndex != -1){

            if(firstIndex == -1) return secondIndex;
            if(secondIndex == -1) return firstIndex;

            return firstIndex < secondIndex ? firstIndex : secondIndex;
        }

        return -1;
    }

}
