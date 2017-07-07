package xyz.kalinski.perform.activities.main

internal class MainPresenter(private var view: IMainView?) : IMainPresenter, IMainInteractor.OnDoSomethingListener {

    private val interactor: IMainInteractor = MainInteractor()

    override fun onConnecting() {
        view?.showProgressBar()
        interactor.doSomething(this)
    }

    override fun onSomethingError() {
        view?.showSomethingError()
    }

    override fun onDestroy() {
        view = null
    }

    override fun onStart() {

    }

    override fun onError() {
        view?.hideProgressBar()
        view?.showSomethingError()
    }

    override fun onFinished() {
        view?.hideProgressBar()
    }
}
