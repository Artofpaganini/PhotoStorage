package by.andersen.intern.photostorage

import android.app.SearchManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.andersen.intern.photostorage.databinding.ActivityMainBinding


class MainScreen : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.mainToolbar.root)

        initNavAndUI()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }

    private fun initNavAndUI() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchView =
            MenuItemCompat.getActionView(menu?.findItem(R.id.search)) as androidx.appcompat.widget.SearchView
        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.about -> Toast.makeText(this, "ABOUT", Toast.LENGTH_SHORT).show()
            R.id.search -> Toast.makeText(this, "SEARCH", Toast.LENGTH_SHORT).show()
            R.id.exit -> Toast.makeText(this, "EXIT", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}