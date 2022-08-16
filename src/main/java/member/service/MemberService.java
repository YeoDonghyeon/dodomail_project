package member.service;

import member.dao.MemberInfoDao;
import member.dto.MemberInfo;

public class MemberService {
	public boolean join(MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		if(dao.selectById(memberInfo.getId()) != null || dao.selectByTel(memberInfo.getTel()) != null || dao.selectByTel(memberInfo.getEmail()) != null) {
			return false;
		} else {
			return dao.insert(memberInfo);
		}
		
	}
}
