
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processFileUsingTransformer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processFileUsingTransformer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.talend.com/mdm}WSProcessFileUsingTransformer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processFileUsingTransformer", propOrder = {
    "arg0"
})
public class ProcessFileUsingTransformer {

    protected WSProcessFileUsingTransformer arg0;

    /**
     * Default no-arg constructor
     * 
     */
    public ProcessFileUsingTransformer() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ProcessFileUsingTransformer(final WSProcessFileUsingTransformer arg0) {
        this.arg0 = arg0;
    }

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link WSProcessFileUsingTransformer }
     *     
     */
    public WSProcessFileUsingTransformer getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSProcessFileUsingTransformer }
     *     
     */
    public void setArg0(WSProcessFileUsingTransformer value) {
        this.arg0 = value;
    }

}
