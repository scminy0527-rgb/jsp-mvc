package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.vo.PostVO;

public class PostDAO {
	SqlSession sqlSession;
	
	public PostDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(PostVO postVO) {
		sqlSession.insert("post.insert", postVO);
	}
	
	public List<PostVO> selectAll() {
		List<PostVO> postList = sqlSession.selectList("post.selectAll");
		return postList;
	}
	
	public Optional<PostVO> select(Long id) {
		PostVO postVO = sqlSession.selectOne("post.select", id);
		Optional<PostVO> foundPost = Optional.ofNullable(postVO);
		return foundPost;
	}
	
	public void update(PostVO postVO) {
		sqlSession.update("post.update", postVO);
	}
	
	public void delete(Long id) {
		sqlSession.delete("post.delete", id);
	}
}
