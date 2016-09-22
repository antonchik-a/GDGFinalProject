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


    public static int WEEK = -7;
    public static int MONTH = -30;
    public static int HALF_YAER = -182;
    private int mCount = MONTH;
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

    public  void init(int count){
        mCount = count;
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
                    calendar.add(Calendar.DAY_OF_YEAR, mCount);

                    return fixture.getDate().after(calendar.getTime());
                })
                .take(MAX_COUNT)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> {
                    if(!force) mView.showLoadingIndicator();
                })
                .doAfterTerminate(() ->  mView.hideLoadingIndicator())
                .compose(force ? mLifecycleHandler.reload(R.id.fixtures_request) : mLifecycleHandler.load(R.id.fixtures_request))
                .subscribe(fixtures -> {
                            mView.setFixtures(fixtures);
                        },
                        throwable -> {
                            mView.showError();
                            throwable.printStackTrace();
                        });
    }

    public void showWeekFixtures(){
        mCount = WEEK;
        load(true);
    }

    public void showMonth(){
        mCount = MONTH;
        load(true);
    }

    public void showHalfYearFixtures(){
        mCount = HALF_YAER;
        load(true);
    }

}
