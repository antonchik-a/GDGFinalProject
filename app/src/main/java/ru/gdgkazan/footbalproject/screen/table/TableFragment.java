package ru.gdgkazan.footbalproject.screen.table;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Standings;
import ru.gdgkazan.footbalproject.utils.Dialog;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class TableFragment extends Fragment implements TableContract.View {

    private TablePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, null);

        LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(getActivity(), getLoaderManager());
        mPresenter = new TablePresenter(this, lifecycleHandler);
        mPresenter.init();

        return view;
    }

    @Override
    public void showTable(List<Standings> standingsList) {
        //TODO: show data in recycler view
    }

    @Override
    public void showLoadingProgress() {
        //TODO: show loading progress
    }

    @Override
    public void hideLoadingProgress() {
        //TODO: hide loading progress
    }

    @Override
    public void showError() {
        Dialog.showWithPositiveButton(
                getActivity(),
                getString(R.string.error),
                getString(R.string.error_please_try_again_refresh_your_table),
                getString(R.string.ok));
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
