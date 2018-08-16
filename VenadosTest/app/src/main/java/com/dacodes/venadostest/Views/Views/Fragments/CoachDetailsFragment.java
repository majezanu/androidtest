package com.dacodes.venadostest.Views.Views.Fragments;

import android.app.Dialog;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.Models.Players.Coach;
import com.dacodes.venadostest.Views.Views.Miscellanius.PicassoCircleTransformation;
import com.squareup.picasso.Picasso;


public class CoachDetailsFragment extends DialogFragment {
    private static final String coach_ID = "coach_ID";

    private Coach coach;
    private TextView name;
    private String name_s;
    private TextView position;
    private String position_s;
    private TextView birthdate;
    private String birthdate_s;
    private TextView birthplace;
    private String birthplace_s;
    private TextView weight;
    private String weight_s;
    private TextView height;
    private String height_s;
    private TextView lastTeam;
    private String lastTeam_s;
    private ImageView url;
    private String url_s;

    private View view;

    private CoachDetailsFragment.OnFragmentInteractionListener mListener;

    public CoachDetailsFragment() {
    }
    public static CoachDetailsFragment newInstance(Bundle save)
    {
        CoachDetailsFragment fragment = new CoachDetailsFragment();
        if(save != null)
        {
            fragment.setArguments(save);
        }
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        if (getArguments() != null) {
            coach = (Coach)getArguments().getSerializable(coach_ID);
            name_s = coach.getName()+" "+coach.getFirstSurName()+" "+ coach.getSecondSurName();
            position_s = coach.getRole();
            birthdate_s = coach.getBirthday();
            birthplace_s = coach.getBirthPlace();
            weight_s = String.valueOf(coach.getWeight());
            height_s = String.valueOf(coach.getHeight());
            lastTeam_s = "No disponible";
            url_s = coach.getUrlImage();
        }
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Hola);
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(R.string.player_details);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.players_dialog_fragment, container, false);
        name = view.findViewById(R.id.player_name_d);
        name.setText(name_s);

        position = view.findViewById(R.id.player_position_d);
        position.setText(position_s);

        birthdate = view.findViewById(R.id.birthdate_tv_d);
        birthdate.setText(birthdate_s);

        birthplace = view.findViewById(R.id.birthplace_tv_d);
        birthplace.setText(birthplace_s);

        weight = view.findViewById(R.id.weight_tv_d);
        weight.setText(weight_s);

        height = view.findViewById(R.id.height_tv_d);
        height.setText(height_s);

        lastTeam = view.findViewById(R.id.last_team_tv_d);
        lastTeam.setText(lastTeam_s);

        url = view.findViewById(R.id.Player_image_d);
        Picasso.get().load(url_s)
                .placeholder(R.mipmap.icon_launcher)
                .error(R.mipmap.icon_launcher)
                .transform(new PicassoCircleTransformation())
                .into(url);
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
        this.dismiss();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CoachDetailsFragment.OnFragmentInteractionListener) {
            mListener = (CoachDetailsFragment.OnFragmentInteractionListener) context;
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



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
