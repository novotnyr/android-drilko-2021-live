package com.github.novotnyr.drilko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private val cityViewModel: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(isSmallDevice()) {
            supportFragmentManager.commit {
                replace(R.id.mainActivity, MasterFragment())
            }

            cityViewModel.selectedCity.observe(this) {
                supportFragmentManager.commit {
                    replace(R.id.mainActivity, DetailFragment())
                    addToBackStack(null)
                }
            }
        }
    }

    fun isSmallDevice(): Boolean {
        //v layoute s identifikatorom vzdy vidno len jediny fragment a musime ich prepinat
        return findViewById<View>(R.id.mainActivity) != null
    }
}