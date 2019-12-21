/**
 * 
 */
package com.atanu.java.springboot.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atanu.java.springboot.converter.EntityConverter;
import com.atanu.java.springboot.dao.AncillaryDAO;
import com.atanu.java.springboot.entity.AncillaryDetailsEntity;
import com.atanu.java.springboot.entity.PreferredAncillaryEntity;
import com.atanu.java.springboot.exception.DataSvcException;
import com.atanu.java.springboot.logger.ApplicationLogger;
import com.atanu.java.springboot.model.AncillaryDetails;
import com.atanu.java.springboot.model.PreferredAncillaryRequest;
import com.atanu.java.springboot.model.PreferredAncillaryResponse;

/**
 * @author Atanu Bhowmick
 *
 */

@Service
public class AncillaryMgmtBO {

	@Autowired
	private AncillaryDAO ancillaryDAO;

	@Autowired
	private EntityConverter entityConverter;

	private static final ApplicationLogger logger = new ApplicationLogger(AncillaryMgmtBO.class);
	
	/**
	 * @param ancillaryRequest
	 * @return PreferredAncillaryResponse
	 * @throws DataSvcException 
	 */
	public PreferredAncillaryResponse getPreferredAncillariesByAirports(String originAirportCode, String destAirporCode) throws DataSvcException {
		logger.debug("Inside getDestinationDetailsByAirportCode()");
		List<PreferredAncillaryEntity> prefferedAncillaryList = ancillaryDAO.getPreferredAncillariesByAirports(
				originAirportCode, destAirporCode);
		return entityConverter.convertPreferredAncillaryEntityToPreferredAncillaryResponse(prefferedAncillaryList);
	}

	/**
	 * @param ancillaryRequest
	 * @return int
	 */
	public void updatePreferredAncillary(PreferredAncillaryRequest ancillaryRequest) {
		logger.debug("Inside updatePreferredAncillary()");
		PreferredAncillaryEntity ancillaryEntity = entityConverter.convertPreferredAncillaryRequestToPreferredAncillaryEntity(ancillaryRequest);
		ancillaryDAO.updatePreferredAncillary(ancillaryEntity);
	}
	
	/**
	 * @param ancillaryId
	 * @return AncillaryDetails
	 * @throws DataSvcException 
	 */
	public AncillaryDetails getAncillaryDetailsById(Integer ancillaryId) throws DataSvcException {
		return entityConverter
				.convertAncillaryDetailsEntityToAncillaryDetails(ancillaryDAO
						.getAncillaryDetailsById(ancillaryId));
	}
	
	/**
	 * @param ancillaryName
	 * @return AncillaryDetails
	 */
	public AncillaryDetails getAncillaryDetailsByName(String ancillaryName) {
		return entityConverter
				.convertAncillaryDetailsEntityToAncillaryDetails(ancillaryDAO
						.getAncillaryDetailsByName(ancillaryName));
	}
	
	/**
	 * @return List
	 */
	public List<AncillaryDetails> getAllAncillary() {
		List<AncillaryDetails> ancillaries = new ArrayList<AncillaryDetails>();
		List<AncillaryDetailsEntity> list = ancillaryDAO.getAllAncillaries();
		for (AncillaryDetailsEntity ancillaryDetailsEntity : list){
			ancillaries.add(entityConverter
					.convertAncillaryDetailsEntityToAncillaryDetails(ancillaryDetailsEntity));
		}
		
		return ancillaries;
	}
	
	/**
	 * @param ancillaryRequest
	 * @throws DataSvcException 
	 */
	public AncillaryDetails saveAncillaryDetails(AncillaryDetails ancillaryDetails) throws DataSvcException {
		AncillaryDetailsEntity ancillaryEntity = entityConverter.convertAncillaryDetailsToAncillaryDetailsEntity(ancillaryDetails);
		Integer ancillaryId = ancillaryDAO.saveAncillaryDetails(ancillaryEntity);
		return entityConverter.convertAncillaryDetailsEntityToAncillaryDetails(ancillaryDAO.getAncillaryDetailsById(ancillaryId));
	}
	
	/**
	 * @param ancillaryRequest
	 * @throws DataSvcException 
	 */
	public AncillaryDetails updateAncillaryDetails(AncillaryDetails ancillaryDetails) throws DataSvcException {
		AncillaryDetailsEntity ancillaryEntity = entityConverter.convertAncillaryDetailsToAncillaryDetailsEntity(ancillaryDetails);
		ancillaryDAO.updateAncillaryDetails(ancillaryEntity);
		return entityConverter.convertAncillaryDetailsEntityToAncillaryDetails(ancillaryDAO.getAncillaryDetailsById(ancillaryEntity.getAncillaryId()));
	}
	
	/**
	 * @param ancillaryRequest
	 * @throws DataSvcException 
	 */
	public void deleteAncillaryDetails(int ancillaryId) throws DataSvcException {
		AncillaryDetailsEntity ancillaryEntity = ancillaryDAO.getAncillaryDetailsById(ancillaryId);
		ancillaryDAO.deleteAncillaryDetails(ancillaryEntity);
	}
}
