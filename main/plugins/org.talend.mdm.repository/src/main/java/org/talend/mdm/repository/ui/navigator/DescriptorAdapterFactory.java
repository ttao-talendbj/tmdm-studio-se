package org.talend.mdm.repository.ui.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.models.WSRootRepositoryObject;
import org.talend.repository.navigator.INavigatorDescriptor;

public class DescriptorAdapterFactory implements IAdapterFactory {

    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == INavigatorDescriptor.class) {
            if (adaptableObject instanceof WSRootRepositoryObject) {
                return new INavigatorDescriptor() {

                    @Override
                    public String getDescriptor() {
                        return ProxyRepositoryFactory.getInstance().getNavigatorViewDescription();
                    }
                };
            }// else return null
        }// else return null
        return null;
    }

    @Override
    public Class[] getAdapterList() {
        return new Class[] { INavigatorDescriptor.class };
    }

}