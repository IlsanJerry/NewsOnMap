package com.mynews.newsbigdata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.CheckInsertService;
import service.NewsCrawlingService;
import service.NewsService;
import vo.NewsAnalysisVO;
import vo.NewsVO;

@RestController
@SessionAttributes("status")
public class NewsController {
	@Autowired
	NewsService newsService;
	@Autowired
	CheckInsertService checkInsertService;
	@Autowired
	NewsCrawlingService crawlingService;
	
	@RequestMapping(value="/mainNews", method=RequestMethod.GET)
	public HashMap<String, Object> mainNews() {
		HashMap<String, Object> map = new HashMap<>();
		try {
			// 오늘의 뉴스 데이터 로드
			map.put("todayNews", newsService.listAll());
			// 지도에 시도명, 시군구명, 위도, 경도 데이터 로드
			map.put("province", checkInsertService.provinceList());
			map.put("sigungu", checkInsertService.sigunguList());
		} catch(NullPointerException e) {
			System.out.println("NewsList or ProvinceList or SigunguList is null!");
		} 
//		finally {
//			crawlingService.startCrawling();
//		}
		return map;
	}
	
	// 메인페이지 뉴스 기사 리스트 출력 & 모달페이지 뉴스 기사 내용 출력
	@RequestMapping(value="/readNews", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public NewsVO readNews(@ModelAttribute NewsVO vo) {
		try {
			vo = newsService.readNews(vo);
		} catch(NullPointerException e) {
			System.out.println("There is no matching article with the title!");
		}
		return vo;
	}
	
	@RequestMapping(value="/selectZone", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public Map<String, HashSet<String>> selectZone(@ModelAttribute NewsAnalysisVO vo) {
		HashMap<String, HashSet<String>> map = new HashMap<>();
		HashSet<String> set = new HashSet<>(checkInsertService.zoneTitle(vo));
		map.put("zoneNews", set);
		return map;
	}
}
