package ru.gdgkazan.footbalproject.screen.team;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import ru.gdgkazan.footbalproject.test.MockLifecycleHandler;
import ru.gdgkazan.footbalproject.test.TestFootballRepository;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;

/**
 * @author Sergei Riabov
 */

public class TeamPresenterTest {
    private TeamContract.View mView;
    private TeamPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mView = Mockito.mock(TeamContract.View.class);
        LifecycleHandler lifecycleHandler = new MockLifecycleHandler();

        mPresenter = new TeamPresenter(mView, lifecycleHandler);

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
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false));
        mPresenter.init("");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTeam(anyObject());
    }

    @Test
    public void testError() throws Exception {
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true));
        mPresenter.init("");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTeam(anyObject());
    }

    @Test
    public void testReload() throws Exception {
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true));
        mPresenter.init("");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTeam(anyObject());

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false));
        mPresenter.reload();
        Mockito.verify(mView, times(2)).showLoadingIndicator();
        Mockito.verify(mView, times(2)).hideLoadingIndicator();
        Mockito.verify(mView, times(1)).showError();
        Mockito.verify(mView, times(1)).showTeam(anyObject());
    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
        RxJavaHooks.reset();
    }
}
