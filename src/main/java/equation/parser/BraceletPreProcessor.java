package equation.parser;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class BraceletPreProcessor {

    private static int insideBraceletsDif;
    private static int bracletsToBeRemovedNmb;

    public static String preProcess(@NotNull String equation) {
        countStartingBraceletsNmb(equation);
        countInsideBracelets(equation);

        bracletsToBeRemovedNmb -= insideBraceletsDif;

        return removeBracelets(equation, bracletsToBeRemovedNmb);
    }

    private static void countInsideBracelets(@NotNull String equation) {
        for(int i = bracletsToBeRemovedNmb; i < equation.length() - bracletsToBeRemovedNmb; ++i){
            if(equation.charAt(i) == '(') --insideBraceletsDif;
            if(equation.charAt(i) == ')') ++insideBraceletsDif;
        }
    }

    private static void countStartingBraceletsNmb(@NotNull String equation) {
        while (bracletsToBeRemovedNmb < equation.length() && equation.charAt(bracletsToBeRemovedNmb) == '('){
            ++bracletsToBeRemovedNmb;
        }
    }

    private static String removeBracelets(String equation, int bracletsToBeRemovedNmb) {

        for(int i = 0; i < bracletsToBeRemovedNmb; ++i){
            if(equation.charAt(equation.length()-1) != ')') break;

            equation = equation.substring(1, equation.length()-1);
        }

        return equation;
    }
}
