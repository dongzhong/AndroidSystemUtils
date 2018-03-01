package dongzhong.androidsystemutils;

import android.app.Application;
import android.content.Context;

/**
 * Created by dongzhong on 2018/3/1.
 */

public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
