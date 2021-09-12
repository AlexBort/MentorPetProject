package com.android.academy.mentorpetproject.top_destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.android.academy.mentorpetproject.R


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var view: View

        val isTablet = requireContext().resources.getBoolean(R.bool.isTablet)

        when {
            isTablet -> {
                view = inflater.inflate(R.layout.fragment_profile_land, container, false)
                displayMasterDetailLayout(view)
            }
            else -> {
                view = inflater.inflate(R.layout.fragment_profile, container, false)
                displaySingleLayout(view)
            }
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun displaySingleLayout(view: View?) {
        view?.findViewById<TextView>(R.id.account_textview)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_accountFragment)
        )
        view?.findViewById<TextView>(R.id.notifications_textview)
            ?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_notificationsFragment))

        view?.findViewById<TextView>(R.id.settings_textview)
            ?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_settingsFragment))
    }

    private fun displayMasterDetailLayout(view: View?) {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.profile_nav_container) as NavHostFragment

        view?.findViewById<TextView>(R.id.account_textview)?.setOnClickListener {
            navHostFragment.navController.navigate(R.id.accountFragment)
        }

        view?.findViewById<TextView>(R.id.settings_textview)
            ?.setOnClickListener { navHostFragment.navController.navigate(R.id.settingsFragment) }

        view?.findViewById<TextView>(R.id.notifications_textview)
            ?.setOnClickListener { navHostFragment.navController.navigate(R.id.notificationsFragment) }
    }
}