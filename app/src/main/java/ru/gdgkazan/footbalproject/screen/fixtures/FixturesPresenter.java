package ru.gdgkazan.footbalproject.screen.fixtures;

import android.support.annotation.NonNull;

import java.util.Calendar;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class FixturesPresenter {

    final static  int RELEVANCE_DAYS = -20;
    final static  int MAX_COUNT = 50;
    private FixturesView mView;
    private LifecycleHandler mLifecycleHandler;


    public FixturesPresenter(@NonNull FixturesView fixturesView,@NonNull LifecycleHandler lifecycleHandler) {
        mView = fixturesView;
        mLifecycleHandler = lifecycleHandler;
    }

    public  void init(){
        load(false);
    }

    public void refresh(){
        load(true);
    }

    private void load(boolean force){
        RepositoryProvider.provideFootballRepository()
                .fixtures()
                .flatMap(Observable::from)
                .filter(fixture -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, RELEVANCE_DAYS);

                    return fixture.getDate().after(calendar.getTime());
                })
                .toList()
                .take(MAX_COUNT)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> {
                    if(!force) mView.showLoadingIndicator();
                })
                .doAfterTerminate(() ->  mView.hideLoadingIndicator())
                .compose(force ?mLifecycleHandler.reload(R.id.fixtures_request) : mLifecycleHandler.load(R.id.fixtures_request))
                .subscribe(fixtures -> {
                            mView.setFixtures(fixtures);
                        },
                        throwable -> {
                            mView.showError();
                            throwable.printStackTrace();
                        });
    }

}
