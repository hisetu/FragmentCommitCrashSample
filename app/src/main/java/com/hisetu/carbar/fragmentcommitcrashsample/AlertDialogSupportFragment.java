package com.hisetu.carbar.fragmentcommitcrashsample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class AlertDialogSupportFragment extends DialogFragment {
    private int title;
    private View.OnClickListener clickListener;
    private int message;

    public static AlertDialogSupportFragment newInstance(@StringRes int title, @StringRes int message) {
        return newInstance(title, message, null);
    }

    public static AlertDialogSupportFragment newInstance(@StringRes int title, @StringRes int message, View.OnClickListener listener) {
        AlertDialogSupportFragment fragment = new AlertDialogSupportFragment();
        fragment.title = title;
        fragment.message = message;
        fragment.clickListener = listener;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new android.app.AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (clickListener != null)
                            clickListener.onClick(null);
                    }
                })
                .create();
    }
}
