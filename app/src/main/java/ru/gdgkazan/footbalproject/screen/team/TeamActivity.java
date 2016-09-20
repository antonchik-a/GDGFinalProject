package ru.gdgkazan.footbalproject.screen.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Player;
import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.screen.loading.LoadingDialog;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;
import ru.gdgkazan.footbalproject.utils.Images;

/**
 * Created by Sergei Riabov
 */
public class TeamActivity extends AppCompatActivity implements TeamContract.View {

    public static final String EXTRA_TEAM = "extraTeamName";

    private TeamContract.UserActionListener mPresenter;
    private LoadingView mLoadingView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbar;

    @BindView(R.id.title)
    TextView mTeamNameTextView;

    @BindView(R.id.players_recyclerview)
    RecyclerView playersRecyclerView;

    @BindView(R.id.team_logo)
    ImageView logoImageView;

    public static void navigate(@NonNull AppCompatActivity activity, @NonNull String teamName) {
        Intent intent = new Intent(activity, TeamActivity.class);
        intent.putExtra(EXTRA_TEAM, teamName);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        String teamName = getIntent().getStringExtra(EXTRA_TEAM);
        //teamName = "Chelsea FC";
        teamName = "West Ham United FC";
        mPresenter = new TeamPresenter(this);
        mPresenter.init(teamName);
    }

    @Override
    public void showTeam(Team team) {
        mCollapsingToolbar.setTitle(team.getName());
        Images.loadTeamLogo(logoImageView, team);

    }

    @Override
    public void showError() {
        Snackbar.make(playersRecyclerView, getResources().getString(R.string.loading_error), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingView.hideLoadingIndicator();
    }
}
