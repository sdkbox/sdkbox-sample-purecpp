package com.sdkbox.sdkboxcpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sdkbox.plugin.SDKBox;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SDKBox.init(this);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    // sdkbox start

    @Override
    protected void onStart() {
        super.onStart();
        SDKBox.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SDKBox.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SDKBox.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SDKBox.onPause();
    }

    @Override
    public void onBackPressed() {
        if (!SDKBox.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(!SDKBox.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    // sdkbox end

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
