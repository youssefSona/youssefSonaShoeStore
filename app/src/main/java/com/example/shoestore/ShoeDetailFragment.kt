package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    //    private val sharedViewModels: SharedViewModel by activityViewModels()
    private val sharedViewModels by activityViewModels<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val b: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        b.sharedViewModel = sharedViewModels
        b.lifecycleOwner = this

        b.apply {

            btnCancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))

            btnSave.setOnClickListener {
                sharedViewModels.addNewShoe()

                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
//            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)

            }// End of Save button
        }


        return b.root
    }
}


//            val newShoe = Shoe(
//                b.editTextName.text.toString(),
//                b.editTextCompany.text.toString(),
//                b.editTextSize.text.toString(),
//                b.editTextDescription.text.toString()
//            )
//            sharedViewModels.addNewShoe(newShoe)

//
//            sharedViewModels.name.value = b.editTextName.text.toString()
//            val company = b.editTextCompany.text.toString()
//            val size = b.editTextSize.text.toString()
//            val description = b.editTextDescription.text.toString()
//            val newShoe =
//                "Name: $name \nCompany: $company \nSize: $size \nDescription: $description \n\n"
//            sharedViewModels.addNewShoe(newShoe)