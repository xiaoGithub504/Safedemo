package com.example.xiao.safetydemo;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiao on 2017/3/14.
 */
//界面劫持
public class AtyModule {
    /**
     * 用于执行定时任务
     */
    private Timer timer = null;

    /**
     * 用于保存当前任务
     */
    private List<MyTimerTask> tasks = null;

    /**
     * 唯一实例
     */
    private static AtyModule atyModule;

    private AtyModule() {
        // 初始化
        tasks = new ArrayList<MyTimerTask>();
        timer = new Timer();
    }

    /**
     * 获取唯一实例
     *
     * @return 唯一实例
     */
    public static AtyModule getinstance() {
        if (atyModule == null) {
            atyModule = new AtyModule();
        }
        return atyModule;
    }

    /**
     * 在activity的onPause()方法中调用
     *
     * @param activity
     */
    public void onPause(final Activity activity) {
        MyTimerTask task = new MyTimerTask(activity);
        tasks.add(task);
        timer.schedule(task, 2000);
    }

    /**
     * 在activity的onResume()方法中调用
     */
    public void onResume() {
        if (tasks.size() > 0) {
            tasks.get(tasks.size() - 1).setCanRun(false);
            tasks.remove(tasks.size() - 1);
        }
    }

    /**
     * 自定义TimerTask类
     */
    class MyTimerTask extends TimerTask {
        /**
         * 任务是否有效
         */
        private boolean canRun = true;
        private Activity activity;

        public void setCanRun(boolean canRun) {
            this.canRun = canRun;
        }

        public MyTimerTask(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (canRun) {
                        // 程序退到后台，进行风险警告
                        Toast.makeText(activity, "应用Test切换至后台运行",
                                Toast.LENGTH_LONG).show();
                        tasks.remove(MyTimerTask.this);
                    }
                }
            });
        }
    }
}
