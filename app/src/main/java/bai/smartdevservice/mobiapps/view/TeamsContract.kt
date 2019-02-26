package bai.smartdevservice.mobiapps.view

import bai.smartdevservice.mobiapps.model.data.ItemTeam

interface TeamsContract {

    fun onFailure()
    fun onResponse(teams: ArrayList<ItemTeam>)
}
