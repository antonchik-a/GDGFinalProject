package ru.gdgkazan.footbalproject.utils;

import android.content.Context;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by mikes on 21.09.16.
 */

public class Dialog {

    public static void showWithPositiveButton(Context context, String title, String message, String buttonText){
        MaterialDialog materialDialog = new MaterialDialog(context);
        materialDialog.setTitle(title);
        materialDialog.setMessage(message);
        materialDialog.setPositiveButton(buttonText, view -> materialDialog.dismiss());
        materialDialog.show();
    }

}
