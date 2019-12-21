/**
 * 
 */
package com.atanu.java.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Atanu Bhowmick
 *
 */

@Entity
@Table(name = "PREFFERED_ANCILLARY", catalog = "PERSONALISED_OFFER_DB")
public class PreferredAncillaryEntity implements Serializable {

	private static final long serialVersionUID = 5264353918215076417L;

	private String id;
	private String originAirportCode;
	private String destAirportCode;
	private int ancillaryCount;
	private AncillaryDetailsEntity ancillaryDetails;

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ORIGIN_AIRPORT_CODE", nullable = false)
	public String getOriginAirportCode() {
		return originAirportCode;
	}

	public void setOriginAirportCode(String originAirportCode) {
		this.originAirportCode = originAirportCode;
	}

	@Column(name = "DEST_AIRPORT_CODE", nullable = false)
	public String getDestAirportCode() {
		return destAirportCode;
	}

	public void setDestAirportCode(String destAirportCode) {
		this.destAirportCode = destAirportCode;
	}

	@Column(name = "ANCILLARY_COUNT", nullable = false)
	public int getAncillaryCount() {
		return ancillaryCount;
	}

	public void setAncillaryCount(int ancillaryCount) {
		this.ancillaryCount = ancillaryCount;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "ANCILLARY_ID", nullable = false)
	public AncillaryDetailsEntity getAncillaryDetails() {
		return ancillaryDetails;
	}

	public void setAncillaryDetails(AncillaryDetailsEntity ancillaryDetails) {
		this.ancillaryDetails = ancillaryDetails;
	}
}
