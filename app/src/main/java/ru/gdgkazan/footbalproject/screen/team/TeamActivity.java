package ru.gdgkazan.footbalproject.screen.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.screen.loading.LoadingDialog;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;
import ru.gdgkazan.footbalproject.utils.Images;
import ru.gdgkazan.footbalproject.widget.DividerItemDecoration;

/**
 * Created by Sergei Riabov
 */
public class TeamActivity extends AppCompatActivity implements TeamContract.View, SwipeRefreshLayout.OnRefreshListener {

    public static final String EXTRA_TEAM = "extraTeamName";

    private TeamContract.UserActionListener mPresenter;
    private LifecycleHandler mLifecycleHandler;
    private PlayersAdapter mPlayersAdapter;
    private LoadingView mLoadingView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbar;

    @BindView(R.id.players_recyclerview)
    RecyclerView mPlayersRecyclerView;

    @BindView(R.id.team_logo)
    ImageView logoImageView;

    @BindView(R.id.squad_market_value)
    TextView mMarketValueView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

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

        mPlayersAdapter = new PlayersAdapter();
        mPlayersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPlayersRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mPlayersRecyclerView.setAdapter(mPlayersAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        String teamName = getIntent().getStringExtra(EXTRA_TEAM);
        //teamName = "Chelsea FC";
        mLifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new TeamPresenter(this, mLifecycleHandler);
        mPresenter.init(teamName);
    }

    @Override
    public void showTeam(Team team) {
        Images.loadTeamLogo(logoImageView, team);
        mCollapsingToolbar.setTitle(team.getName());
        mMarketValueView.setText(getString(R.string.squad_market_value, team.getSquadMarketValue()));
        mPlayersAdapter.setData(team.getPlayers());
        if(mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showError() {
        Snackbar.make(mPlayersRecyclerView, getResources().getString(R.string.loading_error), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingView.hideLoadingIndicator();
    }

    @Override
    public void onRefresh() {
        mPresenter.reload();
    }
}
