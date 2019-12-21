/**
 * 
 */
package com.atanu.java.springboot.model;

import java.io.Serializable;

import com.atanu.java.springboot.constant.Constants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Atanu Bhowmick
 *
 */
@ApiModel(value = "ErrorDO", description = "Error Details")
public class ErrorDO implements Serializable {

	private static final long serialVersionUID = 4947858162814897886L;

	@ApiModelProperty(value = "Error Code", example = Constants.ERROR_CODE_2001)
	private String errorCode;
	
	@ApiModelProperty(value = "Error Message", example = Constants.ERROR_MSG_2001)
	private String errorMsg;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
