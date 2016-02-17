package com.amalto.workbench.widgets.xmleditor;

import org.eclipse.swt.widgets.Composite;

public abstract class ExtensibleContentEditorPageCreator {

    public ExtensibleContentEditorPageCreator() {
    }

    public abstract ExtensibleContentEditorPage createXMLEditorPage(Composite parent, int style, String plugin);

}
