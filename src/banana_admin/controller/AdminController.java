package banana_admin.controller;

<<<<<<< HEAD
public class AdminController {

	public void insertAdmin(){
		
		// 뷰 호출.
		
		
		
		// dao에 정보 전달. 
		
	}
=======
import java.util.ArrayList;

import banana_admin.dao.AdminDao;
import banana_admin.domain.AdminDomain;
import banana_admin.view.AlertView;
import banana_admin.view.InsertAdminView;

public class AdminController {

	AdminDao adminDao;

	public AdminController() {
		
		adminDao = new AdminDao();
		
	}
	
	public void menuViewToInsertView(){
		InsertAdminView insertAdminView = new InsertAdminView();
		insertAdminView.insertAdminView();
	}
	
	public void RegisterProcess(AdminDomain adminDomain){
		
		this.requestRegisterAdmin(adminDomain);
				
	};
	
	public void requestRegisterAdmin(AdminDomain adminDomain){
		
		//dao로 보내기.

		boolean success = adminDao.insertAdmin(adminDomain);
		
		if(success){
			AlertView alertView = new AlertView();
			alertView.alertView("관리자 등록에 성공했습니다.");
			
		} else {
			System.out.println("관리자 등록에 실패했습니다.");
		}
	}
	
	public ArrayList<AdminDomain> requestSelectAllAdmin(){
		
		ArrayList<AdminDomain> adminInfo= null;
		//dao에서 정보 받아오기
		adminInfo = adminDao.selectAllAdmin();
		//view에서 호출 받기
		return adminInfo;
	}

	
>>>>>>> refs/heads/test-branch
	
}
