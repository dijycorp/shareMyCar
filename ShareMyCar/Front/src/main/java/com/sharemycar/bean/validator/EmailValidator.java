package com.sharemycar.bean.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserService;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	// regex pour l'email
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	private UserService userservice = FacadeFactory.getInstance().getUserService();

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

//		match le regex avec l'email
		matcher = pattern.matcher(value.toString());

		// vérifie que le format de l'email est correct avec le match
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage("E-mail invalide", "Le format de l'email saisie est invalide");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

		// verifie que l'email n'est pas déjà utilisé
		if (!userservice.isUniqueEmail(value.toString())) {
			FacesMessage msg = new FacesMessage("E-mail déjà enregistré",
					"Vous êtes déjà enregistrer avec cette email, essayer de vous connectez ou de réinitialiser votre compte");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
