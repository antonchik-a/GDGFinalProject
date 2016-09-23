package ru.gdgkazan.footbalproject.screen.search;

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
import ru.gdgkazan.footbalproject.screen.fixtures.FixturesPresenter;
import ru.gdgkazan.footbalproject.screen.fixtures.FixturesView;
import ru.gdgkazan.footbalproject.test.MockLifecycleHandler;
import ru.gdgkazan.footbalproject.test.TestFootballRepository;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.times;

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

    @Test
    public void testCreated() throws Exception {
        assertNotNull(mPresenter);
        assertNotNull(mView);
    }

    @Test
    public void testQuerySearch() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.onQueryChanged("test");
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showSearchData(fixtures);
    }

    @Test
    public void testEmptyQuerySearch() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.onQueryChanged("");
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).clearSearchResult();
    }

    @Test
    public void testSuccessEmpty() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.onQueryChanged("test");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showSearchData(fixtures);
        Mockito.verify(mView).showError();
    }

    @Test
    public void testHideKeyboard() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.onQueryChanged("test");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showError();
        Mockito.verify(mView).showSearchData(fixtures);
        Mockito.verify(mView, times(0)).hideKeyboard();
    }

    @Test
    public void testKeyboardNoHiddenAfterEmptySearch() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        fixtures.add(Fixture.getFixtureWithResult());

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.onQueryChanged("chelsea");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showSearchData(fixtures);
        Mockito.verify(mView,times(0)).showError();
        Mockito.verify(mView).hideKeyboard();
    }


    @Test
    public void testQueryChaged() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, fixtures));
        mPresenter.onQueryChanged("test");
        Mockito.verify(mView, times(0)).clearSearchResult();

        mPresenter.onQueryChanged("");
        Mockito.verify(mView).clearSearchResult();

    }


    @Test
    public void testError() throws Exception {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, fixtures));
        mPresenter.onQueryChanged("123");
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showSearchData(fixtures);
    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
        RxJavaHooks.reset();
    }

}
