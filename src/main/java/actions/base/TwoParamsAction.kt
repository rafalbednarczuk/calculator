package actions.base

open class TwoParamsAction(f: BaseAction, s: BaseAction) : BaseAction {
    val first: BaseAction = f.evaluated()
    val second: BaseAction = s.evaluated()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TwoParamsAction) return false

        if (first != other.first) return false
        if (second != other.second) return false

        return true
    }

    override fun hashCode(): Int {
        var result = first.hashCode()
        result = 31 * result + second.hashCode()
        return result
    }


}