package com.sharemycar.bean.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserService;

@FacesValidator(value="loginValidator")
public class LoginValidator implements Validator {

	
	private UserService userService = FacadeFactory.getInstance().getUserService();
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
			if(!userService.isUniqueLogin(value.toString())){
			
				FacesMessage msg = new FacesMessage("Login non disponible", "merci de choisir un nouveau login");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		
	}

}
