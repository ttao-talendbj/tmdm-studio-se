package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class VariableDefinitionDialog extends Dialog{
    
	protected TableViewer descriptionsViewer;
	private String outPut;
	private boolean inputVariable;
	
	private ArrayList<String> inputList = new ArrayList<String>();
	private static String title = "Variable Assignment";
	
	private static String SMART_VIEW_TRANSFORMER = "Smart_view";
	private static String BEFORE_SAVING_TRANSFORMER = "beforeSaving";
	
	private static final String VARIABLE_DEFAULT = "DEFAULT";
	private static final String VARIABLE_OUTPUT_OF_BEFORESAVINGTRANFORMER = "OUTPUT_OF_BEFORESAVINGTRANFORMER";
	private static final String VARIABLE_OUTPUT_TO_ITEMDISPATCHERSERVICE = "OUTPUT_TO_ITEMDISPATCHERSERVICE";
	private static final String VARIABLE_OUTPUT_FOR_SMARTVIEW = "OUTPUT_FOR_SMARTVIEW";
	
	private static HashMap<String, String> descriptionMap = new HashMap<String, String>();
	static
	{
		descriptionMap.put(VARIABLE_DEFAULT, "_DEFAULT_");
		descriptionMap.put(VARIABLE_OUTPUT_OF_BEFORESAVINGTRANFORMER, "output_error_message");
		descriptionMap.put(VARIABLE_OUTPUT_TO_ITEMDISPATCHERSERVICE, "output_to_itemdispatcher");
		descriptionMap.put(VARIABLE_OUTPUT_FOR_SMARTVIEW, "html");
	}
	
	public VariableDefinitionDialog(Shell shell, String type, boolean input, String plugin)
	{
		super(shell);
		
		inputVariable = input;
		String transformType = type;
		transformType = transformType.split(" ")[1];
		
		if (transformType.startsWith(SMART_VIEW_TRANSFORMER) && plugin.equals("xslt"))
		{
			if (input)
				inputList.add(VARIABLE_DEFAULT);
			else
				inputList.add(VARIABLE_OUTPUT_FOR_SMARTVIEW);
		}
		else if (transformType.startsWith(BEFORE_SAVING_TRANSFORMER))
		{
			if (input)
				inputList.add(VARIABLE_DEFAULT);
			else
			{
				inputList.add(VARIABLE_OUTPUT_OF_BEFORESAVINGTRANFORMER);
				inputList.add(VARIABLE_OUTPUT_TO_ITEMDISPATCHERSERVICE);	
			}
		}
	}
	
	protected Control createDialogArea(Composite parent) {
		
		parent.getShell().setText(title);
		
		Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 2;
		
        descriptionsViewer = new TableViewer(composite,SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER|SWT.FULL_SELECTION);
        descriptionsViewer.getControl().setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
        );
        ((GridData)descriptionsViewer.getControl().getLayoutData()).heightHint=100;
        // Set up the underlying table
        Table table = descriptionsViewer.getTable();
        final String columnTitle = "Available Variables";
        new TableColumn(table, SWT.CENTER).setText(columnTitle);
        table.getColumn(0).setWidth(350);
        
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
       
        CellEditor[] editors = new CellEditor[1];
        editors[0] = new TextCellEditor(table);
        descriptionsViewer.setCellEditors(editors);
        
        descriptionsViewer.setContentProvider(new IStructuredContentProvider() {
        	public void dispose() {}
        	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
        	public Object[] getElements(Object inputElement) {
        		ArrayList<String> descs = (ArrayList<String>)inputElement; 
        		return descs.toArray();
        	}
        });
        
        //set the label provider
        descriptionsViewer.setLabelProvider(new ITableLabelProvider() {
        	public boolean isLabelProperty(Object element, String property) {return false;}
        	public void dispose() {}
        	public void addListener(ILabelProviderListener listener) {}
        	public void removeListener(ILabelProviderListener listener) {}
        	public String getColumnText(Object element, int columnIndex) {
        		return element.toString().toLowerCase();
        	}
        	public Image getColumnImage(Object element, int columnIndex) {return null;}
        });
        
        descriptionsViewer.setColumnProperties(new String[]{columnTitle});
        
        descriptionsViewer.setCellModifier(new ICellModifier() {
        	public boolean canModify(Object element, String property) {
        		return false;
        	}
        	public void modify(Object element, String property, Object value) {
        	}
        	public Object getValue(Object element, String property) {
        		return element.toString();
        	}
        });
        
        descriptionsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
        	public void selectionChanged(SelectionChangedEvent event){
        		IStructuredSelection selection = (IStructuredSelection)event.getSelection();
        		outPut = (String)selection.getFirstElement();
        		getButton(IDialogConstants.OK_ID).setEnabled(true);
        	}
        });
		
		descriptionsViewer.setInput(inputList);
        descriptionsViewer.refresh();
        
        return composite;
	}
	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
	}
	
	public String outPutVariable()
	{
		return descriptionMap.get(outPut);
	}
}
