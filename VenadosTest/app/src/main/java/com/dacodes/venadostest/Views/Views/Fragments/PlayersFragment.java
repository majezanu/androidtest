package com.dacodes.venadostest.Views.Views.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.CentersAdapter;
import com.dacodes.venadostest.Views.DefensesAdapter;
import com.dacodes.venadostest.Views.DtAdapter;
import com.dacodes.venadostest.Views.ForwardsAdapter;
import com.dacodes.venadostest.Views.GoalKeeperAdapter;
import com.dacodes.venadostest.Views.IO.VenadosApiAdapter;
import com.dacodes.venadostest.Views.Models.Players.Forward;
import com.dacodes.venadostest.Views.Models.Players.Player;
import com.dacodes.venadostest.Views.Models.Players.PlayerResponse;
import com.dacodes.venadostest.Views.Models.Players.Team;
import com.dacodes.venadostest.Views.PlayersAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayersFragment extends Fragment {

    private static final String TEAM_ID = "Team_ID";
    private static final String CASO_ID = "Caso_ID";
    // TODO: Rename and change types of parameters
    private Team team;

    private GridView gridView;

    private ForwardsAdapter adapter_forwards;
    private CentersAdapter adapter_centers;
    private DefensesAdapter adapter_defenses;
    private GoalKeeperAdapter adapter_goalKeeper;
    private DtAdapter adapter_coaches;
    private OnFragmentInteractionListener mListener;
    private View view;

    public PlayersFragment()
    {
    }
    public static PlayersFragment newInstance(Bundle save)
    {
        PlayersFragment fragment = new PlayersFragment();
        if(save != null)
        {
            fragment.setArguments(save);
        }
        return fragment;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.forwards:
                    gridView.setAdapter(adapter_forwards);
                    return true;
                case R.id.centers:
                    gridView.setAdapter(adapter_centers);
                    return true;
                case R.id.defenses:
                    gridView.setAdapter(adapter_defenses);
                    return true;
                case R.id.goalKeepers:
                    gridView.setAdapter(adapter_goalKeeper);
                    return true;
                case R.id.coaches_menu:
                    gridView.setAdapter(adapter_coaches);
                    return true;
            }
            return false;
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            team = (Team) getArguments().getSerializable(TEAM_ID);
            if(getActivity().getApplicationContext() != null)
            {

                adapter_forwards = new ForwardsAdapter(getActivity().getApplicationContext(),team);
                adapter_centers = new CentersAdapter(getActivity().getApplicationContext(),team);
                adapter_defenses = new DefensesAdapter(getActivity().getApplicationContext(),team);
                adapter_goalKeeper = new GoalKeeperAdapter(getActivity().getApplicationContext(),team);
                adapter_coaches = new DtAdapter(getActivity().getApplicationContext(),team);
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_players, container, false);
        gridView = (GridView) view.findViewById(R.id.Players_grid);
        gridView.setAdapter(adapter_forwards);
        BottomNavigationView navegacion = (BottomNavigationView) view.findViewById(R.id.navigation);
        navegacion.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


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
}
