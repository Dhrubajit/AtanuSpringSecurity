/**
 * 
 */
package com.atanu.java.springboot.constant;

/**
 * @author ATANU
 *
 */
public class Constants {
	private Constants() {
	}
	
	public static final String EMPTY_STRING 					= "";
	public static final String CSV_FILE_PATH 					= "csvFilePath";
	
	public static final String PATH_ANCILLARY 					= "/ancillary";
	public static final String PATH_GET_ANCILLARY 				= "/getAncillary";
	public static final String PATH_GET_ANCILLARY_BY_AIRPORTS	= "/getAncillaryByAirports";
	public static final String PATH_GET_ALL_ANCILLARY 			= "/getAllAncillary";
	public static final String PATH_SAVE_ANCILLARY 				= "/save";
	public static final String PATH_UPDATE_ANCILLARY 			= "/update";
	public static final String PATH_DELETE_ANCILLARY 			= "/delete";
	public static final String PATH_SAVE_PREFERRED_ANCILLARY	= "/savePrefferedAncillary";
	
	public static final String SUCCESS							= "SUCCESS";
	public static final String ERROR							= "ERROR";
	
	public static final String ERROR_CODE_2001					= "2001";
	public static final String ERROR_CODE_2002					= "2002";
	public static final String ERROR_CODE_2003					= "2003";
	public static final String ERROR_CODE_2004					= "2004";
	public static final String ERROR_CODE_2005					= "2005";
	public static final String ERROR_CODE_2006					= "2006";
	public static final String ERROR_CODE_2007					= "2007";
	public static final String ERROR_CODE_2008					= "2008";
	public static final String ERROR_CODE_2009					= "2009";
	
	public static final String ERROR_MSG_2001					= "Database error. Unable to retrieve data.";
	public static final String ERROR_MSG_2002					= "Origin/Destination airport can't be empty.";
	public static final String ERROR_MSG_2003					= "Airport details are not available in database.";
	public static final String ERROR_MSG_2004					= "Ancillary details is not available for the airports.";
	public static final String ERROR_MSG_2005					= "Unexcepted error occurred. Please try again later.";
	public static final String ERROR_MSG_2006					= "No Data Found.";
	public static final String ERROR_MSG_2007					= "Requested data already present.";
	public static final String ERROR_MSG_2008					= "Unable to add Preffered Ancillary. Please try again.";
	public static final String ERROR_MSG_2009					= "Unauthorized Access.";
	
}
