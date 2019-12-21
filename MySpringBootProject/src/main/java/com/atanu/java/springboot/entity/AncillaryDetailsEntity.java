/**
 * 
 */
package com.atanu.java.springboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Atanu Bhowmick
 *
 */

@Entity
@Table(name = "ANCILLARY_DETAILS", catalog = "PERSONALISED_OFFER_DB")
public class AncillaryDetailsEntity implements Serializable {

	private static final long serialVersionUID = 6361407413701418511L;

	private Integer ancillaryId;
	private String ancillaryName;
	private String ancillaryDesc;
	private List<PreferredAncillaryEntity> preferredAncillaries = new ArrayList<PreferredAncillaryEntity>();

	/*@SequenceGenerator(name = "ANC_ID_GEN", initialValue = 101, allocationSize = 100, sequenceName = "ANCILLARY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANC_ID_GEN")*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ANCILLARY_ID", nullable = true)
	public Integer getAncillaryId() {
		return ancillaryId;
	}

	public void setAncillaryId(Integer ancillaryId) {
		this.ancillaryId = ancillaryId;
	}

	@Column(name = "ANCILLARY_NAME", nullable = false, unique = true)
	public String getAncillaryName() {
		return ancillaryName;
	}

	public void setAncillaryName(String ancillaryName) {
		this.ancillaryName = ancillaryName;
	}

	@Column(name = "ANCILLARY_DESC", nullable = false, unique = true)
	public String getAncillaryDesc() {
		return ancillaryDesc;
	}

	public void setAncillaryDesc(String ancillaryDesc) {
		this.ancillaryDesc = ancillaryDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ancillaryDetails")
	public List<PreferredAncillaryEntity> getPreferredAncillaries() {
		return preferredAncillaries;
	}

	public void setPreferredAncillaries(List<PreferredAncillaryEntity> preferredAncillaries) {
		this.preferredAncillaries = preferredAncillaries;
	}
}