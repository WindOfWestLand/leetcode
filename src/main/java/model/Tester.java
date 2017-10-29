package model;

/**
 * Created by 孙亮 on 2017/10/29.
 */
public class Tester extends Entity {

    @Override
    public void validate() {
        new TesterValidator(this, new TesterValidationHandler()).validate();
    }

    public static void main(String[] args) {
        new Tester().validate();
    }
}
