package xyz.kalinski.perform.activities.main.fragments.news

class NewsPresenter : INewsPresenter {

    lateinit var requester: NewsRequester

    override fun initRequester(requester: NewsRequester) {
        this.requester = requester
    }

    override fun getLatestNews() {
        requester.getLatestNews()
    }
}