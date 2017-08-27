#include <jni.h>
#include <stdio.h>
#include "jni_JNI.h"

JNIEXPORT void JNICALL Java_jni_JNI_sayHello (JNIEnv *env, jobject obj){
printf("hello\n");

}
