package com.ls.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ls.dialogfragmentdemo.R;

/**
 * Created by ls on 15-6-28.
 */
public class LoginDialogFragment extends DialogFragment {


    private EditText mUsername;
    private EditText mPassword;

    public void setLoginInputListener(LoginInputListener mLoginInputListener) {
        this.mLoginInputListener = mLoginInputListener;
    }

    private LoginInputListener mLoginInputListener;

    public interface LoginInputListener {
        void onLoginInputComplete(String username, String password);
    }


    /**
     * 在onCreateDialog中一般可以使用AlertDialog或者Dialog创建对话框
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_login_dialog, null);
        mUsername = (EditText) view.findViewById(R.id.et_user_name);
        mPassword = (EditText) view.findViewById(R.id.et_password);
        builder.setView(view).setPositiveButton("登陆", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mLoginInputListener != null) {
                    mLoginInputListener.onLoginInputComplete(mUsername.getText().toString(), mPassword.getText().toString());
                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
