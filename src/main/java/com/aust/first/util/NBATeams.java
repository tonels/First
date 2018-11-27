package com.aust.first.util;

import java.util.Random;

public class NBATeams {
	
	private NBATeams(){  }
	
	
	public static String randomTeam(){
	 String[] teams = {"Atlanta Hawks","Boston Celtics","Brooklyn Nets",
			"Charlotte Hornets","Chicago Bulls","Cleveland Cavaliers",
			"Dallas Mavericks","Denver Nuggets","Detroit Pistons",
			"Golden State Warriors","Houston Rockets","Indiana Pacers",
			"LA Clippers","Los Angeles Lakers","Memphis Grizzlies",
			"Miami Heat","Milwaukee Bucks","Minnesota Timberwolves",
			"New Orleans Pelicans","New York Knicks","Phoenix Suns",
			"Orlando Magic","Philadelphia 76ers","Oklahoma City Thunder",
			"Portland Trail Blazers","Sacramento Kings","Utah Jazz",
			"Toronto Raptors","San Antonio Spurs","Washington Wizards"};
		return teams[new Random().nextInt(teams.length-1)];
	}
}
