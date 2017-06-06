package dagger.nambv.app.demo.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.nambv.app.demo.BaseApplication
import dagger.nambv.app.demo.R
import dagger.nambv.app.demo.model.Repo
import dagger.nambv.app.demo.presenter.PromotionsPresenter
import dagger.nambv.app.demo.util.CommonConstants
import dagger.nambv.app.demo.util.CommonUtils
import javax.inject.Inject

class PromotionsFragment : Fragment(), PromotionsView {

    @Inject
    lateinit var presenter: PromotionsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_promotions, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeFragment()
    }

    fun initializeFragment() {
        BaseApplication[this.context]
            .getAppComponent()
            .plus(PromotionsFragmentModule(this))
            .inject(this)

        presenter.requestRepoList(CommonConstants.DEFAULT_USER_NAME)
    }

    override fun showRepoList(values: List<Repo>) {
        Log.w("TAG", values.size.toString())
    }

    override fun showError(errorMessage: String) {
        CommonUtils.showToastMessage(this.activity, errorMessage)
    }
}
