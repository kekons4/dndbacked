package com.dd.dao;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import com.dd.entity.UserEntity;
import com.dd.model.Users;
import com.dd.utility.HashingUtility;

@Repository("UserDAO")
public class UsersDAOImpl implements UsersDAO{
	
	@Autowired
	private EntityManager em;
	
	//Adds a character to the DB
	@Override
	public String registerChar(Users user) {
		UserEntity ue = new UserEntity();
		int id = new Random().nextInt(10000);
		String charId = "C" + id;
		
		//Test to see whether the character id is unique
		UserEntity test = em.find(UserEntity.class, charId);
		while(test != null) {
			id = new Random().nextInt(10000);
			charId = "C" + id;
			test = null;
			test = em.find(UserEntity.class, charId);
		}
		
		ue.setCharId(charId);
		ue.setPlayerName(user.getPlayerName());
		ue.setInventoryId("INV" + id);
		ue.setArmor(0);
		ue.setAttackRange(1);
		ue.setAttackSpeed(1);
		ue.setAwareness(1);
		ue.setComputer(0);
		ue.setCurrentXp(0);
		ue.setDefenseMelee(1);
		ue.setDefenseRanged(1);
		ue.setEnergy(0);
		ue.setEnergyRegen(0);
		ue.setForceProf(0);
		ue.setForceShield(0);
		ue.setHealthPoints(1);
		ue.setLevel(1);
		ue.setMartialArts(1);
		ue.setMeleeProf(1);
		ue.setMovementSpeed(1);
		ue.setNextLevelXp(25);
		ue.setOrigin("");
		ue.setPilotProf(0);
		ue.setPlayerActive(true);
		ue.setPowerLevel(0);
		ue.setRangedProf(0);
		ue.setRepair(0);
		ue.setSecurityRating("0");
		ue.setSpecies(user.getSpecies());
		ue.setStarshipCombat(0);
		ue.setStrength(1);
		ue.setTitle("");
		
		em.persist(ue);
		UserEntity check = em.find(UserEntity.class, ue.getCharId());
		if(check == null){
			return "User was not added";
		} else{
			autoINV create = new autoINV();
			String inv = create.createINV(ue.getInventoryId());
			return "The Character: " + ue.getPlayerName() + " has been registered and " + inv;
		}
	}
	
	//Delete the Character from the DB
	@Override
	public String deleteChar(String charId) {
		UserEntity del = em.find(UserEntity.class, charId);
		if(del == null) {
			return "Character was not deleted";
		} else {
			em.remove(del);
			return "Character was Successfully deleted";
		}
	}
	
	
	//Get Data/Stats of Character
	@Override
	public Users getChar(String charId) {
		UserEntity search = em.find(UserEntity.class, charId);
		if(search == null) {
			return null;
		} else {
			Users user = new Users();
			user.setArmor(search.getArmor());
			user.setAttackRange(search.getAttackRange());
			user.setAttackSpeed(search.getAttackSpeed());
			user.setAwareness(search.getAwareness());
			user.setCharId(search.getCharId());
			user.setComputer(search.getComputer());
			user.setCredits(search.getCredits());
			user.setCurrentXp(search.getCurrentXp());
			user.setDefenseMelee(search.getDefenseMelee());
			user.setDefenseRanged(search.getDefenseRanged());
			user.setEnergy(search.getEnergy());
			user.setEnergyRegen(search.getEnergyRegen());
			user.setForceProf(search.getForceProf());
			user.setForceShield(search.getForceShield());
			user.setHealthPoints(search.getHealthPoints());
			user.setInventoryId(search.getInventoryId());
			user.setLevel(search.getLevel());
			user.setMartialArts(search.getMartialArts());
			user.setMeleeProf(search.getMeleeProf());
			user.setMovementSpeed(search.getMovementSpeed());
			user.setNextLevelXp(search.getNextLevelXp());
			user.setOrigin(search.getOrigin());
			user.setPilotProf(search.getPilotProf());
			user.setPilotRating(search.getPilotRating());
			user.setPlayerActive(search.isPlayerActive());
			user.setPlayerName(search.getPlayerName());
			user.setPowerLevel(search.getPowerLevel());
			user.setRangedProf(search.getRangedProf());
			user.setRepair(search.getRepair());
			user.setStrength(search.getStrength());
			user.setSecurityRating(search.getSecurityRating());
			user.setSpecies(search.getSpecies());
			user.setStarshipCombat(search.getStarshipCombat());
			user.setTitle(search.getTitle());
			user.setWampaWampa(search.getWampaWampa());
			return user;
		}
	}
	
	//Level up Character Stats
	@Override
	public String modifyChar(Users user) {
		UserEntity search = em.find(UserEntity.class, user.getCharId());
		int limit = 0;
		
		limit += user.getArmor() - search.getArmor();
		limit += user.getAttackSpeed() - search.getAttackSpeed();
		limit += user.getAwareness() - search.getAwareness();
		limit += user.getComputer() - search.getComputer();
		limit += user.getDefenseMelee() - search.getDefenseMelee();
		limit += user.getDefenseRanged() - search.getDefenseRanged();
		limit += user.getEnergy() - search.getEnergy();
		limit += user.getEnergyRegen() - search.getEnergyRegen();
		limit += user.getForceProf() - search.getForceProf();
		limit += user.getForceShield() - search.getForceShield();
		limit += user.getHealthPoints() - search.getHealthPoints();
		limit += user.getMartialArts() - search.getMartialArts();
		limit += user.getMeleeProf() - search.getMeleeProf();
		limit += user.getMovementSpeed() - search.getMovementSpeed();
		limit += user.getPilotProf() - search.getPilotProf();
		limit += user.getRangedProf() - search.getRangedProf();
		limit += user.getRepair() - search.getRepair();
		limit += user.getStarshipCombat() - search.getStarshipCombat();
		limit += user.getStrength() - search.getStrength();
		
		if(limit > 13) {
			return "ERROR to many points entered...";
		} else {
			search.setArmor(user.getArmor());
			search.setAttackSpeed(user.getAttackSpeed());
			search.setAwareness(user.getAwareness());
			search.setComputer(user.getComputer());
			search.setDefenseMelee(user.getDefenseMelee());
			search.setDefenseRanged(user.getDefenseRanged());
			search.setEnergy(user.getEnergy());
			search.setEnergyRegen(user.getEnergyRegen());
			search.setForceProf(user.getForceProf());
			search.setForceShield(user.getForceShield());
			search.setHealthPoints(user.getHealthPoints());
			search.setMartialArts(user.getMartialArts());
			search.setMeleeProf(user.getMeleeProf());
			search.setMovementSpeed(user.getMovementSpeed());
			search.setPilotProf(user.getPilotProf());
			search.setRangedProf(user.getRangedProf());
			search.setRepair(user.getRepair());
			search.setStarshipCombat(user.getStarshipCombat());
			search.setStrength(user.getStrength());
			em.persist(search);
			return "Successfully updated the characters stats...";
		}
	}
	
	//Add Level One stats of new Character 
	@Override
	public String lvlOneChar(Users user) {
		UserEntity search = em.find(UserEntity.class, user.getCharId());
		int limit = 0;
		
		limit += user.getArmor() - search.getArmor();
		limit += user.getAttackSpeed() - search.getAttackSpeed();
		limit += user.getAwareness() - search.getAwareness();
		limit += user.getComputer() - search.getComputer();
		limit += user.getDefenseMelee() - search.getDefenseMelee();
		limit += user.getDefenseRanged() - search.getDefenseRanged();
		limit += user.getEnergy() - search.getEnergy();
		limit += user.getEnergyRegen() - search.getEnergyRegen();
		limit += user.getForceProf() - search.getForceProf();
		limit += user.getForceShield() - search.getForceShield();
		limit += user.getHealthPoints() - search.getHealthPoints();
		limit += user.getMartialArts() - search.getMartialArts();
		limit += user.getMeleeProf() - search.getMeleeProf();
		limit += user.getMovementSpeed() - search.getMovementSpeed();
		limit += user.getPilotProf() - search.getPilotProf();
		limit += user.getRangedProf() - search.getRangedProf();
		limit += user.getRepair() - search.getRepair();
		limit += user.getStarshipCombat() - search.getStarshipCombat();
		limit += user.getStrength() - search.getStrength();
		
		if(limit > 60) {
			return "ERROR to many points entered...";
		} else {
			search.setArmor(user.getArmor());
			search.setAttackSpeed(user.getAttackSpeed());
			search.setAwareness(user.getAwareness());
			search.setComputer(user.getComputer());
			search.setDefenseMelee(user.getDefenseMelee());
			search.setDefenseRanged(user.getDefenseRanged());
			search.setEnergy(user.getEnergy());
			search.setEnergyRegen(user.getEnergyRegen());
			search.setForceProf(user.getForceProf());
			search.setForceShield(user.getForceShield());
			search.setHealthPoints(user.getHealthPoints());
			search.setMartialArts(user.getMartialArts());
			search.setMeleeProf(user.getMeleeProf());
			search.setMovementSpeed(user.getMovementSpeed());
			search.setPilotProf(user.getPilotProf());
			search.setRangedProf(user.getRangedProf());
			search.setRepair(user.getRepair());
			search.setStarshipCombat(user.getStarshipCombat());
			search.setStrength(user.getStrength());
			em.persist(search);
			return "Successfully add level one character stats...";
		}
	}

}