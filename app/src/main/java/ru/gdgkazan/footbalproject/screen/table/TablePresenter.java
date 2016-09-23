package ru.gdgkazan.footbalproject.screen.table;

import android.support.annotation.NonNull;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mikes on 21.09.16.
 */

public class TablePresenter implements TableContract.Presenter {

    private final TableContract.View mView;
    private final LifecycleHandler mLifeCycleHandler;

    public TablePresenter(@NonNull TableContract.View view, @NonNull LifecycleHandler lifecycleHandler){
        mView = view;
        mLifeCycleHandler = lifecycleHandler;
    }

    @Override
    public void load() {
        getData(false);
    }

    @Override
    public void reload() {
        getData(true);
    }

    @Override
    public void onClickSortByPointsFromAToZ() {
        mView.showToastMessage("points from a to z");
    }

    @Override
    public void onClickSortByPointsFromZToA() {
        mView.showToastMessage("points from z to a");
    }

    @Override
    public void onClickSortByScoredGoalsFromAToZ() {
        mView.showToastMessage("scored goals from a to z");
    }

    @Override
    public void onClickSortByScoredGoalsFromZToA() {
        mView.showToastMessage("scored goals from z to a");
    }

    @Override
    public void onClickSortByAgainstGoalsFromAToZ() {
        mView.showToastMessage("against goals from a to z");
    }

    @Override
    public void onClickSortByAgainstGoalsFromZToA() {
        mView.showToastMessage("against goals from z to a");
    }

    public void getData(boolean isReload) {
        RepositoryProvider.provideFootballRepository().standingsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> {
                    if (!isReload) mView.showLoadingIndicator();
                })
                .doOnTerminate(isReload ? mView::hideSwipeRefreshing
                                        : mView::hideLoadingIndicator)
                .compose(isReload ? mLifeCycleHandler.reload(R.id.standings_list_request)
                                  : mLifeCycleHandler.load(R.id.standings_list_request))
                .subscribe(mView::showTable, throwable -> mView.showError());
    }

}
