package com.example.testalodokter.animalapp.ui.account

import androidx.fragment.app.viewModels
import com.example.testalodokter.R
import com.example.testalodokter.animalapp.base.BaseFragment
import com.example.testalodokter.animalapp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun setLayoutResource(): Int = R.layout.fragment_account
    override fun onViewCreated() {
        setupUI()
    }

    private fun setupUI() {
        viewModel.getUser()
        viewModel.userGetResponse.observe(viewLifecycleOwner,  { user ->
            lblName.text = user.userName
        })
    }

}