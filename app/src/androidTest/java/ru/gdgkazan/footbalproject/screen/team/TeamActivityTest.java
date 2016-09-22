package ru.gdgkazan.footbalproject.screen.team;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.gdgkazan.footbalproject.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author Sergei Riabov 2016
 */

@RunWith(AndroidJUnit4.class)
public class TeamActivityTest {
    private static final String CORRECT_TEAM_NAME = "Chelsea FC";
    private static final String INCORRECT_TEAM_NAME = "Not found";


    @Rule
    public final ActivityTestRule<TeamActivity> mActivityTestRule
            = new ActivityTestRule<>(TeamActivity.class, false, false);

    @Test
    public void testRecyclerViewVisibility() throws Exception {
        launchActivityWithTeamName(CORRECT_TEAM_NAME);
        onView(withId(R.id.players_recyclerview)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerViewScrolling() throws Exception {
        launchActivityWithTeamName(CORRECT_TEAM_NAME);
        onView(withId(R.id.players_recyclerview))
                .perform(scrollToPosition(9))
                .perform(scrollToPosition(0))
                .perform(scrollToPosition(7))
                .perform(scrollToPosition(3))
                .perform(scrollToPosition(10));
    }

    @Test
    public void testDataError() throws Exception {
        launchActivityWithTeamName(INCORRECT_TEAM_NAME);

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.loading_error)))
                .check(matches(isDisplayed()));
    }

    private void launchActivityWithTeamName(String teamName) {
        Context context = InstrumentationRegistry.getContext();
        Intent intent = new Intent(context, TeamActivity.class);
        intent.putExtra(TeamActivity.EXTRA_TEAM, teamName);
        mActivityTestRule.launchActivity(intent);
    }
}


