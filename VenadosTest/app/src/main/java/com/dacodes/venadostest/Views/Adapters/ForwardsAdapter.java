package com.dacodes.venadostest.Views.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.Models.Players.Forward;
import com.dacodes.venadostest.Views.Models.Players.Player;
import com.dacodes.venadostest.Views.Models.Players.Team;
import com.dacodes.venadostest.Views.Views.Fragments.PlayerDetailsFragment;
import com.dacodes.venadostest.Views.Views.Miscellanius.PicassoCircleTransformation;
import com.squareup.picasso.Picasso;

public class ForwardsAdapter extends BaseAdapter {
    private Context context;
    private Team team;
    private FragmentManager f;
    private static final String PLAYER_ID = "PLAYER_ID";

    public ForwardsAdapter(Context context, Team t, FragmentManager fm) {
        this.context = context;
        this.team = t;
        this.f = fm;
    }

    @Override
    public int getCount() {
        return team.getForwards().size();
    }

    @Override
    public Forward getItem(int i) {
        return  team.getForwards().get(i);

    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.player_grid_item, viewGroup, false);
        }
        ImageView imagePlayer = (ImageView) view.findViewById(R.id.Player_image);
        TextView positionPlayer = (TextView) view.findViewById(R.id.Player_Position);
        TextView namePlayer = (TextView) view.findViewById(R.id.Player_Name);
           final Forward item = getItem(i);
            Picasso.get().load(item.getUrlImage())
                    .placeholder(R.mipmap.icon_launcher)
                    .error(R.mipmap.icon_launcher)
                    .transform(new PicassoCircleTransformation())
                    .into(imagePlayer);
            positionPlayer.setText(item.getPosition());
            namePlayer.setText(item.getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle b = new Bundle();
                    b.putSerializable(PLAYER_ID, item);
                    showDialog(b);
                }
            });


        return view;
    }

    private void showDialog(Bundle bundle) {
        //FragmentManager fm = getSupportFragmentManager();
        PlayerDetailsFragment p = PlayerDetailsFragment.newInstance(bundle);
        p.show(f,"players_dialog_fragment");

    }
}
