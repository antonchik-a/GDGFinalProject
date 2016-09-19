package ru.gdgkazan.footbalproject.screen.fixtures;

import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public interface FixturesView extends LoadingView {

    void setFixtures(List<Fixture> fixtures);

    void clickFixture(Fixture fixture);

    void showError();

}
