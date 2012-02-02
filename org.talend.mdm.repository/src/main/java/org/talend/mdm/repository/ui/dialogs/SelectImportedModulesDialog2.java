// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.dialogs;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDSchema;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.dialogs.SelectImportedModulesDialog;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC Administrator  class global comment. Detailled comment
 */
public class SelectImportedModulesDialog2 extends SelectImportedModulesDialog {

    private static Logger log = Logger.getLogger(SelectImportedModulesDialog2.class);

    MDMServerDef serverDef;
    public SelectImportedModulesDialog2(Shell parentShell, XSDSchema schema, TreeObject treeObj, String title) {
        super(parentShell, schema, treeObj, title);

    }

    protected XtentisPort getPort() {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());

        try {
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef();
                this.serverDef = serverDef;
                return RepositoryWebServiceAdapter.getXtentisPort(serverDef);
            }
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public String getLocal_mdm_url() {
        if (local_mdm_url == null) {
            String url = "http://" + serverDef.getHost() + ":" + serverDef.getPort() + "/pubcomponent/secure/dataModelsTypes/";//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return url;
        }
        return null;
    }

}