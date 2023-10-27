package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val shoppingFragment = ShoppingFragment()
    private val billsFragment = BillsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(shoppingFragment)

        binding.bottomNavigation.setOnItemSelectedListener { selectedItem ->
            when(selectedItem.itemId){
                R.id.shopping -> replaceFragment(shoppingFragment)
                R.id.bills -> replaceFragment(billsFragment)
            }
            return@setOnItemSelectedListener true
        }

        binding.fab.setOnClickListener {
            when(binding.bottomNavigation.selectedItemId){
                R.id.shopping -> showAddShoppingItemDialog()
                R.id.bills -> showAddBillItemDialog()
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.fragmentContainer.id, fragment)
        }
    }

    private fun showAddShoppingItemDialog(){
        Log.d("MainActivity", "shopping dialog opened")
    }

    private fun showAddBillItemDialog(){
        Log.d("MainActivity", "bills dialog opened")

    }
}