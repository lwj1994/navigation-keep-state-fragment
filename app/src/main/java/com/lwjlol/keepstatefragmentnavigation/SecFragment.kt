package com.lwjlol.keepstatefragmentnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class SecFragment() : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        Log.d("lwjlol-log", "SecFragment onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lwjlol-log", "SecFragment onResume")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("lwjlol-log", "viewTest.parent = ${viewTest?.parent}")
        viewTest ?:  TextView(context).apply {
            viewTest = this
            text = "SecFragment"
            textSize = 100F
        }

        viewTest?.setOnClickListener {
            findNavController().navigate(
                R.id.secFragment, null, NavOptions.Builder()
                    .setEnterAnim(R.anim.enter_anim)
                    .setExitAnim(R.anim.exit_anim)
                    .setPopEnterAnim(R.anim.pop_enter_anim)
                    .setPopExitAnim(R.anim.pop_exit_anim)
                    .build()
            )
        }
        return  viewTest
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}
