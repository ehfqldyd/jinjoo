package com.work.spring15.dto;

/**
 * �α��� �������� ���� ������Ŭ����
 */
public class Board {
   private int categoryNo;
   private int boardNo;
   private String userid;
   private String title;
   private String contents;
   private String writeDate;
   
   
   public Board(){}
   
   public Board(int boardNo , String userid, String title , String contents,String writeDate ) {
      
      this.boardNo = boardNo;
      this.userid = userid;
      this.title = title;
      this.contents = contents;
      this.writeDate = writeDate;
   }
   public Board( String userid, String title , String contents ) {
      
      this.userid = userid;
      this.title = title;
      this.contents = contents;
      
   }

   public int getCategoryNo() {
      return categoryNo;
   }

   public void setCategoryNo(int categoryNo) {
      this.categoryNo = categoryNo;
   }

   public int getBoardNo() {
      return boardNo;
   }

   public void setBoardNo(int boardNo) {
      this.boardNo = boardNo;
   }

   public String getUserid() {
      return userid;
   }

   public void setUserid(String userid) {
      this.userid = userid;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

   public String getWriteDate() {
      return writeDate;
   }

   public void setWriteDate(String writeDate) {
      this.writeDate = writeDate;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Board [categoryNo=");
      builder.append(categoryNo);
      builder.append(", boardNo=");
      builder.append(boardNo);
      builder.append(", userid=");
      builder.append(userid);
      builder.append(", title=");
      builder.append(title);
      builder.append(", contents=");
      builder.append(contents);
      builder.append(", writeDate=");
      builder.append(writeDate);
      builder.append("]");
      return builder.toString();
   }
   
   
}


