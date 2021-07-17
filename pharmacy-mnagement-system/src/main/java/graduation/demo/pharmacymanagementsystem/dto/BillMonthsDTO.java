package graduation.demo.pharmacymanagementsystem.dto;

public class BillMonthsDTO {

	private String replyTime1;
	
	private String replyTime2;

	public BillMonthsDTO(String replyTime1, String replyTime2) {
		this.replyTime1 = replyTime1;
		this.replyTime2 = replyTime2;
	}

	public BillMonthsDTO() {
	}

	@Override
	public String toString() {
		return "BillMonthsDTO [replyTime1=" + replyTime1 + ", replyTime2=" + replyTime2 + "]";
	}

	public String getReplyTime1() {
		return replyTime1;
	}

	public void setReplyTime1(String replyTime1) {
		this.replyTime1 = replyTime1;
	}

	public String getReplyTime2() {
		return replyTime2;
	}

	public void setReplyTime2(String replyTime2) {
		this.replyTime2 = replyTime2;
	}
	
	
	
	
}
