/**
 * 
 */
package com.afirme.afirmenet.model;

import java.sql.Timestamp;
import java.util.Date;

import com.afirme.afirmenet.model.base.ModelBase;

/**
 * Clase para mapeo y transporte de informacion de la tabla DC_PROPERTY
 * @author 0cdcarguz
 * 
 */
public class DCProperty implements ModelBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int propertyId;
	private String name;
	private String description;
	private String value;
	private int legalType;
	private int propertyType;
	private Timestamp opdate;
	private String opuser;
	private Timestamp modate;
	private String mouser;
	   
	/**
	 * @return the propertyId
	 */
	public long getPropertyId() {
		return propertyId;
	}
	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the legalType
	 */
	public int getLegalType() {
		return legalType;
	}
	/**
	 * @param legalType the legalType to set
	 */
	public void setLegalType(int legalType) {
		this.legalType = legalType;
	}
	/**
	 * @return the propertyType
	 */
	public int getPropertyType() {
		return propertyType;
	}
	/**
	 * @param propertyType the propertyType to set
	 */
	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}
	/**
	 * @return the opdate
	 */
	public Date getOpdate() {
		return opdate;
	}
	/**
	 * @param opdate the opdate to set
	 */
	public void setOpdate(Timestamp opdate) {
		this.opdate = opdate;
	}
	/**
	 * @return the opuser
	 */
	public String getOpuser() {
		return opuser;
	}
	/**
	 * @param opuser the opuser to set
	 */
	public void setOpuser(String opuser) {
		this.opuser = opuser;
	}
	/**
	 * @return the modate
	 */
	public Date getModate() {
		return modate;
	}
	/**
	 * @param modate the modate to set
	 */
	public void setModate(Timestamp modate) {
		this.modate = modate;
	}
	/**
	 * @return the mouser
	 */
	public String getMouser() {
		return mouser;
	}
	/**
	 * @param mouser the mouser to set
	 */
	public void setMouser(String mouser) {
		this.mouser = mouser;
	}
}
