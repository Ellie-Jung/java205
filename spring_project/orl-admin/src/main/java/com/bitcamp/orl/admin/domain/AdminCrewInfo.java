package com.bitcamp.orl.admin.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCrewInfo {
	private List<Crew> crewList;
	private List<CrewMemberList> crewRegList;
}