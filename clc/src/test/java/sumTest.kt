import actions.Sum
import actions.Value
import org.junit.Test

class SumTest {
    @Test
    fun sumTest() {
        val v1 = Value(1.0)
        val v2 = Value(2.0)
        val sum = Sum(v1, v2)
        val evaluated = sum.evaluate()
        print(evaluated.toString() == "3.0")
    }
}