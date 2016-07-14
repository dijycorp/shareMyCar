package com.sharemycar.bean.tools;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="dateToolsBean")
@ApplicationScoped
public class DateToolsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Date additionnerDateAvecHeure(Date date1, Date heure2) {

		// variable
		Integer year;
		Integer month;
		Integer date;
		Integer hourOfDay;
		Integer minute;

		// initialisation des deux dates
		Calendar calDateDepart = new GregorianCalendar();
		calDateDepart.setTime(date1);

		Calendar calHeureDepart = new GregorianCalendar();
		calHeureDepart.setTime(heure2);

		// mise en place des variables

		year = calDateDepart.get(Calendar.YEAR);
		month = calDateDepart.get(Calendar.MONTH);
		date = calDateDepart.get(Calendar.DAY_OF_MONTH);
		hourOfDay = calHeureDepart.get(Calendar.HOUR_OF_DAY);
		minute = calHeureDepart.get(Calendar.MINUTE);

		Calendar calDepart = new GregorianCalendar();
		calDepart.set(year, month, date, hourOfDay, minute);

		return calDepart.getTime();
	}

}
