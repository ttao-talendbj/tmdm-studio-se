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

public class WSPipelineTypedContentEntry_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final QName ns1_output_QNAME = new QName("", "output");
    private static final QName ns3_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
    private CombinedSerializer ns3_myns3_string__java_lang_String_String_Serializer;
    private static final QName ns1_wsExtractedContent_QNAME = new QName("", "wsExtractedContent");
    private static final QName ns2_WSExtractedContent_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSExtractedContent");
    private CombinedSerializer ns2_myWSExtractedContent_LiteralSerializer;
    
    public WSPipelineTypedContentEntry_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public WSPipelineTypedContentEntry_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns3_myns3_string__java_lang_String_String_Serializer = (CombinedSerializer)registry.getSerializer("", java.lang.String.class, ns3_string_TYPE_QNAME);
        ns2_myWSExtractedContent_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSExtractedContent.class, ns2_WSExtractedContent_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSPipelineTypedContentEntry instance = new com.amalto.workbench.webservices.WSPipelineTypedContentEntry();
        Object member=null;
        QName elementName;
        List values;
        Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_output_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_output_QNAME, reader, context);
                instance.setOutput((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_output_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_wsExtractedContent_QNAME)) {
                member = ns2_myWSExtractedContent_LiteralSerializer.deserialize(ns1_wsExtractedContent_QNAME, reader, context);
                instance.setWsExtractedContent((com.amalto.workbench.webservices.WSExtractedContent)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_wsExtractedContent_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSPipelineTypedContentEntry instance = (com.amalto.workbench.webservices.WSPipelineTypedContentEntry)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSPipelineTypedContentEntry instance = (com.amalto.workbench.webservices.WSPipelineTypedContentEntry)obj;
        
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getOutput(), ns1_output_QNAME, null, writer, context);
        ns2_myWSExtractedContent_LiteralSerializer.serialize(instance.getWsExtractedContent(), ns1_wsExtractedContent_QNAME, null, writer, context);
    }
}
