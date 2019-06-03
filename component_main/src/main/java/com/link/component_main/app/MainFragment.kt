package com.link.component_main.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.link.component_main.R

class MainFragment : Fragment() {

    companion object {
            @JvmStatic
            fun newInstance() =
                MainFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }
}