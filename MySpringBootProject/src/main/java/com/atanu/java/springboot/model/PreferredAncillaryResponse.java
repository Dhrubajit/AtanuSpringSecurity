/**
 * 
 */
package com.atanu.java.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ATANU
 *
 */

@ApiModel(value = "PreferredAncillaryResponse",
		description = "All details about Preferred Ancillary Response")
public class PreferredAncillaryResponse implements Serializable {

	private static final long serialVersionUID = -5730428775920387647L;

	@ApiModelProperty(value = "Origin Airport Code", example = "ATL")
	private String originAirportCode;
	
	@ApiModelProperty(value = "Destination Airport Code", example = "MSP")
	private String destAirportCode;
	
	@ApiModelProperty(value = "List of Preffered Ancillaries")
	private List<AncillaryDetails> preferredAncillaries;

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

	public List<AncillaryDetails> getPreferredAncillaries() {
		if (null == preferredAncillaries) {
			preferredAncillaries = new ArrayList<AncillaryDetails>();
		}
		return preferredAncillaries;
	}

}
