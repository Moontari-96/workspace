package dao;

import classes.Member;

// MemberManger has - a  Silver

public class MemberManager {
//	private Silver[] silverMembers = new Silver[10];
//	private Gold[] goldMembers = new Gold[10];
	private Member[] members = new Member[10];
	private int index = 0;

	public void addMember(Member member) {
		this.members[index++] = member;
	}

	public Member[] getMember() {
		return this.members;
	}

	public int getIndex() {
		return index;
	}
}
