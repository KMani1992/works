/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class Vector {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        exampleJNI.delete_Vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(int value) {
    exampleJNI.Vector_x_set(swigCPtr, this, value);
  }

  public int getX() {
    return exampleJNI.Vector_x_get(swigCPtr, this);
  }

  public void setY(int value) {
    exampleJNI.Vector_y_set(swigCPtr, this, value);
  }

  public int getY() {
    return exampleJNI.Vector_y_get(swigCPtr, this);
  }

  public void setZ(int value) {
    exampleJNI.Vector_z_set(swigCPtr, this, value);
  }

  public int getZ() {
    return exampleJNI.Vector_z_get(swigCPtr, this);
  }

  public Vector() {
    this(exampleJNI.new_Vector(), true);
  }

}