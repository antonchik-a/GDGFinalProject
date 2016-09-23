package ru.gdgkazan.footbalproject.screen.table;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.model.content.Standings;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import ru.gdgkazan.footbalproject.test.MockLifecycleHandler;
import ru.gdgkazan.footbalproject.test.TestFootballRepository;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.times;

/**
 * Created by mikes on 23.09.16.
 */

@RunWith(JUnit4.class)
public class TablePresenterTest {

    private TableContract.View mView;
    private TablePresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mView = Mockito.mock(TableContract.View.class);
        LifecycleHandler lifecycleHandler = new MockLifecycleHandler();

        mPresenter = new TablePresenter(mView, lifecycleHandler);

        RxJavaHooks.setOnIOScheduler(current -> Schedulers.immediate());

        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @Test
    public void testCreated() throws Exception{
        Assert.assertNotNull(mPresenter);
    }

    @Test
    public void testLoadSuccess() throws Exception {
        List<Standings> standings = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standings));
        mPresenter.load();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standings);
    }

    @Test
    public void testLoadError() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, standingsList));
        mPresenter.load();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);
    }

    @Test
    public void testLoadSuccessThenReloadSuccess() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standingsList));
        mPresenter.load();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standingsList);

        mPresenter.reload();
        Mockito.verify(mView, times(1)).showLoadingIndicator();
        Mockito.verify(mView, times(1)).hideLoadingIndicator();
        Mockito.verify(mView).hideSwipeRefreshing();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView, times(2)).showTable(standingsList);
    }

    @Test
    public void testLoadErrorThenReloadError() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, standingsList));
        mPresenter.load();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);

        mPresenter.reload();
        Mockito.verify(mView, times(1)).showLoadingIndicator();
        Mockito.verify(mView, times(1)).hideLoadingIndicator();
        Mockito.verify(mView).hideSwipeRefreshing();
        Mockito.verify(mView, times(2)).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);
    }

    @Test
    public void testReloadSuccess() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standingsList));
        mPresenter.reload();
        Mockito.verify(mView, times(0)).showLoadingIndicator();
        Mockito.verify(mView, times(0)).hideLoadingIndicator();
        Mockito.verify(mView).hideSwipeRefreshing();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standingsList);
    }

    @Test
    public void testReloadError() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, standingsList));
        mPresenter.reload();
        Mockito.verify(mView, times(0)).showLoadingIndicator();
        Mockito.verify(mView, times(0)).hideLoadingIndicator();
        Mockito.verify(mView).hideSwipeRefreshing();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);
    }

    @Test
    public void onClickSortByPointsFromAToZ() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standingsList));
        mPresenter.onClickSortByPointsFromAToZ();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standingsList);
    }

    @Test
    public void onClickSortByPointsFromAToZSecondType() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standingsList));
        mPresenter.onClickSortByPointsFromAToZ();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standingsList);
    }

    @Test
    public void onClickSortByPointsFromZToA() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standingsList));
        mPresenter.onClickSortByPointsFromZToA();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standingsList);
    }

    @Test
    public void onClickSortByScoredGoalsFromAToZ() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        Standings standings1 = new Standings();
        standings1.setGoals(2);
        Standings standings2 = new Standings();
        standings1.setGoals(3);
        Standings standings3 = new Standings();
        standings1.setGoals(1);
        standingsList.add(standings1);
        standingsList.add(standings2);
        standingsList.add(standings3);



        RepositoryProvider.setFootballRepository(new TestFootballRepository(false, standingsList));
        mPresenter.onClickSortByScoredGoalsFromAToZ();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView).showTable(standingsList);
    }

    @Test
    public void onClickSortByScoredGoalsFromZToA() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, standingsList));
        mPresenter.onClickSortByScoredGoalsFromZToA();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);
    }

    @Test
    public void onClickSortByAgainstGoalsFromAToZ() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, standingsList));
        mPresenter.onClickSortByAgainstGoalsFromAToZ();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView, times(0)).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);
    }

    @Test
    public void onClickSortByAgainstGoalsFromZToA() throws Exception {
        List<Standings> standingsList = new ArrayList<>();
        RepositoryProvider.setFootballRepository(new TestFootballRepository(true, standingsList));
        mPresenter.onClickSortByAgainstGoalsFromZToA();
        Mockito.verify(mView).showLoadingIndicator();
        Mockito.verify(mView).hideLoadingIndicator();
        Mockito.verify(mView).showError();
        Mockito.verify(mView, times(0)).showTable(standingsList);
    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
        RxJavaHooks.reset();
    }

}
