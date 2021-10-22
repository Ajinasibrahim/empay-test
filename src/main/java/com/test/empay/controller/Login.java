package com.test.empay.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	@PostMapping("/login")
	public ResponseEntity<?> signup(@RequestBody com.test.empay.model.Login login){	
			
			String namePattern="^[a-zA-Z0-9]{10,15}$";
			System.out.println("name is "+login.getName());
			if(login.getName().matches(namePattern)) {
				ResponseEntity.ok("name validation is ok");
				StringBuilder name=new StringBuilder(login.getName());
				StringBuilder rev= name.reverse();
				char ch[]=rev.toString().toCharArray();
				String char5 = "";
				for(int i=0; i<=4;i++) {
					char5=char5+ch[i];
				}
				System.out.println(login.getDob());
				Date date=  login.getDob();
				int day=date.getDate();
				int mnth=date.getMonth();
				int yr=date.getYear();
				System.out.println(day);
				System.out.println(mnth);
				System.out.println(yr);
				String mm="";
				switch(mnth)
				{
					case 0:
						mm="01";
						break;
					case 1:
						mm="02";
						break;
					case 2:
						mm="03";
						break;
					case 3:
						mm="04";
						break;
					case 4:
						mm="05";
						break;
					case 5:
						mm="06";
						break;
					case 6:
						mm="07";
						break;
					case 7:
						mm="08";
						break;
					case 8:
						mm="09";
						break;
					case 9:
						mm="10";
						break;
					case 10:
						mm="11";
						break;
					case 11:
						mm="12";
						break;
				}
				String pass=char5+yr+mm+day;
				System.out.println(pass);
				if(login.getPassword().equals(pass)) {
					ResponseEntity.ok("password validation is ok");
				}else {
					return ResponseEntity.ok("password should be first 5 digit of user name in reverse order + yymmdd(date of birth)");
				}
			}
			else {
				return ResponseEntity.ok("name should be Alpha Numeric , No special character allowed, minimum 10 and maximum 15 length");
			}
		
		
		return ResponseEntity.ok("success");
	}
}
