package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import bean.ForgotPasswordBean;
import bean.RegisterBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ForgotPasswordDAO;

public class ForgotPasswordAction extends ActionSupport implements
ModelDriven<ForgotPasswordBean>, SessionAware {
 
	ForgotPasswordBean fpb;
	
	
	public String getSecretQuestion()
	{
		String question = "";
		try
		{
			ForgotPasswordDAO fp = new ForgotPasswordDAO();
			String check = fpb.getUsername();
			System.out.println("checking username before forgot password"+check);
			fpb.setSecretQuestion(fp.forgotPassword(fpb.getUsername()));
			question = fp.forgotPassword(fpb.getUsername());
			Map session = ActionContext.getContext().getSession();
			session.put("username",check);
			session.put("secretQuestion", question);
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "done";
	}
	
	
	public String setNewPassword(){
		
		ForgotPasswordDAO fp = new ForgotPasswordDAO();
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		fpb.setUsername(username);
		//System.out.println(fpb.getSecretAnswer());
		String status = fp.setNewPassword(username, fpb.getSecretAnswer());
		if(status.equals("done"))
		{
			session.put("message", "done");
			return "done";
		}
		else 
			return "not done";
		
	}
	
	
	public String changePassword() throws Exception
	{
		ForgotPasswordDAO fp = new ForgotPasswordDAO();
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		String password = fpb.getPassword();
		String status = fp.changePassword(password, username);
		if(status.equals("done"))
		{
			return "done";
		}
		else
			return "not done";
		
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	public ForgotPasswordBean getModel() {
		if (fpb == null)
			fpb = new ForgotPasswordBean();
		return fpb;


	}
	

}
