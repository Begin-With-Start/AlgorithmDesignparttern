package designpartern.minifly.com.designparttern.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by dama on 2017/11/19.
 */

public class PlatformTools {

    /**
     * 监测是否是模拟器  (是否是支持opengl 2.0 开发)
     * @param mContext
     * @return 是否是模拟器
     */
    private static boolean checkSupported(Context mContext) {
        ActivityManager activityManager = (ActivityManager) mContext.getSystemService(ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x2000;

        boolean isEmulator = Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                && (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86"));

        supportsEs2 = supportsEs2 || isEmulator;

        return supportsEs2;
    }

}
