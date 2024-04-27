package com.project.listnavigationcomponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.listnavigationcomponent.MainActivity
import com.project.listnavigationcomponent.R
import com.project.listnavigationcomponent.adapters.TextAdapter
import com.project.listnavigationcomponent.databinding.FragmentFirstBinding
import com.project.listnavigationcomponent.fragments.SecondFragment.Companion.EXTRA_ALPHABET
import com.project.listnavigationcomponent.utils.Constants
import com.project.listnavigationcomponent.viewmodel.MainViewModel

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val textAdapter = TextAdapter()
    private val alphabetList = arrayListOf<String>()

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = (requireActivity() as MainActivity).viewModel

        viewModel.isListView.observe(viewLifecycleOwner) {
            if (it) {
                binding.rvBtn.layoutManager = LinearLayoutManager(requireContext())
            } else {
                binding.rvBtn.layoutManager = GridLayoutManager(requireContext(), 2)
            }
        }

        alphabetList.clear()

        Constants.wordMap().forEach { (letter) ->
            alphabetList.add(letter.toString())
        }

        binding.rvBtn.apply {
            textAdapter.submitList(alphabetList)
            textAdapter.onBtnClick = {
                val bundle = Bundle()
                bundle.putString(EXTRA_ALPHABET, it)
                findNavController().navigate(R.id.action_firstFragment_to_mySecondFragment2, bundle)
            }
            adapter = textAdapter
        }

        return binding.root
    }
}