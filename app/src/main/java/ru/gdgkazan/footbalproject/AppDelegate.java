package ru.gdgkazan.footbalproject;

/**
 * Created by Alexey Antonchik on 17.09.16.
 */
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;
import ru.gdgkazan.footbalproject.api.ApiFactory;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;

/**
 * @author Artur Vasilov
 */
public class AppDelegate extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))
                .setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE)
                .build();

        ApiFactory.recreate();
    }

    @NonNull
    public static Context getContext() {
        return sContext;
    }
}
