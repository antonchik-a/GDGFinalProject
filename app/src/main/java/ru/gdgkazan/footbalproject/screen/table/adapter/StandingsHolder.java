package ru.gdgkazan.footbalproject.screen.table.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Standings;
import ru.gdgkazan.footbalproject.utils.CircleImageView;

/**
 * Created by mikes on 21.09.16.
 */

public class StandingsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.standingsParentRank)
    TextView mStandingsParentRank;

    @BindView(R.id.standingsParentTeam)
    TextView mStandingsParentTeam;

    @BindView(R.id.standingsParentWins)
    TextView mStandingsParentWins;

    @BindView(R.id.standingsParentDraws)
    TextView mStandingsParentDraws;

    @BindView(R.id.standingsParentLosses)
    TextView mStandingsParentLosses;

    @BindView(R.id.standingsParentPoints)
    TextView mStandingsParentPoints;

    @BindView(R.id.standingsChildHomeWins)
    TextView mStandingsChildHomeWins;

    @BindView(R.id.standingsChildHomeDraws)
    TextView mStandingsChildHomeDraws;

    @BindView(R.id.standingsChildHomeLosses)
    TextView mStandingsChildHomeLosses;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.standingsChildGoalsDifference)
    TextView mStandingsChildGoalsDifference;

    @BindView(R.id.standingsChildHomeGoalsScored)
    TextView mStandingsChildHomeGoalsScored;

    @BindView(R.id.standingsChildAwayGoalsScored)
    TextView mStandingsChildAwayGoalsScored;

    @BindView(R.id.standingsChildHomeGoalsAgainst)
    TextView mStandingsChildHomeGoalsAgainst;

    @BindView(R.id.standingsChildAwayGoalsAgainst)
    TextView mStandingsChildAwayGoalsAgainst;

    @BindView(R.id.standingsChildAwayWins)
    TextView mStandingsChildAwayWins;

    @BindView(R.id.standingsChildAwayDraws)
    TextView mStandingsChildAwayDraws;

    @BindView(R.id.standingsChildAwayLosses)
    TextView mStandingsChildAwayLosses;

    @BindView(R.id.standingsParentLogo)
    CircleImageView mStandingsParentLogo;

    public StandingsHolder(@NonNull  View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull Standings standings){
        mStandingsParentRank.setText(String.valueOf(standings.getPosition()));
        mStandingsParentTeam.setText(standings.getTeamname());
        mStandingsParentWins.setText(String.valueOf(standings.getWins()));
        mStandingsParentDraws.setText(String.valueOf(standings.getDraws()));
        mStandingsParentLosses.setText(String.valueOf(standings.getLosses()));
        mStandingsParentPoints.setText(String.valueOf(standings.getPoints()));
        mStandingsChildHomeWins.setText(String.valueOf(standings.getStandingsDetailsHome().getWins()));
        mStandingsChildHomeDraws.setText(String.valueOf(standings.getStandingsDetailsHome().getDraws()));
        mStandingsChildHomeLosses.setText(String.valueOf(standings.getStandingsDetailsHome().getLosses()));
        mStandingsChildGoalsDifference.setText(String.valueOf(standings.getGoalDifference()));
        mStandingsChildHomeGoalsScored.setText(String.valueOf(standings.getStandingsDetailsHome().getGoals()));
        mStandingsChildAwayGoalsScored.setText(String.valueOf(standings.getStandingsDetailsAway().getGoals()));
        mStandingsChildHomeGoalsAgainst.setText(String.valueOf(standings.getStandingsDetailsHome().getGoalsAgainst()));
        mStandingsChildAwayGoalsAgainst.setText(String.valueOf(standings.getStandingsDetailsAway().getGoalsAgainst()));
        mStandingsChildAwayWins.setText(String.valueOf(standings.getStandingsDetailsAway().getWins()));
        mStandingsChildAwayDraws.setText(String.valueOf(standings.getStandingsDetailsAway().getDraws()));
        mStandingsChildAwayLosses.setText(String.valueOf(standings.getStandingsDetailsAway().getLosses()));
        mProgressBar.setProgress(getGoalsPercentage(standings.getGoals(), standings.getGoalsAgainst()));
    }

    private int getGoalsPercentage(int goals, int goalsAgainst){
        return (100 * goals / (goals + goalsAgainst));
    }

}
