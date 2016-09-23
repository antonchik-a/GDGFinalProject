package ru.gdgkazan.footbalproject.screen.fixtures;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.screen.loading.LoadingDialog;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;
import ru.gdgkazan.footbalproject.screen.search.SearchActivity;
import ru.gdgkazan.footbalproject.widget.DividerItemDecoration;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class FixturesFragment extends Fragment implements FixturesView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private FixturesAdapter mFixturesAdapter;
    private LifecycleHandler mLifecycleHandler;
    private FixturesPresenter mFixturesPresenter;
    private LoadingView mLoadingView;
    private int mCount = FixturesPresenter.WEEK;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixtures, null);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLoadingView = LoadingDialog.view(getChildFragmentManager());
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mFixturesAdapter = new FixturesAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        mRecyclerView.setAdapter(mFixturesAdapter);

        mLifecycleHandler = LoaderLifecycleHandler.create(getActivity(), getLoaderManager());
        mFixturesPresenter = new FixturesPresenter(this, mLifecycleHandler);
        mFixturesPresenter.init(savedInstanceState);

    }

    @Override
    public void setFixtures(@NonNull List<Fixture> fixtures) {
        mFixturesAdapter.setData(fixtures);
    }

    @Override
    public void clickFixture(@NonNull Fixture fixture) {
        //TODO
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingView.hideLoadingIndicator();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        Snackbar.make(mRecyclerView, getResources().getString(R.string.loading_error), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        mFixturesPresenter.refresh();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fixtures_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.week:
                mCount = FixturesPresenter.WEEK;
                mFixturesPresenter.showWeekFixtures();
                return true;
            case R.id.month:
                mCount = FixturesPresenter.MONTH;
                mFixturesPresenter.showMonth();
                return true;
            case R.id.half_year:
                mCount = FixturesPresenter.HALF_YAER;
                mFixturesPresenter.showHalfYearFixtures();
                return true;
            case R.id.menu_search:
                SearchActivity.startActivity(getActivity());
                return true;
            default:
                break;
        }

        return false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mFixturesPresenter.saveState(outState);
    }
}
