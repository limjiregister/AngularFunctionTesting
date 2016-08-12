package domain;


public class ProfitSearch {

	private String businessNo;
	private String saleMan;
	private String reciverMan;
	private String creator;
	private String department;
	private String payType;
	private String finishTime;
	private String makeTime;
	private String sendTime;
	private String pageNo;
	private String pageCount;

	public ProfitSearch() {
	}


	public ProfitSearch(String businessNo, String saleMan, String reciverMan, String creator, String department, String payType, String finishTime, String makeTime, String sendTime, String pageNo, String pageCount) {
		this.businessNo = businessNo;
		this.saleMan = saleMan;
		this.reciverMan = reciverMan;
		this.creator = creator;
		this.department = department;
		this.payType = payType;
		this.finishTime = finishTime;
		this.makeTime = makeTime;
		this.sendTime = sendTime;
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getSaleMan() {
		return saleMan;
	}

	public void setSaleMan(String saleMan) {
		this.saleMan = saleMan;
	}

	public String getReciverMan() {
		return reciverMan;
	}

	public void setReciverMan(String reciverMan) {
		this.reciverMan = reciverMan;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "ProfitSearch{" + "businessNo='" + businessNo + '\'' + ", saleMan='" + saleMan + '\'' + ", reciverMan='" + reciverMan + '\'' + ", creator='" + creator + '\'' + ", department='" + department + '\'' + ", payType='" + payType + '\'' + ", finishTime='" + finishTime + '\'' + ", makeTime='" + makeTime + '\'' + ", sendTime='" + sendTime + '\'' + ", pageNo='" + pageNo + '\'' + ", pageCount='" + pageCount + '\'' + '}';
	}
}
