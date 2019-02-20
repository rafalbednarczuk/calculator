package equation.parser;

import equation.parser.exception.WrongEquationException;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class BracketPreProcessor {

    public static String preProcess(@NotNull String equation) {
        int bracketsToBeRemovedNmb = countStartingBraceletsNmb(equation);
        int insideBracketsDif = countInsideBrackets(equation, bracketsToBeRemovedNmb);

        bracketsToBeRemovedNmb -= insideBracketsDif;

        return removeBrackets(equation, bracketsToBeRemovedNmb);
    }

    private static int countInsideBrackets(@NotNull String equation, int bracketsToBeRemovedNmb) {
        int insideBracketsDif = 0;

        for(int i = bracketsToBeRemovedNmb; i < equation.length() - bracketsToBeRemovedNmb; ++i){
            if(equation.charAt(i) == '(') --insideBracketsDif;
            if(equation.charAt(i) == ')') ++insideBracketsDif;
        }

        return insideBracketsDif;
    }

    private static int countStartingBraceletsNmb(@NotNull String equation) {
        for(int i = 0; i < equation.length(); ++i){
            if(equation.charAt(i) != '(') return i;
        }

        throw new WrongEquationException("Equation contains only brackets");
    }

    private static String removeBrackets(String equation, int bracketsToBeRemovedNmb) {

        for(int i = 0; i < bracketsToBeRemovedNmb; ++i){
            if(equation.charAt(equation.length()-1) != ')') break;

            equation = equation.substring(1, equation.length()-1);
        }

        return equation;
    }
}
