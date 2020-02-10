package com.dd.model;

import java.time.LocalDateTime;

import javax.persistence.Column;

public class Users {
	private String charId;
	private String inventoryId;
	private String playerName;
	private int credits;
	private int wampaWampa;
	private String species;
	private String title;
	private String origin;
	private String securityRating;
	private int level;
	private int currentXp;
	private int nextLevelXp;
	private String pilotRating;
	private int powerLevel;
	private int healthPoints;
	private int defenseRanged;
	private int energy;
	private int energyRegen;
	private int strength;
	private int movementSpeed;
	private int attackSpeed;
	private int awareness;
	private int meleeProf;
	private int rangedProf;
	private int forceProf;
	private int attackRange;
	private int computer;
	private int repair;
	private int martialArts;
	private int armor;
	private int defenseMelee;
	private int pilotProf;
	private int starshipCombat;
	private int forceShield;
	private boolean playerActive;
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSecurityRating() {
		return securityRating;
	}
	public void setSecurityRating(String securityRating) {
		this.securityRating = securityRating;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCurrentXp() {
		return currentXp;
	}
	public void setCurrentXp(int currentXp) {
		this.currentXp = currentXp;
	}
	public int getNextLevelXp() {
		return nextLevelXp;
	}
	public void setNextLevelXp(int nextLevelXp) {
		this.nextLevelXp = nextLevelXp;
	}
	public String getPilotRating() {
		return pilotRating;
	}
	public void setPilotRating(String pilotRating) {
		this.pilotRating = pilotRating;
	}
	public int getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getDefenseRanged() {
		return defenseRanged;
	}
	public void setDefenseRanged(int defenseRanged) {
		this.defenseRanged = defenseRanged;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getEnergyRegen() {
		return energyRegen;
	}
	public void setEnergyRegen(int energyRegen) {
		this.energyRegen = energyRegen;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getMovementSpeed() {
		return movementSpeed;
	}
	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public int getAwareness() {
		return awareness;
	}
	public void setAwareness(int awareness) {
		this.awareness = awareness;
	}
	public int getMeleeProf() {
		return meleeProf;
	}
	public void setMeleeProf(int meleeProf) {
		this.meleeProf = meleeProf;
	}
	public int getRangedProf() {
		return rangedProf;
	}
	public void setRangedProf(int rangedProf) {
		this.rangedProf = rangedProf;
	}
	public int getForceProf() {
		return forceProf;
	}
	public void setForceProf(int forceProf) {
		this.forceProf = forceProf;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getRepair() {
		return repair;
	}
	public void setRepair(int repair) {
		this.repair = repair;
	}
	public int getMartialArts() {
		return martialArts;
	}
	public void setMartialArts(int martialArts) {
		this.martialArts = martialArts;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getDefenseMelee() {
		return defenseMelee;
	}
	public void setDefenseMelee(int defenseMelee) {
		this.defenseMelee = defenseMelee;
	}
	public int getPilotProf() {
		return pilotProf;
	}
	public void setPilotProf(int pilotProf) {
		this.pilotProf = pilotProf;
	}
	public int getStarshipCombat() {
		return starshipCombat;
	}
	public void setStarshipCombat(int starshipCombat) {
		this.starshipCombat = starshipCombat;
	}
	public int getForceShield() {
		return forceShield;
	}
	public void setForceShield(int forceShield) {
		this.forceShield = forceShield;
	}
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public boolean isPlayerActive() {
		return playerActive;
	}
	public void setPlayerActive(boolean playerActive) {
		this.playerActive = playerActive;
	}
	public void setCharId(String charId) {
		this.charId = charId;
	}
	public String getCharId() {
		return charId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getWampaWampa() {
		return wampaWampa;
	}
	public void setWampaWampa(int wampaWampa) {
		this.wampaWampa = wampaWampa;
	}
}
