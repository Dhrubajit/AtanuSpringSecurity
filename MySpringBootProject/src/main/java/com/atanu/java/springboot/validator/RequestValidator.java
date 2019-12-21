package com.atanu.java.springboot.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.atanu.java.springboot.constant.Constants;
import com.atanu.java.springboot.exception.DataSvcException;
import com.atanu.java.springboot.model.PreferredAncillaryRequest;
import com.atanu.java.springboot.utils.StringUtils;

/**
 * @author Atanu Bhowmick
 *
 */
@Component
public class RequestValidator {

	/**
	 * @param ancillaryRequest
	 * @throws DataSvcException
	 */
	public void validatePreferredAncillaryRequest(PreferredAncillaryRequest ancillaryRequest) throws DataSvcException {
		if(ancillaryRequest != null) {
			if(StringUtils.isEmpty(ancillaryRequest.getOriginAirportCode()) 
					|| StringUtils.isEmpty(ancillaryRequest.getDestAirportCode())) {
				throw new DataSvcException(Constants.ERROR_CODE_2002, Constants.ERROR_MSG_2002, HttpStatus.BAD_REQUEST);
			}
		}
		
	}
}
