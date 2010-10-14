// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation （1.1.2_01，编译版 R40）
// Generated source version: 1.1.2

package com.amalto.workbench.webservices;


import java.util.Map;
import java.util.HashMap;

public class WSConnectorFunction {
    private java.lang.String value;
    private static Map valueMap = new HashMap();
    public static final String _GET_STATUSString = "GET_STATUS";
    public static final String _STARTString = "START";
    public static final String _STOPString = "STOP";
    public static final String _PULLString = "PULL";
    public static final String _PUSHString = "PUSH";
    
    public static final java.lang.String _GET_STATUS = new java.lang.String(_GET_STATUSString);
    public static final java.lang.String _START = new java.lang.String(_STARTString);
    public static final java.lang.String _STOP = new java.lang.String(_STOPString);
    public static final java.lang.String _PULL = new java.lang.String(_PULLString);
    public static final java.lang.String _PUSH = new java.lang.String(_PUSHString);
    
    public static final WSConnectorFunction GET_STATUS = new WSConnectorFunction(_GET_STATUS);
    public static final WSConnectorFunction START = new WSConnectorFunction(_START);
    public static final WSConnectorFunction STOP = new WSConnectorFunction(_STOP);
    public static final WSConnectorFunction PULL = new WSConnectorFunction(_PULL);
    public static final WSConnectorFunction PUSH = new WSConnectorFunction(_PUSH);
    
    protected WSConnectorFunction(java.lang.String value) {
        this.value = value;
        valueMap.put(this.toString(), this);
    }
    
    public java.lang.String getValue() {
        return value;
    }
    
    public static WSConnectorFunction fromValue(java.lang.String value)
        throws java.lang.IllegalStateException {
        if (GET_STATUS.value.equals(value)) {
            return GET_STATUS;
        } else if (START.value.equals(value)) {
            return START;
        } else if (STOP.value.equals(value)) {
            return STOP;
        } else if (PULL.value.equals(value)) {
            return PULL;
        } else if (PUSH.value.equals(value)) {
            return PUSH;
        }
        throw new IllegalArgumentException();
    }
    
    public static WSConnectorFunction fromString(String value)
        throws java.lang.IllegalStateException {
        WSConnectorFunction ret = (WSConnectorFunction)valueMap.get(value);
        if (ret != null) {
            return ret;
        }
        if (value.equals(_GET_STATUSString)) {
            return GET_STATUS;
        } else if (value.equals(_STARTString)) {
            return START;
        } else if (value.equals(_STOPString)) {
            return STOP;
        } else if (value.equals(_PULLString)) {
            return PULL;
        } else if (value.equals(_PUSHString)) {
            return PUSH;
        }
        throw new IllegalArgumentException();
    }
    
    public String toString() {
        return value.toString();
    }
    
    private Object readResolve()
        throws java.io.ObjectStreamException {
        return fromValue(getValue());
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof WSConnectorFunction)) {
            return false;
        }
        return ((WSConnectorFunction)obj).value.equals(value);
    }
    
    public int hashCode() {
        return value.hashCode();
    }
}
