package dongzhong.androidsystemutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dongzhong.androidsystemutils.wifi.WifiStatusActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonWifiStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        buttonWifiStatus = (Button) findViewById(R.id.button_wifi_status);
        buttonWifiStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_wifi_status:
                Intent wifiStatusIntent = new Intent(MainActivity.this, WifiStatusActivity.class);
                startActivity(wifiStatusIntent);
                break;
            default:
                break;
        }
    }
}
