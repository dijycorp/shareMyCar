package com.sharemycar.bean.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.sharemycar.entities.Environnement;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.EnvironnementService;

@FacesConverter("environnementConverter")
public class EnvironnementConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
                EnvironnementService environnementService = FacadeFactory.getInstance().getEnvironnementService();
                return environnementService.findById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de conversion", "Aucun environnement trouvé"));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null) {
			return String.valueOf(((Environnement) object).getId());
		}
        else {
            return null;
        }
	}

}
