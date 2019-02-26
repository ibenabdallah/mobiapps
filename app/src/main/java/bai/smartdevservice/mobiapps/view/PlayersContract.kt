package bai.smartdevservice.mobiapps.view

import bai.smartdevservice.mobiapps.model.data.ItemPlayer

interface PlayersContract {

    fun onFailure()
    fun onResponse(players: ArrayList<ItemPlayer>)
}
