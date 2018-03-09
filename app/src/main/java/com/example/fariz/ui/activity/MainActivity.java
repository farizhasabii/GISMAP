package com.example.fariz.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fariz.ui.R;
import com.example.fariz.ui.fragment.AboutUsFragment;
import com.example.fariz.ui.fragment.DemografiFragment;
import com.example.fariz.ui.fragment.HomeFragment;
import com.example.fariz.ui.fragment.IkanFragment;
import com.example.fariz.ui.fragment.InfrastrukturFragment;
import com.example.fariz.ui.fragment.PertanianFragment;

public class MainActivity extends AppCompatActivity implements IkanFragment.OnFragmentInteractionListener,
        DemografiFragment.OnFragmentInteractionListener, PertanianFragment.OnFragmentInteractionListener ,
        AboutUsFragment.OnFragmentInteractionListener, InfrastrukturFragment.OnFragmentInteractionListener{

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    public static int navItemIndex = 0;

    boolean shouldLoadHomeFragOnBackPress = false;




    private static final String TAG_HOME = "Home";
    private static final String TAG_PERIKAN = "Perikanan";
    private static final String TAG_PERTANIAN = "Pertanian";
    private static final String TAG_INFRASTRUKTUR = "Infrastruktur";
    private static final String TAG_DEMOGRAFI = "Demografi";
    public static String CURRENT_TAG = TAG_HOME;

    private String[] activityTitles;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);


        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        loadNavHeader();
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private void loadNavHeader() {
        txtName.setText("Fariz");
        txtWebsite.setText("www.fariz.com");



        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }

    private void loadHomeFragment() {
        selectNavMenu();
        setToolbarTitle();
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();
            return;
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                android.support.v4.app.Fragment fragment = getHomeFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        drawer.closeDrawers();
        invalidateOptionsMenu();
    }

    private android.support.v4.app.Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1:
                IkanFragment ikanFragment = new IkanFragment();
                return ikanFragment;

            case 2:
                PertanianFragment pertanianFragment = new PertanianFragment();
                return pertanianFragment;

            case 3:
                DemografiFragment demografiFragment = new DemografiFragment();
                return demografiFragment;
            default:
                return new HomeFragment();
        }

    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_ikan:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_PERIKAN;
                        break;
                    case R.id.nav_pertanian:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_PERTANIAN;
                        break;
                    case R.id.nav_infrastruktur:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_INFRASTRUKTUR;
                        break;
                    case R.id.nav_demografi:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_DEMOGRAFI;
                        break;
                    default:
                        navItemIndex = 0;
                }
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;

            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        }

        // when fragment is notifications, load the menu created for notifications

        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
