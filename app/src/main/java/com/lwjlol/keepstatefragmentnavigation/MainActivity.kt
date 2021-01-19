package com.lwjlol.keepstatefragmentnavigation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    lateinit var container:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.container)
        val navHostFragment = NavHostFragment.create(R.navigation.main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, navHostFragment)
            .commit()
    }

    override fun onNavigateUp(): Boolean {
        return Navigation.findNavController(container).navigateUp()
    }

    override fun onBackPressed() {
        if (!onNavigateUp()){
            finish()
        }
    }

}
