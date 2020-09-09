package com.github.panpf.android.publish.sample;

import android.app.Activity;
import android.content.pm.PackageManager;

public class MyDreamActivity extends Activity {
    /**
     * {@link Activity}
     */
    Activity activity = this;

    public String getName() {
        PackageManager packageManager = activity.getPackageManager();
        try {
            return packageManager.getApplicationInfo(getPackageName(), 0).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
