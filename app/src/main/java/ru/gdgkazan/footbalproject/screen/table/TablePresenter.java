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
    public void init() {
        RepositoryProvider.provideFootballRepository().standingsList()
                .doOnSubscribe(mView::showLoadingIndicator)
                .doOnTerminate(mView::hideLoadingIndicator)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mLifeCycleHandler.load(R.id.standings_list_request))
                .subscribe(mView::showTable, throwable -> mView.showError());
    }

    @Override
    public void onClickStandings(@NonNull Standings standings) {
        mView.showToastMessage("TODO: some action by clicking on item");
    }

}
