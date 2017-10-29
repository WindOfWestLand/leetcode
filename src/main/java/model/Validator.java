package model;

/**
 * Created by 孙亮 on 2017/10/29.
 */
public abstract class Validator {

    private ValidationNotificationHandler validationNotificationHandler;

    public Validator(ValidationNotificationHandler validationNotificationHandler) {
        super();
        this.setValidationNotificationHandler(validationNotificationHandler);
    }

    public abstract void validate();

    protected ValidationNotificationHandler notificationHandler() {
        return this.validationNotificationHandler;
    }

    private void setValidationNotificationHandler(ValidationNotificationHandler validationNotificationHandler) {
        this.validationNotificationHandler = validationNotificationHandler;
    }
}
