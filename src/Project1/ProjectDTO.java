package Project1;

public class ProjectDTO {
	// 회원 id  , password , 칩갯수 , 승 , 패 , 승률
	private String id;
	private String password;
	private Long chip;
	private Long win;
	private Long lose;
	private Long winRate;
	
	
	public ProjectDTO(String id, String password, Long chip, Long win, Long lose, Long winRate) {
		this.id = id;
		this.password = password;
		this.chip = chip;
		this.win = win;
		this.lose = lose;
		this.winRate = winRate;
	}
	
	
	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", password=" + password + ", chip=" + chip + ", win=" + win + ", lose=" + lose
				+ ", winRate=" + winRate + "]";
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getChip() {
		return chip;
	}
	public void setChip(Long chip) {
		this.chip = chip;
	}
	public Long getWin() {
		return win;
	}
	public void setWin(Long win) {
		this.win = win;
	}
	public Long getLose() {
		return lose;
	}
	public void setLose(Long lose) {
		this.lose = lose;
	}
	public Long getWinRate() {
		return winRate;
	}
	public void setWinRate(Long winRate) {
		this.winRate = winRate;
	}
	
	
	
	
	
	
	
	
	
}
