package actions

interface BaseAction {
    fun evaluate(): BaseAction
}