package com.topera.epoch.vo;

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
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
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
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
