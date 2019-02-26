package bai.smartdevservice.mobiapps.view.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import bai.smartdevservice.mobiapps.R
import bai.smartdevservice.mobiapps.model.data.ItemTeam
import bai.smartdevservice.mobiapps.view.TeamsActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_team.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyTeamsRecyclerViewAdapter(
    private val mContext: Context,
    private val mValues: ArrayList<ItemTeam>,
    private val mListener: TeamsActivity.OnListTeamInteractionListener?
) : RecyclerView.Adapter<MyTeamsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ItemTeam
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onTeamClick(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mNameTextView.text = item.strTeam

        Glide
            .with(mContext)
            .load(item.strTeamBadge)
            .into(holder.mLogoImageView);

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mLogoImageView: ImageView = mView.item_logo_image_view
        val mNameTextView: TextView = mView.item_name_text_view

        override fun toString(): String {
            return super.toString()
        }
    }
}
