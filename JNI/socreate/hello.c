#include <jni.h>
#include <stdio.h>
#include "jni_JNI.h"

struct employ{
int age;
}emp;

JNIEXPORT void JNICALL Java_jni_JNI_sayHello (JNIEnv *env, jobject obj, jint intval){
printf("hello %d \n", intval);
return;

}

//gcc -o libHello.so -lc -shared -I/usr/lib/java/jdk1.8.0_91/include -I/usr/lib/java/jdk1.8.0_91/include/linux hello.c

JNIEXPORT void JNICALL Java_jni_JNI_passStr (JNIEnv *env, jobject obj, jstring message){


   const char *cStr = (*env)->GetStringUTFChars(env, message, NULL);

printf("hello string : %s \n", cStr);
return;
}

JNIEXPORT void JNICALL Java_jni_JNI_setEmp (JNIEnv *env, jobject thisObj, jobject tempobj){


 	// get the class reference for the IntHolder object
        jclass cls = (*env)->GetObjectClass(env, tempobj);
        
	
	// get the field ID and value of the int field
        jfieldID afid = (*env)->GetFieldID(env, cls, "age", "I");
        jint aval = (*env)->GetIntField(env, tempobj, afid);

emp.age=aval;

	 // Get the Field ID of the instance variables "message"
	 jfieldID fidMessage = (*env)->GetFieldID(env, cls, "name", "Ljava/lang/String;");
	 if (NULL == fidMessage) return;
 
	 // String
	 // Get the object given the Field ID
	 jstring message = (*env)->GetObjectField(env, thisObj, fidMessage);
        
	 const char *cStr = (*env)->GetStringUTFChars(env, thisObj, NULL);

	 printf("A field : %d ; %s \n", aval,cStr);

	 printf("struct age %d\n ",emp.age);


  	// get the field ID and value of the Inner object reference field
        jfieldID inner_fid = (*env)->GetFieldID(env, cls, "in", "Ljni/Inner;");
	if (NULL == inner_fid) return;

        jobject inner_val = (*env)->GetObjectField(env, tempobj, inner_fid);

        // get the class reference for the Inner object
        jclass inner_cls = (*env)->GetObjectClass(env, inner_val);
        // get the field ID and value of the subtotal int field
        jfieldID subtotal_fid = (*env)->GetFieldID(env, inner_cls, "inner", "I");
        jint subtotal_val = (*env)->GetIntField(env, inner_val, subtotal_fid); 
	
	printf("inner value %d \n",subtotal_val);

	return;
}
