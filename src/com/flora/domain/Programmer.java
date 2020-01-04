package com.flora.domain;

import com.flora.service.Status;

public class Programmer extends Employee {
	   private int memberId;//id in development team
	   private Status status = Status.FREE;
	   private Equipment equipment;
	   public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	   public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

		public Programmer(int id, String name, int age, double salary,Equipment equipment) {
			super(id, name, age, salary);
			
			this.equipment = equipment;
		}
		public Programmer() {
			super();
			
		}
		@Override
		public String toString() {
			
			return getDetails()+"\tprogrammer\t"+status+"\t\t\t"+equipment.getDescription();
		}
		public String getDetailsForTeam() {
			return memberId+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\tProgrammer\t";
		}
		
	}
