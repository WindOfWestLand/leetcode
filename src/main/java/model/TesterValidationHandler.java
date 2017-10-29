package model;

/**
 * Created by 孙亮 on 2017/10/29.
 */
public class TesterValidationHandler implements ValidationNotificationHandler {

    public void handleError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
