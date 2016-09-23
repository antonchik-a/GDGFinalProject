package ru.gdgkazan.footbalproject.screen.search;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.api.MockingInterceptor;
import ru.gdgkazan.footbalproject.model.content.Fixture;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author Sergei Riabov 2016
 */
@RunWith(AndroidJUnit4.class)
public class SearchActivityErrorTest {

    @Rule
    public final ActivityTestRule<SearchActivity> mActivityTestRule
            = new ActivityTestRule<>(SearchActivity.class);

    @Before
    public void setUp() throws Exception {
        MockingInterceptor.shouldIntercept = true;
        Realm.getDefaultInstance().executeTransaction(realm -> realm.delete(Fixture.class));
    }

    @After
    public void tearDown() throws Exception {
        MockingInterceptor.shouldIntercept = false;
    }

    @Test
    public void testQueryError() throws Exception {
        onView(withId(R.id.search_query))
                .perform(typeText(SearchActivityTest.NORMAL_QUERY));
        SystemClock.sleep(3000);
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.search_empty)))
                .check(matches(isDisplayed()));
        MockingInterceptor.shouldIntercept = false;
    }
}
