package banana_admin.controller;
import java.util.ArrayList;

import banana_admin.dao.UserDao;
import banana_admin.domain.User;
import banana_admin.view.AlertView;
import banana_admin.view.SelectOneUserView;
import banana_admin.view.UserInfoUpdateView;
import banana_admin.view.UserInfoView;

public class UserController {

	private UserDao userDao;
	private int number; 
	User user=new User(); 


	public UserController() {

		userDao = new UserDao();

	}

	public void requestUpdateUserInfo() {

		UserInfoUpdateView userInfoUpdateView = new UserInfoUpdateView();
		userInfoUpdateView.willUpdateUser(this.number);

		//Dao 통해 수정
		boolean success =userDao.updateUserInfo(user);

		AlertView alertView = new AlertView();
		if(success) {
			alertView.alert("회원삭제 성공");
		} else {
			alertView.alert("회원삭제 실패");
		}


		//관리자메뉴로가...

	}

	public void requestDeleteUser() {


		//dao
		boolean success = userDao.deleteUser(this.number);

		AlertView alertView = new AlertView();

		if(success) {
			alertView.alert("회원삭제 성공");
		} else {
			alertView.alert("회원삭제 실패");
		}

		//관리자 메뉴로가기

	}

	public void requestAllUser(){

		ArrayList<User> user=userDao.AllUserList();

		UserInfoView infoView=new UserInfoView();
		infoView.printUserInfo(user);

	}

	public void requestOneUser(){

		SelectOneUserView selectOneView=new SelectOneUserView();	
		selectOneView.selectOneUserView(userDao.selectOneUser(this.number));

	}

	public int requestReturnNumber(){

		return this.number;

	}

	public void responseSelectReturnNumber(int number){

		this.number = number; 
	}

	public void requestResponseUser(User user){
		this.user=user;
	}

	public void requestMenu(){

		UserInfoView userInfoView = new UserInfoView();
		userInfoView.menu();

	}

}
