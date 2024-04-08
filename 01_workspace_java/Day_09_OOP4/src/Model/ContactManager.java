package Model;

import classes.Contact;

public class ContactManager {
	Contact[] conts = new Contact[100];
	int index = 0;
	int count = 0;

	public void addContact(Contact cont) {
		this.conts[index++] = cont;
	}

	public Contact[] getCont() {
		return conts;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int ContIndex() {
		return index;
	}

}
