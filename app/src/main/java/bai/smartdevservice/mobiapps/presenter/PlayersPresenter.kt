package bai.smartdevservice.mobiapps.presenter

import android.util.Log
import bai.smartdevservice.mobiapps.model.data.AllPlayerResponse
import bai.smartdevservice.mobiapps.model.network.RestApiFacade
import bai.smartdevservice.mobiapps.view.PlayersContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayersPresenter(var playersContract: PlayersContract?) : Callback<AllPlayerResponse> {

    var TAG = "PlayersPresenter"

    fun getAllPlayerByIdTeam(idTeam: String) {
        val interfaceAPI = RestApiFacade.getRestApi()
        val call = interfaceAPI?.getAllPlayersInTeamById(idTeam)
        call?.enqueue(this@PlayersPresenter)
    }

    override fun onFailure(call: Call<AllPlayerResponse>, t: Throwable) {
        Log.e(TAG, "onFailure : t = " + t.toString())
        playersContract!!.onFailure()
    }

    override fun onResponse(call: Call<AllPlayerResponse>, response: Response<AllPlayerResponse>) {

        Log.e(TAG, "onResponse")

        if (response.code() == 200) {
            val allPlayerResponse = response.body()
            val allPlayers = allPlayerResponse?.player
            playersContract!!.onResponse(allPlayers!!)
        }
    }

}
