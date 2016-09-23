package ru.gdgkazan.footbalproject.screen.fixtures;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.screen.main.MainActivity;
import ru.gdgkazan.footbalproject.screen.team.TeamActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static ru.gdgkazan.footbalproject.action.Actions.waitId;

/**
 * Created by Alexey Antonchik on 23.09.16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityFixturesTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<>(MainActivity.class, false, false);

    @Test
    public void testRecyclerViewVisibility() throws Exception {
        launchActivity();
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerViewScrolling() throws Exception {
        launchActivity();
        onView(isRoot()).perform(waitId(R.id.recyclerView, 4000));
        onView(withId(R.id.recyclerView))
                .perform(scrollToPosition(0))
                .perform(scrollToPosition(3))
                .perform(scrollToPosition(10))
                .perform(swipeDown());
    }

    private void launchActivity() {
        Context context = InstrumentationRegistry.getContext();
        Intent intent = new Intent(context, MainActivity.class);
        mActivityTestRule.launchActivity(intent);
    }


}
