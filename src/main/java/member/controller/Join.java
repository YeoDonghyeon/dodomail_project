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

	// 1. Ŭ���̾�Ʈ�� �ʿ��� �Ķ���Ϳ� �Ķ���� ���� ���������� ���´� �� �������� ȸ�� ���� ����� ����
	// 2. �̹� ������� ���̵� �Ǵ� ����ó �Ǵ� �̸��Ϸ� ������ ���� �� 409 �����ڵ带 �����ϵ��� ����
	// 3. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. �ѱ�ó��
		request.setCharacterEncoding("utf-8");
		
		// 1. �Ķ���͸� �ҷ��´�.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
	
		// �Է� ��Ģ�� �����ش�.
		if(id == null || pw == null || pwChk == null || name == null || tel == null || addr == null || email == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			// return�� �޼����� ���̴�.
			return ;
		} else if(id.trim().length() == 0 || pw.trim().length() == 0 || pwChk.trim().length() == 0 || name.trim().length() == 0 || tel.trim().length() == 0 || addr.trim().length() == 0 || email.trim().length() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		} else if((id.length() < 4 || id.length() > 10) || (pw.length() < 6 || pw.length() > 16) || name.length() != 3 || tel.length() != 13 || addr.length() > 20 || email.length() > 50) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		} 
		
		// 2. �Ķ���͸� �����ش�.
		MemberInfo newMemberInfo = new MemberInfo(id, pw, pwChk, name, tel, addr, email, LocalDateTime.now());
		
		// 3. ȸ������ ó��
		MemberService service = new MemberService();
		boolean result = service.join(newMemberInfo);
		
		// 4. ȸ�� ���� ó���� ���� ��� �ڵ� ����
		if(result) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
		
	}

}
