package agd.yaskoam.binomial.support;

import agd.yaskoam.binomial.UiUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * @author Q-YAA
 */
public class DoubleTextFieldConstraint implements ChangeListener<String> {

    private TextField textField;

    public DoubleTextFieldConstraint(TextField textField) {
        this.textField = textField;
    }

    @Override
    public void changed(ObservableValue<? extends String> value, String s, String s2) {

        if (!UiUtils.isDouble(s2) && !s2.equals("")) {
            textField.setText(s);
        }
    }
}