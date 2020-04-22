package jp.mufg.it.pattern.state;

public class ApprovedState implements State {

    @Override
    public boolean canDoAction(String actionName) {
        return false;
    }

    @Override
    public State doAction(String actionName) {
        throw new IllegalArgumentException();
    }
}
