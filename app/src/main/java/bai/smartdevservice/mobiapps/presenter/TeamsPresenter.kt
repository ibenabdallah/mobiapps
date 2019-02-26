package bai.smartdevservice.mobiapps.presenter

import android.util.Log
import bai.smartdevservice.mobiapps.model.data.AllTeamResponse
import bai.smartdevservice.mobiapps.model.network.RestApiFacade
import bai.smartdevservice.mobiapps.view.TeamsContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsPresenter(var teamsContract: TeamsContract?) : Callback<AllTeamResponse> {

    var TAG = "TeamsPresenter"

    fun getAllTeams() {
        val interfaceAPI = RestApiFacade.getRestApi()
        val call = interfaceAPI?.searchAllTeams("French Ligue 1")
        call?.enqueue(this@TeamsPresenter)
    }

    override fun onFailure(call: Call<AllTeamResponse>, t: Throwable) {
        Log.e(TAG, "onFailure : t = " + t.toString())
        teamsContract!!.onFailure()
    }

    override fun onResponse(call: Call<AllTeamResponse>, response: Response<AllTeamResponse>) {

        Log.e(TAG, "onResponse")

        if (response.code() == 200) {

            val allTeamResponse = response.body()
            val allTeams = allTeamResponse!!.teams
            teamsContract!!.onResponse(allTeams!!)

        }
    }

}
