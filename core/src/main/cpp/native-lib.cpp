#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_yogadarma_core_utils_Keys_apiKey(JNIEnv *env, jobject object) {
    std::string api_key = "c4419b53161aa5ce9706b6c909cb6775";
    return env->NewStringUTF(api_key.c_str());
}