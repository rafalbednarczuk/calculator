package actions.base

open class TwoParamsAction(f: BaseAction, s: BaseAction) : BaseAction {
    val first: BaseAction = f.evaluated()
    val second: BaseAction = s.evaluated()
}