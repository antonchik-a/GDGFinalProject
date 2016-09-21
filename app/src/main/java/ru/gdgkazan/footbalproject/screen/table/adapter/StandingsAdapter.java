package ru.gdgkazan.footbalproject.screen.table.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Standings;

/**
 * Created by mikes on 21.09.16.
 */

public class StandingsAdapter extends RecyclerView.Adapter<StandingsHolder> {

    private final List<Standings> mStandings;

    private final OnItemClick mOnItemClick;

    private final View.OnClickListener mInternalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Standings standing = (Standings) view.getTag();
            mOnItemClick.onItemClick(standing);
        }
    };

    public StandingsAdapter(@NonNull List<Standings> standings, @NonNull OnItemClick onItemClick) {
        mStandings = standings;
        mOnItemClick = onItemClick;
    }

    public void changeDataSet(@NonNull List<Standings> standings) {
        mStandings.clear();
        mStandings.addAll(standings);
        notifyDataSetChanged();
    }

    @Override
    public StandingsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_standings, parent, false);
        return new StandingsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StandingsHolder holder, int position) {
        Standings standing = mStandings.get(position);
        holder.bind(standing);
        holder.itemView.setTag(standing);
        holder.itemView.setOnClickListener(mInternalListener);
    }

    @Override
    public int getItemCount() {
        return mStandings.size();
    }

    public interface OnItemClick {

        void onItemClick(@NonNull Standings standing);

    }

}
