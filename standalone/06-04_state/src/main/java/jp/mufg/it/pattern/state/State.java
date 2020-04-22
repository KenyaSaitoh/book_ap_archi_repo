package jp.mufg.it.pattern.state;

public interface State {
    public abstract boolean canDoAction(String actionName);
    public abstract State doAction(String actionName);
}
