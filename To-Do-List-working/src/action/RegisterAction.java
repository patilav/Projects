package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import bean.RegisterBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.RegisterDAO;

public class RegisterAction extends ActionSupport implements
		ModelDriven<RegisterBean>, SessionAware {

	boolean status;
	RegisterBean rb;

	public RegisterBean getRb() {
		return rb;
	}

	public void setRb(RegisterBean rb) {
		this.rb = rb;
	}

	public String execute() throws Exception{

		RegisterDAO rd = new RegisterDAO();
		try {
			Map session = ActionContext.getContext().getSession();
			String password = rb.getPassword();
			String confirmed_password = rb.getConfirmPassword();
			
			if(password.equals(confirmed_password))
			{
				
			status = rd.registerCustomer(rb.getFname(), rb.getLname(),
					rb.getUsername(), rb.getPassword(), rb.getDob(),
					rb.getSecretQuestion(), rb.getSecretAnswer(),
					rb.getHomePhone(),rb.getWorkPhone(),rb.getMobilePhone());

			if (status) {
				return "done";
			} else {
				return "input";
			}}
			
			else {
				
				session.put("message", "not same");
				return "not same";
			}
			
		} catch (Exception e) {
			System.out.println("Exception Occured!");
			throw e;
		}
	}

	public RegisterBean getModel() {
		if (rb == null)
			rb = new RegisterBean();
		return rb;

	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
	}

}
