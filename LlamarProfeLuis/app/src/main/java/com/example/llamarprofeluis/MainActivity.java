package com.example.llamarprofeluis;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LlamarProfe desbloqueoReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        desbloqueoReceiver = new LlamarProfe();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intent = new IntentFilter(Intent.ACTION_USER_PRESENT);
        registerReceiver(desbloqueoReceiver, intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(desbloqueoReceiver);
    }
}