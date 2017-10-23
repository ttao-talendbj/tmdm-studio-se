// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.dialogs.datamodel.IXPathSelectionFilter;
import com.amalto.workbench.dialogs.datamodel.IXPathSelectionFilter.FilterResult;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDUtil {

    private static final String X_FOREIGN_KEY = "X_ForeignKey"; //$NON-NLS-1$

    public static final int VALIDATE_DATE = 1;

    public static final int VALIDATE_TIME = 2;

    public static final int VALIDATE_DATE_TIME = 4;

    public static String getAnnotationValue(XSDElementDeclaration elementDesc, String key) {
        XSDAnnotation annotation = elementDesc.getAnnotation();
        if (annotation != null) {
            EList<Element> applicationInformation = annotation.getApplicationInformation();
            if (applicationInformation != null) {
                for (Element element : applicationInformation) {
                    if (element.getLocalName().equalsIgnoreCase("appinfo")) { //$NON-NLS-1$
                        String source = element.getAttribute("source"); //$NON-NLS-1$
                        if (key.equalsIgnoreCase(source)) {
                            NodeList childNodes = element.getChildNodes();
                            String nodeValue = null;
                            if (childNodes.getLength() > 0) {
                                Node node = childNodes.item(0);
                                nodeValue = node.getNodeValue();
                            }
                            return nodeValue;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static List<String> getEntityName(XSDSchema schema) {

        List<String> names = new LinkedList<String>();
        if (schema != null) {
            for (XSDElementDeclaration elem : schema.getElementDeclarations()) {
                names.add(elem.getName());
            }
        }
        return names;

    }

    public static boolean hasFKInfo(XSDElementDeclaration elementDeclaration) {
        String value = XSDUtil.getAnnotationValue(elementDeclaration, X_FOREIGN_KEY);
        return value != null;
    }

    public static boolean isValidatedXSDName(String newText) {
        boolean result = false;
        if (newText != null) {
            Pattern pattern = Pattern.compile("([a-zA-Z][-|\\.|\\w]*\\w)|[a-zA-Z]"); //$NON-NLS-1$
            result = pattern.matcher(newText).matches();
        }

        return result;
    }

    private static List<String> builtInTypes = null;

    public static List<String> getBuiltInTypes() {
        if (builtInTypes == null) {
            builtInTypes = new LinkedList<String>();
            builtInTypes.add("anyURI"); //$NON-NLS-1$
            builtInTypes.add("base64Binary"); //$NON-NLS-1$
            builtInTypes.add("boolean"); //$NON-NLS-1$
            builtInTypes.add("byte"); //$NON-NLS-1$
            builtInTypes.add("date"); //$NON-NLS-1$
            builtInTypes.add("dateTime"); //$NON-NLS-1$
            builtInTypes.add("decimal"); //$NON-NLS-1$
            builtInTypes.add("double"); //$NON-NLS-1$
            builtInTypes.add("duration"); //$NON-NLS-1$
            builtInTypes.add("float"); //$NON-NLS-1$
            builtInTypes.add("hexBinary"); //$NON-NLS-1$
            builtInTypes.add("int"); //$NON-NLS-1$
            builtInTypes.add("integer"); //$NON-NLS-1$
            builtInTypes.add("language"); //$NON-NLS-1$
            builtInTypes.add("long"); //$NON-NLS-1$
            builtInTypes.add("negativeInteger"); //$NON-NLS-1$
            builtInTypes.add("nonNegativeInteger"); //$NON-NLS-1$
            builtInTypes.add("nonPositiveInteger"); //$NON-NLS-1$
            builtInTypes.add("normalizedString"); //$NON-NLS-1$
            builtInTypes.add("positiveInteger"); //$NON-NLS-1$
            builtInTypes.add("short"); //$NON-NLS-1$
            builtInTypes.add("string"); //$NON-NLS-1$
            builtInTypes.add("time"); //$NON-NLS-1$
            builtInTypes.add("token"); //$NON-NLS-1$
            builtInTypes.add("unsignedByte"); //$NON-NLS-1$
            builtInTypes.add("unsignedInt"); //$NON-NLS-1$
            builtInTypes.add("unsignedLong"); //$NON-NLS-1$
            builtInTypes.add("unsignedShort"); //$NON-NLS-1$

        }
        return builtInTypes;
    }

    private static final String DIVIDE = "/"; //$NON-NLS-1$

    public static Set<String> getValidElementPaths(XSDElementDeclaration ed, IXPathSelectionFilter filter) {

        String curPrefix = ed.getName() + DIVIDE;
        XSDTypeDefinition type = ed.getType();
        Set<String> paths = new HashSet<String>();
        if (type instanceof XSDComplexTypeDefinition) {
            XSDParticle particle = type.getComplexType();
            iterateParticle(particle, filter, paths, curPrefix);

        }

        return paths;
    }

    private static void iterateParticle(XSDParticle particle, IXPathSelectionFilter filter, Set<String> paths, String prefix) {
        XSDTerm term = particle.getTerm();
        if (term instanceof XSDModelGroup) {
            EList<XSDParticle> contents = ((XSDModelGroup) term).getContents();
            for (XSDParticle p : contents) {
                XSDTerm t = p.getTerm();
                if (t instanceof XSDElementDeclaration) {
                    XSDElementDeclaration element = ((XSDElementDeclaration) t);
                    FilterResult r = filter.check(p);
                    if (r == FilterResult.ENABLE) {
                        String path = prefix + element.getName();
                        paths.add(path);
                    } else {
                        XSDTypeDefinition type = element.getType();
                        if (type instanceof XSDComplexTypeDefinition) {
                            String nextPrefix = prefix + element.getName() + DIVIDE;
                            XSDParticle cp = type.getComplexType();
                            iterateParticle(cp, filter, paths, nextPrefix);

                        }
                    }

                }

            }
        }
    }

    public static boolean isEntity(Object obj) {
        if (obj instanceof XSDElementDeclaration) {
            XSDElementDeclaration xsdElementDec = (XSDElementDeclaration) obj;
            if (xsdElementDec.getRootContainer() == xsdElementDec.getContainer()
                    && !xsdElementDec.getIdentityConstraintDefinitions().isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFirstLevelChild(XSDParticle particle) {
        XSDSchema schema = (XSDSchema) particle.getRootContainer();
        Map<XSDElementDeclaration, List<XSDComplexTypeDefinition>> entityMapComplexTypes = buildEntityUsedComplexTypeMap(schema);

        Iterator<XSDElementDeclaration> iterator = entityMapComplexTypes.keySet().iterator();
        while(iterator.hasNext()) {
            XSDElementDeclaration concept = iterator.next();
            List<XSDComplexTypeDefinition> ctypes = entityMapComplexTypes.get(concept);
            for (XSDComplexTypeDefinition ctype : ctypes) {
                XSDComplexTypeContent ctypeContent = ctype.getContent();
                if (ctypeContent instanceof XSDParticle) {
                    XSDParticle typeParticle = (XSDParticle) ctypeContent;
                    XSDParticleContent particleContent = typeParticle.getContent();
                    if (particleContent instanceof XSDModelGroup) {
                        XSDModelGroup particleGroup = (XSDModelGroup) particleContent;
                        if (particleGroup.getContents().contains(particle)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static Map<XSDElementDeclaration,List<XSDComplexTypeDefinition>> buildEntityUsedComplexTypeMap(XSDSchema schema) {
        Map<XSDElementDeclaration, List<XSDComplexTypeDefinition>> entityMapComplexType = new HashMap<XSDElementDeclaration, List<XSDComplexTypeDefinition>>();

        EList<XSDSchemaContent> contents = schema.getContents();
        for (XSDSchemaContent content : contents) {
            if (content instanceof XSDElementDeclaration) {
                XSDElementDeclaration concept = (XSDElementDeclaration) content;
                XSDComplexTypeDefinition ctypeDef = (XSDComplexTypeDefinition) concept.getTypeDefinition();
                List<XSDComplexTypeDefinition> ctypes = new ArrayList<XSDComplexTypeDefinition>();
                ctypes.add(ctypeDef);
                while (ctypeDef.getBaseTypeDefinition() != ((XSDComplexTypeDefinition) ctypeDef.getBaseTypeDefinition())
                        .getBaseTypeDefinition()) {
                    ctypes.add((XSDComplexTypeDefinition) ctypeDef.getBaseTypeDefinition());
                    ctypeDef = (XSDComplexTypeDefinition) ctypeDef.getBaseTypeDefinition();
                }

                entityMapComplexType.put(concept, ctypes);
            }
        }

        return entityMapComplexType;
    }

    public static boolean isSimpleTypeElement(XSDParticle particle) {
        XSDTerm term = particle.getTerm();
        if (term instanceof XSDElementDeclaration) {
            XSDElementDeclaration element = ((XSDElementDeclaration) term);
            XSDTypeDefinition type = element.getType();
            if (type instanceof XSDSimpleTypeDefinition) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPrimaryKeyElement(XSDParticle particle) {
        if(isSimpleTypeElement(particle)) {
            Map<XSDElementDeclaration, List<XSDComplexTypeDefinition>> entityMapComplexTypes = buildEntityUsedComplexTypeMap(
                    (XSDSchema) particle.getRootContainer());

            Iterator<XSDElementDeclaration> iterator = entityMapComplexTypes.keySet().iterator();
            while(iterator.hasNext()) {
                XSDElementDeclaration concept = iterator.next();
                List<String> keyFields  = getKeyFields(concept);

                if(keyFields.contains(((XSDElementDeclaration)particle.getTerm()).getName())) {
                    List<XSDComplexTypeDefinition> ctypes = entityMapComplexTypes.get(concept);
                    for (XSDComplexTypeDefinition ctype : ctypes) {
                        XSDComplexTypeContent ctypeContent = ctype.getContent();
                        if (ctypeContent instanceof XSDParticle) {
                            XSDParticle typeParticle = (XSDParticle) ctypeContent;
                            XSDParticleContent particleContent = typeParticle.getContent();
                            if (particleContent instanceof XSDModelGroup) {
                                XSDModelGroup particleGroup = (XSDModelGroup) particleContent;
                                if(particleGroup.getContents().contains(particle)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }

        }

        return false;
    }

    public static List<String> getKeyFields(XSDElementDeclaration concept) {
        List<String> keyFields = new ArrayList<String>();

        EList<XSDIdentityConstraintDefinition> identityConstraintDefinitions = concept.getIdentityConstraintDefinitions();
        for(XSDIdentityConstraintDefinition icd:identityConstraintDefinitions) {
            if(concept.getName().equals(icd.getName())) {
                EList<XSDXPathDefinition> fields = icd.getFields();
                for(XSDXPathDefinition xpathdef:fields) {
                    keyFields.add(xpathdef.getValue());
                }
            }
        }
        return keyFields;
    }

    public static List<String> getAllPKXpaths(XSDSchema schema) {
        List<String> entity2xpaths = new LinkedList<String>();

        if (schema != null) {
            for (XSDSchemaContent content : schema.getContents()) {
                if (isEntity(content)) {
                    XSDElementDeclaration concept = (XSDElementDeclaration) content;
                    List<String> keyFields = getKeyFields(concept);
                    entity2xpaths.add(0, concept.getName());
                    for (String pkfield : keyFields) {
                        entity2xpaths.add(concept.getName() + "/" + pkfield); //$NON-NLS-1$
                    }
                }
            }
        }

        return entity2xpaths;
    }

    public static boolean isValidatedXSDDate(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            return true;
        }
        String regex = "([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?";//$NON-NLS-1$
        return matches(regex, newText);
    }

    public static boolean isValidatedXSDDateTime(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            return true;
        }
        String regex = "([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?|(24:00:00(\\.0+)?))(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?";//$NON-NLS-1$
        return matches(regex, newText);
    }

    public static boolean isValidatedXSDTime(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            return true;
        }
        String regex = "(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?|(24:00:00(\\.0+)?))(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?";//$NON-NLS-1$
        return matches(regex, newText);
    }

    public static boolean isValidatedXSDDate(int key, String newText) {
        switch (key) {
        case VALIDATE_DATE:
            return isValidatedXSDDate(newText);
        case VALIDATE_TIME:
            return isValidatedXSDTime(newText);
        case VALIDATE_DATE_TIME:
            return isValidatedXSDDateTime(newText);

        default:
            throw new IllegalArgumentException();

        }
    }

    private static boolean matches(String regex, String newText) {
        Pattern pattern = Pattern.compile(regex);
        boolean match = pattern.matcher(newText).matches();
        return match;
    }
}
