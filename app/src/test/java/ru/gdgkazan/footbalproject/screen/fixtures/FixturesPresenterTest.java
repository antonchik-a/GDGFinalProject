package ru.gdgkazan.footbalproject.screen.fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import ru.gdgkazan.footbalproject.screen.team.TeamContract;
import ru.gdgkazan.footbalproject.screen.team.TeamPresenter;
import ru.gdgkazan.footbalproject.test.MockLifecycleHandler;
import ru.gdgkazan.footbalproject.test.TestFootballRepository;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;

/**
 * Created by Alexey Antonchik on 21.09.16.
 */
@RunWith(JUnit4.class)
public class FixturesPresenterTest {

    private FixturesView mView;
    private FixturesPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mView = Mockito.mock(FixturesView.class);
        LifecycleHandler lifecycleHandler = new MockLifecycleHandler();

        mPresenter = new FixturesPresenter(mView, lifecycleHandler);

        RxJavaHooks.setOnIOScheduler(current -> Schedulers.immediate());

        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @Test
    public void testCreated() throws Exception {
        assertNotNull(mPresenter);
    }


    @Test
    public void testSuccess() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.init();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).setFixtures(fixtures);
    }

    @Test
    public void testError() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, fixtures));
        mPresenter.init();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).setFixtures(fixtures);
    }

    @Test
    public void testReload() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.init();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).setFixtures(fixtures);

        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, fixtures));
        mPresenter.refresh();
        Mockito.verify(mView, times(1)).showLoadingIndicator();
        Mockito.verify(mView,  times(2)).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(1)).setFixtures(fixtures);
    }

    @Test
    public void testScenario() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.init(FixturesPresenter.WEEK);
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).setFixtures(fixtures);

        mPresenter.showHalfYearFixtures();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView,  times(2)).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView, times(2)).setFixtures(fixtures);

        mPresenter.showWeekFixtures();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView,  times(3)).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView, times(3)).setFixtures(fixtures);

        mPresenter.showMonth();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView,  times(4)).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView, times(4)).setFixtures(fixtures);

        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, fixtures));
        mPresenter.refresh();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView,  times(5)).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(4)).setFixtures(fixtures);
    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
        RxJavaHooks.reset();
    }
}
