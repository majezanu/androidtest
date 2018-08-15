package com.dacodes.venadostest.Views.Views.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.IO.VenadosApiAdapter;
import com.dacodes.venadostest.Views.Models.Players.PlayerResponse;
import com.dacodes.venadostest.Views.Models.Players.Team;
import com.dacodes.venadostest.Views.Views.Fragments.PlayersFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PlayersFragment.OnFragmentInteractionListener{
    Toolbar toolbar;
    Bundle bundle = new Bundle();
    private static final String TEAM_ID = "Team_ID";
    private static final String CASO_ID = "Caso_ID";

    Team team = new Team();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState == null)
        {
            Call<PlayerResponse> call = VenadosApiAdapter.getApiService().getPlayers();
            call.enqueue(new Callback<PlayerResponse>() {
                @Override
                public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                    if(!response.isSuccessful() && response.errorBody() != null)
                    {

                    }else if(response.body() != null)
                    {
                        Log.d("RETFIT", response.body().getData().getTeam().getCenters().get(0).getUrlImage());
                        team = response.body().getData().getTeam();
                    }
                }

                @Override
                public void onFailure(Call<PlayerResponse> call, Throwable t) {

                }
            });

        }else
        {
            team = (Team)savedInstanceState.getSerializable(TEAM_ID);
        }
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.statistics) {
            toolbar.setTitle(R.string.statistics_item);
        } else if (id == R.id.players)
        {
            bundle.putSerializable(TEAM_ID, team);
            setFragment(2,bundle);
            toolbar.setTitle(R.string.group_team_menu);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setFragment(int position, Bundle args) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                //fragmentManager = getSupportFragmentManager();
                //fragmentTransaction = fragmentManager.beginTransaction();
                //InboxFragment inboxFragment = new InboxFragment();
                //fragmentTransaction.replace(R.id.fragment, inboxFragment);
                //fragmentTransaction.commit();
                break;
            case 1:
                //fragmentManager = getSupportFragmentManager();
                //fragmentTransaction = fragmentManager.beginTransaction();
                //StarredFragment starredFragment = new StarredFragment();
                //fragmentTransaction.replace(R.id.fragment, starredFragment);
                //fragmentTransaction.commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                PlayersFragment playersFragment = PlayersFragment.newInstance(args);
                fragmentTransaction.replace(R.id.content_fragment, playersFragment);
                fragmentTransaction.commit();
                break;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(TEAM_ID, team);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        team = (Team)savedInstanceState.getSerializable(TEAM_ID);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
