package com.gnjBook.vo;

import com.gnjBook.dto.Member;
import com.gnjBook.model.MemberDAO;

public class DBSetupFunction {
  public void addMember(String name, String id, String pw, String email, String tel, String birth, String postcode, String address){
    Member new_member = new Member();
    new_member.setName(name);
    new_member.setId(id);
    new_member.setPw(pw);
    new_member.setEmail(email);
    new_member.setTel(tel);
    new_member.setBirth(birth);
    new_member.setPostcode(postcode);
    new_member.setAddress(address);
    MemberDAO dao = new MemberDAO();
    int cnt = dao.addMember(new_member);

    if(cnt>0) {
      System.out.println("정상적으로 회원가입 되었습니다.");
    }
  }
}
