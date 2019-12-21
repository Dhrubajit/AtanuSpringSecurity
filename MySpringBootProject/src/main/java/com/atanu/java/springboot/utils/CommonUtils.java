/**
 * 
 */
package com.atanu.java.springboot.utils;

import com.atanu.java.springboot.constant.Constants;
import com.atanu.java.springboot.model.ErrorDO;
import com.atanu.java.springboot.model.FaultDO;

/**
 * @author ATANU
 *
 */
public class CommonUtils {
	
	/**
	 * @return FaultDO
	 */
	public static FaultDO createFaultDOForSuccess(){
		FaultDO faultDO = new FaultDO();
		faultDO.setStatus(Constants.SUCCESS);
		return faultDO;
	}
	
	/**
	 * @param errorCode
	 * @param errorMsg
	 * @return FaultDO
	 */
	public static FaultDO createFaultDOForError(String errorCode, String errorMsg){
		FaultDO faultDO = new FaultDO();
		ErrorDO errorDO = new ErrorDO();
		errorDO.setErrorCode(errorCode);
		errorDO.setErrorMsg(errorMsg);
		faultDO.setStatus(Constants.ERROR);
		faultDO.setError(errorDO);
		return faultDO;
	}
}
