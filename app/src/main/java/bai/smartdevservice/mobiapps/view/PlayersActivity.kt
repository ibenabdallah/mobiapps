package bai.smartdevservice.mobiapps.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import bai.smartdevservice.mobiapps.R
import bai.smartdevservice.mobiapps.model.data.ItemPlayer
import bai.smartdevservice.mobiapps.presenter.PlayersPresenter
import bai.smartdevservice.mobiapps.util.Constant
import bai.smartdevservice.mobiapps.view.adapter.MyPlayersRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_players.*

class PlayersActivity : AppCompatActivity(), PlayersContract {

    private var TAG = "PlayersActivity"

    override fun onFailure() {
        Log.d(TAG, "onFailure")
    }

    override fun onResponse(players: ArrayList<ItemPlayer>) {

        Log.d(TAG, "onResponse")
        val adapter =
            MyPlayersRecyclerViewAdapter(this@PlayersActivity, players, object : OnListPlayerInteractionListener {
                override fun onPlayerClick(item: ItemPlayer?) {

                    intent = Intent(this@PlayersActivity, PlayerDetailActivity::class.java)
                    val bundle = Bundle()
                    bundle.putParcelable(Constant.KeyExtra.KEY_PLAYER, item)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })
        players_recycler_view.adapter = adapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        players_recycler_view.layoutManager = LinearLayoutManager(this@PlayersActivity)

        val idTeam = intent.extras?.getString(Constant.KeyExtra.KEY_ID_TEAM)
        val nameTeam = intent.extras?.getString(Constant.KeyExtra.KEY_TEAM_NAME)

        val playersPresenter = PlayersPresenter(this@PlayersActivity)


        playersPresenter.getAllPlayerByIdTeam(idTeam!!)
    }


    interface OnListPlayerInteractionListener {
        fun onPlayerClick(item: ItemPlayer?)
    }


}
