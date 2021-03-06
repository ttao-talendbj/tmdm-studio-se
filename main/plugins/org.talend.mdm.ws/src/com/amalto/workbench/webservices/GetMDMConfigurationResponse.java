
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMDMConfigurationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMDMConfigurationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}WSMDMConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMDMConfigurationResponse", propOrder = {
    "_return"
})
public class GetMDMConfigurationResponse {

    @XmlElement(name = "return")
    protected WSMDMConfig _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetMDMConfigurationResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetMDMConfigurationResponse(final WSMDMConfig _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WSMDMConfig }
     *     
     */
    public WSMDMConfig getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSMDMConfig }
     *     
     */
    public void setReturn(WSMDMConfig value) {
        this._return = value;
    }

}
