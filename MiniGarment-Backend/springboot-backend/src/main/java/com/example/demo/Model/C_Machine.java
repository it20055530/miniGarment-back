package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machines")

public class C_Machine {
	
	@Id
	@Column(name = "machine_number")
	private String machinenumber;
	
	@Column(name = "machine_model")
	private String machinemodel;
	
	@Column(name = "dateoflastrepair")
	private String dateoflastrepair;
	
	@Column(name = "dateofnextrepair")
	private String dateofnextrepair;
	
	@Column(name = "replacedparts")
	private String replacedparts;
	
	@Column(name = "repaircharge")
	private String repaircharge;
	
	public C_Machine() {
		
	}
	
	
	public C_Machine(String machinemodel, String dateoflastrepair, String dateofnextrepair, String replacedparts, String repaircharge) {
		super();
		this.machinemodel = machinemodel;
		this.dateoflastrepair = dateoflastrepair;
		this.dateofnextrepair = dateofnextrepair;
		this.replacedparts = replacedparts;
		this.repaircharge = repaircharge;
		
	}
	public String getMachinenumber() {
		return machinenumber;
	}
	public void setMachinenumber(String machinenumber) {
		this.machinenumber = machinenumber;
	}
	public String getMachinemodel() {
		return machinemodel;
	}
	public void setMachinemodel(String machinemodel) {
		this.machinemodel = machinemodel;
	}
	public String getDateoflastrepair() {
		return dateoflastrepair;
	}
	public void setDateoflastrepair(String dateoflastrepair) {
		this.dateoflastrepair = dateoflastrepair;
	}
	public String getDateofnextrepair() {
		return dateofnextrepair;
	}
	public void setDateofnextrepair(String dateofnextrepair) {
		this.dateofnextrepair = dateofnextrepair;
	}
	public String getReplacedparts() {
		return replacedparts;
	}
	public void setReplacedparts(String replacedparts) {
		this.replacedparts = replacedparts;
	}
	public String getRepaircharge() {
		return repaircharge;
	}
	public void setRepaircharge(String repaircharge) {
		this.repaircharge = repaircharge;
	}
	
	

	
}