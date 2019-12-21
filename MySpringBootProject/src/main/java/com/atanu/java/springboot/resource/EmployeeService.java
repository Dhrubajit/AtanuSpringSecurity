/**
 * 
 */
package com.atanu.java.springboot.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atanu.java.springboot.model.Address;
import com.atanu.java.springboot.model.Employee;

/**
 * @author Atanu Bhowmick
 *
 */

@RestController
@RequestMapping(value = "/employee")
public class EmployeeService {

	private static final Log log = LogFactory.getLog(EmployeeService.class);

	@RequestMapping(value = "/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") String empId) {
		log.debug("Inside getEmployee... empId = " + empId);
		Employee employee = new Employee(empId, "Atanu Bhowmick", 30, null,
				new Address("A1/2", "H Street", "Hooghly", "WB"));

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		log.debug("Inside saveEmployee... empId = " + employee.getEmpId());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
