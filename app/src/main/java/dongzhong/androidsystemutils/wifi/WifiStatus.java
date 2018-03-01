package dongzhong.androidsystemutils.wifi;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

import dongzhong.androidsystemutils.BaseApplication;

/**
 * Created by dongzhong on 2018/3/1.
 */

public class WifiStatus {
    private static final String TAG = WifiStatus.class.getSimpleName();

    private static WifiManager wifiManager = (WifiManager) BaseApplication.getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);

    public static final String RSSI = "rssi";
    public static final String LINK_SPEED = "link_speed";

    public static Bundle getWifiInfo() {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        Log.d(TAG, "Wifi信号强度: " + wifiInfo.getRssi() + ", Wifi速度: " + wifiInfo.getLinkSpeed());

        Bundle bundle = new Bundle();
        bundle.putInt(RSSI, wifiInfo.getRssi());
        bundle.putInt(LINK_SPEED, wifiInfo.getLinkSpeed());

        return bundle;
    }
}
