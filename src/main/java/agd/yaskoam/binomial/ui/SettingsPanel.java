package agd.yaskoam.binomial.ui;

import java.net.URL;
import java.util.ResourceBundle;

import agd.yaskoam.binomial.ui.support.DoubleTextFieldConstraint;
import agd.yaskoam.binomial.ui.support.IntTextFieldConstraint;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * @author Q-YAA
 */
public class SettingsPanel extends BaseComponent {

    @FXML
    private Label nSliderMaxValueLabel;

    @FXML
    private Label pSliderMaxValueLabel;

    @FXML
    private TextField maxNTextField;

    @FXML
    private TextField maxPTextField;

    @FXML
    private Slider nSlider;

    @FXML
    private Slider pSlider;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        nSliderMaxValueLabel.textProperty().bind(nSlider.maxProperty().asString());
        pSliderMaxValueLabel.textProperty().bind(pSlider.maxProperty().asString());

        setTextFieldsEventHandlers();
    }

    private void setTextFieldsEventHandlers() {
        maxNTextField.textProperty().addListener(new IntTextFieldConstraint(maxNTextField));
        maxNTextField.textProperty().addListener(new MaxNFieldOnChangeListener());

        maxPTextField.textProperty().addListener(new DoubleTextFieldConstraint(maxPTextField));
        maxPTextField.textProperty().addListener(new MaxDoubleTextFieldConstraint(1, maxPTextField));
        maxPTextField.textProperty().addListener(new MaxPFieldOnChangeListener());
    }

    private class MaxNFieldOnChangeListener implements ChangeListener<String> {

        @Override
        public void changed(ObservableValue<? extends String> value, String s, String s2) {
            if (!s2.equals("")) {
                nSlider.setMax(Double.parseDouble(s2));
            }
        }
    }

    private class MaxPFieldOnChangeListener implements ChangeListener<String> {

        @Override
        public void changed(ObservableValue<? extends String> value, String s, String s2) {
            if (!s2.equals("")) {
                pSlider.setMax(Double.parseDouble(s2));
            }
        }
    }

    private class MaxDoubleTextFieldConstraint implements ChangeListener<String> {

        private double max;

        private TextField textField;

        public MaxDoubleTextFieldConstraint(double max, TextField textField) {
            this.max = max;
            this.textField = textField;
        }

        @Override
        public void changed(ObservableValue<? extends String> value, String s, String s2) {

            if (!s2.equals("") && Double.parseDouble(s2) > max) {
                textField.setText(s);
            }
        }
    }
}
