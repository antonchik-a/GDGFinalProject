package ru.gdgkazan.footbalproject.screen.search;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.screen.fixtures.FixturesPresenter;
import ru.gdgkazan.footbalproject.screen.fixtures.FixturesView;
import ru.gdgkazan.footbalproject.test.MockLifecycleHandler;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey Antonchik on 23.09.16.
 */

@RunWith(JUnit4.class)
public class SearchPresenterTest {


    private SearchView mView;
    private SearchPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mView = Mockito.mock(SearchView.class);
        LifecycleHandler lifecycleHandler = new MockLifecycleHandler();

        mPresenter = new SearchPresenter(mView, lifecycleHandler);

        RxJavaHooks.setOnIOScheduler(current -> Schedulers.immediate());

        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }




    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
        RxJavaHooks.reset();
    }

}
