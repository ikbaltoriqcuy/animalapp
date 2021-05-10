package com.example.testalodokter.animalapp.ui.animal

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import com.example.testalodokter.R
import com.example.testalodokter.animalapp.base.BaseFragment
import com.example.testalodokter.animalapp.ui.adapter.CarouselAdapter
import com.tmall.ultraviewpager.UltraViewPager
import kotlinx.android.synthetic.main.fragment_animal.*

class AnimalFragment : BaseFragment() {

    private var listImage = intArrayOf()
    private var carouselAdapter: CarouselAdapter? = null

    override fun setLayoutResource(): Int = R.layout.fragment_animal
    override fun onViewCreated() {
        getBundle()
        setup()
    }

    private fun getBundle() {
        listImage = arguments?.getIntArray("image") ?: intArrayOf()
    }

    private fun setup() {
        viewpagerAnimal.initIndicator()
        viewpagerAnimal.indicator
            .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
            .setFocusColor(Color.parseColor("#FFEB3B"))
            .setNormalColor(Color.WHITE)
            .setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5f, resources.displayMetrics).toInt())

        viewpagerAnimal.indicator.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM)
        viewpagerAnimal.indicator.build()

        carouselAdapter = CarouselAdapter(requireContext(), listImage)
        viewpagerAnimal.adapter = carouselAdapter
    }
}