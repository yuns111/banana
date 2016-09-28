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

	public UserController() {

		userDao = new UserDao();

	}

	//조회 요청
	public void requestOneUser(){

		SelectOneUserView selectOneView=new SelectOneUserView();	
		selectOneView.selectOneView();

	}

	//조회 응답
	public void responseOneUser(int number){

		//dao에가서 해당 번호 유저 정보를 받아와
		User user = userDao.selectOneUser(number);

		//view에 가서 그 정보를 출력하는 것
		SelectOneUserView selectOneView=new SelectOneUserView();	
		selectOneView.selectOneUserView(user);
	}

	//수정 요청
	public void requestUpdateUserInfo(){
		
		UserInfoUpdateView userInfoUpdateView=new UserInfoUpdateView();
		userInfoUpdateView.selectUpdateView();
	}

	//수정 응답
	public void responseUpdateUserInfo(int number) {

		UserInfoUpdateView userInfoUpdateView=new UserInfoUpdateView();
		userInfoUpdateView.willUpdateUser(number);

	}

	public void requestResponseUser(User user){
		boolean success =userDao.updateUserInfo(user);

		AlertView alertView = new AlertView();
		if(success) {
			alertView.alert("회원수정 성공");
		} else {
			alertView.alert("회원수정 실패");
		}

	}

	//삭제 요청
	public void requestDeleteUser(){
		SelectOneUserView selectOneUserView=new SelectOneUserView();
		selectOneUserView.selectDeleteView();
	}

	//삭제 응답
	public void responseDeleteUser(int number) {

		//dao
		boolean success = userDao.deleteUser(number);

		AlertView alertView = new AlertView();

		if(success) {
			alertView.alert("회원삭제 성공");
		} else {
			alertView.alert("회원삭제 실패");
		}

	}

	public void requestAllUser(){

		ArrayList<User> user=userDao.AllUserList();

		UserInfoView infoView=new UserInfoView();
		infoView.printUserInfo(user);

	}

	//메뉴 요청
	public void requestMenu(){

		UserInfoView userInfoView = new UserInfoView();
		userInfoView.menu();

	}

}
