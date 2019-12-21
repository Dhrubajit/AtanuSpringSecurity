/**
 * 
 */
package com.atanu.java.springboot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atanu.java.springboot.bo.AncillaryMgmtBO;
import com.atanu.java.springboot.constant.Constants;
import com.atanu.java.springboot.exception.DataSvcException;
import com.atanu.java.springboot.logger.ApplicationLogger;
import com.atanu.java.springboot.model.AncillaryDetails;
import com.atanu.java.springboot.model.FaultDO;
import com.atanu.java.springboot.model.PreferredAncillaryRequest;
import com.atanu.java.springboot.model.PreferredAncillaryResponse;
import com.atanu.java.springboot.utils.StringUtils;
import com.atanu.java.springboot.validator.RequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Atanu Bhowmick
 *
 */

@RestController
@RequestMapping(value = Constants.PATH_ANCILLARY)
@Api(value = "Ancillary Management System in DB")
@PreAuthorize("hasAnyRole('ROLE_CLIENT', 'ROLE_USER', 'ROLE_ADMIN')")
public class AncillaryDataSvc {

	@Autowired
	private AncillaryMgmtBO ancillaryMgmtBO;

	@Autowired
	RequestValidator requestValidator;
	
	private static final ApplicationLogger logger = new ApplicationLogger(AncillaryDataSvc.class);

	@ApiOperation(value = "Get ancilarry by Id", response = AncillaryDetails.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved the ancillary"),
			@ApiResponse(code = 404, message = Constants.ERROR_MSG_2006, response = FaultDO.class),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) 
	})
	@RequestMapping(value = "/{ancillaryId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AncillaryDetails> getAncillary(
			@ApiParam(value = "Ancillary Id in path param", required = true)
			@PathVariable("ancillaryId") Integer ancillaryId)
			throws DataSvcException {
		logger.debug("Inside getAncillary()");
		AncillaryDetails ancillaryDetails = ancillaryMgmtBO.getAncillaryDetailsById(ancillaryId);
		return new ResponseEntity<>(ancillaryDetails, HttpStatus.OK);
	}

	@ApiOperation(value = "Get ancilarry by Id", response = AncillaryDetails.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved the ancillary"),
			@ApiResponse(code = 404, message = Constants.ERROR_MSG_2006, response = FaultDO.class),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) })
	@RequestMapping(value = Constants.PATH_GET_ANCILLARY, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AncillaryDetails> getAncillaryById(
			@ApiParam(value = "Ancillary Id in request param", required = true) 
			@RequestParam(required = true) Integer ancillaryId) throws DataSvcException {
		logger.debug("Inside getAncillaryById()");
		AncillaryDetails ancillaryDetails = ancillaryMgmtBO.getAncillaryDetailsById(ancillaryId);
		return new ResponseEntity<>(ancillaryDetails, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all ancilarries", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved the ancillary"),
			@ApiResponse(code = 404, message = Constants.ERROR_MSG_2006, response = FaultDO.class),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) 
	})
	@RequestMapping(value = Constants.PATH_GET_ALL_ANCILLARY, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<AncillaryDetails>> getAllAncillaries() {
		logger.debug("Inside getAllAncillaries()");
		List<AncillaryDetails> ancillaries = ancillaryMgmtBO.getAllAncillary();
		return new ResponseEntity<>(ancillaries, HttpStatus.OK);
	}

	@ApiOperation(value = "Get list of the avaliable ancilarries between two airports", response = PreferredAncillaryResponse.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved ancillary list"),
			@ApiResponse(code = 400, message = Constants.ERROR_MSG_2002, response = FaultDO.class),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 404, message = Constants.ERROR_MSG_2006, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) 
	})
	@RequestMapping(value = Constants.PATH_GET_ANCILLARY_BY_AIRPORTS, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PreferredAncillaryResponse> getAllAncillaryByAirports(
			@ApiParam(value = "Send origin airport code in the query param", required = true) 
			@RequestParam(required = true) String originAirportCode, 
			@ApiParam(value = "Send destination airport code in the query param", required = true)
			@RequestParam(required = true) String destAirporCode) throws DataSvcException {
		logger.debug("Inside getAllAncillaryByAirports()");
		PreferredAncillaryResponse response = null;
		if (StringUtils.isEmpty(originAirportCode) || StringUtils.isEmpty(destAirporCode)) {
			logger.debug("Invalid request. Origin/Destination airport code is empty");
			throw new DataSvcException(Constants.ERROR_CODE_2002, Constants.ERROR_MSG_2002, HttpStatus.BAD_REQUEST);
		} else {
			response = ancillaryMgmtBO.getPreferredAncillariesByAirports(originAirportCode, destAirporCode);
			if (null == response || response.getPreferredAncillaries().isEmpty()) {
				logger.debug("No ancillary found between {} and {}", originAirportCode , destAirporCode);
				throw new DataSvcException(Constants.ERROR_CODE_2006, Constants.ERROR_MSG_2006, HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Save Preferred Ancillary b/w two Airports", response = PreferredAncillaryResponse.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved ancillary list"),
			@ApiResponse(code = 400, message = Constants.ERROR_MSG_2002, response = FaultDO.class),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 404, message = Constants.ERROR_MSG_2006, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2008, response = FaultDO.class) 
	})
	@RequestMapping(value = Constants.PATH_SAVE_PREFERRED_ANCILLARY, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PreferredAncillaryResponse> savePreferredAncillary(
			@ApiParam(value = "Send Preferred Ancillary Request", required = true) 
			@RequestBody(required = true) PreferredAncillaryRequest request) throws DataSvcException {
		logger.debug("Inside getAllAncillaryByAirports()");
		PreferredAncillaryResponse response = null;
		requestValidator.validatePreferredAncillaryRequest(request);
		ancillaryMgmtBO.updatePreferredAncillary(request);
		response = ancillaryMgmtBO.getPreferredAncillariesByAirports(request.getOriginAirportCode(), request.getDestAirportCode());
		if (null == response || response.getPreferredAncillaries().isEmpty()) {
			logger.debug("No ancillary found between {} and {}", request.getOriginAirportCode(), request.getDestAirportCode());
			throw new DataSvcException(Constants.ERROR_CODE_2008, Constants.ERROR_MSG_2008);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Save Ancilarry", response = AncillaryDetails.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully saved the ancillary", response = AncillaryDetails.class),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 409, message = Constants.ERROR_MSG_2007, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) 
	})
	@RequestMapping(value = Constants.PATH_SAVE_ANCILLARY, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AncillaryDetails> saveAncillary(
			@ApiParam(value = "Ancillary Details in RequestBody", required = true) 
			@RequestBody(required = true) AncillaryDetails ancillaryDetails) throws DataSvcException {
		logger.debug("Inside saveAncillary()");
		ancillaryDetails = ancillaryMgmtBO.saveAncillaryDetails(ancillaryDetails);
		return new ResponseEntity<>(ancillaryDetails, HttpStatus.OK);
	}

	@ApiOperation(value = "Update Ancilarry", response = AncillaryDetails.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully saved the ancillary", response = AncillaryDetails.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) 
	})
	@RequestMapping(value = Constants.PATH_UPDATE_ANCILLARY, method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AncillaryDetails> updateAncillary(
			@ApiParam(value = "Ancillary Details in RequestBody", required = true) 
			@RequestBody(required = true) AncillaryDetails ancillaryDetails) throws DataSvcException {
		logger.debug("Inside updateAncillary()");
		ancillaryMgmtBO.updateAncillaryDetails(ancillaryDetails);
		return new ResponseEntity<>(ancillaryDetails, HttpStatus.OK);
	}

	
	
	/**
	 * @param ancillaryId
	 * @return ResponseEntity
	 * @throws DataSvcException
	 */
	@ApiOperation(value = "Delete Ancilarry by Id")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully deleted the ancillary"),
			@ApiResponse(code = 401, message = Constants.ERROR_MSG_2009, response = FaultDO.class),
			@ApiResponse(code = 404, message = Constants.ERROR_MSG_2006, response = FaultDO.class),
			@ApiResponse(code = 500, message = Constants.ERROR_MSG_2005, response = FaultDO.class) 
	})
	@RequestMapping(value = Constants.PATH_DELETE_ANCILLARY
			+ "/{ancillaryId}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteAncillary(
			@ApiParam(value = "Ancillary Id in path param", required = true) @PathVariable("ancillaryId") Integer ancillaryId) throws DataSvcException {
		logger.debug("Inside deleteAncillary()");
		ancillaryMgmtBO.deleteAncillaryDetails(ancillaryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
