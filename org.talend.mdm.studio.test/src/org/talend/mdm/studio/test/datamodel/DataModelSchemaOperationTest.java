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
package org.talend.mdm.studio.test.datamodel;

import junit.framework.Assert;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;

/**
 * 
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaOperationTest extends TalendSWTBotForMDM {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem entityNode;

	private SWTBotTreeItem elementNode;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();
		if (dataModelItem.getNodes().contains("TestDataModel"))
			dataModelItem.getNode("TestDataModel").doubleClick();
		else
			newDatamodel();

		final SWTBotEditor editor = bot.editorByTitle("TestDataModel");
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				XSDEditor ep = (XSDEditor) editor.getReference().getPart(true);
				mainpage = (DataModelMainPage) ep.getSelectedPage();
			}
		});
		Tree conceptTree = mainpage.getElementsViewer().getTree();
		conceptBotTree = new SWTBotTree(conceptTree);
		newEntity();
		newElement();
	}

	private void newDatamodel() {
		dataModelItem.contextMenu("New").click();
		SWTBotShell newDataContainerShell = bot.shell("New Data Model");
		newDataContainerShell.activate();
		SWTBotText text = bot
				.textWithLabel("Enter a name for the New Instance");
		text.setText("TestDataModel");
		sleep();
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(dataModelItem.getNode("TestDataModel"));
		sleep(2);
	}

	private void newEntity() {
		conceptBotTree.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		entityNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		entityNode.select();
	}

	private void newElement() {
		entityNode.expand().getNode("ComplexTypeEntityType")
				.contextMenu("Add Element").click();

		SWTBotShell newElementShell = bot.shell("Add a new Business Element");
		newElementShell.activate();
		bot.textWithLabel("Business Element Name").setText("Ele");
		sleep();
		bot.button("OK").click();
		sleep(2);
		elementNode = entityNode.expand().getNode("ComplexTypeEntityType")
				.expand().getNode("Ele  [0...1]");
	}

	@After
	public void runAfterEveryTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
				bot.activeEditor().close();
			}
		});
		dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
		bot.button("OK").click();
	}

	// @Test
	public void filterTest() {
		bot.toolbarRadioButtonWithTooltip("Filter...").click();
		SWTBotShell filterShell = bot.shell("Data Model Filter");
		filterShell.activate();
		bot.ccomboBox().setSelection(1);
		sleep();
		bot.radio(3).click();
		sleep();
		bot.button("OK").click();
		sleep();
		bot.toolbarButtonWithTooltip("Filter...").click();
		filterShell = bot.shell("Data Model Filter");
		filterShell.activate();
		bot.ccomboBox().setSelection(0);
		sleep();
		bot.radio(0).click();
		sleep();
		bot.button("OK").click();
	}

	@Test
	public void expandTest() {
		entityNode.select();
		bot.toolbarButtonWithTooltip("Expand...").click();
		sleep(2);
	}

	@Test
	public void collapseTest() {
		entityNode.select();
		bot.toolbarButtonWithTooltip("Collapse...").click();
		sleep(2);
	}

	@Test
	public void expandModelGroupTest() {
		entityNode.select();
		bot.toolbarButtonWithTooltip("Expand ModelGroup...").click();
		sleep(2);
	}

	@Test
	public void elementUpTest() {
		elementNode.select();
		bot.toolbarButtonWithTooltip("UP...").click();
		sleep(2);
	}

	@Test
	public void elementDownTest() {
		entityNode.expand().getNode("ComplexTypeEntityType").expand()
				.getNode("subelement").select();
		bot.toolbarButtonWithTooltip("DOWN...").click();
	}

	@Test
	public void labelOperationTest() {
		entityNode.select();
		bot.toolbarButtonWithTooltip("Expand...").click();
		sleep();
		bot.comboBoxWithLabel("Language:").setSelection(1);
		bot.buttonWithTooltip("Add...").click();
		sleep(2);
		bot.buttonWithTooltip("Remove...").click();
		sleep(2);
	}
}