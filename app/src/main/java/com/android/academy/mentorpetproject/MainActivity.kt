package com.android.academy.mentorpetproject

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    private lateinit var listener: NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.fragment_container)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setupWithNavController(navController)


        val topLevelDestinations: Set<Int> = hashSetOf(R.id.firstFragment,R.id.secondFragment,R.id.profileFragment)
appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).setOpenableLayout(drawerLayout).build()
//        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        /**
         * Sets up a [NavigationView] for use with a [NavController]. This will call
         * [android.view.MenuItem.onNavDestinationSelected] when a menu item is selected.
         * The selected item in the NavigationView will automatically be updated when the destination
         * changes.
         */
//        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this,
            this.navController,
            this.appBarConfiguration)

/*        // example of using controllerListener
        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.firstFragment) {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
//                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_700)))
                } else if (destination.id == R.id.secondFragment) {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
//                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.black)))
                } else if (destination.id == R.id.profileFragment) {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }*/
    }

    override fun onResume() {
        super.onResume()
//        navController.addOnDestinationChangedListener(listener)
    }

    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}