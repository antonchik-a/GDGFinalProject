package ru.gdgkazan.footbalproject.screen.table;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.screen.main.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by mikes on 24.09.16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTableTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() throws Exception{
        onView(withId(R.id.viewpager)).perform(swipeLeft());
    }

    @Test
    public void testRecyclerViewVisibility() throws Exception {
        onView(withId(R.id.recyclerViewStandings)).check(matches(isDisplayed()));
    }

    @Test
    public void testScroll(){
        onView(withId(R.id.recyclerViewStandings))
                .perform(scrollToPosition(9))
                .perform(scrollToPosition(0))
                .perform(scrollToPosition(7))
                .perform(scrollToPosition(3))
                .perform(scrollToPosition(15))
                .perform(scrollToPosition(9))
                .perform(scrollToPosition(3))
                .perform(scrollToPosition(15))
                .perform(scrollToPosition(20))
                .perform(scrollToPosition(25));
    }

    @Test
    public void testSwipeRefreshLayout() throws Exception {
        onView(withId(R.id.refreshLayout))
                .perform(withCustomConstraints(swipeDown(), isDisplayingAtLeast(45)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testOnClickItem(){
        onView(withId(R.id.recyclerViewStandings))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    }

    private static ViewAction withCustomConstraints(final ViewAction action, final Matcher<View> constraints) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return constraints;
            }

            @Override
            public String getDescription() {
                return action.getDescription();
            }

            @Override
            public void perform(UiController uiController, View view) {
                action.perform(uiController, view);
            }
        };
    }

}
