package app.learn.koin.presentation.activity

import app.learn.koin.data.response.Team

class MainContract {

    interface View {
        fun setupUIListener()
        fun showTeamData(teamData: Team?)
        fun showError(error: String)
    }

    interface UserActionListener {
        fun setupView(view: View)
        fun searchTeams(searchText: String?)
        fun fetchTeamData(teamData: Team)
    }
}