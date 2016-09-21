package ru.gdgkazan.footbalproject.screen.table;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Standings;
import ru.gdgkazan.footbalproject.screen.table.adapter.StandingsAdapter;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class TableFragment extends Fragment implements TableContract.View, StandingsAdapter.OnItemClick {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, null);
        return view;
    }

    @Override
    public void showTable(List<Standings> standingsList) {
        //TODO: show table in recycler view
    }

    @Override
    public void showError() {
        //TODO: show error
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(@NonNull Standings standing) {
        Toast.makeText(getActivity(), "Pressed on standings!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator() {
        //TODO: show loading indicator
    }

    @Override
    public void hideLoadingIndicator() {
        //TODO: hide loading indicator
    }
}
