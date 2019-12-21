/**
 * 
 */
package com.atanu.java.springboot.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Atanu Bhowmick
 *
 */
@ApiModel(value = "AncillaryDetails", description = "All details about ancillary")
public class AncillaryDetails implements Serializable {

	private static final long serialVersionUID = -3429123474397175306L;
	
	@ApiModelProperty(value = "Ancillary Id", example = "101")
	private String ancillaryId;
	
	@ApiModelProperty(value = "Ancillary Name", example = "WiFi")
	private String ancillaryName;
	
	@ApiModelProperty(value = "Ancillary Decsription", example = "WiFi availabe inside")
	private String ancillaryDesc;

	public AncillaryDetails() {
	}

	public AncillaryDetails(String ancillaryId, String ancillaryName,
			String ancillaryDesc) {
		this.ancillaryId = ancillaryId;
		this.ancillaryName = ancillaryName;
		this.ancillaryDesc = ancillaryDesc;
	}

	public String getAncillaryId() {
		return ancillaryId;
	}

	public void setAncillaryId(String ancillaryId) {
		this.ancillaryId = ancillaryId;
	}

	public String getAncillaryName() {
		return ancillaryName;
	}

	public void setAncillaryName(String ancillaryName) {
		this.ancillaryName = ancillaryName;
	}

	public String getAncillaryDesc() {
		return ancillaryDesc;
	}

	public void setAncillaryDesc(String ancillaryDesc) {
		this.ancillaryDesc = ancillaryDesc;
	}
}
