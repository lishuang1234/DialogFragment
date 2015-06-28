package com.ls.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.dialogfragmentdemo.R;

/**
 * Created by ls on 15-6-28.
 */
public class EditNameDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // getDialog().requestWindowFeature(STYLE_NO_TITLE);//取消标题栏
        View view = inflater.inflate(R.layout.fragment_edit_name, container);
        return view;
    }
}
