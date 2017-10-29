package model;

/**
 * Created by 孙亮 on 2017/10/29.
 */
public class TesterValidator extends Validator {

    private Tester tester;

    public TesterValidator(Tester tester,
                           ValidationNotificationHandler validationNotificationHandler) {
        super(validationNotificationHandler);
        this.setTester(tester);
    }

    public void validate() {
        if(true) {
            System.out.println("Tester Validate");
            this.notificationHandler().handleError("Error");
        }
    }

    private void setTester(Tester tester) {
        this.tester = tester;
    }

}
