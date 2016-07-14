package com.sharemycar.bean.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.sharemycar.entity.Ville;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.VilleService;

@FacesConverter("villeConverter")
public class VilleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
                VilleService villeService = FacadeFactory.getInstance().getVilleService();
                return villeService.findById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de conversion", "Aucune ville trouv�"));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null) {
			return String.valueOf(((Ville) object).getId());
		}
        else {
            return null;
        }
	}

}
