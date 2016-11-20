package com.work.spring15.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring15.dto.Member;
import com.work.spring15.exception.AuthenticationException;
import com.work.spring15.service.MemberService;

@Controller
public class MemberController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /** spring di : setter injection */
   private MemberService service;
   @Autowired
   public void setService(MemberService service) {
      this.service = service;
   }
   
   /** �α��� ������ ��û */
   @RequestMapping("loginView.do")
   public String loginView() {
      return "login";
   }
   
   /** ȸ������ ������ ��û */
   @RequestMapping("joinView.do")
   public String joinView() {
      return "member/join";
   }
   
   /** �α��� ��û */
   @RequestMapping(value="login.do", method=RequestMethod.POST)
   public ModelAndView login(String userid, String userpw, HttpSession session) throws AuthenticationException {
      System.out.println("\n## controller login : " + userid + ", " + userpw);
      String grade = service.login(userid, userpw);
      
      ModelAndView mv = new ModelAndView();
      if(grade != null) {
         session.setAttribute("userid", userid);
         session.setAttribute("grade", grade);
         
         //mv.addObject("user", userid);
         //mv.addObject("grade", grade);
      
         mv.setViewName("notice/noticeList");
      
      } else {
         mv.addObject("message", "로그인에 실패하셨습니다.");
         mv.setViewName("error/errorLogin");
      }
      return mv;
   }

   /** �α׾ƿ� ��û */
   @RequestMapping("logout.do")
   public String logout(HttpSession session) {
      session.invalidate();
      return "login";
   }
   

   /** ȸ������ ��û 
    * @throws AuthenticationException */
   @RequestMapping(value="join.do", method=RequestMethod.POST)
   public String join(Member member, Model model) throws AuthenticationException {
      if(member.getUserid()!= null && member.getName()!=null && member.getUserpw()!=null&&member.getEmail()!=null&&member.getMobile()!=null){
         int checkNum = service.join(member);
         if(checkNum == 1 ){
            StringBuilder message = new StringBuilder();
            message.append(member.getName());
            message.append("회원 등록을 완료하였습니다.");
            model.addAttribute("message", message);
            
            return "login";
         } else {
            return "error";
         }
      } else { 
         return "errorJoin";
      }
   }   
//
//   /** ��üȸ�� ��ȸ ��û */
//   @RequestMapping("getMemberAll.do")
//   public void getMemberAll() {
//   }
//   
//   /** ȸ�� �� ��ȸ ��û */
//   @RequestMapping("getMember.do")
//   public void getMember() {
//      
//   }
//   
   /** ������ ��ȸ ��û 
    * @throws AuthenticationException */
   @RequestMapping("myInfo.do")
   public ModelAndView myInfo(HttpSession session) throws AuthenticationException {
      String userid = (String)session.getAttribute("userid");
      Member member = service.selectOne(userid);
      
      ModelAndView mav = new ModelAndView();
      if( member != null) {
         // �������� ��� ����
         mav.addObject("userid", userid);
         mav.addObject("name", member.getName());
         mav.addObject("mobile",member.getMobile());
         mav.addObject("email", member.getEmail());
         mav.addObject("gender", member.getGender());
         mav.addObject("birth", member.getBirth());
         mav.addObject("grade", member.getGrade());

         // ���������� �̵�
         mav.setViewName("myInfo");
      } else {
         mav.addObject("message", "회원을 조회하지 못했습니다.");
         mav.setViewName("error/errorLogin");
      }
      return mav;
   }

}






