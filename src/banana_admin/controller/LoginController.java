package banana_admin.controller;
import banana_admin.dao.LoginDao;
import banana_admin.domain.Login;
import banana_admin.view.AlertView;
import banana_admin.view.LoginView;

public class LoginController {

	LoginDao loginDao;

	public LoginController() {
		loginDao = new LoginDao();
	}

	//로그인 요청
	public void requestLogin(){

		//view
		LoginView loginView = new LoginView();
		loginView.LoginView();

	}

	//로그인 응답
	public void responseLogin(Login login){

		//dao 
		boolean success = loginDao.insert(login);
		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("로그인을 성공했습니다.");
		} else{
			alertView.alert("id 또는 password가 틀렸습니다.");
			Controllers.getLoginController().requestLogin();
		}

	}

	//로그아웃 요청
	public void requestLogout(){

		boolean success = loginDao.delete();
		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("로그아웃을 성공했습니다.");
		} 
	}

}
