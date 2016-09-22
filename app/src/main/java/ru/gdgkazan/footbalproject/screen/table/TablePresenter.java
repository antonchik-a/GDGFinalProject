package ru.gdgkazan.footbalproject.screen.table;

import android.support.annotation.NonNull;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Standings;
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
    public void onClickStandings(@NonNull Standings standings) {
        mView.showToastMessage("TODO: some action by clicking on item");
    }

    public void getData(boolean isReload) {
        RepositoryProvider.provideFootballRepository().standingsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> {
                    if (!isReload) mView.showLoadingIndicator();
                })
                .doOnTerminate(mView::hideLoadingIndicator)
                .compose(isReload ? mLifeCycleHandler.reload(R.id.standings_list_request)
                                  : mLifeCycleHandler.load(R.id.standings_list_request))
                .subscribe(mView::showTable, throwable -> mView.showError());
    }

}
