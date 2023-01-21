package com.example.shoestore

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    //    private val sharedViewModels: SharedViewModel by activityViewModels()
    private val sharedViewModels by activityViewModels<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val b: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        //add new shoe
        b.btnFloating.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))

        // logout menu
        setHasOptionsMenu(true)

        // List shoes
        sharedViewModels.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                val shoeTextView = TextView(requireContext())
                shoeTextView.text = shoe
                b.linearLayout.addView(shoeTextView)
            }
        })


        return b.root
    }

    // logout menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_menue, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginFragment) {
//            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_loginFragment)
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
            return true
        }
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }//End of menu

}
