package com.albo.model;

import java.util.ArrayList;

public class CharacterDataContainer {

	 private float offset;
	 private float limit;
	 private float total;
	 private float count;
	 ArrayList<Character> results = new ArrayList<>();


	 // Getter Methods 

	 public float getOffset() {
	  return offset;
	 }

	 public float getLimit() {
	  return limit;
	 }

	 public float getTotal() {
	  return total;
	 }

	 public float getCount() {
	  return count;
	 }

	 // Setter Methods 

	 public void setOffset(float offset) {
	  this.offset = offset;
	 }

	 public void setLimit(float limit) {
	  this.limit = limit;
	 }

	 public void setTotal(float total) {
	  this.total = total;
	 }

	 public void setCount(float count) {
	  this.count = count;
	 }

	public ArrayList<Character> getResults() {
		return results;
	}

	public void setResults(ArrayList<Character> results) {
		this.results = results;
	}
	 
}
