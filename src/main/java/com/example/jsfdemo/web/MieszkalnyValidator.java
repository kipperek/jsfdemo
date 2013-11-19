package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cmValidator")
public class MieszkalnyValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		int czy_mieszkalny = (Integer) value;
		
		
		if (czy_mieszkalny > 999999) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Nie może być więcej okien niż 999999");
			message.setSummary("Nie może być więcej okien niż 999999");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
