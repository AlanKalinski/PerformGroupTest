package xyz.kalinski.perform.activities.sample

internal class SamplePresenterImpl(private var view: SampleView?) : SamplePresenter, SampleInteractor.OnDoSomethingListener {
    private val interactor: SampleInteractor = SampleInteractorImpl()

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
