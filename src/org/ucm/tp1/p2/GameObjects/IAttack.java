package org.ucm.tp1.p2.GameObjects;

public interface IAttack {

	void attack();

	default boolean receiveSlayerAttack(int damage) {return false;};
	default boolean receiveVampireAttack(int damage) {return false;};
}
