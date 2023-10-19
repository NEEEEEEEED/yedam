package com.yedam.java.ch03_example;

public class Player {
	// 필드
	private PlayerLevel level;

	// 생성자
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}

	// 메서드
	public PlayerLevel getLevel() {
		return level;
	}

	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}

	public void play(int count) {
		level.go(count);
	}
}
