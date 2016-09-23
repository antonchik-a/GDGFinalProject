package ru.gdgkazan.footbalproject.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.screen.search.SearchPresenter;
import ru.gdgkazan.footbalproject.screen.search.SearchView;
import ru.gdgkazan.footbalproject.test.MockLifecycleHandler;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by Alexey Antonchik on 23.09.16.
 */
@RunWith(JUnit4.class)
public class FixtureSearchTest {

    private Fixture mFixtureWithResult;
    private Fixture mFixtureWithoutResult;

    @Before
    public void setUp() throws Exception {
        mFixtureWithoutResult = Fixture.getFixtureWithoutResult();
        mFixtureWithResult = Fixture.getFixtureWithResult();
    }

    @Test
    public void testCreated() throws Exception {
        assertNotNull(mFixtureWithoutResult);
        assertNull(mFixtureWithoutResult.getResult());
        assertNotNull(mFixtureWithResult);
        assertNotNull(mFixtureWithResult.getResult());

    }

    @Test
    public void testFilterByTeamName() throws Exception {
        assertEquals(true, mFixtureWithResult.hasQueryData("chelsea"));
        assertEquals(false, mFixtureWithResult.hasQueryData("manchester"));
    }

    @Test
    public void testFilterByGoals() throws Exception {
        assertEquals(true, mFixtureWithResult.hasQueryData("2"));
        assertEquals(false, mFixtureWithResult.hasQueryData("1"));
        assertEquals(false, mFixtureWithResult.hasQueryData("123"));
    }

    @After
    public void tearDown() throws Exception {
        mFixtureWithoutResult = null;
        mFixtureWithResult = null;
    }
}
