package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import member.dto.MemberInfo;
import util.DatabaseManager;

public class MemberInfoDao {

	public MemberInfo selectById(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 처음에 회원 정보를 null둔 이유는
		// 아직 셀렉 전이라서 모르기 때문에 아직없다의 뜻을 넣어준거임
		MemberInfo memberInfo = null;

		try {
			conn = DatabaseManager.getConnection();

			String sql = "SELECT * FROM member_info WHERE id = ?";

			pstmt = DatabaseManager.getPreparedStatement(conn, sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			// 아이디는 한명만 쓸 수 있기때문
			// 만약 여러사람이 동시에 쓸 수 있다면 while로 돌렸을 것이다.

			// rs.next()는 이 결과가 있다면 이라는 뜻
			if (rs.next()) {
				int memberIdx = rs.getInt("memberIdx");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();

				// 만약 있다면 하나의 정보로 합쳐준다. 리턴해준다.
				memberInfo = new MemberInfo(memberIdx, id, pw, name, tel, addr, email, joinDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		// 아이디를 사용하고 있는 회원이 있다면 memberInfo로 리턴해줌
		// 만약 없다면 맨 위의 null값이 리턴된다.
		return memberInfo;
	}

	public MemberInfo selectByTel(String tel) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 처음에 회원 정보를 null둔 이유는
		// 아직 셀렉 전이라서 모르기 때문에 아직없다의 뜻을 넣어준거임
		MemberInfo memberInfo = null;

		try {
			conn = DatabaseManager.getConnection();

			String sql = "SELECT * FROM member_info WHERE tel = ?";

			pstmt = DatabaseManager.getPreparedStatement(conn, sql);
			pstmt.setString(1, tel);

			rs = pstmt.executeQuery();

			// 아이디는 한명만 쓸 수 있기때문
			// 만약 여러사람이 동시에 쓸 수 있다면 while로 돌렸을 것이다.

			// rs.next()는 이 결과가 있다면 이라는 뜻
			if (rs.next()) {
				int memberIdx = rs.getInt("memberIdx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();

				// 만약 있다면 하나의 정보로 합쳐준다. 리턴해준다.
				memberInfo = new MemberInfo(memberIdx, id, pw, name, tel, addr, email, joinDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		// 아이디를 사용하고 있는 회원이 있다면 memberInfo로 리턴해줌
		// 만약 없다면 맨 위의 null값이 리턴된다.
		return memberInfo;
	}

	public MemberInfo selectByEmail(String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 처음에 회원 정보를 null둔 이유는
		// 아직 셀렉 전이라서 모르기 때문에 아직없다의 뜻을 넣어준거임
		MemberInfo memberInfo = null;

		try {
			conn = DatabaseManager.getConnection();

			String sql = "SELECT * FROM member_info WHERE email = ?";

			pstmt = DatabaseManager.getPreparedStatement(conn, sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			// rs.next()는 이 결과가 있다면 이라는 뜻
			if (rs.next()) {
				int memberIdx = rs.getInt("memberIdx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();

				// 만약 있다면 하나의 정보로 합쳐준다. 리턴해준다.
				memberInfo = new MemberInfo(memberIdx, id, pw, name, tel, addr, email, joinDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		
		return memberInfo;
	}

	public boolean insert(MemberInfo memberInfo) {
		// insert 메서드가 전달 받은 memberInfo를 사용해서
		// 회원 가입이 이뤄지도록 코드를 완성하세요.
		// (아직은 반환타입이 void이니까 return은 고민하지말기)

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. db접속
			conn = DatabaseManager.getConnection();

			// 2. 쿼리준비
			String sql = "INSERT INTO member_info(id, pw, name, tel, addr, email, joinDate) VALUES(?, ?, ?, ?, ?, ?, ?)";

			pstmt = DatabaseManager.getPreparedStatement(conn, sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getTel());
			pstmt.setString(5, memberInfo.getAddr());
			pstmt.setString(6, memberInfo.getEmail());
			pstmt.setString(7, memberInfo.getJoinDate().toString());

			// 3. 쿼리 실행
			pstmt.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		} finally {
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}

	}
}
