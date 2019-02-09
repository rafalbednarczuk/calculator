package actions.basic

import actions.base.BaseAction
import actions.base.TwoParamsAction
import actions.base.Value

class Div(f: BaseAction, s: BaseAction) : TwoParamsAction(f, s) {
    override fun evaluated(): BaseAction {
        return if (first is Value && second is Value) {
            Value(first.value / second.value)
        } else this
    }
}