package actions.base

interface BaseAction {
    fun evaluated(): BaseAction = this
}