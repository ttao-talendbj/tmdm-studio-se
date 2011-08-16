/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmserverobject.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmserverobjectFactoryImpl extends EFactoryImpl implements MdmserverobjectFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MdmserverobjectFactory init() {
        try {
            MdmserverobjectFactory theMdmserverobjectFactory = (MdmserverobjectFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/mdmserverobject"); 
            if (theMdmserverobjectFactory != null) {
                return theMdmserverobjectFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MdmserverobjectFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case MdmserverobjectPackage.MDM_SERVER_OBJECT: return createMDMServerObject();
            case MdmserverobjectPackage.WS_MENU_E: return createWSMenuE();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E: return createWSMenuEntryE();
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E: return createWSMenuMenuEntriesDescriptionsE();
            case MdmserverobjectPackage.WS_ROLE_E: return createWSRoleE();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E: return createWSRoleSpecificationE();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E: return createWSRoleSpecificationInstanceE();
            case MdmserverobjectPackage.WS_VIEW_E: return createWSViewE();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E: return createWSWhereConditionE();
            case MdmserverobjectPackage.WS_WHERE_OPERATOR_E: return createWSWhereOperatorE();
            case MdmserverobjectPackage.WS_STRING_PREDICATE_E: return createWSStringPredicateE();
            case MdmserverobjectPackage.WS_DATA_MODEL_E: return createWSDataModelE();
            case MdmserverobjectPackage.WS_DATA_CLUSTER_E: return createWSDataClusterE();
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E: return createWSStoredProcedureE();
            case MdmserverobjectPackage.WS_UNIVERSE_E: return createWSUniverseE();
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E: return createWSUniverseXtentisObjectsRevisionIDsE();
            case MdmserverobjectPackage.WS_UNIVERSE_ITEMS_REVISION_IDS_E: return createWSUniverseItemsRevisionIDsE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_E: return createWSSynchronizationPlanE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E: return createWSSynchronizationPlanItemsSynchronizationsE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E: return createWSSynchronizationPlanXtentisObjectsSynchronizationsE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E: return createWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE();
            case MdmserverobjectPackage.WS_BOOLEAN_E: return createWSBooleanE();
            case MdmserverobjectPackage.WS_WORKFLOW_DEPLOY_E: return createWSWorkflowDeployE();
            case MdmserverobjectPackage.WS_TRANSFORMER_V2E: return createWSTransformerV2E();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E: return createWSTransformerProcessStepE();
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E: return createWSTransformerVariablesMappingE();
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E: return createWSTypedContentE();
            case MdmserverobjectPackage.WS_BYTE_ARRAY_E: return createWSByteArrayE();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E: return createWSRoutingRuleE();
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E: return createWSRoutingRuleExpressionE();
            case MdmserverobjectPackage.WS_ROUTING_RULE_OPERATOR_E: return createWSRoutingRuleOperatorE();
            case MdmserverobjectPackage.WS_JOB_MODEL_E: return createWSJobModelE();
            case MdmserverobjectPackage.WS_EVENT_MANAGER_E: return createWSEventManagerE();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMServerObject createMDMServerObject() {
        MDMServerObjectImpl mdmServerObject = new MDMServerObjectImpl();
        return mdmServerObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuE createWSMenuE() {
        WSMenuEImpl wsMenuE = new WSMenuEImpl();
        return wsMenuE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuEntryE createWSMenuEntryE() {
        WSMenuEntryEImpl wsMenuEntryE = new WSMenuEntryEImpl();
        return wsMenuEntryE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuMenuEntriesDescriptionsE createWSMenuMenuEntriesDescriptionsE() {
        WSMenuMenuEntriesDescriptionsEImpl wsMenuMenuEntriesDescriptionsE = new WSMenuMenuEntriesDescriptionsEImpl();
        return wsMenuMenuEntriesDescriptionsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleE createWSRoleE() {
        WSRoleEImpl wsRoleE = new WSRoleEImpl();
        return wsRoleE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleSpecificationE createWSRoleSpecificationE() {
        WSRoleSpecificationEImpl wsRoleSpecificationE = new WSRoleSpecificationEImpl();
        return wsRoleSpecificationE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleSpecificationInstanceE createWSRoleSpecificationInstanceE() {
        WSRoleSpecificationInstanceEImpl wsRoleSpecificationInstanceE = new WSRoleSpecificationInstanceEImpl();
        return wsRoleSpecificationInstanceE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSViewE createWSViewE() {
        WSViewEImpl wsViewE = new WSViewEImpl();
        return wsViewE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSWhereConditionE createWSWhereConditionE() {
        WSWhereConditionEImpl wsWhereConditionE = new WSWhereConditionEImpl();
        return wsWhereConditionE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSWhereOperatorE createWSWhereOperatorE() {
        WSWhereOperatorEImpl wsWhereOperatorE = new WSWhereOperatorEImpl();
        return wsWhereOperatorE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSStringPredicateE createWSStringPredicateE() {
        WSStringPredicateEImpl wsStringPredicateE = new WSStringPredicateEImpl();
        return wsStringPredicateE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSDataModelE createWSDataModelE() {
        WSDataModelEImpl wsDataModelE = new WSDataModelEImpl();
        return wsDataModelE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSDataClusterE createWSDataClusterE() {
        WSDataClusterEImpl wsDataClusterE = new WSDataClusterEImpl();
        return wsDataClusterE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSStoredProcedureE createWSStoredProcedureE() {
        WSStoredProcedureEImpl wsStoredProcedureE = new WSStoredProcedureEImpl();
        return wsStoredProcedureE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSUniverseE createWSUniverseE() {
        WSUniverseEImpl wsUniverseE = new WSUniverseEImpl();
        return wsUniverseE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSUniverseXtentisObjectsRevisionIDsE createWSUniverseXtentisObjectsRevisionIDsE() {
        WSUniverseXtentisObjectsRevisionIDsEImpl wsUniverseXtentisObjectsRevisionIDsE = new WSUniverseXtentisObjectsRevisionIDsEImpl();
        return wsUniverseXtentisObjectsRevisionIDsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSUniverseItemsRevisionIDsE createWSUniverseItemsRevisionIDsE() {
        WSUniverseItemsRevisionIDsEImpl wsUniverseItemsRevisionIDsE = new WSUniverseItemsRevisionIDsEImpl();
        return wsUniverseItemsRevisionIDsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSSynchronizationPlanE createWSSynchronizationPlanE() {
        WSSynchronizationPlanEImpl wsSynchronizationPlanE = new WSSynchronizationPlanEImpl();
        return wsSynchronizationPlanE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSSynchronizationPlanItemsSynchronizationsE createWSSynchronizationPlanItemsSynchronizationsE() {
        WSSynchronizationPlanItemsSynchronizationsEImpl wsSynchronizationPlanItemsSynchronizationsE = new WSSynchronizationPlanItemsSynchronizationsEImpl();
        return wsSynchronizationPlanItemsSynchronizationsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSSynchronizationPlanXtentisObjectsSynchronizationsE createWSSynchronizationPlanXtentisObjectsSynchronizationsE() {
        WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl wsSynchronizationPlanXtentisObjectsSynchronizationsE = new WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl();
        return wsSynchronizationPlanXtentisObjectsSynchronizationsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE createWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE() {
        WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE = new WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl();
        return wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSBooleanE createWSBooleanE() {
        WSBooleanEImpl wsBooleanE = new WSBooleanEImpl();
        return wsBooleanE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSWorkflowDeployE createWSWorkflowDeployE() {
        WSWorkflowDeployEImpl wsWorkflowDeployE = new WSWorkflowDeployEImpl();
        return wsWorkflowDeployE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSTransformerV2E createWSTransformerV2E() {
        WSTransformerV2EImpl wsTransformerV2E = new WSTransformerV2EImpl();
        return wsTransformerV2E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSTransformerProcessStepE createWSTransformerProcessStepE() {
        WSTransformerProcessStepEImpl wsTransformerProcessStepE = new WSTransformerProcessStepEImpl();
        return wsTransformerProcessStepE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSTransformerVariablesMappingE createWSTransformerVariablesMappingE() {
        WSTransformerVariablesMappingEImpl wsTransformerVariablesMappingE = new WSTransformerVariablesMappingEImpl();
        return wsTransformerVariablesMappingE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSTypedContentE createWSTypedContentE() {
        WSTypedContentEImpl wsTypedContentE = new WSTypedContentEImpl();
        return wsTypedContentE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSByteArrayE createWSByteArrayE() {
        WSByteArrayEImpl wsByteArrayE = new WSByteArrayEImpl();
        return wsByteArrayE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoutingRuleE createWSRoutingRuleE() {
        WSRoutingRuleEImpl wsRoutingRuleE = new WSRoutingRuleEImpl();
        return wsRoutingRuleE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoutingRuleExpressionE createWSRoutingRuleExpressionE() {
        WSRoutingRuleExpressionEImpl wsRoutingRuleExpressionE = new WSRoutingRuleExpressionEImpl();
        return wsRoutingRuleExpressionE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoutingRuleOperatorE createWSRoutingRuleOperatorE() {
        WSRoutingRuleOperatorEImpl wsRoutingRuleOperatorE = new WSRoutingRuleOperatorEImpl();
        return wsRoutingRuleOperatorE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSJobModelE createWSJobModelE() {
        WSJobModelEImpl wsJobModelE = new WSJobModelEImpl();
        return wsJobModelE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSEventManagerE createWSEventManagerE() {
        WSEventManagerEImpl wsEventManagerE = new WSEventManagerEImpl();
        return wsEventManagerE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectPackage getMdmserverobjectPackage() {
        return (MdmserverobjectPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MdmserverobjectPackage getPackage() {
        return MdmserverobjectPackage.eINSTANCE;
    }

} //MdmserverobjectFactoryImpl
