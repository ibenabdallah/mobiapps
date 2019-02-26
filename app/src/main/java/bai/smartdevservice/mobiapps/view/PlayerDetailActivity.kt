package bai.smartdevservice.mobiapps.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import bai.smartdevservice.mobiapps.R
import bai.smartdevservice.mobiapps.model.data.ItemPlayer
import bai.smartdevservice.mobiapps.util.Constant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_player_detail.*


class PlayerDetailActivity : AppCompatActivity() {

    var mPlayer: ItemPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        mPlayer = intent.extras?.getParcelable<ItemPlayer>(Constant.KeyExtra.KEY_PLAYER)

        Glide.with(this@PlayerDetailActivity)
            .load(mPlayer?.strThumb)
            .centerInside()
            .into(player_detail_icon_image_view as ImageView)

        player_detail_name_text_view.text = mPlayer?.strPlayer
        player_detail_des_text_view.text = mPlayer?.strDescriptionEN

    }

    fun share() {
        val shareBody = "https://www.thesportsdb.com/api/v1/json/1/lookupplayer.php?id=" + mPlayer?.idPlayer
        val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share Player")
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "share_using"));
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_share, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_share -> {
                // Action goes here
                share()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
