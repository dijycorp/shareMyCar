package com.sharemycar.bean.nav;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class TemplatesNavigationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * routes générales
	 */

	private String root = "/resources/templates";
	private String menu = "/menu";

	private String basicTemplate = "/BasicTemplate.xhtml";
	private String navLeftTemplate = "/NavLeftTemplate.xhtml";
	private String gridTemplate = "/GridTemplate.xhtml";

	private String content = "/content.xhtml";
	private String footer = "/footer.xhtml";
	private String header = "/header.xhtml";
	private String messages = "/messages.xhtml";
	private String navLeft = "/navLeft.xhtml";
	private String recherche = "/recherche.xhtml";
	private String pageMenuClient = "/menu-espace-client.xhtml";
	private String pageMenuAdmin = "/menu-espace-admin.xhtml";
	private String pageMenuRecherche = "/menu-recherche.xhtml";

	/*
	 * paramètres des routes spéciques
	 */

	/*
	 * methodes
	 */

	public String getBasicTemplate() {return root + basicTemplate;}
	public String getNavLeftTemplate() {return root + navLeftTemplate;}
	public String getGridTemplate(){return root + gridTemplate;}
	
	public String getHeader() {return root + header;}
	public String getMessages() {return root + messages;}
	public String getRecherche() {return root + recherche;}
	public String getContent() {return root + content;}
	public String getNavLeft() {return root + navLeft;}
	public String getFooter() {return root + footer;}
	
	public String getMenuClient() {return root + menu + pageMenuClient;}
	public String getMenuAdmin() {return root + menu + pageMenuAdmin;}
	public String getMenuRecherche() {return root + menu + pageMenuRecherche;}
}
