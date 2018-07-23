package com.example.zzzz.architector;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.support.annotation.NonNull;

public class App extends Application {
    public static String isWXPaySuccessed = null;// 微信支付是否成功
    public static String city = null;
    public static int width = 0;
    public static int height = 0;
    private static App mApp;

//    private DaoSession mSession;
//    private RefWatcher watcher;

    static {
        /*SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.black_darker, R.color.white);
                return new ClassicsHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });*/
    }

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
        super.onCreate();
        mApp = this;
        //greenDao初始化
        initDB();
//        ExceptionCaught.getInstance().init();//仅限内部测试使用
//        if (LeakCanary.isInAnalyzerProcess(this))
//            watcher = RefWatcher.DISABLED;
//        watcher = LeakCanary.install(this);
        //日志格式化输出
//        Logger.addLogAdapter(new AndroidLogAdapter() {
//            @Override
//            public boolean isLoggable(int priority, String tag) {
//                return BuildConfig.DEBUG;
//            }
//        });
    }

    private void initDB() {
//        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "ymyc-db");
//        Database db = openHelper.getWritableDb();
//        mSession = new DaoMaster(db).newSession();
//
//        width = ScreenHelper.getScreenWidth(this);
//        height = ScreenHelper.getScreenHeight(this);
    }

//    public DaoSession getDaoSession() {
//        return mSession;
//    }

    public static App getInstance() {
        return mApp;
    }

//    public RefWatcher getWatcher() {
//        return watcher;
//    }
}
