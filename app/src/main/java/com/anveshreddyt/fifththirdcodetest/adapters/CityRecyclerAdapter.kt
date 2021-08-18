package com.anveshreddyt.fifththirdcodetest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.anveshreddyt.fifththirdcodetest.R
import com.anveshreddyt.fifththirdcodetest.model.City

class CityRecyclerAdapter(
    private val dataSet: List<City>,
    private val mOnClickListener: View.OnClickListener
) :
    RecyclerView.Adapter<CityRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cityTextView: TextView = view.findViewById(R.id.cityTextView)
        var weatherTextView: TextView = view.findViewById(R.id.weatherTextView)
        var card: ConstraintLayout = view.findViewById(R.id.card)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = dataSet[position]
        viewHolder.cityTextView.text = currentItem.city
        viewHolder.weatherTextView.tag = currentItem.city
        viewHolder.weatherTextView.setOnClickListener(mOnClickListener)
        when(currentItem.city) {
             "Dallas" -> viewHolder.card.setBackgroundResource(R.drawable.dallas)
            "Miami" -> viewHolder.card.setBackgroundResource(R.drawable.miami)
            "San Francisco" -> viewHolder.card.setBackgroundResource(R.drawable.sfo)
            "Seattle" -> viewHolder.card.setBackgroundResource(R.drawable.seattle)
            "Chicago" -> viewHolder.card.setBackgroundResource(R.drawable.detroit)
            "Detroit" -> viewHolder.card.setBackgroundResource(R.drawable.detroit)
            "Anchorage" -> viewHolder.card.setBackgroundResource(R.drawable.anchorage)
            "New York" -> viewHolder.card.setBackgroundResource(R.drawable.newyork)
        }
    }

    override fun getItemCount() = dataSet.size

}
