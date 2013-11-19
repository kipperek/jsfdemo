package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Building;

@ApplicationScoped
public class BuildingManager {
	private List<Building> db = new ArrayList<Building>();
	
	public void addBuilding(Building building){
		Building building2 = new Building();
		
		building2.setAdres(building.getAdres());
		building2.setMiasto(building.getMiasto());
		building2.setIloscOkien(building.getIloscOkien());
		building2.setKolor(building.getKolor());
		building2.setMieszkalny(building.getMieszkalny());
		building2.setWysokosc(building.getWysokosc());
		building2.setYob(building.getYob());
		
		db.add(building2);
	}
	
	public List<Building> getAllBuildings(){
		return db;
	}
	
		public void deleteBuilding(Building building) {
			Building buildingToRemove = null;
			for (Building b : db) {
				if (building.getAdres().equals(b.getAdres())) {
					buildingToRemove = b;
					break;
				}
			}
			if (buildingToRemove != null)
				db.remove(buildingToRemove);
		}


}
