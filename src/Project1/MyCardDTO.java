package Project1;

public class MyCardDTO {
	String mark;
	String num;
	Long markNum;
	Long numNum;
	public MyCardDTO(String mark, String num, Long markNum, Long numNum) {
		this.mark = mark;
		this.num = num;
		this.markNum = markNum;
		this.numNum = numNum;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Long getMarkNum() {
		return markNum;
	}
	public void setMarkNum(Long markNum) {
		this.markNum = markNum;
	}
	public Long getNumNum() {
		return numNum;
	}
	public void setNumNum(Long numNum) {
		this.numNum = numNum;
	}
}
