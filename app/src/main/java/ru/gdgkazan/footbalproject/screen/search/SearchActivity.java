package ru.gdgkazan.footbalproject.screen.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.screen.fixtures.FixturesAdapter;
import ru.gdgkazan.footbalproject.utils.RxEditText;
import ru.gdgkazan.footbalproject.widget.DividerItemDecoration;

/**
 * Created by Alexey Antonchik on 23.09.16.
 */

public class SearchActivity extends AppCompatActivity implements SearchView {


    public final static int DEBOUNCE = 1000;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    @BindView(R.id.search_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recyclerView)
    RecyclerView mSearchRecyclerView;

    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    @BindView(R.id.search_query)
    RxEditText mQueryEdit;

    private SearchPresenter mPresenter;
    private FixturesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mAdapter = new FixturesAdapter();
        mSearchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSearchRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mSearchRecyclerView.setAdapter(mAdapter);
        mSearchRecyclerView.setVisibility(View.INVISIBLE);

        mQueryEdit.setOnRxTextChangeListener(new RxEditText.RxEditTextChangeListener() {
            @Override
            public void onTextChanged(String text) {
                mPresenter.onQueryChanged(text);
            }
        }, DEBOUNCE);
        mQueryEdit.requestFocus();

        LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new SearchPresenter(this, lifecycleHandler);
    }

    @Override
    public void showSearchData(List<Fixture> list) {
        mAdapter.setData(list);
        SearchAnimator.fade(mSearchRecyclerView, SearchAnimator.Action.FADEIN).start();
    }


    @Override
    public void clearSearchResult() {
        SearchAnimator.fade(mSearchRecyclerView, SearchAnimator.Action.FADEOUT).start();
    }

    @Override
    public void showError() {
        Snackbar.make(mSearchRecyclerView, getResources().getString(R.string.search_empty), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setQuery(String query) {
        mQueryEdit.setText(query);
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mQueryEdit.getWindowToken(), 0);
    }

    @Override
    public void showKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mQueryEdit, 0);
    }

    @Override
    public void showLoadingIndicator() {
        mProgressBar.setVisibility(View.VISIBLE);
        mSearchRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoadingIndicator() {
        mProgressBar.setVisibility(View.GONE);
        mSearchRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
