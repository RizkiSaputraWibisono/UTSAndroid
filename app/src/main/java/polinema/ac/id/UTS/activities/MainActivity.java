package polinema.ac.id.UTS.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import polinema.ac.id.UTS.R;
import polinema.ac.id.UTS.fragments.EsCampurFragment;
import polinema.ac.id.UTS.fragments.EsCendolDawetFragment;
import polinema.ac.id.UTS.fragments.EsPisangHijauFragment;
import polinema.ac.id.UTS.fragments.HomeFragment;
import polinema.ac.id.UTS.fragments.MenuMakananFragment;
import polinema.ac.id.UTS.fragments.MenuMinumanFragment;
import polinema.ac.id.UTS.fragments.MinumFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
, HomeFragment.OnFragmentInteractionListener, MinumFragment.OnFragmentInteractionListener, MenuMinumanFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment (new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.minum:
                fragment = new MinumFragment();
                break;

        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onMeatClicked() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MenuMakananFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onMinumMClicked() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MenuMinumanFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onMinuman1Clicked() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new EsCendolDawetFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onMinuman2Clicked() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new EsCampurFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onMinuman3Clicked() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new EsPisangHijauFragment()).addToBackStack(null).commit();
    }
}
