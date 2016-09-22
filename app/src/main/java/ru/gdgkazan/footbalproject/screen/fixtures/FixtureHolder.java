package ru.gdgkazan.footbalproject.screen.fixtures;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gdgkazan.footbalproject.R;
import ru.gdgkazan.footbalproject.model.content.Fixture;

/**
 * Created by Alexey Antonchik on 18.09.16.
 */
public class FixtureHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.awayTitle)
    TextView mAwayText;
    @BindView(R.id.homeTitle)
    TextView mHomeText;
    @BindView(R.id.result)
    TextView mResultText;
    @BindView(R.id.time)
    TextView mTimeText;


    public FixtureHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull Fixture fixture){

        mAwayText.setText(fixture.getAwayTeamName());
        mHomeText.setText(fixture.getHomeTeamName());

        if(fixture.getResult() != null && fixture.getResult().getGoalsHomeTeam() != null && fixture.getResult().getGoalsAwayTeam() != null) {
            mResultText.setText(fixture.getResult().toString());
            mResultText.setTextColor(mResultText.getContext().getResources().getColor(R.color.textPrimary));
        }else {
            mResultText.setText("0 : 0");
            mResultText.setAlpha(0.54f);
            mResultText.setTextColor(mResultText.getContext().getResources().getColor(R.color.textSecondary));
        }

        if(Calendar.getInstance().getTime().after(fixture.getDate())){
            mTimeText.setText(mTimeText.getContext().getResources().getString(R.string.fixture_end));
        }else {
            mTimeText.setText(getStringDate(fixture.getDate()));
        }
    }

    @NonNull
    public String getStringDate(@NonNull Date date){
        String result = "";
        try {
            String dateFormatString = "dd.MM.yyyy";
            SimpleDateFormat df = new SimpleDateFormat(dateFormatString);
            result = df.format(date);
        }catch (Exception ex) {

        }
        return result;
    }
}
