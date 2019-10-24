package com.nearby.app.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentHelper {

    private fun openFragment(ctx: AppCompatActivity,container:Int, fragment: Fragment) {
        val transaction = ctx.supportFragmentManager.beginTransaction()
        transaction.replace(container ,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}