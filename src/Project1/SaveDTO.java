package Project1;

public class SaveDTO {
	Long markNum;
	Long numNum;
	public SaveDTO(Long markNum, Long numNum) {
		this.markNum = markNum;
		this.numNum = numNum;

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
