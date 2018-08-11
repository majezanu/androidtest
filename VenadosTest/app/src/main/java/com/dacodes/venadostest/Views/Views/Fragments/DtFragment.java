package com.dacodes.venadostest.Views.Views.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.DtAdapter;
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
 * {@link DtFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DtFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DtFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GridView gridView;
    private DtAdapter adapter;

    private Team team = new Team();
    private OnFragmentInteractionListener mListener;
    View view;

    public DtFragment() {
        // Required empty public constructor


    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DtFragment newInstance(Bundle save) {
        DtFragment fragment = new DtFragment();
        Bundle args = save;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Call<PlayerResponse> call = VenadosApiAdapter.getApiService().getPlayers();
        call.enqueue(new Callback<PlayerResponse>() {
            @Override
            public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                if(!response.isSuccessful() && response.errorBody() != null)
                {

                }else if(response.body() != null)
                {
                    //if(response.body().getCode() == 200)
                    //{
                    Log.d("RETFIT", response.body().getData().getTeam().getCenters().get(0).getUrlImage());
                    //team.setForwards(response.body().getData().getTeam().getForwards());
                    team = response.body().getData().getTeam();
                    adapter = new DtAdapter(getActivity().getApplicationContext(),team);
                    gridView.setAdapter(adapter);
                    //}
                }
            }

            @Override
            public void onFailure(Call<PlayerResponse> call, Throwable t) {

            }
        });
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_players, container, false);

        gridView = (GridView) view.findViewById(R.id.Players_grid);


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
