/**
 * 
 */
package com.ecw.empaddbook.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecw.empaddbook.entity.Employee;

/**
 * @author Ashish Modified Date : May 16, 2020
 */
@Service
public class CsvReadWriteOperation {

	private final String csvFileName = "E:\\EmployeeAddrBookData\\empdata.csv";
	private static final String NEW_LINE_SEPARATOR = "\n";
	String line = "";
	String splitChar = ",";

	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
			while ((line = br.readLine()) != null) {
				String[] empData = line.split(splitChar);
				Employee emp = new Employee();
				emp.setId(empData[0]);
				emp.setFirstName(empData[1]);
				emp.setLastName(empData[2]);
				emp.setEmail(empData[3]);
				emp.setAddress(empData[4]);
				empList.add(emp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	public boolean addNewEmployee(Employee emp) {
		boolean returnResponce = false;
		try(FileWriter fw = new FileWriter(csvFileName,true)) {
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(emp.getId());
			fw.append(splitChar);
			fw.append(emp.getFirstName());
			fw.append(splitChar);
			fw.append(emp.getLastName());
			fw.append(splitChar);
			fw.append(emp.getEmail());
			fw.append(splitChar);
			fw.append(emp.getAddress());
			fw.flush();
			fw.close();
			returnResponce = true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return returnResponce;
	}
}
