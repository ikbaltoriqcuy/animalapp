package com.example.testalodokter.animalapp.ui.main

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testalodokter.R
import com.example.testalodokter.animalapp.base.BaseFragment
import com.example.testalodokter.animalapp.model.animal.Animal
import com.example.testalodokter.animalapp.ui.adapter.AnimalAdapter
import com.example.testalodokter.animalapp.viewmodel.AnimalViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private val viewModel: AnimalViewModel by viewModels()
    private var animalAdapter: AnimalAdapter? = null
    private var data: List<Animal> = listOf()

    override fun setLayoutResource(): Int = R.layout.fragment_home
    override fun onViewCreated() {
        buildAnimalData()
    }

    private fun showList() {
        animalAdapter = AnimalAdapter(requireContext()) { animal ->
            Navigation.findNavController(requireView()).navigate(R.id.animalFragment, bundleOf(
                "image" to animal.listImgSrc.toIntArray()
            ))
        }
        animalAdapter?.setAllData(
            data
        )
        val recyclerLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        lstAnimal.layoutManager = recyclerLayoutManager
        lstAnimal.adapter = animalAdapter
    }

    private fun buildAnimalData() {
        viewModel.getAnimal()
        viewModel.animalGetResponse.observe(viewLifecycleOwner,  {  animal ->
            if (animal == null || animal.isEmpty()) {
                data = listOf(
                    getCat(),
                    getDuck(),
                    getHamster()
                )
                viewModel.insertAnimal(data)
                showList()
            } else {
                data = animal
                showList()
            }
        })
    }


    private fun getCat(): Animal {
        return Animal(
            0,
            "cat",
            arrayListOf(
                R.drawable.cat_1_illustration,
                R.drawable.cat_2_illustration,
                R.drawable.cat_3_illustration,
            ),
        )
    }

    private fun getDuck(): Animal {
        return Animal(
            1,
            "duck",
            arrayListOf(
                R.drawable.duck_1_illustration,
                R.drawable.duck_2_illustration,
                R.drawable.duck_3_illustration,
                R.drawable.duck_4_illustration
            ),
        )
    }


    private fun getHamster(): Animal {
        return Animal(
            2,
            "hamster",
            arrayListOf(
                R.drawable.hamster_1_illustration,
                R.drawable.hamster_2_illustration,
                R.drawable.hamster_3_illustration,
                R.drawable.hamster_4_illustration
            ),
        )
    }
}