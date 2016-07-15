package domain;


import javax.persistence.*;

/**
 * Created by Administrator on 2016/7/15.
 */

@Entity
@Table(name = "ooo_profit")
public class Profit {

	private Integer id;
	private String businessNo;
	private String salesman;
	private Integer salePrice;
	private Integer profits;
	private Integer costPrice;
	private String shipper;
	private String recipient;
	private String cuctomerService;
	private String finishTime;
	private String shipmentTime;
	private String deliverTime;
	private String businessTime;
	private String recordingPerson;
	private String contType;
	private String contNum;
	private String destination;
	private String feeType;
	private String payType;
	private String businessType;
	private String department;


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public Integer getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getProfits() {
		return profits;
	}

	public void setProfits(Integer profits) {
		this.profits = profits;
	}

	public Integer getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getCuctomerService() {
		return cuctomerService;
	}

	public void setCuctomerService(String cuctomerService) {
		this.cuctomerService = cuctomerService;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getShipmentTime() {
		return shipmentTime;
	}

	public void setShipmentTime(String shipmentTime) {
		this.shipmentTime = shipmentTime;
	}

	public String getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getRecordingPerson() {
		return recordingPerson;
	}

	public void setRecordingPerson(String recordingPerson) {
		this.recordingPerson = recordingPerson;
	}

	public String getContType() {
		return contType;
	}

	public void setContType(String contType) {
		this.contType = contType;
	}

	public String getContNum() {
		return contNum;
	}

	public void setContNum(String contNum) {
		this.contNum = contNum;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public Profit() {

	}

	public Profit(Integer id, String businessNo, String salesman, Integer salePrice, Integer profits, Integer costPrice, String shipper, String recipient, String cuctomerService, String finishTime, String shipmentTime, String deliverTime, String businessTime, String recordingPerson, String contType, String contNum, String destination, String feeType, String payType, String businessType, String department) {
		this.id = id;
		this.businessNo = businessNo;
		this.salesman = salesman;
		this.salePrice = salePrice;
		this.profits = profits;
		this.costPrice = costPrice;
		this.shipper = shipper;
		this.recipient = recipient;
		this.cuctomerService = cuctomerService;
		this.finishTime = finishTime;
		this.shipmentTime = shipmentTime;
		this.deliverTime = deliverTime;
		this.businessTime = businessTime;
		this.recordingPerson = recordingPerson;
		this.contType = contType;
		this.contNum = contNum;
		this.destination = destination;
		this.feeType = feeType;
		this.payType = payType;
		this.businessType = businessType;
		this.department = department;
	}
}
