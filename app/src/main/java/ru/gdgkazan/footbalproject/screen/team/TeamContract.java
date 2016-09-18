package ru.gdgkazan.footbalproject.screen.team;

import ru.gdgkazan.footbalproject.model.content.Team;

/**
 * Created by Sergei Riabov
 */
public interface TeamContract {
    interface View {
        void showTeam(Team team);
    }

    interface UserActionListener {
        void init(String teamName);
    }
}
