package com.ls.dialogfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ls.fragment.EditNameDialogFragment;
import com.ls.fragment.LoginDialogFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_edit_name).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_in_different_screen).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit_name:
                showEditNameDialog();
                break;
            case R.id.btn_login:
                showLoginDialog();
                break;
            case R.id.btn_in_different_screen:
                showDialogInDifferentScreen();
                break;
        }
    }

    /**
     * 适配多种屏幕
     * ，一个对话框在大屏幕上以对话框的形式展示，而小屏幕上则直接嵌入当前的Activity中。
     * 这种效果的对话框，只能通过重写onCreateView实现。
     */
    private void showDialogInDifferentScreen() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        EditNameDialogFragment newEditNameDialogFragment = new EditNameDialogFragment();
        boolean isLargeLayout = getResources().getBoolean(R.bool.large_layout);
        if (isLargeLayout) {
            newEditNameDialogFragment.show(fragmentManager, "large_layout");
        } else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//切换动画

            // fragmentTransaction.replace(R.id.id_ly, newEditNameDialogFragment).commit();//切换 !!!有问题
        }
    }

    /**
     * 通过onCreateDialog()创建
     * 此种方式可以适应任何横竖屏操作.
     */
    private void showLoginDialog() {
        LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
        loginDialogFragment.setLoginInputListener(new LoginDialogFragment.LoginInputListener() {
            @Override
            public void onLoginInputComplete(String username, String password) {
                Toast.makeText(getApplicationContext(), "userName:" + username + " password:" + password, Toast.LENGTH_SHORT).show();
            }
        });
        loginDialogFragment.show(getSupportFragmentManager(), "login");
    }

    /**
     * 通过onCreateView创建,自定义很高,可以做屏幕适配方案
     */
    private void showEditNameDialog() {
        EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
        editNameDialogFragment.show(getSupportFragmentManager(), "edit_name");
    }
}
