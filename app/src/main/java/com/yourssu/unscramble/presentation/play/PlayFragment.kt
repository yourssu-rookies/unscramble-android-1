package com.yourssu.unscramble.presentation.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentPlayBinding
import com.yourssu.unscramble.presentation.MainViewModel
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayFragment : BindFragment<FragmentPlayBinding>() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private val viewModel: PlayViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentPlayBinding {
        return FragmentPlayBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        observeViewModel()
        viewModel.checkValid()
        observeNavigationToEnd()
        setupListeners()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.navigateToEnd.collect { navigateToEnd ->
                if (navigateToEnd) {
                    findNavController().navigate(R.id.endFragment)
                }
            }
        }
    }

    private fun observeNavigationToEnd() {
        lifecycleScope.launch {
            viewModel.navigateToEnd.collect { navigateToEnd ->
                if (navigateToEnd) {
                    findNavController().navigate(R.id.endFragment)
                }
            }
        }
    }

    private fun setupListeners() {
        binding.btnSubmit.setOnClickListener {
            viewModel.onPlayButtonClick()
            binding.etAnswer.text.clear()
        }
        binding.btnSkip.setOnClickListener {
            viewModel.onPlayButtonClick()
            binding.etAnswer.text.clear()
        }

        mainViewModel.startTimer()

        viewLifecycleOwner.lifecycleScope.launch {
            mainViewModel.isEnd
                .collectLatest { isEnd ->
                    if (isEnd) {
                        findNavController().navigate(R.id.endFragment)
                    }
                }
        }
    }
}
