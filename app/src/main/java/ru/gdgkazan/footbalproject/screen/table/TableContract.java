package ru.gdgkazan.footbalproject.screen.table;

import android.support.annotation.NonNull;

import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Standings;

/**
 * Created by mikes on 21.09.16.
 */

public interface TableContract {

    interface View {

        void showTable(List<Standings> standingsList);

        void showLoadingProgress();

        void hideLoadingProgress();

        void showError();

        void showToastMessage(String message);

    }

    interface Presenter {

        void init();

        void onClickStandings(@NonNull Standings standings);

    }

}