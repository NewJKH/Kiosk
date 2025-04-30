package org.example.core.ui;

/**
 * UIHandler는 템플릿 메서드 패턴을 따르는 추상 클래스입니다.
 * UI 표시 → 사용자 입력 → 입력 처리의 순서를 고정하고,
 * 각 단계는 하위 클래스에서 구체적으로 구현하도록 강제합니다.
 *
 * @param <T> 사용자 입력 타입 (예: String, Integer, Enum 등)
 */
public abstract class UIHandler<T> {

    /**
     * UI 처리 전체 흐름을 실행합니다.
     * 순서는 showUI - getInput - handleInput 입니다.
     * 하위 클래스에서 각 단계의 동작을 정의해야 합니다.
     * @see org.example.core.ui.handler.CartHandler 에 임시적으로 주석을 처리하고 나머지는 카트 핸들러처럼 처리 되었습니다.
     */
    public final void process() {
        showUI();
        T input = getInput();
        handleInput(input);
    }

    /**
     * 사용자에게 UI(화면/메뉴)를 보여주는 메서드입니다.
     * 반드시 하위 클래스에서 구현해야 합니다.
     */
    protected abstract void showUI();

    /**
     * 사용자 입력을 받는 메서드입니다.
     *
     * @return 사용자가 입력한 값 (형식은 제네릭 T)
     */
    protected abstract T getInput();

    /**
     * 입력값에 따라 로직을 처리하는 메서드입니다.
     *
     * @param input 사용자 입력값
     */
    protected abstract void handleInput(T input);
}