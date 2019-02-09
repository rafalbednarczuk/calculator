package actions

import actions.BaseAction

class Value(val value: Double) : BaseAction {
    override fun evaluate() = this
    override fun toString() = "$value"
}
