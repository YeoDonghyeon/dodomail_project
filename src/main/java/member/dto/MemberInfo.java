package member.dto;

import java.time.LocalDateTime;

public class MemberInfo {
	private int memberIdx;
	private String id;
	private String pw;
	private String pwChk;
	private String name;
	private String tel;
	private String addr;
	private String email;
	private LocalDateTime joinDate;
	
	public MemberInfo(int memberIdx, String id, String pw, String name, String tel, String addr, String email,
			LocalDateTime joinDate) {
		this.memberIdx = memberIdx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
	}

	public MemberInfo(String id, String pw, String pwChk, String name, String tel, String addr, String email, LocalDateTime joinDate) {
		this.id = id;
		this.pw = pw;
		this.pwChk = pwChk;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	
	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwChk() {
		return pwChk;
	}
	public void setPwChk(String pwChk) {
		this.pwChk = pwChk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
