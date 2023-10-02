package agent_ABCD;

import java.util.Random;

import agent_ABCD.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO

		Random random_Move = new Random();
		int random = random_Move.nextInt(4);
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else if (random == 0) {
			return Environment.MOVE_UP;
		} else if (random == 1) {
			return Environment.MOVE_RIGHT;
		} else if (random == 2) {
			return Environment.MOVE_DOWN;
		} else if (random == 3) {
			return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;

	}
}