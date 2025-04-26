package org.example.core.ui;

abstract class UIHandler<T> {
    public final void process() {
        showUI();
        T input = getInput();
        handleInput(input);
    }

    protected abstract void showUI();
    protected abstract T getInput();
    protected abstract void handleInput(T input);
}