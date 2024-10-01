package zerobase.weather.error;

import org.aspectj.bridge.Message;

public class InvalidDate extends RuntimeException {
    private static final String MESSAGE = "너무 과거 혹은 미래의 메시지 입니다.";

    public InvalidDate() {
        super(MESSAGE);
    }
}
