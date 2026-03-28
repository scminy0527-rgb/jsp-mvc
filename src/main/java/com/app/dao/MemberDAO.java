package com.app.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.vo.MemberVO;

public class MemberDAO {
	private SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public int iruByMemberEmail(String memberEmail) {
		return sqlSession.selectOne("member.iruByMemberEmail", memberEmail);
	}
	
	public Optional<MemberVO> findByMemberEmailAndMemberPassword(MemberVO memberVO) {
		MemberVO member = sqlSession.selectOne("member.selectByMemberEmailAndMemberPassword", memberVO);
		return Optional.ofNullable(member);
	}
	
	public Optional<MemberVO> findById(Long id) {
		MemberVO member = sqlSession.selectOne("member.selectById", id);
		return Optional.ofNullable(member);
	}
}
