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
package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationForeignKeyInfoAction extends UndoAction {

    private static Log log = LogFactory.getLog(XSDSetAnnotationForeignKeyInfoAction.class);

    protected AnnotationOrderedListsDialog dlg = null;

    protected String dataModelName;

    public XSDSetAnnotationForeignKeyInfoAction(DataModelMainPage page, String dataModelName) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.KEYINFO.getPath()));
        setText(Messages.getString("SetForeignKeyInfos")); //$NON-NLS-1$
        setToolTipText(Messages.getString("SetForeignKeyInfos")); //$NON-NLS-1$
        this.dataModelName = dataModelName;
    }

    public IStatus doAction() {
        try {
            // add by ymli. fix the bug:0010293
            if (page.isDirty()) {
                boolean save = MessageDialog.openConfirm(page.getSite().getShell(), Messages.getString("SaveResource"), "'" //$NON-NLS-1$ //$NON-NLS-2$
                        + page.getXObject().getDisplayName() + "' " + Messages.getString("modifiedChanges")); //$NON-NLS-1$ //$NON-NLS-2$
                if (save) {
                    IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveEditor(part, false);
                }
                else
                    return Status.CANCEL_STATUS;
            }

            IStructuredSelection selection = (TreeSelection) page.getTreeViewer().getSelection();
            XSDComponent xSDCom = null;
            if (selection.getFirstElement() instanceof Element) {
                TreePath tPath = ((TreeSelection) selection).getPaths()[0];
                for (int i = 0; i < tPath.getSegmentCount(); i++) {
                    if (tPath.getSegment(i) instanceof XSDAnnotation)
                        xSDCom = (XSDAnnotation) (tPath.getSegment(i));
                }
            } else
                xSDCom = (XSDComponent) selection.getFirstElement();
            XSDAnnotationsStructure struc = new XSDAnnotationsStructure(xSDCom);
            if (struc.getAnnotation() == null) {
                throw new RuntimeException(Messages.getString("UnableEditAnnotationType") + xSDCom.getClass().getName()); //$NON-NLS-1$
            }

            dlg = getNewAnnotaionOrderedListsDialog(struc.getForeignKeyInfos().values());

            dlg.setRetrieveFKinfos(struc.getRetrieveFKinfos());
            dlg.setBlockOnOpen(true);
            int ret = dlg.open();
            if (ret == Window.CANCEL) {
                return Status.CANCEL_STATUS;
            }

            struc.setForeignKeyInfos(dlg.getXPaths());
            struc.setRetrieveFKinfos(dlg.isRetrieveFKinfos());
            if (struc.hasChanged()) {
                page.refresh();
                page.getTreeViewer().expandToLevel(xSDCom, 2);
                page.markDirty();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), Messages.getString("Error.title"), //$NON-NLS-1$
                    Messages.getString("ErrorForeignKey") + e.getLocalizedMessage()); //$NON-NLS-1$
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    protected AnnotationOrderedListsDialog getNewAnnotaionOrderedListsDialog(Collection<String> values) {
        return new AnnotationOrderedListsDialog(new ArrayList<String>(values), new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                dlg.close();
            }
        }, page.getSite().getShell(), Messages.getString("SetForeignKeyInfos"), "xPaths", page, //$NON-NLS-1$//$NON-NLS-2$
                AnnotationOrderedListsDialog.AnnotationForeignKeyInfo_ActionType, dataModelName);
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}