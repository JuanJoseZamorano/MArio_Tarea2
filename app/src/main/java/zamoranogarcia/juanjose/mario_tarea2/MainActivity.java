package zamoranogarcia.juanjose.mario_tarea2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.navigation.NavigationView;

import zamoranogarcia.juanjose.mario_tarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa el ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura la Toolbar
        setSupportActionBar(binding.toolbar);

        // Configura el Navigation Drawer
        DrawerLayout drawerLayout = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configura el NavController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        // Configura AppBarConfiguration para manejar el DrawerLayout
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.recycleFragment,  // Fragmento principal
                R.id.configuracion_Fragment // Fragmento de ajustes
        ).setOpenableLayout(drawerLayout).build();

        // Vincula la Toolbar con el NavController
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        // Configura las acciones del NavigationView:

        binding.navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                navController.navigate(R.id.recycleFragment);
            } else if (id == R.id.nav_settings) {
                navController.navigate(R.id.configuracion_Fragment);
            }
            // Cierra automáticamente el Drawer al seleccionar una opción.
            binding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú de opciones superior
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejo del menú "Acerca de"
        if (item.getItemId() == R.id.menu_acerca_de) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.acercade))
                    .setMessage(getString(R.string.mensajedialogo))
                    .setPositiveButton("Cerrar", (dialog, which) -> dialog.dismiss())
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Maneja el botón "Up" con el DrawerLayout
        NavController navController = ((NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment)).getNavController();
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }


}