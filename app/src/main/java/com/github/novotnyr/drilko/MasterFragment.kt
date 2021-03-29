package com.github.novotnyr.drilko

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.github.novotnyr.drilko.databinding.FragmentMasterBinding

class MasterFragment : Fragment() {
    private lateinit var binding: FragmentMasterBinding

    private val cityViewModel: CityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasterBinding.inflate(inflater, container, false)
        return binding.root
    }

    // MasterFragment
    //         |
    //     viewmodel:     bude niest info o vybranom meste ako LiveData
    // ak sa kliklo na polozku zoznamu ListView, tak natlac do zivych data LiveData informaciu
    // o vybranom meste

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cityListView.setOnItemClickListener { _, _, position: Int, _ ->
            val city = binding.cityListView.getItemAtPosition(position) as String
            cityViewModel.setSelectedCity(city)
            Log.d("MasterFragment", "Kliklo sa na mesto $city")
        }
    }
}