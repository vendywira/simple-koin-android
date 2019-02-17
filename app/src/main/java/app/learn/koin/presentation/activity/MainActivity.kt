package app.learn.koin.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.learn.koin.R
import app.learn.koin.data.response.Team
import app.learn.koin.domain.router.openFragment
import app.learn.koin.external.constant.Constant
import app.learn.koin.presentation.fragment.DetailTeamFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    val presenter: MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setupView(this)
        setupUIListener()
    }

    override fun setupUIListener() {
        btnSearch.setOnClickListener {
            val searchText = etSearchText.text.toString()
            presenter.searchTeams(searchText)
        }
    }

    override fun showTeamData(teamData: Team?) {
        val bundle = Bundle()
        bundle.putParcelable(Constant.BUNDLE_KEY, teamData)
        supportFragmentManager.openFragment(R.id.layoutSearchResult, DetailTeamFragment(), bundle)
    }

    override fun showError(error: String) {
        toast(error)
    }

}
