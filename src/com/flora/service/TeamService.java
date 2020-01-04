/**
 * 
 */
package com.flora.service;

import com.flora.domain.Architect;
import com.flora.domain.Designer;
import com.flora.domain.Employee;
import com.flora.domain.Programmer;

/**
 * @description management of team member
 * @author aiquanquanderen
 * @date2020年1月3日
 */
public class TeamService {
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total;

	public TeamService() {
		super();
	}

	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	public void addMember(Employee e) throws TeamException {
		if (total >= MAX_MEMBER) {
			throw new TeamException("add failed because it is already full");
		}
		if (!(e instanceof Programmer)) {
			throw new TeamException("add failed because this staff is not developer");
		}
		if (isExist(e)) {
			throw new TeamException("add failed because stuff is already in development team");
		}
		Programmer p = (Programmer) e;
		if ("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("add failed because this stuff is already belong to development team");
		} else if ("VACATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("add failed because this stuff is on vacation");
		}
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else {
				numOfPro++;
			}
		}
		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("no more than one Architect!");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("no more than two Designers!");
			}
		} else {
			if (numOfPro >= 3) {
				throw new TeamException("no more than three Programmers!");
			}
		}
		// add /e to existing team
		team[total++] = p;
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}

	/**
	 * @param e
	 * @return
	 */
	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if (i == total) {
			throw new TeamException("can't find stuff!");
		}
		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}
		team[--total] = null;
	}
}
