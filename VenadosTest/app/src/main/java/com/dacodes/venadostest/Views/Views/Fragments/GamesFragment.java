package com.dacodes.venadostest.Views.Views.Fragments;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.Adapters.GamesRVAdapter;
import com.dacodes.venadostest.Views.Models.Games.DataGames;
import com.dacodes.venadostest.Views.Models.Games.Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GamesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String GaMES_ID = "GAMES_ID";
    private RecyclerView rv;
    private GamesRVAdapter adapter;
    private View view;
    // TODO: Rename and change types of parameters
    private DataGames dataGames = new DataGames();
    ArrayList<Game> games;
    private OnFragmentInteractionListener mListener;

    public GamesFragment() {
    }
    // TODO: Rename and change types and number of parameters
    public static GamesFragment newInstance(Bundle args) {
        GamesFragment gamesFragment = new GamesFragment();
        if(args != null)
        {
            gamesFragment.setArguments(args);
        }
        return gamesFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataGames = (DataGames)getArguments().getSerializable(GaMES_ID);
            games = dataGames.getGames();
            adapter = new GamesRVAdapter(copaMX(games), getActivity());


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);
        Toolbar toolbar = view.findViewById(R.id.appbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);



        TabLayout tabLayout = view.findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("COPA MX"));
        tabLayout.addTab(tabLayout.newTab().setText("ASCENSO MX"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        adapter = new GamesRVAdapter(copaMX(games),getActivity());
                        rv.setAdapter(adapter);
                        Log.d("TAB",copaMX(games).get(1).getOpponent());
                        break;
                    case 1:
                        adapter = new GamesRVAdapter(ascensoMX(games),getActivity());
                        rv.setAdapter(adapter);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        rv = view.findViewById(R.id.games_rv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setAdapter(adapter);
        rv.setLayoutManager(llm);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public ArrayList<Game> copaMX(ArrayList<Game> allGames)
    {
        ArrayList<Game> copaMX = new ArrayList<>();
        for(Game g: allGames)
        {
            if(g.getLeague().contains("Copa MX"))
            {
                copaMX.add(g);
            }
        }
        Collections.sort(copaMX, new Comparator<Game>() {
            @Override
            public int compare(Game game, Game t1) {
                return game.getDate().compareTo(t1.getDate());
            }
        });
        return copaMX;
    }

    public ArrayList<Game> ascensoMX(ArrayList<Game> allGames)
    {
        ArrayList<Game> AscensoMX = new ArrayList<>();
        for(Game g: allGames)
        {
            if(g.getLeague().contains("Ascenso MX"))
            {
                AscensoMX.add(g);
            }
        }
        Collections.sort(AscensoMX, new Comparator<Game>() {
            @Override
            public int compare(Game game, Game t1) {
                return game.getDate().compareTo(t1.getDate());
            }
        });
        return AscensoMX;
    }


}
