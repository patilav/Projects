package action;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import bean.NotesBean;
import dao.NotesDeleteDAO;
import dao.NotesViewDAO;
import dao.NotesAddDAO;
import dao.NotesEditDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.commons.io.FileUtils;

public class NotesAction extends ActionSupport implements
		ModelDriven<NotesBean>, SessionAware, ServletRequestAware {

	String status = null;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	private HttpServletRequest servletRequest;
	NotesBean nb;

	public NotesBean getNb() {
		return nb;
	}

	public void setNb(NotesBean nb) {
		this.nb = nb;
	}

	Map<String, Object> map;

	public String execute() throws Exception {

		Map session = ActionContext.getContext().getSession();
		Integer user_id = (Integer) session.get("user_id");
		if (session == null || user_id == null) {
			return "not done";
		}
		try {

			String filePath = servletRequest.getSession().getServletContext()
					.getRealPath("/").concat("myImages");
			System.out.println(this.userImageFileName);
			System.out.println("Image Location:" + filePath);// see the server
																// console for
																// actual
																// location
			File fileToCreate = new File(filePath, this.userImageFileName);
			System.out.println(fileToCreate);
			FileUtils.copyFile(this.userImage, fileToCreate);// copying image in
																// the new file
			Integer userId = (Integer) session.get("user_id");
			NotesAddDAO ead = new NotesAddDAO();
			System.out.println("id->" + String.valueOf(userId));
			status = ead.addNotes(userId, nb, fileToCreate);
			if (status.equals("success")) {
				return "done";
			}

			else {
				return "not done";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String simpleView() throws SQLException, IOException {
		Map session = (Map) ActionContext.getContext().getSession();
		Integer user_id = (Integer) session.get("user_id");
		System.out.println("user id here is :" + user_id);
		if (session == null || user_id == null) {
			return "not done";
		}
		System.out.println("id->" + nb.getNotes_id());
		NotesViewDAO nvd = new NotesViewDAO();
		List li = new ArrayList();
		li = nvd.getNotesInfo(user_id);
		nb.setNoteslist(nvd.getNotesInfo(user_id));
		session.put("images", li);
		return "done";
	}

	public String editNotesAction() throws Exception {

		Map session = ActionContext.getContext().getSession();
		Integer user_id = (Integer) session.get("user_id");
		if (session == null || user_id == null) {
			return "not done";
		}

		try {
			
			String filePath = servletRequest.getSession().getServletContext()
					.getRealPath("/").concat("myImages");
			System.out.println(this.userImageFileName);
			System.out.println("Image Location:" + filePath);// see the server
																// console for
																// actual
																// location
			File fileToCreate = new File(filePath, this.userImageFileName);
			System.out.println(fileToCreate);
			FileUtils.copyFile(this.userImage, fileToCreate);// copying image in
																// the new file
			
			Integer userId = (Integer) session.get("user_id");
			NotesEditDAO ne = new NotesEditDAO();
			System.out.println("id->" + String.valueOf(userId));
			status = ne.editNotes(nb.getNotes_id(), nb.getName(), nb.getText(),
					fileToCreate);

			status = "success";
			if (status.equals("success")) {
				return "done";
			}

			else {
				return "not done";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String viewNotesForEdit() throws SQLException {
		System.out.println("id->" + nb.getNotes_id());
		NotesViewDAO edo = new NotesViewDAO();
		NotesBean nvb = edo.getNotesForEdit(nb.getNotes_id());
		Map session = ActionContext.getContext().getSession();
		System.out.println(nvb);
		session.put("notesBean", nvb);
		return "done";
	}

	public String deleteNotes() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Integer user_id = (Integer) session.get("user_id");
		if (session == null || user_id == null) {
			return "not done";
		}
		NotesDeleteDAO ead = new NotesDeleteDAO();

		status = ead.deleteNotes(nb.getNotes_id());

		NotesViewDAO nv = new NotesViewDAO();

		List noteslist = nv.view(user_id);
		session.put("user_id", user_id);
		session.put("noteslist", noteslist);

		if (status.equals("success")) {
			return "done";
		}

		else {
			return "not done";
		}
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.map = arg0;

	}

	public NotesBean getModel() {
		if (nb == null)
			nb = new NotesBean();
		return nb;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

}
