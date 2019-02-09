package actions

class Sum(private val first: BaseAction, private val second: BaseAction) : BaseAction {
    override fun evaluate(): BaseAction {
        return if (first is Value && second is Value) {
            Value(first.value + second.value)
        } else this
    }
}