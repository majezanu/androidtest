package com.dacodes.venadostest.Views.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dacodes.venadostest.R;
import com.dacodes.venadostest.Views.Models.Games.Game;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GamesRVAdapter extends RecyclerView.Adapter<GamesRVAdapter.GamesViewHolder>{

    ArrayList<Game> games;
    Activity activity;
    public GamesRVAdapter(ArrayList<Game> games, Activity a) {
        this.games = games;
        this.activity = a;
    }
    public static class GamesViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cv;
        private ImageButton calendar;
        private TextView date;
        private TextView day;
        private ImageView local;
        private TextView local_name;
        private TextView home_score;
        private TextView away_score;
        private ImageView visitor;
        private TextView visitor_name;
        public GamesViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.games_cv);
            calendar = itemView.findViewById(R.id.calendar);
            date = itemView.findViewById(R.id.date);
            day = itemView.findViewById(R.id.day);
            local = itemView.findViewById(R.id.local);
            local_name = itemView.findViewById(R.id.home_name);
            home_score = itemView.findViewById(R.id.home_score);
            away_score = itemView.findViewById(R.id.away_score);
            visitor = itemView.findViewById(R.id.visitor_image);
            visitor_name = itemView.findViewById(R.id.visitor_name);
        }
    }

    @NonNull
    @Override
    public GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_games,parent,false);
        GamesRVAdapter.GamesViewHolder svh = new GamesRVAdapter.GamesViewHolder(v);
        return  svh;
    }

    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        final Game g = games.get(position);
        holder.date.setText(g.getDateDay());
        holder.day.setText(getDayOfTheWeek(g.getDate()));
        if(g.isLocal())
        {
            holder.local.setImageResource(R.drawable.logo_c);
            holder.local_name.setText(R.string.app_name);
            Picasso.get().load(g.getOpponent_image())
                    .placeholder(R.mipmap.icon_launcher)
                    .error(R.mipmap.icon_launcher)
                    .into(holder.visitor);
            holder.visitor_name.setText(g.getOpponent());
        }else
        {
            Picasso.get().load(g.getOpponent_image())
                    .placeholder(R.mipmap.icon_launcher)
                    .error(R.mipmap.icon_launcher)
                    .into(holder.local);
            holder.local_name.setText(g.getOpponent());
            holder.visitor_name.setText(R.string.app_name);
            holder.visitor.setImageResource(R.drawable.logo_c);
        }
        holder.home_score.setText(String.valueOf(g.getHome_score()));
        holder.away_score.setText(String.valueOf(g.getAway_score()));
        holder.calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    addEventToCalendar(g.getDate());
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public String getDayOfTheWeek(Date d)
    {
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE", Locale.forLanguageTag("es-ES"));
        return simpleDateformat.format(d);
    }

    private void addEventToCalendar(Date d){
        android.icu.util.Calendar cal = android.icu.util.Calendar.getInstance();
        cal.setTime(d);

        //cal.set(android.icu.util.Calendar.DAY_OF_MONTH, d.getDay());
        //cal.set(android.icu.util.Calendar.MONTH, d.getMonth());
        //cal.set(android.icu.util.Calendar.YEAR, d.getYear());
//
        //cal.set(android.icu.util.Calendar.HOUR_OF_DAY, d.getHours());
        //cal.set(android.icu.util.Calendar.MINUTE, d.getMinutes());

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis()+90*60*1000);

        intent.putExtra(CalendarContract.Events.ALL_DAY, false);
        intent.putExtra(CalendarContract.Events.RRULE , "FRE");
        intent.putExtra(CalendarContract.Events.TITLE, "Partido de Venados FC VS");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Descripción");


        activity.startActivity(intent);
    }

}
