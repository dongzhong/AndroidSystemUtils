package dongzhong.androidsystemutils.wifi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import dongzhong.androidsystemutils.R;

public class WifiStatusActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView wifiStatusTextView;
    private Button startListenWifiStatus;
    private Button stopListenWifiStatus;
    private Timer wifiStatusTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_status);

        initView();
    }

    private void initView() {
        wifiStatusTextView = (TextView) findViewById(R.id.textview_wifistatus);
        startListenWifiStatus = (Button) findViewById(R.id.button_start_listen_wifi_status);
        stopListenWifiStatus = (Button) findViewById(R.id.button_stop_listen_wifi_status);

        startListenWifiStatus.setOnClickListener(this);
        stopListenWifiStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_listen_wifi_status:
                if (wifiStatusTimer != null) {
                    wifiStatusTimer.cancel();
                    wifiStatusTimer = null;
                }

                wifiStatusTimer = new Timer();
                wifiStatusTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        final Bundle bundle = WifiStatus.getWifiInfo();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int rssi = bundle.getInt(WifiStatus.RSSI);
                                int linkSpeed = bundle.getInt(WifiStatus.LINK_SPEED);
                                wifiStatusTextView.setText("Wifi信号强度: " + rssi + "\nWifi速度: " + linkSpeed);
                            }
                        });
                    }
                }, 0, 1000);
                break;
            case R.id.button_stop_listen_wifi_status:
                if (wifiStatusTimer != null) {
                    wifiStatusTimer.cancel();
                    wifiStatusTimer = null;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        wifiStatusTextView.setText("");
                    }
                });
                break;
            default:
                break;
        }
    }
}
