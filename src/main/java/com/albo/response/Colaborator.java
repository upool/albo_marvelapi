package com.albo.response;

import java.util.ArrayList;


/***
 * contains the information of the collaborators of a character in all its comics
 * @author PaulM
 *
 */
public class Colaborator {

	String last_sync;
	ArrayList<String> editors;
	ArrayList<String> writers;
	ArrayList<String> colorists;
	
	public Colaborator() {
		this.editors = new ArrayList<>();
		this.writers = new ArrayList<>();
		this.colorists = new ArrayList<>();
	}

	/**
	 * @return the last_sync
	 */
	public String getLast_sync() {
		return last_sync;
	}

	/**
	 * @param last_sync the last_sync to set
	 */
	public void setLast_sync(String last_sync) {
		this.last_sync = last_sync;
	}

	/**
	 * @return the editors
	 */
	public ArrayList<String> getEditors() {
		return editors;
	}

	/**
	 * @param editors the editors to set
	 */
	public void setEditors(ArrayList<String> editors) {
		this.editors = editors;
	}

	/**
	 * @return the writers
	 */
	public ArrayList<String> getWriters() {
		return writers;
	}

	/**
	 * @param writers the writers to set
	 */
	public void setWriters(ArrayList<String> writers) {
		this.writers = writers;
	}

	/**
	 * @return the colorists
	 */
	public ArrayList<String> getColorists() {
		return colorists;
	}

	/**
	 * @param colorists the colorists to set
	 */
	public void setColorists(ArrayList<String> colorists) {
		this.colorists = colorists;
	}
	
	
	
	
}
