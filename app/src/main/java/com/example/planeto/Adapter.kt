package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.view.view.distance
import kotlinx.android.synthetic.main.view.view.galaxy
import kotlinx.android.synthetic.main.view.view.gravity
import kotlinx.android.synthetic.main.view.view.planet_img
import kotlinx.android.synthetic.main.view.view.title
import java.util.Locale

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {


    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.title
        var planetimg = view.planet_img
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + " m km"
        holder.gravity.text = planet[position].gravity + " m/ss"

        when (planet[position].title!!.lowercase(Locale.getDefault())) {
            "mars" -> {
                dummyImage = R.drawable.mars
            }

            "neptune" -> {
                dummyImage = R.drawable.neptune
            }

            "earth" -> {
                dummyImage = R.drawable.earth
            }

            "moon" -> {
                dummyImage = R.drawable.moon
            }

            "venus" -> {
                dummyImage = R.drawable.venus
            }

            "jupiter" -> {
                dummyImage = R.drawable.jupiter
            }

            "saturn" -> {
                dummyImage = R.drawable.saturn
            }

            "uranus" -> {
                dummyImage = R.drawable.uranus
            }

            "mercury" -> {
                dummyImage = R.drawable.mercury
            }

            "sun" -> {
                dummyImage = R.drawable.sun
            }
        }

        holder.planetimg.setImageResource(dummyImage!!)

    }

    override fun getItemCount(): Int {
        return planet.size
    }


}

