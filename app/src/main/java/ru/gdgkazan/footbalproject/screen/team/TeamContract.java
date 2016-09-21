package ru.gdgkazan.footbalproject.screen.team;

import android.support.annotation.NonNull;

import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;

/**
 * Created by Sergei Riabov
 */
public interface TeamContract {

    interface View extends LoadingView {

        void showTeam(@NonNull Team team);

        void showError();

    }

    interface UserActionListener {

        void init(@NonNull String teamName);

        void reload();

    }
}
