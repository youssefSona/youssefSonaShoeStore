package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val b: FragmentInstructionsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        b.btn1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListFragment))

        return b.root
    }

}