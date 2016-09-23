package ru.gdgkazan.footbalproject.screen.search;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.gdgkazan.footbalproject.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author Sergei Riabov 2016
 */
@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {
    private static final String NORMAL_QUERY = "United";
    private static final String NO_DATA_QUERY = "34234";


    @Rule
    public final ActivityTestRule<SearchActivity> mActivityTestRule
            = new ActivityTestRule<>(SearchActivity.class);


    @Test
    public void testNoDataQuery() throws Exception {
        onView(withId(R.id.search_query))
                .perform(typeText(NO_DATA_QUERY));
        SystemClock.sleep(3000);
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.search_empty)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testNormalQuery() throws Exception {
        onView(withId(R.id.search_query))
                .perform(typeText(NORMAL_QUERY));
        SystemClock.sleep(3000);
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void testUpButton() throws Exception {
        onView(withContentDescription(R.string.abc_action_bar_up_description))
                .perform(click());
    }
}
