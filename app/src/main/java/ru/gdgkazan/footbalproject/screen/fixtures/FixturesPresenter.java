package ru.gdgkazan.footbalproject.screen.fixtures;

import android.support.annotation.NonNull;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class FixturesPresenter {

    private FixturesView mView;
    private LifecycleHandler mLifecycleHandler;


    public FixturesPresenter(@NonNull FixturesView fixturesView,@NonNull LifecycleHandler lifecycleHandler) {
        mView = fixturesView;
        mLifecycleHandler = lifecycleHandler;
    }

    public  void init(){

        RepositoryProvider.provideFootballRepository()
                .fixtures()
                .doOnSubscribe(() -> mView.showLoadingIndicator())
                .doAfterTerminate(() -> mView.hideLoadingIndicator())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(fixtures -> {
                            mView.setFixtures(fixtures);
                        },
                        throwable -> {
                            mView.showError();
                            throwable.printStackTrace();
                        });

    }
}
