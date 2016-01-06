package com.topera.epoch.vo;

import org.springframework.util.StringUtils;

public class SearchInput {
	
	private String hospital;
	private String workstation;
	private String procedureId;
	private String dateTime;
	private String fromDate;
	private String toDate;
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
	public String getProcedureId() {
		return procedureId;
	}
	@Override
	public String toString() {
		return "SearchInput [hospital=" + hospital + ", workstation=" + workstation + ", procedureId=" + procedureId
				+ ", dateTime=" + dateTime + "]";
	}
	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
	}
	String processDate(String date){
		System.out.println("SearchInput.processDate()date=="+date);
		if(StringUtils.isEmpty(date)){
			return "";
		}
		return date.split("/")[2]+"-"+(date.split("/")[0].equals("12")?"00":date.split("/")[0])+"-"+date.split("/")[1];	
	}
	public String getDateTime() {
			
		return processDate(dateTime);
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return processDate(fromDate);
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return processDate(toDate);
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
