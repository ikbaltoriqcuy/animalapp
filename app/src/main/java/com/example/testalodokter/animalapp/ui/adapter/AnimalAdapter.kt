package com.example.testalodokter.animalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testalodokter.R
import com.example.testalodokter.animalapp.model.animal.Animal
import com.example.testalodokter.animalapp.ui.adapter.AnimalAdapter.ViewHolder
import com.example.testalodokter.animalapp.util.Util.setImage
import kotlinx.android.synthetic.main.animal_item.view.*
import kotlin.collections.ArrayList

class AnimalAdapter(val context: Context, val clickListener: (Animal) -> Unit ) : RecyclerView.Adapter<ViewHolder>() {

    var data:ArrayList<Animal> = arrayListOf()

    fun setAllData(allData: List<Animal>) {
        this.data.addAll(allData)
        notifyDataSetChanged()
    }

    fun setData(data: Animal) {
        this.data.add(this.data.size,data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.animal_item, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = holder.itemView

        item.imgAnimal.setImage(
            data.get(position).listImgSrc.get(0)
        )

        item.setOnClickListener {
            clickListener(data[position])
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}