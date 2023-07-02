package com.yumtaufikhidayat.tourismappkoin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.yumtaufikhidayat.tourismappflow.R
import com.yumtaufikhidayat.tourismappflow.databinding.ActivityMainBinding
import com.yumtaufikhidayat.tourismappkoin.core.utils.showToast
import com.yumtaufikhidayat.tourismappkoin.favorite.FavoriteFragment
import com.yumtaufikhidayat.tourismappkoin.home.HomeFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        setUi(savedInstanceState)
    }

    private fun setUi(savedInstanceState: Bundle?) {
        binding.apply {
            val toggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout,
                appBarMain.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            navView.setNavigationItemSelectedListener(this@MainActivity)

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, HomeFragment())
                    .commit()
                supportActionBar?.title = getString(R.string.menu_home)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.apply {
            var fragment: Fragment? = null
            var title = ""
            when (item.itemId) {
                R.id.nav_home -> {
                    fragment = HomeFragment()
                    title = getString(R.string.menu_home)
                }
                R.id.nav_favorite -> {
                    fragment = FavoriteFragment()
                    title = getString(R.string.menu_favorite)
                }
                R.id.nav_map -> showToast(this@MainActivity, "Coming Soon")
            }

            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            supportActionBar?.title = title

            drawerLayout.closeDrawer(GravityCompat.START)
        }
        return true
    }
}