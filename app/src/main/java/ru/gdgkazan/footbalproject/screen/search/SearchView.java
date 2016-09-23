package ru.gdgkazan.footbalproject.screen.search;

import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;

/**
 * Created by Alexey Antonchik on 23.09.16.
 */

public interface SearchView extends LoadingView {

    void showSearchData(List<Fixture> list);

    void clearSearchResult();

    void notFound();

    void showError();

    void setQuery(String query);

    void hideKeyboard();

    void showKeyboard();
}
