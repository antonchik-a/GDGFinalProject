package ru.gdgkazan.footbalproject.api;

import android.os.SystemClock;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Sergei Riabov
 */
public class MockingInterceptor implements Interceptor {

    public static volatile boolean shouldIntercept = false;

    @NonNull
    public static Interceptor create() {
        return new MockingInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (shouldIntercept) {
            return error(request, 500, "Incorrectly intercepted request");
        }
        return chain.proceed(request);
    }

    private Response error(@NonNull Request request, int code, @NonNull String message) {
        return new Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(code)
                .message(message)
                .build();
    }
}

