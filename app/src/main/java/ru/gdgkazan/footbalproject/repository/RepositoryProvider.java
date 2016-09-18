package ru.gdgkazan.footbalproject.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/**
 * Created by Alexey Antonchik on 17.09.16.
 */
public final class RepositoryProvider {

    private static FootballRepository sFootballRepository;

    private RepositoryProvider() {
    }

    @NonNull
    public static FootballRepository provideFootballRepository() {
        if (sFootballRepository == null) {
            sFootballRepository = new DefaulFootballRepository();
        }
        return sFootballRepository;
    }

    public static void setFootballRepository(FootballRepository footballRepository) {
        sFootballRepository = footballRepository;
    }

    @MainThread
    public static void init() {
        sFootballRepository = new DefaulFootballRepository();
    }

}

