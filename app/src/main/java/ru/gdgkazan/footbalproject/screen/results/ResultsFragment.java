package ru.gdgkazan.footbalproject.screen.results;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.gdgkazan.footbalproject.R;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class ResultsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_results, null);
            return view;

    }
}
