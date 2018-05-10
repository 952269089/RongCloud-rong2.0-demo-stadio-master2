package rong.io.demo;

import android.app.Application;
import android.util.Log;

import io.rong.imkit.RongIM;

/**
 * Created by Bob on 2015/4/28.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化融云
         */
        RongIM.init(this);
        Log.e("222","22222");
    }
}
