// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.workbench.serverexplorer.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.DynaEnum;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSPing;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ServerDefService {

    private static Logger log = Logger.getLogger(ServerDefService.class);

    public static ERepositoryObjectType REPOSITORY_TYPE_SERVER_DEF = DynaEnum.valueOf(ERepositoryObjectType.class,
            "MDM.ServerDef"); //$NON-NLS-1$

    public static List<IRepositoryViewObject> getAllServerDefViewObjects() {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        try {
            return factory.getAll(REPOSITORY_TYPE_SERVER_DEF);

        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static List<MDMServerDef> getAllServerDefs() {
        List<IRepositoryViewObject> viewObjects = getAllServerDefViewObjects();
        if (viewObjects != null) {
            List<MDMServerDef> serverDefs = new ArrayList<MDMServerDef>(viewObjects.size());
            for (IRepositoryViewObject viewObj : viewObjects) {
                Item item = viewObj.getProperty().getItem();
                MDMServerDef serverDef = ((MDMServerDefItem) item).getServerDef();
                if (serverDef != null) {
                    serverDefs.add(serverDef);
                }
            }
            return serverDefs;
        }
        return null;
    }

    /**
     * DOC hbhong Comment method "deleteServerDef".
     * 
     * @param viewObject
     */
    public static boolean deleteServerDef(IRepositoryViewObject viewObject) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

        if (viewObject != null) {
            try {
                // because TIS Repository's hard code
                factory.deleteObjectPhysical(viewObject);
                // so use the following to replace above
                // Project project = ProjectManager.getInstance().getCurrentProject();
                // IRepositoryViewObject object = new RepositoryObject(viewObject.getProperty());
                // ((ProxyRepositoryFactory) factory).getRepositoryFactoryFromProvider().deleteObjectPhysical(project,
                // object);
                return true;
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }
        }
        return false;

    }

    public static boolean isExistServerDefName(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        List<MDMServerDef> serverDefs = getAllServerDefs();
        if (serverDefs != null) {
            for (MDMServerDef def : serverDefs) {
                if (def.getName().equalsIgnoreCase(name))
                    return true;
            }
        }
        return false;
    }

    public static boolean saveServeDef(MDMServerDefItem item) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        try {
            String name = item.getServerDef().getName();
            item.getProperty().setLabel(name);
            factory.save(item, false);
            return true;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public static boolean createServerDef(MDMServerDef serverDef) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        RepositoryContext context = factory.getRepositoryContext();

        MDMServerDefItem item = MdmpropertiesFactory.eINSTANCE.createMDMServerDefItem();

        item.setServerDef(serverDef);
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        item.setProperty(prop);
        try {
            String nextId = factory.getNextId();
            Property property = item.getProperty();
            property.setId(nextId);
            property.setVersion(VersionUtils.DEFAULT_VERSION);
            property.setAuthor(context.getUser());
            property.setLabel(item.getServerDef().getName());
            factory.create(item, new Path("")); //$NON-NLS-1$
            return true;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public static boolean checkMDMConnection(MDMServerDef serverDef) {
        return checkMDMConnection(serverDef.getUrl(), serverDef.getUser(), serverDef.getPasswd(), serverDef.getUniverse());
    }

    public static boolean checkMDMConnection(String endpointaddress, String username, String password, String universe) {

        try {
            XtentisPort port = Util.getPort(new URL(endpointaddress), universe, username, password);
            port.ping(new WSPing("ServerExplorer")); //$NON-NLS-1$
            return true;
        } catch (RemoteException e) {
            log.debug(e.getMessage(), e);
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}