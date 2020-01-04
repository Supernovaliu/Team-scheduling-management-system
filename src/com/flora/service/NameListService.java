package com.flora.service;

/**@description encapsulate data from class data to Emploee[],providing method for Employee[]
 * @author Flora Liu
 * @date2020年1月3日
 */
import static com.flora.service.Data.*;
import com.flora.domain.*;


public class NameListService {
private Employee[] employees;
/**
 * initialize 'employees'and elements in 'employees'
 */
public NameListService(){
	//create array according to Data class
	//create different objects according to Data class
	//store objects in array
	employees = new Employee[EMPLOYEES.length];
	for(int i = 0;i<employees.length;i++) {
		int type = Integer.parseInt(EMPLOYEES[i][0]);
		//get basic information from EMPLOYEES
		int id = Integer.parseInt(EMPLOYEES[i][1]);
		String name = EMPLOYEES[i][2];
		int age = Integer.parseInt(EMPLOYEES[i][3]);
		double salary = Double.parseDouble(EMPLOYEES[i][4]);
		Equipment equipment;
		double bonus;
		int stock;
		switch(type) {
		case EMPLOYEE:
			employees[i] = new Employee(id, name, age, salary);
			break;
		case PROGRAMMER:
			equipment = createEquipment(i);
			employees[i] = new Programmer(id, name, age, salary, equipment);
			
			break;
		case DESIGNER:
			equipment = createEquipment(i);
			bonus = Double.parseDouble(EMPLOYEES[i][5]);
			employees[i] = new Designer(id, name, age, salary, equipment, bonus);
			break;
		case ARCHITECT:
			equipment = createEquipment(i);
			bonus = Double.parseDouble(EMPLOYEES[i][5]);
			stock = Integer.parseInt(EMPLOYEES[i][6]);
			employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
			break;
		}
	}
}
/**get equipment description of defined index employee
 * @param i
 * @return
 */
private Equipment createEquipment(int index) {
	int key = Integer.parseInt(EQUIPMENTS[index][0]);
	String modelOrName = EQUIPMENTS[index][1];
	switch(key) {
	case PC://21
		String display = EQUIPMENTS[index][2];
		return new PC(modelOrName, display);
	case NOTEBOOK://22
		double price = Double.parseDouble(EQUIPMENTS[index][2]);
		return new NoteBook(modelOrName, price);
	case PRINTER://23
		
		String type = EQUIPMENTS[index][2];
		return new Printer(modelOrName,type);
	}
	return null;
}
public Employee[] getAllEmployees() {
	return employees;
}
public Employee getEmployee(int id) throws TeamException {
	for(int i = 0;i<employees.length;i++) {
		if(employees[i].getId() == id) {
			return employees[i];
		}
	}
	throw new TeamException("finding failed");
}
}
