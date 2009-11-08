package com.client.model.object;

import com.system.data.sheets.Unit_Sheed;

public class Unit {

	/*
	 *
	 * VARIABLES
	 * *********
	 * 
	 */

	private int		health;
	private Player	owner;
	private Unit_Sheed sheet;
	private int		morale;
	private int		experience;
	private int		rank;
	private int		fuel;
	private int		ammo;
		
	
	
	/*
	 *
	 * CONSTRUCTORS
	 * ************
	 * 
	 */

	public Unit( Unit_Sheed type , Player owner ){
		
		this.sheet	= type;
		this.owner	= owner;
		health		= 99;
		morale		= 100;
		experience	= 0;
		rank		= 0;
	}

	/*
	 *
	 * ACCESSING METHODS
	 * *****************
	 * 
	 */
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void increaseHealth( int health ){
		if( this.health + health > 99 ) this.health = 99;
		else this.health += health; 
	}
	
	public void decreaseHealth( int health ){
		if( this.health - health < 0 ) this.health = 0;
		else this.health -= health; 
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Unit_Sheed sheet(){
		return sheet;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public void decreaseFuel(){
		if( this.fuel > 0 ) this.fuel--;
	}

	public void decreaseFuel( int fuel ){
		if( this.fuel - fuel >= 0 ) this.fuel -= fuel;
	}
	
	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public void decreaseAmmo(){
		if( this.ammo > 0 ) this.ammo--;
	}
	
	public int getID(){
		return ( owner.getID() * 10000 ) + owner.getUnits().indexOf(this);
	}
	
	

	/*
	 *
	 * WORK METHODS
	 * ************
	 * 
	 */

	/*
	 *
	 * OUTPUT METHODS
	 * **************
	 * 
	 */

	public void printStatus(){
		System.out.println( toString() );
	}
	
    @Override
	public String toString(){
		
		String s;
		s = "UNIT HEALTH:"+getHealth()+" EXP:"+getExperience()+" MORALE:"+getMorale();
		return s;
	}

}

