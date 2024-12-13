package edu.kh.admin.main.model.service;

import edu.kh.admin.main.model.dto.Member;

public interface Adminservice {

	/** 관리자 로그인
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);



}
