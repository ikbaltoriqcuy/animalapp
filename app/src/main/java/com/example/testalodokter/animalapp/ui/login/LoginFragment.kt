package com.example.testalodokter.animalapp.ui.login


import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.testalodokter.R
import com.example.testalodokter.animalapp.base.BaseFragment
import com.example.testalodokter.animalapp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()
    private var validationIsCorrect = false

    override fun setLayoutResource(): Int = R.layout.fragment_login
    override fun onViewCreated() {
        setup()
        setupEventUI()
    }

    private fun setup() {
        mainLayout.visibility = View.GONE
        viewModel.getUser()
        viewModel.userGetResponse.observe(viewLifecycleOwner,  { user ->
            pbLoading.visibility = View.GONE
            if (user != null) {
                gotoHome()
            } else {
                mainLayout.visibility = View.VISIBLE
            }
        })
    }

    private fun setupEventUI() {
        txtEmail.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                validationEmail(txtEmail.text.toString())
            }

            override fun afterTextChanged(text: Editable?) {}

        })

        txtPassword.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validationPassword(txtPassword.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        btnLogin.setOnClickListener {
            validationEmail(txtEmail.text.toString())
            validationPassword(txtPassword.text.toString())

            if (validationIsCorrect) {
                viewModel.insertUser(txtEmail.text.toString(),txtPassword.text.toString())
                gotoHome()
            } else {
                Toast.makeText(requireContext(),"Isi terlebih dahulu email dan password", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validationEmail(text: String) {
        if (text.isEmpty()) {
            lblStatusEmail.error = "email tidak boleh kosong"
            validationIsCorrect = false
        } else {
            lblStatusEmail.error = ""
            validationIsCorrect = true
        }
    }

    private fun validationPassword(text: String) {
        if (text.isEmpty()) {
            lblStatusPassword.error = "email tidak boleh kosong"
            validationIsCorrect = false
        } else {
            lblStatusPassword.error = ""
            validationIsCorrect = true
        }
    }

    private fun gotoHome() {
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment)
    }

}