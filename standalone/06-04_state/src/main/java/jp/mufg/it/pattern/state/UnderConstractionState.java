package jp.mufg.it.pattern.state;

public class UnderConstractionState implements State {

    @Override
    public boolean canDoAction(String actionName) {
        return false;
    }

    @Override
    public State doAction(String actionName) {
        if (actionName.equals("apply")) {
            System.out.println("[ UnderConstractionState#doAction ] action = apply, newState = ApprovalPendingState");
            return new ApprovalPendingState();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
