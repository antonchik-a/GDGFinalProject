package ru.gdgkazan.footbalproject.screen.team;

import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Sergei Riabov
 */
public class TeamPresenter implements TeamContract.UserActionListener {

    private TeamContract.View mView;

    public TeamPresenter(TeamContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void init(String teamName) {

        RepositoryProvider.provideFootballRepository()
                .team(teamName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(team -> {
                    mView.showTeam(team);
                },
                        throwable -> {
                            mView.showError();
                            throwable.printStackTrace();
                        });
    }

}
