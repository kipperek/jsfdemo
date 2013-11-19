package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Building;
import com.example.jsfdemo.service.BuildingManager;

@SessionScoped
@Named("buildingF")
public class BuildingForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Building building = new Building();
	
	private ListDataModel<Building> buildings = new ListDataModel<Building>();

	@Inject
	BuildingManager bm;

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
	public ListDataModel<Building> getAllBuildings() {
		buildings.setWrappedData(bm.getAllBuildings());
		return buildings;
	}
	
	//Action
	public String addBuilding(){
		bm.addBuilding(building);
		return "listBuilding";
	}
	
	public String deleteBuilding() {
		Building buildingToDelete = buildings.getRowData();
		bm.deleteBuilding(buildingToDelete);
		return null;
	}
	//Validation
	public void uniqueAdres(FacesContext context, UIComponent component,
			Object value) {

		String adres = (String) value;

		for (Building building: bm.getAllBuildings()) {
			if (building.getAdres().equalsIgnoreCase(adres)) {
				FacesMessage message = new FacesMessage(
						"Budynek o tym adresie jest już w bazie");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

	public void validateOkna(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput okna = (UIInput) form.findComponent("iloscOkien");
		UIInput wysokosc = (UIInput) form.findComponent("wysokosc");

		if (okna.getValue() != null && wysokosc.getValue() != null) {
			double wys = (Double) wysokosc.getValue();
			int ilOkien = (Integer) okna.getValue();

			

			if (wys * 10 > ilOkien) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"Ilość okien musi być większa niż 10cio krotność wysokości"));
				context.renderResponse();
			}
		}
	}
		
}

