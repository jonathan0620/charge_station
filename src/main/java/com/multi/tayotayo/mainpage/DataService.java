package com.multi.tayotayo.mainpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
 
    @Autowired
    DataDAO dao;

    public void insert(DataVO dataVO) {
         dao.insert(dataVO);
    }

///// select 호출 (찾기 페이지 클릭 시 실행)
    
    public List<JoinVO> mapfind() {
    	
        return dao.mapfind();
    }
    
///// selectlist 호출 (검색하기(키워드) 버튼 클릭 시 실행)
    
    public List<JoinVO> maplist(String es_statNm) {
        return dao.maplist(es_statNm);
    }
    
///// filter 호출 (검색하기(키워드) 버튼 클릭 시 실행)
    
    public List<JoinVO> filter(JoinVO joinVO) {
        if (joinVO.getEs_gungoo() == null && joinVO.getEs_faciL() == null && joinVO.getEs_dvcS() == null) {
            return null;
        }

        joinVO.setEs_gungoo(emptyToNull(joinVO.getEs_gungoo()));
        joinVO.setEs_faciL(emptyToNull(joinVO.getEs_faciL()));
        joinVO.setEs_dvcS(emptyToNull(joinVO.getEs_dvcS()));

        List<JoinVO> list = dao.filter(joinVO);

        if (list.isEmpty()) {
            return null;
        }

        return list;
    }

///// 공백 또는 null 확인     
    
    public String emptyToNull(String value) {
        return (value != null && value.equals("")) ? null : value;
    }

///// myLocationFindRecommand 호출 (추천하기 버튼 클릭 시 실행)

    public List<JoinVO> myLocationFindRecommand(JoinVO joinVO) {
        return dao.myLocationFindRecommand(joinVO);
    }
}
