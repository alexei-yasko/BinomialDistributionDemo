package agd.yaskoam.binomial.support;

import agd.yaskoam.binomial.UiUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * @author Q-YAA
 */
public class IntTextFieldConstraint implements ChangeListener<String> {

    private TextField textField;

    public IntTextFieldConstraint(TextField textField) {
        this.textField = textField;
    }

    @Override
    public void changed(ObservableValue<? extends String> value, String s, String s2) {

        if (!UiUtils.isInt(s2) && !s2.equals("")) {
            textField.setText(s);
        }
    }
}