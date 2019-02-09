import actions.basic.Sum
import actions.base.Value
import actions.basic.Div
import actions.basic.Mul
import actions.basic.Sub
import org.junit.Test

class SumTest {
    @Test
    fun `sum 1 + 3 + 5 == 9`() {
        val v1 = Value(1.0)
        val v2 = Sum(Value(3.0), Value(5.0))
        val sum = Sum(v1, v2)
        val evaluated = sum.evaluated()
        assert(evaluated is Value && evaluated.value == 9.0)
    }

    @Test
    fun `sub 1 - (3 - 5) == 3`() {
        val v1 = Value(1.0)
        val v2 = Sub(Value(3.0), Value(5.0))
        val sub = Sub(v1, v2)
        val evaluated = sub.evaluated()
        assert(evaluated is Value && evaluated.value == 3.0)
    }

    @Test
    fun `mul 3,0 * 1,5 * 5,25 ==  23,625`() {
        val v1 = Value(3.0)
        val v2 = Mul(Value(1.5), Value(5.25))
        val mul = Mul(v1, v2)
        val evaluated = mul.evaluated()
        assert(evaluated is Value && evaluated.value == 23.625)
    }

    @Test
    fun `div 3,0 by (1,5 by 5) ==  10`() {
        val v1 = Value(3.0)
        val v2 = Div(Value(1.5), Value(5.0))
        val div = Div(v1, v2)
        val evaluated = div.evaluated()
        assert(evaluated is Value && evaluated.value == 10.00)
    }


}