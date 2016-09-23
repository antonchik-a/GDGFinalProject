package ru.gdgkazan.footbalproject.screen.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.List;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey Antonchik on 23.09.16.
 */

public class SearchPresenter {

    public static String QUERY_KEY = "query_key";

    private LifecycleHandler mLifecycleHandler;
    private SearchView mView;
    private String mQuery;

    public SearchPresenter(@NonNull SearchView searchView, @NonNull LifecycleHandler lifecycleHandler) {
        mLifecycleHandler = lifecycleHandler;
        mView = searchView;
        mQuery = "";
    }

    public void searchFixtures(String query) {
        RepositoryProvider.provideFootballRepository()
                .fixtures()
                .compose(mLifecycleHandler.load(R.id.fixtures_request))
                .flatMap(Observable::from)
                .filter(fixture -> fixture.hasQueryData(query))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> {
                    mView.showLoadingIndicator();
                })
                .doAfterTerminate(() -> mView.hideLoadingIndicator())
                .subscribe(fixtures -> {
                            showData(fixtures);
                        },
                        throwable -> {
                            mView.showError();
                            throwable.printStackTrace();
                        });
    }

    public void onQueryChanged(String text) {
        mQuery = text.toLowerCase().trim();

        if (mQuery.length() == 0) {
            mView.clearSearchResult();
        } else {
            searchFixtures(mQuery);
        }
    }

    private void showData(List<Fixture> fixtures) {
        if (fixtures.size() == 0) {
            mView.notFound();
        } else {
            mView.hideKeyboard();
        }

        mView.showSearchData(fixtures);
    }
}
