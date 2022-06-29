#include <jni.h>
#include <string>
#include "third.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_xmac_jni_CodeNative_stringFromJNI(JNIEnv* env, jclass clazz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_xmac_jni_CodeNative_callAdd(JNIEnv *env, jclass clazz, jint a, jint b) {
    int _a = a;
    int _b = b;
    int _c = CallAdd(_a, _b);
    return (jint) _c;
}

extern "C" JNIEXPORT jbyteArray
Java_com_xmac_jni_CodeNative_callBuf(JNIEnv *env, jobject clazz, jbyteArray src) {
    // get input buffer and its length
    jbyte *srcbuf = env->GetByteArrayElements(src, 0);
    jsize len = env->GetArrayLength(src);

    // call 3rd-party function
    unsigned char *_srcbuf = (unsigned char*)srcbuf;
    unsigned char *_dstbuf = (unsigned char*)malloc(len);
    CallBuf(_srcbuf, len, _dstbuf);

    // change to java type
    jbyte *dstBuf = (jbyte *)_dstbuf;
    jbyteArray jarray = env->NewByteArray(len);
    env->SetByteArrayRegion(jarray, 0, len, dstBuf);

    // release memory
    env->ReleaseByteArrayElements(src, srcbuf, 0);
    free(_dstbuf);

    return jarray;
}