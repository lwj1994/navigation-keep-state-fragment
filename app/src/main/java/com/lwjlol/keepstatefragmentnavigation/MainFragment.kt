package com.lwjlol.keepstatefragmentnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment():Fragment() {

    override fun onPause() {
        super.onPause()
        Log.d("lwjlol-log","MainFragment onPause")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lwjlol-log","MainFragment onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lwjlol-log","MainFragment onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("lwjlol-log","MainFragment onDestroyView")

    }

    override fun onResume() {
        super.onResume()
        Log.d("lwjlol-log","MainFragment onResume")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("lwjlol-log","MainFragment onCreateView")
        return TextView(context).apply {
            text  = "MainFragment"
            textSize = 100F
            setOnClickListener {
                findNavController().navigate(R.id.secFragment)
            }
        }
    }
}
