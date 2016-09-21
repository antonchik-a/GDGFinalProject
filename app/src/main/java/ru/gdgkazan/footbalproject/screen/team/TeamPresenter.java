package ru.gdgkazan.footbalproject.screen.team;

import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.repository.RepositoryProvider;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Sergei Riabov
 */
public class TeamPresenter implements TeamContract.UserActionListener {

    private TeamContract.View mView;
    private LifecycleHandler mLifecycleHandler;
    private String mTeamName;

    public TeamPresenter(TeamContract.View mView, LifecycleHandler mLifeCycleHanlder) {
        this.mView = mView;
        this.mLifecycleHandler = mLifeCycleHanlder;
    }

    @Override
    public void init(String teamName) {
        mTeamName = teamName;
        load(false);
    }

    @Override
    public void reload() {
        load(true);
    }

    private void load(boolean isReload) {
        RepositoryProvider.provideFootballRepository()
                .team(mTeamName)
                .doOnSubscribe(() -> mView.showLoadingIndicator())
                .doAfterTerminate(() -> mView.hideLoadingIndicator())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(isReload ? mLifecycleHandler.reload(R.id.team_request) : mLifecycleHandler.load(R.id.team_request))
                .subscribe(team -> {
                            mView.showTeam(team);
                        },
                        throwable -> {
                            mView.showError();
                            throwable.printStackTrace();
                        });
    }

}