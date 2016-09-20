package ru.gdgkazan.footbalproject.screen.fixtures;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Fixture;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class FixturesAdapter extends RecyclerView.Adapter<FixtureHolder> {

    private ArrayList<Fixture> mFixtures;


    public FixturesAdapter() {
        mFixtures = new ArrayList<>();
    }

    public void setData(List<Fixture> fixtures){
        mFixtures = (ArrayList<Fixture>) fixtures;
        notifyDataSetChanged();
    }

    @Override
    public FixtureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return   new FixtureHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fixture, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureHolder holder, int position) {
        holder.bind(mFixtures.get(position));
    }

    @Override
    public int getItemCount() {
        return mFixtures.size();
    }
}
