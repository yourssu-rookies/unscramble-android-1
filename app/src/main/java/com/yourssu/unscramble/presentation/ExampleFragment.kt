package com.yourssu.unscramble.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.yourssu.unscramble.util.base.BindFragment
import com.yourssu.unscramble.databinding.FragmentExampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleFragment : BindFragment<FragmentExampleBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): FragmentExampleBinding {
        return FragmentExampleBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
