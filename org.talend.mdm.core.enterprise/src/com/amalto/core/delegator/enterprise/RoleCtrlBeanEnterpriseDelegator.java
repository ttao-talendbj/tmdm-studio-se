package com.amalto.core.delegator.enterprise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.amalto.core.delegator.RoleCtrlBeanDefaultDelegator;
import com.amalto.core.ejb.ObjectPOJO;
import com.amalto.core.ejb.ObjectPOJOPK;
import com.amalto.core.objects.role.ejb.RolePOJO;
import com.amalto.core.objects.role.ejb.RolePOJOPK;
import com.amalto.core.util.XtentisException;

public class RoleCtrlBeanEnterpriseDelegator extends
		RoleCtrlBeanDefaultDelegator {
	  /**
     * Creates or updates a Role
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public RolePOJOPK putRole(RolePOJO role) throws XtentisException{  
    	org.apache.log4j.Logger.getLogger(this.getClass()).trace("putRole() ");
    	
        try {
            
            ObjectPOJOPK pk = role.store();
            if (pk == null) throw new XtentisException("Check the XML Server logs");
            
            return new RolePOJOPK(pk);
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to create/update the Role "+role.getName()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }

    }
    
     
    /**
     * Get Role
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public RolePOJO getRole(RolePOJOPK pk) throws XtentisException{

        try {
        	RolePOJO sp =  ObjectPOJO.load(RolePOJO.class,pk);
        	if (sp == null) {
        		String err= "The Role "+pk.getUniqueId()+" does not exist.";
        		org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
        		throw new XtentisException(err);
        	}
        	return sp;
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to get the Role "+pk.toString()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }
    }
    
    /**
     * Get a Role - no exception is thrown: returns null if not found 
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public RolePOJO existsRole(RolePOJOPK pk) throws XtentisException{
    	
        try {
        	return ObjectPOJO.load(RolePOJO.class,pk);        	
	    } catch (XtentisException e) {
	    	return null;
	    } catch (Exception e) {
    	    String info = "Could not check whether this Role exists:  "+pk.getUniqueId()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).debug(info, e);
    	   return null;
	    }
    }
    

    /**
     * Remove an item
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public RolePOJOPK removeRole(RolePOJOPK pk) 
    throws XtentisException{
    	org.apache.log4j.Logger.getLogger(this.getClass()).trace("Removing "+pk.getUniqueId());

        try {
        	return new RolePOJOPK(ObjectPOJO.remove(RolePOJO.class,pk));
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to remove the Role "+pk.toString()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }
    }    
    
    
    
    /**
	 * Retrieve all Role PKS 
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */       
    public Collection<RolePOJOPK> getRolePKs(String regex) throws XtentisException {
    	Collection<ObjectPOJOPK> c = ObjectPOJO.findAllPKs(RolePOJO.class,regex);
    	ArrayList<RolePOJOPK> l = new ArrayList<RolePOJOPK>();
    	for (Iterator<ObjectPOJOPK> iter = c.iterator(); iter.hasNext(); ) {
			l.add(new RolePOJOPK(iter.next()));
		}
    	return l;
    }
	
}
