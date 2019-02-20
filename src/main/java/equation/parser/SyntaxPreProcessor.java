package equation.parser;

import equation.parser.exception.WrongEquationException;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class SyntaxPreProcessor {

    public static boolean preProcess(@NotNull String equation) {
        if(!validSyntax(equation)){
            throw new WrongEquationException("Equation contained invalid characters");
        }

        return true; // todo
    }

    private static boolean validSyntax(@NotNull String equation) {
        return equation.chars()
                .mapToObj(i -> (char) i)
                .allMatch(e -> e.toString().matches("[0-9|(|)|\\s|+|\\-|/|*]"));
    }
}
