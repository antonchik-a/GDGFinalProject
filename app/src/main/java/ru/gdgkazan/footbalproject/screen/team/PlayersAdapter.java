package ru.gdgkazan.footbalproject.screen.team;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Player;

/**
 * Created by Sergei Riabov
 */
public class PlayersAdapter extends RecyclerView.Adapter<PlayersHolder> {

    private ArrayList<Player> mPlayers;


    public PlayersAdapter() {
        mPlayers = new ArrayList<>();
    }

    public void setData(List<Player> players){
        mPlayers.addAll(players);
        notifyDataSetChanged();
    }

    @Override
    public PlayersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new PlayersHolder(
              LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersHolder holder, int position) {
        holder.bind(mPlayers.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }
}
