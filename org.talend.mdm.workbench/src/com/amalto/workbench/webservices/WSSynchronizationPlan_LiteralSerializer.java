// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation （1.1.2_01，编译版 R40）
// Generated source version: 1.1.2

package com.amalto.workbench.webservices;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.xsd.XSDConstants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.encoding.literal.DetailFragmentDeserializer;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.ArrayList;

public class WSSynchronizationPlan_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final QName ns1_name_QNAME = new QName("", "name");
    private static final QName ns3_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
    private CombinedSerializer ns3_myns3_string__java_lang_String_String_Serializer;
    private static final QName ns1_description_QNAME = new QName("", "description");
    private static final QName ns1_remoteSystemName_QNAME = new QName("", "remoteSystemName");
    private static final QName ns1_remoteSystemURL_QNAME = new QName("", "remoteSystemURL");
    private static final QName ns1_remoteSystemUsername_QNAME = new QName("", "remoteSystemUsername");
    private static final QName ns1_remoteSystemPassword_QNAME = new QName("", "remoteSystemPassword");
    private static final QName ns1_tisURL_QNAME = new QName("", "tisURL");
    private static final QName ns1_tisUsername_QNAME = new QName("", "tisUsername");
    private static final QName ns1_tisPassword_QNAME = new QName("", "tisPassword");
    private static final QName ns1_tisParameters_QNAME = new QName("", "tisParameters");
    private static final QName ns1_xtentisObjectsSynchronizations_QNAME = new QName("", "xtentisObjectsSynchronizations");
    private static final QName ns2_WSSynchronizationPlan$2d$xtentisObjectsSynchronizations_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSSynchronizationPlan-xtentisObjectsSynchronizations");
    private CombinedSerializer ns2_myWSSynchronizationPlanXtentisObjectsSynchronizations_LiteralSerializer;
    private static final QName ns1_itemsSynchronizations_QNAME = new QName("", "itemsSynchronizations");
    private static final QName ns2_WSSynchronizationPlan$2d$itemsSynchronizations_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSSynchronizationPlan-itemsSynchronizations");
    private CombinedSerializer ns2_myWSSynchronizationPlanItemsSynchronizations_LiteralSerializer;
    
    public WSSynchronizationPlan_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public WSSynchronizationPlan_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns3_myns3_string__java_lang_String_String_Serializer = (CombinedSerializer)registry.getSerializer("", java.lang.String.class, ns3_string_TYPE_QNAME);
        ns2_myWSSynchronizationPlanXtentisObjectsSynchronizations_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizations.class, ns2_WSSynchronizationPlan$2d$xtentisObjectsSynchronizations_TYPE_QNAME);
        ns2_myWSSynchronizationPlanItemsSynchronizations_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSSynchronizationPlanItemsSynchronizations.class, ns2_WSSynchronizationPlan$2d$itemsSynchronizations_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSSynchronizationPlan instance = new com.amalto.workbench.webservices.WSSynchronizationPlan();
        Object member=null;
        QName elementName;
        List values;
        Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_name_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_name_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setName((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_name_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_description_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_description_QNAME, reader, context);
                instance.setDescription((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_description_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_remoteSystemName_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_remoteSystemName_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setRemoteSystemName((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_remoteSystemName_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_remoteSystemURL_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_remoteSystemURL_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setRemoteSystemURL((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_remoteSystemURL_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_remoteSystemUsername_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_remoteSystemUsername_QNAME, reader, context);
                instance.setRemoteSystemUsername((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_remoteSystemUsername_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_remoteSystemPassword_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_remoteSystemPassword_QNAME, reader, context);
                instance.setRemoteSystemPassword((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_remoteSystemPassword_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_tisURL_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_tisURL_QNAME, reader, context);
                instance.setTisURL((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_tisURL_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_tisUsername_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_tisUsername_QNAME, reader, context);
                instance.setTisUsername((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_tisUsername_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_tisPassword_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_tisPassword_QNAME, reader, context);
                instance.setTisPassword((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_tisPassword_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_tisParameters_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_tisParameters_QNAME, reader, context);
                instance.setTisParameters((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_tisParameters_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_xtentisObjectsSynchronizations_QNAME))) {
            values = new ArrayList();
            for(;;) {
                elementName = reader.getName();
                if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_xtentisObjectsSynchronizations_QNAME))) {
                    value = ns2_myWSSynchronizationPlanXtentisObjectsSynchronizations_LiteralSerializer.deserialize(ns1_xtentisObjectsSynchronizations_QNAME, reader, context);
                    if (value == null) {
                        throw new DeserializationException("literal.unexpectedNull");
                    }
                    values.add(value);
                    reader.nextElementContent();
                } else {
                    break;
                }
            }
            member = new com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizations[values.size()];
            member = values.toArray((Object[]) member);
            instance.setXtentisObjectsSynchronizations((com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizations[])member);
        }
        else {
            instance.setXtentisObjectsSynchronizations(new com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizations[0]);
        }
        elementName = reader.getName();
        if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_itemsSynchronizations_QNAME))) {
            values = new ArrayList();
            for(;;) {
                elementName = reader.getName();
                if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_itemsSynchronizations_QNAME))) {
                    value = ns2_myWSSynchronizationPlanItemsSynchronizations_LiteralSerializer.deserialize(ns1_itemsSynchronizations_QNAME, reader, context);
                    if (value == null) {
                        throw new DeserializationException("literal.unexpectedNull");
                    }
                    values.add(value);
                    reader.nextElementContent();
                } else {
                    break;
                }
            }
            member = new com.amalto.workbench.webservices.WSSynchronizationPlanItemsSynchronizations[values.size()];
            member = values.toArray((Object[]) member);
            instance.setItemsSynchronizations((com.amalto.workbench.webservices.WSSynchronizationPlanItemsSynchronizations[])member);
        }
        else {
            instance.setItemsSynchronizations(new com.amalto.workbench.webservices.WSSynchronizationPlanItemsSynchronizations[0]);
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSSynchronizationPlan instance = (com.amalto.workbench.webservices.WSSynchronizationPlan)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSSynchronizationPlan instance = (com.amalto.workbench.webservices.WSSynchronizationPlan)obj;
        
        if (instance.getName() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getName(), ns1_name_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getDescription(), ns1_description_QNAME, null, writer, context);
        if (instance.getRemoteSystemName() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getRemoteSystemName(), ns1_remoteSystemName_QNAME, null, writer, context);
        if (instance.getRemoteSystemURL() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getRemoteSystemURL(), ns1_remoteSystemURL_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getRemoteSystemUsername(), ns1_remoteSystemUsername_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getRemoteSystemPassword(), ns1_remoteSystemPassword_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getTisURL(), ns1_tisURL_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getTisUsername(), ns1_tisUsername_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getTisPassword(), ns1_tisPassword_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getTisParameters(), ns1_tisParameters_QNAME, null, writer, context);
        if (instance.getXtentisObjectsSynchronizations() != null) {
            for (int i = 0; i < instance.getXtentisObjectsSynchronizations().length; ++i) {
                ns2_myWSSynchronizationPlanXtentisObjectsSynchronizations_LiteralSerializer.serialize(instance.getXtentisObjectsSynchronizations()[i], ns1_xtentisObjectsSynchronizations_QNAME, null, writer, context);
            }
        }
        if (instance.getItemsSynchronizations() != null) {
            for (int i = 0; i < instance.getItemsSynchronizations().length; ++i) {
                ns2_myWSSynchronizationPlanItemsSynchronizations_LiteralSerializer.serialize(instance.getItemsSynchronizations()[i], ns1_itemsSynchronizations_QNAME, null, writer, context);
            }
        }
    }
}
