package com.lwjlol.keepstatefragmentnavigation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var container: View
    lateinit var text: TextView
    lateinit var navManager: FragmentManager
    lateinit var navHostFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.container)
        text = findViewById(R.id.text)
        navHostFragment = NavHostFragment.create(R.navigation.main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, navHostFragment)
            .commit()

        lifecycleScope.launch {
            while (true){
                delay(1000)
                val sb = StringBuilder()
                navManager = navHostFragment.childFragmentManager

                navManager.fragments.forEach {
                    sb.append(it::class.qualifiedName).append("\n")
                }
                text.text = sb.toString()
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Navigation.findNavController(container)
            .addOnDestinationChangedListener { controller, destination, arguments ->
                Log.d("lwjlol-log", destination.toString())
            }
    }

    override fun onNavigateUp(): Boolean {
        return Navigation.findNavController(container).navigateUp()
    }

    override fun onBackPressed() {
        if (!onNavigateUp()) {
            finish()
        }
    }

}
