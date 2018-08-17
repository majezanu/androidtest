package com.dacodes.venadostest.Views.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.Models.Statistics.Statistic;
import com.dacodes.venadostest.Views.Views.Miscellanius.PicassoCircleTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StatisticsRVAdapter extends RecyclerView.Adapter<StatisticsRVAdapter.StatisticViewHolder> {
   ArrayList<Statistic> statistics;

    public StatisticsRVAdapter(ArrayList<Statistic> statistics) {
        this.statistics = statistics;
    }

    public static class StatisticViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cv;
        private TextView table_pos;
        private ImageView image_team;
        private TextView name_team;
        private TextView game_played;
        private TextView score_diff;
        private TextView points;

        public StatisticViewHolder(View itemView) {
            super(itemView);
            cv =itemView.findViewById(R.id.stats_cv);
            table_pos = itemView.findViewById(R.id.table_position);
            image_team = itemView.findViewById(R.id.image_team);
            name_team = itemView.findViewById(R.id.team_name);
            game_played = itemView.findViewById(R.id.games_played);
            score_diff = itemView.findViewById(R.id.score_diff);
            points = itemView.findViewById(R.id.points);

        }

    }

    @NonNull
    @Override
    public StatisticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_statistic,parent,false);
        StatisticViewHolder svh = new StatisticViewHolder(v);
        return  svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticViewHolder holder, int position) {
        holder.table_pos.setText(String.valueOf(statistics.get(position).getPosition()));
        Picasso.get().load(statistics.get(position).getUrlImage())
                .placeholder(R.mipmap.icon_launcher)
                .error(R.mipmap.icon_launcher)
                .into(holder.image_team);
        holder.name_team.setText(statistics.get(position).getTeam());
        holder.game_played.setText(String.valueOf(statistics.get(position).getGames()));
        holder.score_diff.setText(String.valueOf(statistics.get(position).getScoreDiff()));
        holder.points.setText(String.valueOf(statistics.get(position).getPoints()));

    }

    @Override
    public int getItemCount() {
        return statistics.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
