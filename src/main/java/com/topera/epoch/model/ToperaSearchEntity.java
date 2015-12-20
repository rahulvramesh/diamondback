package com.topera.epoch.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="diamondback_metadata")
public class ToperaSearchEntity implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String hospital;
	private String workstation;
	private String Procedure_ID;
	private Date datetime;
	private String fileName;
	@Transient
	private Date fromDate;
	@Transient
	private Date toDate;
	
	
	
	@Transient
	public Date getFromDate() {
		return fromDate;
	}




	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}



	@Transient
	public Date getToDate() {
		return toDate;
	}




	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}




	public ToperaSearchEntity() {}
	 
    
 
  
	public Integer getId() {
		return id;
	}




	public String getHospital() {
		return hospital;
	}




	public void setHospital(String hospital) {
		this.hospital = hospital;
	}




	public String getWorkstation() {
		return workstation;
	}




	public void setWorkstation(String workstation) {
		this.workstation = workstation;
	}




	@Override
	public String toString() {
		return "["+id + "," + hospital + "," + workstation
				+ "," + Procedure_ID + "," + datetime + "]";
	}
	
	public String[] toArray(){
		return new String[]{hospital,workstation,Procedure_ID,datetime+"",fileName};
	}




	public String getProcedure_ID() {
		return Procedure_ID;
	}




	public void setProcedure_ID(String procedure_ID) {
		Procedure_ID = procedure_ID;
	}




	public Date getDatetime() {
		return datetime;
	}




	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getFileName() {
		return fileName;
	}




	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
}