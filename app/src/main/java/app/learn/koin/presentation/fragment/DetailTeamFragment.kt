package app.learn.koin.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.learn.koin.R
import app.learn.koin.data.response.Team
import app.learn.koin.external.constant.Constant
import app.learn.koin.external.helper.loadImageUrl
import kotlinx.android.synthetic.main.fragment_detail_team.*

class DetailTeamFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_detail_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let {
            val teamData : Team? = it.getParcelable(Constant.BUNDLE_KEY)
            imgTeam.loadImageUrl(teamData?.strTeamBadge.orEmpty())
            tvteamName.text = teamData?.strTeam
            tvteamDescription.text = teamData?.strDescriptionEN
        }
    }
}
