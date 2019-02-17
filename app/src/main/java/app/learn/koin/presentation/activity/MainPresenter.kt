package app.learn.koin.presentation.activity

import android.content.Context
import app.learn.koin.data.response.FootballClub
import app.learn.koin.data.response.Team
import com.google.gson.Gson

class MainPresenter (val context: Context, val gson: Gson) : MainContract.UserActionListener {

    private var view: MainContract.View? = null

    override fun setupView(view: MainContract.View) {
        this.view = view
    }

    override fun searchTeams(searchText: String?) {
        if (!searchText.isNullOrEmpty()) {
            val inputStream = context.assets.open("json/football_club.json")
            val inputString = inputStream.bufferedReader().use { it.readText() }
            val footballJson = gson.fromJson(inputString, FootballClub::class.java)
            val footBallData = footballJson?.teams?.filter {
                it.strTeam.toLowerCase().contains(searchText.toLowerCase())
            }

            if (!footBallData.isNullOrEmpty()) {
                view?.showTeamData(footBallData.first())
            } else {
                view?.showError("data not found")
            }
        } else {
            view?.showError("please fill club name!")
        }
    }

    override fun fetchTeamData(teamData: Team) {
        view?.showTeamData(teamData)
    }
}