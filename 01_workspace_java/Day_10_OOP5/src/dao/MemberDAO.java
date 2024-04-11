package dao;
// DAO - Data Access Object : 데이터를 다루는 것을 목적으로 함

import java.util.ArrayList;

import classes.Member;

// MemberManger has - a  Silver
public class MemberDAO {
//	private Silver[] silverMembers = new Silver[10];
	private ArrayList<Member> members = new ArrayList<>();

	public void addMember(Member member) {
		this.members.add(member);
	}

	public ArrayList<Member> getMember() {
		return this.members;
	}
}
