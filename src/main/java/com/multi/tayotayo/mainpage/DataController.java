package com.multi.tayotayo.mainpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mainpage")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/insert")
    @ResponseBody
    public void insertData(@RequestBody DataVO dataVO) {
        dataService.insert(dataVO);
    }
    
    @GetMapping("/mapfind") 
    @ResponseBody
    public List<JoinVO> selectMainpage() {
        return dataService.mapfind();  
    }
    
    @GetMapping("/maplist")
    @ResponseBody
    public List<JoinVO> selectlistMainpage(@RequestParam String es_statNm) {
        return dataService.maplist(es_statNm);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<JoinVO> filter(JoinVO joinVO) {
        return dataService.filter(joinVO);
    }

    @GetMapping("/myLocationFindRecommand")
    @ResponseBody
    public List<JoinVO> myLocationFindRecommand(JoinVO joinVO) {
       return dataService.myLocationFindRecommand(joinVO);
    }
}





