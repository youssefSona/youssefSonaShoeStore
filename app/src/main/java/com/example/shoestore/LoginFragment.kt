package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val b: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        b.apply {
            btn1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
            btn2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        }

        return b.root
    }

}