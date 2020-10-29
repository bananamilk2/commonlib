package com.asjm.lib.util;

import android.util.Log;

public class ALog {

    private static String TAG = "asjm";

    private static boolean isEnabled = true;

    public static ALog log;

    private ALog() {
    }

    public static ALog getInstance() {
        if (log == null) {
            synchronized (ALog.class) {
                if (log == null)
                    log = new ALog();
            }
        }
        return log;
    }

    public String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
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
            return "[ " + Thread.currentThread().getName() + ": "
                    + st.getFileName() + ":" + st.getLineNumber() + " "
                    + st.getMethodName() + " ]";
        }
        return null;
    }

    public final static String tag = "[asjm]";

    public void d(String str) {
        if (isEnabled) {
            String name = getFunctionName();
            if (name != null) {
                Log.d(tag, name + " - " + str);
            } else {
                Log.d(tag, str.toString());
            }
        }
    }
}
