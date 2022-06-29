package com.xmac.jni;

/**
 * Example of calling 3rd-party library built by NDK.
 * The "first" library is built by NDK.
 * The "second" library is built by NDK, and it depends on the "first" library.
 */
public class MyNative {
    static {
        System.loadLibrary("first");
        System.loadLibrary("second");
    }
    // Call native function from a library (libfirst.so), which depends another library (libsecond.so)
    // https://developer.android.com/ndk/guides/prebuilts
    public static native int callAdd(int a, int b);
    public static native byte[] callBuf(byte[] buf);
}
