package com.dd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items_list")
public class ItemEntity {
	
	@Id
	@Column(name = "item_id")
	private String itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "health_points")
	private int healthPoints;
	@Column(name = "defense_ranged")
	private int defenseRanged;
	private int energy;
	@Column(name = "energy_regen")
	private int energyRegen;
	private int strength;
	@Column(name = "movement_speed")
	private int movementSpeed;
	@Column(name = "attack_speed")
	private int attackSpeed;
	private int awareness;
	@Column(name = "melee_prof")
	private int meleeProf;
	@Column(name = "ranged_prof")
	private int rangedProf;
	@Column(name = "force_prof")
	private int forceProf;
	@Column(name = "attack_range")
	private int attackRange;
	private int computer;
	private int repair;
	@Column(name = "martial_arts")
	private int martialArts;
	private int armor;
	@Column(name = "defense_melee")
	private int defenseMelee;
	@Column(name = "pilot_prof")
	private int pilotProf;
	@Column(name = "starship_combat")
	private int starshipCombat;
	@Column(name = "force_shield")
	private int forceShield;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
}
