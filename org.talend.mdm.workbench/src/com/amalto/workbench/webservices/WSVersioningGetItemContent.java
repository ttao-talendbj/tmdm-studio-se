// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation （1.1.2_01，编译版 R40）
// Generated source version: 1.1.2

package com.amalto.workbench.webservices;


public class WSVersioningGetItemContent {
    protected java.lang.String versioningSystemName;
    protected com.amalto.workbench.webservices.WSItemPK wsItemPK;
    protected java.lang.String revision;
    
    public WSVersioningGetItemContent() {
    }
    
    public WSVersioningGetItemContent(java.lang.String versioningSystemName, com.amalto.workbench.webservices.WSItemPK wsItemPK, java.lang.String revision) {
        this.versioningSystemName = versioningSystemName;
        this.wsItemPK = wsItemPK;
        this.revision = revision;
    }
    
    public java.lang.String getVersioningSystemName() {
        return versioningSystemName;
    }
    
    public void setVersioningSystemName(java.lang.String versioningSystemName) {
        this.versioningSystemName = versioningSystemName;
    }
    
    public com.amalto.workbench.webservices.WSItemPK getWsItemPK() {
        return wsItemPK;
    }
    
    public void setWsItemPK(com.amalto.workbench.webservices.WSItemPK wsItemPK) {
        this.wsItemPK = wsItemPK;
    }
    
    public java.lang.String getRevision() {
        return revision;
    }
    
    public void setRevision(java.lang.String revision) {
        this.revision = revision;
    }
}
