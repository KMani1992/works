/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class example {
  public static void setCallback(SWIGTYPE_p_class value) {
    exampleJNI.Callback_set(SWIGTYPE_p_class.getCPtr(value));
  }

  public static SWIGTYPE_p_class getCallback() {
    return new SWIGTYPE_p_class(exampleJNI.Callback_get(), true);
  }

  public static void setCaller(SWIGTYPE_p_class value) {
    exampleJNI.Caller_set(SWIGTYPE_p_class.getCPtr(value));
  }

  public static SWIGTYPE_p_class getCaller() {
    return new SWIGTYPE_p_class(exampleJNI.Caller_get(), true);
  }

}