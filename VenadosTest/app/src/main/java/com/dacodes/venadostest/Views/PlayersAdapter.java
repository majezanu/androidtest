package com.dacodes.venadostest.Views;

import android.content.Context;
import android.media.Image;
import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.Models.Players.Person;
import com.dacodes.venadostest.Views.Models.Players.Player;
import com.dacodes.venadostest.Views.Models.Players.Team;
import com.dacodes.venadostest.Views.Views.Miscellanius.PicassoCircleTransformation;
import com.squareup.picasso.Picasso;

public class PlayersAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private Team team;

    public PlayersAdapter(Context context, Team t) {
        this.context = context;
        this.team = t;
    }

    @Override
    public int getCount() {
        return team.getAllPlayers().size();
    }

    @Override
    public Player getItem(int i) {
        return  team.getAllPlayers().get(i);

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
           final Player item = (Player)getItem(i);
            Picasso.get().load(item.getUrlImage())
                    .placeholder(R.mipmap.icon_launcher)
                    .error(R.mipmap.icon_launcher)
                    .transform(new PicassoCircleTransformation())
                    .into(imagePlayer);
            positionPlayer.setText(item.getPosition());
            namePlayer.setText(item.getName());



        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
