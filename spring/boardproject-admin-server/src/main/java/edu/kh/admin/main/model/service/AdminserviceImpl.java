package edu.kh.admin.main.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.admin.main.model.dto.Member;
import edu.kh.admin.main.model.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AdminserviceImpl implements Adminservice {

	private final AdminMapper mapper;
	private final BCryptPasswordEncoder bCrypt;

	// 관리자 로그인
	@Override
	public Member login(Member inputMember) {

		Member loginMember = mapper.login(inputMember.getMemberEmail());
		
		if(loginMember == null) return null;
		
		if( !bCrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw()) ) {
			return null;
		}
		
		loginMember.setMemberPw(null);
		return loginMember;
	}


	
	

}
