package com.dacodes.venadostest.Views.Views.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
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
import com.dacodes.venadostest.Views.Models.Games.DataGames;
import com.dacodes.venadostest.Views.Models.Games.GamesResponse;
import com.dacodes.venadostest.Views.Models.Players.Coach;
import com.dacodes.venadostest.Views.Models.Players.PlayerResponse;
import com.dacodes.venadostest.Views.Models.Players.Team;
import com.dacodes.venadostest.Views.Models.Statistics.DataStatistics;
import com.dacodes.venadostest.Views.Models.Statistics.Statistic;
import com.dacodes.venadostest.Views.Models.Statistics.StatisticsResponse;
import com.dacodes.venadostest.Views.Views.Fragments.CoachDetailsFragment;
import com.dacodes.venadostest.Views.Views.Fragments.GamesFragment;
import com.dacodes.venadostest.Views.Views.Fragments.PlayerDetailsFragment;
import com.dacodes.venadostest.Views.Views.Fragments.PlayersFragment;
import com.dacodes.venadostest.Views.Views.Fragments.StatisticsFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PlayersFragment.OnFragmentInteractionListener,
        PlayerDetailsFragment.OnFragmentInteractionListener, CoachDetailsFragment.OnFragmentInteractionListener,
        StatisticsFragment.OnFragmentInteractionListener, GamesFragment.OnFragmentInteractionListener{
    Toolbar toolbar;
    Bundle bundle = new Bundle();
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private static final String TEAM_ID = "Team_ID";
    private static final String STATISTICS_ID = "STATISTICS_ID";
    private static final String GaMES_ID = "GAMES_ID";
    private static final String CASO_ID = "Caso_ID";

    Team team = new Team();
    DataStatistics dataStatistics = new DataStatistics();
    DataGames dataGames = new DataGames();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState == null)
        {
            Call<GamesResponse> call0 = VenadosApiAdapter.getApiService().getGamesResponse();
            call0.enqueue(new Callback<GamesResponse>() {
                @Override
                public void onResponse(Call<GamesResponse> call, Response<GamesResponse> response) {
                    if(!response.isSuccessful() && response.errorBody() != null)
                    {

                    }else if(response.body() != null)
                    {
                        Log.d("RETFIT", response.body().getData().getGames().get(1).getDateReformated());
                        dataGames = response.body().getData();
                    }
                }

                @Override
                public void onFailure(Call<GamesResponse> call, Throwable t) {

                }
            });
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

            Call<StatisticsResponse> call2 = VenadosApiAdapter.getApiService().getStatisticsResponse();
            call2.enqueue(new Callback<StatisticsResponse>() {
                @Override
                public void onResponse(Call<StatisticsResponse> call, Response<StatisticsResponse> response) {
                    if(!response.isSuccessful() && response.errorBody() != null)
                    {

                    }else if(response.body() != null)
                    {
                        dataStatistics = response.body().getData();
                        Log.d("RETFIT", dataStatistics.getStatistics().get(1).getTeam());

                    }
                }

                @Override
                public void onFailure(Call<StatisticsResponse> call, Throwable t) {

                }
            });

        }else
        {
            team = (Team)savedInstanceState.getSerializable(TEAM_ID);
            dataStatistics = (DataStatistics) savedInstanceState.getSerializable(STATISTICS_ID);
        }
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
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

           //getSupportActionBar().hide();
           // getSupportActionBar().setCustomView(R.layout.fragment_games);
            //getSupportActionBar().setDisplayShowCustomEnabled(true);
            //getSupportActionBar().show();
            bundle.putSerializable(GaMES_ID,dataGames);
            setFragment(0,bundle);
        } else if (id == R.id.statistics) {
            //setSupportActionBar(toolbar);

            bundle.putSerializable(STATISTICS_ID, dataStatistics);
            toolbar.setTitle(R.string.statistics_item);
            setFragment(1, bundle);
        } else if (id == R.id.players)
        {

            //setSupportActionBar(toolbar);
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
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                GamesFragment gamesFragment = GamesFragment.newInstance(args);
                fragmentTransaction.replace(R.id.content_fragment, gamesFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                StatisticsFragment statisticsFragment = StatisticsFragment.newInstance(args);
                fragmentTransaction.replace(R.id.content_fragment, statisticsFragment);
                fragmentTransaction.commit();
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
        outState.putSerializable(STATISTICS_ID,dataStatistics);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        team = (Team)savedInstanceState.getSerializable(TEAM_ID);
        dataStatistics = (DataStatistics) savedInstanceState.getSerializable(STATISTICS_ID);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
