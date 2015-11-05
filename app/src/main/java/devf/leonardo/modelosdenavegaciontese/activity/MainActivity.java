package devf.leonardo.modelosdenavegaciontese.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import devf.leonardo.modelosdenavegaciontese.R;
import devf.leonardo.modelosdenavegaciontese.activity.fragment.FragmentoAndroid;
import devf.leonardo.modelosdenavegaciontese.activity.fragment.FragmentoAssigment;
import devf.leonardo.modelosdenavegaciontese.activity.fragment.FragmentoBuild;
import devf.leonardo.modelosdenavegaciontese.activity.fragment.FragmentoHome;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolBar();
        setupDrawer();
        replaceFragment(new FragmentoHome());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass = null;

        Class aClass;

        switch (menuItem.getItemId()) {
            case R.id.menu_item_android:
                fragmentClass = FragmentoAndroid.class;
                Log.d("Navigation", "Android");
                drawerLayout.closeDrawers();
                break;
            case R.id.menu_item_assigment:
                fragmentClass = FragmentoAssigment.class;
                Log.d("Navigation", "Assigment");
                drawerLayout.closeDrawers();
                break;
            case R.id.menu_item_build:
                Log.d("Navigation", "Build");
                fragmentClass = FragmentoBuild.class;
                drawerLayout.closeDrawers();
                break;
            default:
                fragmentClass = FragmentoHome.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        replaceFragment(fragment);


        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());


        return false;
    }
    //metodo de remplazar Fragmentos
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_fragment, fragment).commit();

    }

    //metodo Drawer
    public void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_bar);
        navigationView.setNavigationItemSelectedListener(this);
    }
    //metodo ToolBar

    public void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tootlbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

    }
}
