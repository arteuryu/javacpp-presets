// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Attributes for a single allocation call. Different calls to the same
// allocator could potentially have different allocation attributes.
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class AllocationAttributes extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public AllocationAttributes() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public AllocationAttributes(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AllocationAttributes(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public AllocationAttributes position(long position) {
        return (AllocationAttributes)super.position(position);
    }

  // If the first attempt to allocate the memory fails, the allocation
  // should return immediately without retrying.
  // An example use case is optional scratch spaces where a failure
  // has only performance impact.
  public native @Cast("bool") boolean no_retry_on_failure(); public native AllocationAttributes no_retry_on_failure(boolean setter);
  // If a Tensor is allocated without the following set to true, then
  // it is logged as an unknown allocation. During execution Tensors
  // should be allocated through the OpKernelContext which records
  // which Op is performing the allocation, and sets this flag to
  // true.
  public native @Cast("bool") boolean allocation_will_be_logged(); public native AllocationAttributes allocation_will_be_logged(boolean setter);
}
