package ru.gdgkazan.footbalproject.screen.team;

import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.screen.loading.LoadingView;

/**
 * Created by Sergei Riabov
 */
public interface TeamContract {
    interface View extends LoadingView {
        void showTeam(Team team);
        void showError();
    }

    interface UserActionListener {
        void init(String teamName);
        void reload();
    }
}
