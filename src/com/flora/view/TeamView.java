/**
 * 
 */
package com.flora.view;

import com.flora.domain.Employee;
import com.flora.domain.Programmer;
import com.flora.service.NameListService;
import com.flora.service.TeamException;
import com.flora.service.TeamService;

/**
 * @description
 * @author aiquanquanderen
 * @date2020年1月4日
 */
public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {
		boolean loopFlag = true;
		char menu = 0;
		while (loopFlag) {
			if (menu != '1') {
				listAllEmployees();
			}
			System.out.println("1-Team List 2-Add Team Member 3-Delete Team Member 4-Exit Please choose(1-4):");
			menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println(" Are you sure to quit?  Y/N");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
				break;
			}
		}
	}

	private void listAllEmployees() {
		System.out.println(
				"---------------------------------Development Team Schedule System----------------------------\n");

		Employee[] employees = listSvc.getAllEmployees();
		if (employees == null || employees.length == 0) {
			System.out.println("No Stuff!");
		} else {
			System.out.println("ID\tNAME\tAGE\tSALARY\tPOSITION\tSITUATION\tBONUS\tSTOCK\tEQUIPMENT");
			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------");
	}

	private void getTeam() {
		System.out.println("-------------------Team Member List---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("No Stuff!");
		} else {
			System.out.println("TID/ID\tNAME\tAGE\tSALARY\tPOSITION\tBONUS\tSTOCK\n");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------");
	}

	private void addMember() {
		System.out.println("-------------------Add Team Member---------------------\n");
		System.out.println("Please enter ID:");
		int id = TSUtility.readInt();
		try {
			Employee emp = listSvc.getEmployee(id);

			teamSvc.addMember(emp);
			System.out.println("Add Successfully!");

		} catch (TeamException e) {
			System.out.println("Add Failed,reason:" + e.getMessage());
		}
		TSUtility.readReturn();
	}

	private void deleteMember() {
		System.out.println("-------------------Add Team Member---------------------\n");
		System.out.println("Please enter TID:");
		int memberId = TSUtility.readInt();
		System.out.println("Are you sure to delete?  Y/N");
		char isDelete = TSUtility.readConfirmSelection();
		if (isDelete == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("Delete Successfully!");
		} catch (TeamException e) {
			System.out.println("Delete failed,reason:" + e.getMessage());
		}
		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
