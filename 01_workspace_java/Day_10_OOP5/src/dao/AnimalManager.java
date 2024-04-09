package dao;

import classes.Gold;

public class AnimalManager {
	private Gold[] members = new Gold[10];
	private int index = 0;

	public void addMeber(Gold members) {
		this.members[index++] = members;
	}

	public Gold[] getMembers() {
		return members;
	}

	public int getIndex() {
		return index;
	}
}
