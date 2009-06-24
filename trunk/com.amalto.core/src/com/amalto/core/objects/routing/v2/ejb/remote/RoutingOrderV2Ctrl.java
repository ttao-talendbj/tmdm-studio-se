/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.routing.v2.ejb.remote;

/**
 * Remote interface for RoutingOrderV2Ctrl.
 * @xdoclet-generated at 24-06-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface RoutingOrderV2Ctrl
   extends javax.ejb.EJBObject
{
   /**
    * Executes a Routing Order now
    * @throws XtentisException
    */
   public void executeASynchronously( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO routingOrderPOJO )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes a Routing Order now
    * @throws XtentisException
    */
   public java.lang.String executeSynchronously( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO routingOrderPOJO )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes a Routing Order now
    * @throws XtentisException
    */
   public java.lang.String executeSynchronously( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO routingOrderPOJO,boolean cleanUpRoutingOrder )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes a Routing Order in delay milliseconds
    * @throws XtentisException
    */
   public void executeAsynchronously( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO routingOrderPOJO,long delayInMillis )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes a Routing Order in default DELAY milliseconds
    * @throws XtentisException
    */
   public void executeAsynchronously( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO routingOrderPOJO )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Remove an item
    * @throws XtentisException
    */
   public com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJOPK removeRoutingOrder( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Creates or updates a Transformer
    * @throws XtentisException
    */
   public com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJOPK putRoutingOrder( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO routingOrderPOJO )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get Routing Order
    * @throws XtentisException
    */
   public com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO getRoutingOrder( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get a RoutingOrder knowing its class - no exception is thrown: returns null if not found
    * @throws XtentisException
    */
   public com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO existsRoutingOrder( com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Find Active Routing Orders
    * @throws XtentisException
    */
   public com.amalto.core.objects.routing.v2.ejb.ActiveRoutingOrderV2POJO[] findActiveRoutingOrders( long lastScheduledTime,int maxRoutingOrders )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Find Dead Routing Orders
    * @throws XtentisException
    */
   public com.amalto.core.objects.routing.v2.ejb.ActiveRoutingOrderV2POJO[] findDeadRoutingOrders( long maxLastRunStartedTime,int maxRoutingOrders )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all Active Routing Order PKs
    * @throws XtentisException
    */
   public java.util.Collection getActiveRoutingOrderPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all Completed Routing Order PKs
    * @throws XtentisException
    */
   public java.util.Collection getCompletedRoutingOrderPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all Failed Routing Order PKs
    * @throws XtentisException
    */
   public java.util.Collection getFailedRoutingOrderPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all RoutingOrder PKs whatever the class
    * @throws XtentisException
    */
   public java.util.Collection getAllRoutingOrderPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all RoutingOrder PKs by Criteria
    * @throws XtentisException
    */
   public java.util.Collection getRoutingOrderPKsByCriteria( java.lang.Class routingOrderV2POJOClass,java.lang.String anyFieldContains,java.lang.String name,long timeCreatedMin,long timeCreatedMax,long timeScheduledMin,long timeScheduledMax,long timeLastRunStartedMin,long timeLastRunStartedMax,long timeLastRunCompletedMin,long timeLastRunCompletedMax,java.lang.String itemConceptContains,java.lang.String itemIDsContain,java.lang.String serviceJNDIContains,java.lang.String serviceParametersContains,java.lang.String messageContains )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

}
