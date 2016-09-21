package ru.gdgkazan.footbalproject.repository;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import io.realm.Realm;
import ru.gdgkazan.footbalproject.api.MockingInterceptor;
import ru.gdgkazan.footbalproject.model.content.Player;
import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.test.RxSchedulersTestRule;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Sergei Riabov 2016
 */

@RunWith(AndroidJUnit4.class)
public class FootballRepositoryTest {
    private FootballRepository mRepository;

    @Rule
    public RxSchedulersTestRule mRule = new RxSchedulersTestRule();


    @Before
    public void setUp() throws Exception {
        mRepository = new DefaulFootballRepository();
    }

    @Test
    public void testWrongTeamName() throws Exception {
        TestSubscriber<Team> testSubscriber = new TestSubscriber<>();
        mRepository.team("").subscribe(testSubscriber);
        testSubscriber.assertError(NoSuchElementException.class);
    }

    @Test
    public void testGoodTeamName() throws Exception {
        String teamName = "Chelsea FC";

        Team team = mRepository.team("Chelsea FC").toBlocking().first();
        assertEquals(teamName, team.getName());
        assertNotNull(team.getPlayers().get(0).getName());
    }

    @Test
    public void testTeamsSaved() throws Exception {
        String teamName = "Chelsea FC";

        mRepository.team(teamName).subscribe();

        int savedCount = Realm.getDefaultInstance()
                .where(Team.class)
                .findAll()
                .size();
        Assert.assertEquals(20, savedCount);
    }

    @Test
    public void testErrorWithoutCache() throws Exception {
        MockingInterceptor.shouldIntercept = true;
        String teamName = "Chelsea FC";

        TestSubscriber<Team> teamSubscriber = new TestSubscriber<>();
        mRepository.team(teamName).subscribe(teamSubscriber);
        teamSubscriber.assertError(Exception.class);
    }

    @Test
    public void testDataFromCache() throws Exception {
        String teamName = "Chelsea FC";
        mRepository.team(teamName).subscribe();

        MockingInterceptor.shouldIntercept = true;

        TestSubscriber<Team> teamSubscriber = new TestSubscriber<>();
        mRepository.team(teamName).subscribe(teamSubscriber);

        teamSubscriber.assertNoErrors();
        teamSubscriber.assertValueCount(1);
    }

    @After
    public void tearDown() throws Exception {
        MockingInterceptor.shouldIntercept = false;
        Realm.getDefaultInstance().executeTransaction(realm -> realm.delete(Team.class));
        Realm.getDefaultInstance().executeTransaction(realm -> realm.delete(Player.class));
    }
}
