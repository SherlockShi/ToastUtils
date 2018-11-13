package com.sherlockshi.toast.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sherlockshi.toast.ToastUtils;
import com.sherlockshi.toast.style.ToastBlackStyle;
import com.sherlockshi.toast.style.ToastQQStyle;
import com.sherlockshi.toast.style.ToastWhiteStyle;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void showSystem(final View v) {
        Toast.makeText(ToastActivity.this, "我是一个系统吐司", Toast.LENGTH_SHORT).show();
    }

    public void show(final View v) {
        ToastUtils.show("我是一个普通的吐司");
    }

    public void showHint(final View v) {
        ToastUtils.showHint("我是一个 Hint 吐司");
    }

    public void showWarn(final View v) {
        ToastUtils.showWarn("我是一个 Warn 吐司");
    }

    public void show2(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.show("我是子线程中弹出的吐司");
            }
        }).start();
    }

    public void show3(View v) {
        ToastUtils.initStyle(new ToastWhiteStyle());
        ToastUtils.show("动态切换白色吐司样式成功");
    }

    public void show4(View v) {
        ToastUtils.initStyle(new ToastBlackStyle());
        ToastUtils.show("动态切换黑色吐司样式成功");
    }

    public void show5(View v) {
        ToastUtils.initStyle(new ToastQQStyle());
        ToastUtils.show("动态切换QQ吐司样式成功");
    }

    public void show6(View v) {
        ToastUtils.setView(this, R.layout.toast_custom_view);
        ToastUtils.show("我是自定义Toast");
    }

    public void show7(View v) {
        ToastUtils.show(ToastUtils.isNotificationEnabled(this));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // 如果通知栏的权限被手动关闭了
        if (!ToastUtils.isNotificationEnabled(this) && "XToast".equals(ToastUtils.getToast().getClass().getSimpleName())) {
            // 因为吐司只有初始化的时候才会判断通知权限有没有开启，根据这个通知开关来显示原生的吐司还是兼容的吐司
            ToastUtils.init(getApplication());
            recreate();
            ToastUtils.show("检查到你手动关闭了通知权限，现在只能通过重启应用，吐司才能正常显示出来");
        }
    }
}