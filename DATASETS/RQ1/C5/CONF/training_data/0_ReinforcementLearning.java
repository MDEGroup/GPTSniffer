import org.deepforge.rl.agent.qlearning.QLearning;
import org.deepforge.rl.agent.qlearning.QLearningFactory;
import org.deepforge.rl.environment.Environment;
import org.deepforge.rl.environment.State;
import org.deepforge.rl.environment.action.ActionSpace;

public class QLearningExample {

    public void run() {
        
        Environment environment = new MyEnvironment();
        ActionSpace actionSpace = new MyActionSpace();

        
        QLearning agent = QLearningFactory.create(environment, actionSpace);

        
        for (int i = 0; i < 10000; i++) {
            State state = environment.getInitialState();
            while (!environment.isTerminal(state)) {
                int action = agent.chooseAction(state);
                State nextState = environment.step(state, action);
                double reward = environment.getReward(state, action, nextState);
                agent.learn(state, action, nextState, reward);
                state = nextState;
            }
        }
    }
}

