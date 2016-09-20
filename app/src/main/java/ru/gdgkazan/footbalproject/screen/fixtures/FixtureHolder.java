package ru.gdgkazan.footbalproject.screen.fixtures;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import ru.gdgkazan.footbalproject.model.content.Fixture;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class FixtureHolder extends RecyclerView.ViewHolder {



    public FixtureHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull Fixture fixture){

    }
}
