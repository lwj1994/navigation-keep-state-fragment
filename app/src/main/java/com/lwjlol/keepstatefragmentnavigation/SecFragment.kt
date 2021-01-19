package com.lwjlol.keepstatefragmentnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecFragment():Fragment() {

    override fun onPause() {
        super.onPause()
        Log.d("lwjlol-log","SecFragment onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lwjlol-log","SecFragment onResume")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return TextView(context).apply {
            text  = "SecFragment"
            textSize = 100F
        }
    }
}
