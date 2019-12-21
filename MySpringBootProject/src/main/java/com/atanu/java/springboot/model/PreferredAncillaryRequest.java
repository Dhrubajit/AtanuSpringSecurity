/**
 * 
 */
package com.atanu.java.springboot.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ATANU
 *
 */
@ApiModel(value = "PreferredAncillaryRequest", 
		description = "All details about Preferred Ancillary Request ")
public class PreferredAncillaryRequest implements Serializable {

	private static final long serialVersionUID = 8841272737218591031L;

	@ApiModelProperty(value = "Origin Airport Code", example = "ATL", required = true)
	private String originAirportCode;
	
	@ApiModelProperty(value = "Origin Airport Code", example = "MSP", required = true)
	private String destAirportCode;
	
	@ApiModelProperty(value = "Total count available", example = "5", required = true)
	private Integer ancillaryCount;
	
	@ApiModelProperty(value = "Ancillary Id", example = "101", required = true)
	private Integer ancillaryId;
	
	@ApiModelProperty(value = "Ancillary Name", example = "Wifi", required = true)
	private String ancillaryName;
	
	@ApiModelProperty(value = "Ancillary Description", example = "WiFi available here", required = true)
	private String ancillaryDesc;

	public String getOriginAirportCode() {
		return originAirportCode;
	}

	public void setOriginAirportCode(String originAirportCode) {
		this.originAirportCode = originAirportCode;
	}

	public String getDestAirportCode() {
		return destAirportCode;
	}

	public void setDestAirportCode(String destAirportCode) {
		this.destAirportCode = destAirportCode;
	}
	
	public Integer getAncillaryCount() {
		return ancillaryCount;
	}

	public void setAncillaryCount(Integer ancillaryCount) {
		this.ancillaryCount = ancillaryCount;
	}
	
	public Integer getAncillaryId() {
		return ancillaryId;
	}

	public void setAncillaryId(Integer ancillaryId) {
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

	@Override
	public String toString() {
		return "PreferredAncillaryRequest"
				+ " ["
				+ " originAirportCode : "+ originAirportCode
				+ " destAirportCode : " + destAirportCode
				+ " ]";
	}
}
