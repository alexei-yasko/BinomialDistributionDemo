package agd.yaskoam.binomial;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author Q-YAA
 */
public class StatusPanel extends BaseComponent {

    @FXML
    private Label nLabel;

    @FXML
    private Label pLabel;

    private DoubleProperty nProperty = new SimpleDoubleProperty();

    private DoubleProperty pProperty = new SimpleDoubleProperty();

    public StatusPanel() {
        nProperty.addListener(new ParametersChangedListener());
        pProperty.addListener(new ParametersChangedListener());
    }

    public DoubleProperty nProperty() {
        return nProperty;
    }

    public DoubleProperty pProperty() {
        return pProperty;
    }

    private class ParametersChangedListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> value, Number number, Number number2) {
            nLabel.setText(Integer.toString(nProperty().intValue()));
            pLabel.setText(pProperty().getValue().toString());
        }
    }
}
