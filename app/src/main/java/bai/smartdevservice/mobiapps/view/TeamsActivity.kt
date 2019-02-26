package bai.smartdevservice.mobiapps.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import bai.smartdevservice.mobiapps.R
import bai.smartdevservice.mobiapps.model.data.ItemTeam
import bai.smartdevservice.mobiapps.presenter.TeamsPresenter
import bai.smartdevservice.mobiapps.util.Constant
import bai.smartdevservice.mobiapps.view.adapter.MyTeamsRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_teams.*


class TeamsActivity : AppCompatActivity(), TeamsContract {


    private var TAG = "TeamsActivity"

    override fun onFailure() {
        Log.d(TAG, "onFailure")
    }

    override fun onResponse(teams: ArrayList<ItemTeam>) {
        Log.d(TAG, "onResponse")
        val adapter = MyTeamsRecyclerViewAdapter(this@TeamsActivity, teams,
            object : OnListTeamInteractionListener {
                override fun onTeamClick(item: ItemTeam?) {

                    intent = Intent(this@TeamsActivity, PlayersActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString(Constant.KeyExtra.KEY_ID_TEAM, item?.idTeam)
                    bundle.putString(Constant.KeyExtra.KEY_TEAM_NAME, item?.strTeam)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })
        teams_recycle_view.adapter = adapter

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        teams_recycle_view.layoutManager = GridLayoutManager(this@TeamsActivity, 2)

        val teamsPresenter = TeamsPresenter(this@TeamsActivity)
        teamsPresenter.getAllTeams()
    }

    interface OnListTeamInteractionListener {
        fun onTeamClick(item: ItemTeam?)
    }

}
