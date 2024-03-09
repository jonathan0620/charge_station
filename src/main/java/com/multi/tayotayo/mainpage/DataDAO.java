package com.multi.tayotayo.mainpage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataDAO {
 
    @Autowired
    private SqlSessionTemplate my;

    public void insert(DataVO dataVO) {
        try {
            my.insert("data.insert", dataVO);
        } catch (Exception e) {
            System.out.println(dataVO.getStat() + "에서 예외발생");
        }
    }

 ///// selectList (찾기 페이지 클릭 시 실행)   
    
    public List<JoinVO> mapfind() {
        return my.selectList("data.mapfind");
    }

///// selectList (검색하기(키워드) 버튼 클릭 시 실행)    
    
    public List<JoinVO> maplist(String es_statNm) {
        return my.selectList("data.maplist", es_statNm);
    }

///// filter (검색하기(필터링) 버튼 클릭 시 실행)    
    
    public List<JoinVO> filter(JoinVO joinVO) {
        return my.selectList("data.search-filter", joinVO);
    }

///// myLocationFindRecommand (추천하기 버튼 클릭 시 실행)    
    
    public List<JoinVO> myLocationFindRecommand(JoinVO joinVO) {
        return my.selectList("data.myLocationFindRecommand", joinVO);
    }

      
}
