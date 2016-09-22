package ru.gdgkazan.footbalproject.screen.table.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

import java.util.List;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Standings;

/**
 * Created by mikes on 21.09.16.
 */

public class StandingsAdapter extends RecyclerView.Adapter<StandingsHolder> {

    private final List<Standings> mStandingsList;

    private final OnItemClick mOnItemClick;

    private final int DURATION_ANIMATION = 200;

    private final View.OnClickListener mChildListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Standings standings = (Standings) view.getTag();
            mOnItemClick.onItemClick(standings);
        }
    };

    public StandingsAdapter(@NonNull List<Standings> standingsList, @NonNull OnItemClick onItemClick) {
        mStandingsList = standingsList;
        mOnItemClick = onItemClick;
    }

    public void changeDataSet(@NonNull List<Standings> standings) {
        mStandingsList.clear();
        mStandingsList.addAll(standings);
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

        Standings standings = mStandingsList.get(position);
        holder.bind(standings);
        holder.mItemStandingsChild.setTag(standings);

        holder.mItemStandingsParent.setOnClickListener(view -> {
            boolean isExpanded = mStandingsList.get(position).getIsExpanded();
            mStandingsList.get(position).setIsOpened(!isExpanded);
            if(!isExpanded){
                expandChild(holder.mItemStandingsChild);
            }
            else{
                collapseChild(holder.mItemStandingsChild);
            }
        });
        holder.mItemStandingsChild.setOnClickListener(mChildListener);

    }

    @Override
    public int getItemCount() {
        return mStandingsList.size();
    }

    private void expandChild(final View v) {

        v.measure(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);

        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = (interpolatedTime == 1) ? RelativeLayout.LayoutParams.WRAP_CONTENT : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }
        };

        animation.setDuration(DURATION_ANIMATION);
        v.startAnimation(animation);
    }

    private void collapseChild(final RelativeLayout v) {

        final int initialHeight = v.getMeasuredHeight();

        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                }
                else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }
        };

        animation.setDuration(DURATION_ANIMATION);
        v.startAnimation(animation);
    }

    public interface OnItemClick {

        void onItemClick(Standings standings);

    }

}
