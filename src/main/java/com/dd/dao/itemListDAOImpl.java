package com.dd.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dd.entity.ItemEntity;
import com.dd.model.items;

@Repository("itemListDAO")
public class itemListDAOImpl implements itemListDAO{
	
	@Autowired
	EntityManager em;
	
	//Add Item to the List of items table
	@Override
	public String addItem(items item) throws Exception {
		ItemEntity check = em.find(ItemEntity.class, item.getItemId());
		if(check == null) {
		
			ItemEntity ie = new ItemEntity();
			
			ie.setArmor(item.getArmor());
			ie.setAttackRange(item.getAttackRange());
			ie.setAttackSpeed(item.getAttackSpeed());
			ie.setAwareness(item.getAwareness());
			ie.setComputer(item.getComputer());
			ie.setDefenseMelee(item.getDefenseMelee());
			ie.setDefenseRanged(item.getDefenseRanged());
			ie.setEnergy(item.getEnergy());
			ie.setEnergyRegen(item.getEnergyRegen());
			ie.setForceProf(item.getForceProf());
			ie.setForceShield(item.getForceShield());
			ie.setHealthPoints(item.getHealthPoints());
			ie.setItemId(item.getItemId());
			ie.setItemName(item.getItemName());
			ie.setMartialArts(item.getMartialArts());
			ie.setMeleeProf(item.getMeleeProf());
			ie.setMovementSpeed(item.getMovementSpeed());
			ie.setPilotProf(item.getPilotProf());
			ie.setRangedProf(item.getRangedProf());
			ie.setRepair(item.getRepair());
			ie.setStarshipCombat(item.getStarshipCombat());
			ie.setStrength(item.getStrength());
			
			em.persist(ie);
			return "Successfully added item to DB";
		} else {
			return "ERROR item already Exists in DB...";
		}
	}
	
	//Remove a specific item from the List of all Items table
	@Override
	public String removeItem(String itemId) throws Exception {
		ItemEntity check = em.find(ItemEntity.class, itemId);
		if(check != null) {
			em.remove(check);
			return "Successfully Deleted item from DB";
		} else {
			return "ERROR item does not Exist in DB...";
		}
	}

}
