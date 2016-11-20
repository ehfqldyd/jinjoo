package com.work.spring15.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("home.do")
	public String home() {
		return "board-test";		
	}
	
	/** 실시간 지하철 요청 */
	@RequestMapping("subway.do")
	public String subwayView() {
		return "subway";
	}
	
	/** 공지사항 요청 */
	@RequestMapping("board.do")
	public String boardView() {
		return "board";
	}

	/** 혼잡도 요청 */
	@RequestMapping("congestion.do")
	public String congestionView() {
		return "congestion";
	}
	
	/** 관리자 메인 요청 */
	@RequestMapping("admin_contr.do")
	public String admin_contrView() {
		return "admin_contr";
	}
	
	/** 회원관리 요청 */
	@RequestMapping("member_contr.do")
	public String member_contrView() {
		return "member_contr";
	}
	
	/** 게시물관리 요청 */
	@RequestMapping("board_contr.do")
	public String board_contrView() {
		return "board_contr";
	}
	
	/** 신고관리 요청 */
	@RequestMapping("blame_contr.do")
	public String blame_contrView() {
		return "blame_contr";
	}
	
	/** 관리자 홈 요청 */
	@RequestMapping("admin_home.do")
	public String adminView() {
		return "admin_home";
	}
	
	/** 비회원 홈 요청 */
	@RequestMapping("no_home.do")
	public String no_homeView() {
		return "no_home";
	}
}
