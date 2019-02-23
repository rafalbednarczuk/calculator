package actions.base

data class Value(val value: Double) : BaseAction {
    override fun toString() = "$value"
}
