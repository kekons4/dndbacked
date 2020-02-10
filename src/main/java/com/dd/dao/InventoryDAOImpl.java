package com.dd.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dd.entity.ItemEntity;
import com.dd.model.invItem;
import com.dd.model.inventory;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


@Repository("InventoryDAO")
public class InventoryDAOImpl implements InventoryDAO{
	
	private String tableName = "";
	
	@Autowired
	private EntityManager em;
	
	
	//Get Inventory of Character
	@Override
	public inventory getInventory(String invId) throws Exception {
		this.tableName = invId;
        inventory inter = new inventory();
        invItem pest = new invItem();
        String sql = "SELECT item_id, item_name, quantity FROM " + tableName;
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://192.168.1.134:3306/dd", "pi", "kls619a21b2");
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
            	pest.setItemId(rs.getString(1));
            	pest.setItemName(rs.getString(2));
            	pest.setQuantity(rs.getInt(3));
            	
            	ItemEntity ie = em.find(ItemEntity.class, rs.getString(1));
            	if(ie != null) {
            		pest.setArmor(ie.getArmor());
            		pest.setAttackRange(ie.getAttackRange());
            		pest.setAttackSpeed(ie.getAttackSpeed());
            		pest.setAwareness(ie.getAwareness());
            		pest.setComputer(ie.getComputer());
            		pest.setDefenseMelee(ie.getDefenseMelee());
            		pest.setDefenseRanged(ie.getDefenseRanged());
            		pest.setEnergy(ie.getEnergy());
            		pest.setEnergyRegen(ie.getEnergyRegen());
            		pest.setForceProf(ie.getForceProf());
            		pest.setForceShield(ie.getForceShield());
            		pest.setHealthPoints(ie.getHealthPoints());
            		pest.setMartialArts(ie.getMartialArts());
            		pest.setMeleeProf(ie.getMeleeProf());
            		pest.setMovementSpeed(ie.getMovementSpeed());
            		pest.setPilotProf(ie.getPilotProf());
            		pest.setRangedProf(ie.getRangedProf());
            		pest.setRepair(ie.getRepair());
            		pest.setStarshipCombat(ie.getStarshipCombat());
            		pest.setStrength(ie.getStrength());
            	}
            	inter.addItem(pest);
            	pest = new invItem();
            }
            
            return inter;
        } catch(SQLException e) {
        	System.out.println(e.getMessage());
        	return null;
        }
	}
	
	
	//Add an item to the Characters Inventory
	@Override
	public String addItem(String invId, invItem item) throws Exception {
		this.tableName = invId;
		int count = 0;
		String sql = "SELECT item_id, item_name, quantity FROM " + tableName;
        String sqlInsert = "INSERT INTO " + this.tableName + "(item_id, item_name, quantity) VALUES(" 
        		+ "'" + item.getItemId() + "'" + ", "
        		+ "'" + item.getItemName() + "'" + ", "
        		+ "'" + item.getQuantity()+ "'" + ")";
                
		try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://192.168.1.134:3306/dd", "pi", "kls619a21b2");
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
            	for(int i = 1; i < 100; i++) {
            		if(rs.getString(1).equals(item.getItemId())) {
        				count = item.getQuantity() + rs.getInt(3);
        				pst = conn.prepareStatement("UPDATE " + tableName + " SET quantity = " + count + " WHERE item_id = " + "'" + item.getItemId() + "'");
        				rs = pst.executeQuery();
        				return "Updated the Quantity of the item...";
        			} /*else {
        				return "Failed to update quantity...";
        			}*/
            	}
            }
            pst = conn.prepareStatement(sqlInsert);
            rs = pst.executeQuery();
            return "Added item into DB...";
            
		} catch(SQLException e) {
        	System.out.println(e.getMessage());
        	return "ERROR did not add item...";
        }
	}
	
	
	//Remove item from Characters Inventory
	@Override
	public String removeItem(String itemId, String invId) throws Exception {
		this.tableName = invId;
		String sql = "SELECT item_id FROM " + this.tableName;
		String remove = "DELETE FROM " + this.tableName + " WHERE item_id = " + "'" + itemId + "'";
		
		try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://192.168.1.134:3306/dd", "pi", "kls619a21b2");
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            	for(int i = 1; i < 100; i++) {
            		if(itemId.equals(rs.getString(1))) {
            			pst = conn.prepareStatement(remove);
            			rs = pst.executeQuery();
            			return "Item has been removed from inventory...";
            		}
            	}
            }
            return "ERROR did not remove item...";
		}catch(SQLException e) {
        	System.out.println(e.getMessage());
        	return "ERROR item was not removed...";
        }
	}
}
