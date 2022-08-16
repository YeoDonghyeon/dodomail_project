package member.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.MemberInfo;
import member.service.MemberService;

@WebServlet("/member/join")
public class Join extends HttpServlet {

	// 1. 클라이언트가 필요한 파라미터와 파라미터 값을 정상적으로 보냈다 는 가정으로 회원 가입 기능을 개발
	// 2. 이미 사용중인 아이디 또는 연락처 또는 이메일로 가입을 했을 때 409 상태코드를 응답하도록 개발
	// 3. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 1. 파라미터를 불러온다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
	
		// 입력 규칙을 정해준다.
		if(id == null || pw == null || pwChk == null || name == null || tel == null || addr == null || email == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			// return은 메서드의 끝이다.
			return ;
		} else if(id.trim().length() == 0 || pw.trim().length() == 0 || pwChk.trim().length() == 0 || name.trim().length() == 0 || tel.trim().length() == 0 || addr.trim().length() == 0 || email.trim().length() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		} else if((id.length() < 4 || id.length() > 10) || (pw.length() < 6 || pw.length() > 16) || name.length() != 3 || tel.length() != 13 || addr.length() > 20 || email.length() > 50) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		} 
		
		// 2. 파라미터를 합쳐준다.
		MemberInfo newMemberInfo = new MemberInfo(id, pw, pwChk, name, tel, addr, email, LocalDateTime.now());
		
		// 3. 회원가입 처리
		MemberService service = new MemberService();
		boolean result = service.join(newMemberInfo);
		
		// 4. 회원 가입 처리에 따른 결과 코드 응답
		if(result) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
		
	}

}
