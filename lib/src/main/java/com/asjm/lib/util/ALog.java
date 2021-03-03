package com.asjm.lib.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

public class ALog {

    private static boolean isEnabled = true;

    private final String DEFAULT_APP_NAME = "[asjm]";
    private final static String DEFAULT_TAG = "LogOutput";

    public static final int LOG_LEVEL_VERBOSE = 5;
    public static final int LOG_LEVEL_DEBUG = 4;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_WARN = 2;
    public static final int LOG_LEVEL_ERROR = 1;
    public static final int LOG_LEVEL_NONE = 0;

    private int logLevel = LOG_LEVEL_VERBOSE;

    private boolean enableClassName = true;
    private boolean enableThreadName = true;
    private boolean enableFileName = true;
    private boolean enableMethodName = true;
    private boolean enableLineNumber = true;

    private static ALog instance;
    private String appName = DEFAULT_APP_NAME;
    private Context context;
    private static String TAG = DEFAULT_TAG;

    private ALog() {
    }

    public static ALog getInstance() {
        if (instance == null) {
            synchronized (ALog.class) {
                if (instance == null) {
                    instance = new ALog();
                }
            }
        }
        return instance;
    }

    public ALog init(final Context appContext) {
        return this.init(appContext, null);
    }

    public ALog init(final Context appContext, final String name) throws NullPointerException {
        return this.init(appContext, name, false);
    }

    public ALog init(final Context appContext, final boolean manualLog) throws NullPointerException {
        return this.init(appContext, null, manualLog);
    }

    public ALog init(final Context appContext, final String name, final boolean log) throws NullPointerException {
        if (appContext == null) {
            throw new NullPointerException("applicationContext is null");
        }
        this.context = appContext;
        this.appName = name;

        if (TextUtils.isEmpty(appName)) {
            appName = getAppName(context);
        }
        appName = TAG + ": " + appName;
        return this;
    }

    public void setLogLevel(int level) {
        this.logLevel = level;
    }

    public String getAppName(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            int labelRes = applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void v(Object str) {
        if (logLevel == LOG_LEVEL_VERBOSE) {
            String name = getFunctionName();
            Log.v(appName, name + " - " + str);
        }
    }

    public void d(Object str) {
        if (logLevel >= LOG_LEVEL_DEBUG) {
            String name = getFunctionName();
            Log.d(appName, name + " - " + str);
        }
    }

    public void i(Object str) {
        if (logLevel >= LOG_LEVEL_INFO) {
            String name = getFunctionName();
            Log.i(appName, name + " - " + str);
        }
    }

    public void w(Object str) {
        if (logLevel >= LOG_LEVEL_WARN) {
            String name = getFunctionName();
            Log.w(appName, name + " - " + str);
        }
    }

    public void e(Object str) {
        if (logLevel >= LOG_LEVEL_ERROR) {
            String name = getFunctionName();
            Log.e(appName, name + " - " + str);
        }
    }

    public String getFunctionName() {
        if (!enableMethodName && !enableClassName && !enableThreadName && !enableFileName && !enableLineNumber)
            return "";
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }
            StringBuilder builder = new StringBuilder("[");
            if (enableThreadName)
                builder.append(Thread.currentThread().getName()).append(": ");
            if (enableFileName)
                builder.append(st.getFileName()).append(": ");
            if (enableLineNumber)
                builder.append(st.getLineNumber()).append(": ");
            if (enableMethodName)
                builder.append(st.getMethodName());
            builder.append(" ]");
            return builder.toString();
        }
        return "";
    }

    public ALog enableClassName() {
        this.enableClassName = true;
        return this;
    }

    public ALog disableClassName() {
        this.enableClassName = false;
        return this;
    }

    public ALog enableThreadName() {
        this.enableThreadName = true;
        return this;
    }

    public ALog disableThreadName() {
        this.enableThreadName = false;
        return this;
    }

    public ALog enableFileName() {
        this.enableFileName = true;
        return this;
    }

    public ALog disableFileName() {
        this.enableFileName = false;
        return this;
    }

    public ALog enableMethodName() {
        this.enableMethodName = true;
        return this;
    }

    public ALog disableMethodName() {
        this.enableMethodName = false;
        return this;
    }

    public ALog enableLineNumber() {
        this.enableLineNumber = true;
        return this;
    }

    public ALog disableLineNumber() {
        this.enableLineNumber = false;
        return this;
    }

    public ALog enableAllInfo() {
        enableClassName = true;
        enableThreadName = true;
        enableFileName = true;
        enableMethodName = true;
        enableLineNumber = true;
        return this;
    }

    public ALog disableAllInfo() {
        enableClassName = false;
        enableThreadName = false;
        enableFileName = false;
        enableMethodName = false;
        enableLineNumber = false;
        return this;
    }

    public void destroy() {
        d("destroy LogOutput");
        this.context = null;
    }
}
