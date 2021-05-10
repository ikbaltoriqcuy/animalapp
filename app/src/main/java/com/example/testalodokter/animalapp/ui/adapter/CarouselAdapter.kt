package com.example.testalodokter.animalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.testalodokter.R
import com.example.testalodokter.animalapp.util.Util.setImage

class CarouselAdapter (val context: Context, val data: IntArray) : PagerAdapter() {

        override fun getCount(): Int {
            return data.size
        }

        override fun isViewFromObject(view: View, item: Any): Boolean {
            return view == item
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(context).inflate(R.layout.image_item, container, false)
            val imageAnimal = view.findViewById<ImageView>(R.id.imgAnimalCarousel)
            imageAnimal.setImage(data[position])
            container.addView(view, 0)

            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
}