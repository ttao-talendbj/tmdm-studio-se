/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.synchronization.ejb.remote;

/**
 * Home interface for SynchronizationObjectCtrl.
 * @xdoclet-generated at 10-08-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface SynchronizationObjectCtrlHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/SynchronizationObjectCtrl";
   public static final String JNDI_NAME="amalto/remote/core/synchronizationObjectctrl";

   public com.amalto.core.objects.synchronization.ejb.remote.SynchronizationObjectCtrl create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
