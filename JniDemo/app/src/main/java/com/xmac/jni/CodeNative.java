package com.xmac.jni;

/**
 * Example of calling native c/c++ code in the project.
 * The source code of the library is just in project cpp folder.
 */
public class CodeNative {
    static {
        System.loadLibrary("jnidemo");
        System.loadLibrary("third");
    }
    // Call native function in project c++ code
    public static native String stringFromJNI();

    // Call native function in project c++ code (see cpp folder), which depends a 3rd-party library (see cpp/libs/ folder)
    // https://developer.android.com/studio/projects/configure-cmake
    public static native int callAdd(int a, int b);
    public static native byte[] callBuf(byte[] buf);
}
