package com.xmac.jnidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.xmac.jni.CodeNative;
import com.xmac.jni.MyNative;
import com.xmac.jnidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(CodeNative.stringFromJNI());

        String str1 = CodeNative.stringFromJNI();
        int data1 = MyNative.callAdd(3, 6);
        int data2 = CodeNative.callAdd(4, 3);
        byte[] buf = {1, 2, 3, 4};
        byte[] buf1 = MyNative.callBuf(buf);
        byte[] buf2 = CodeNative.callBuf(buf);


        Log.d("xmac", ">>>" + str1);
        String str2 = "";
        for (byte b:buf1) {
            str2 += " " + b;
        }
        for (byte b:buf2) {
            str2 += " " + b;
        }
        String str = str1 + " " + data1 + " " + data2 + " " + str2;
        Log.d("xmac", ">>>" + str);
    }
}