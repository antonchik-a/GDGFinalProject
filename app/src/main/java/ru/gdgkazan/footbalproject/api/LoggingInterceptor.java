package ru.gdgkazan.footbalproject.api;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.gdgkazan.footbalproject.BuildConfig;

/**
 * Created by Alexey Antonchik on 17.09.16.
 */
public final class LoggingInterceptor implements Interceptor {

    private final Interceptor mLoggingInterceptor;

    private LoggingInterceptor() {
        mLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    @NonNull
    public static Interceptor create() {
        return new LoggingInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return mLoggingInterceptor.intercept(chain);
    }

}
