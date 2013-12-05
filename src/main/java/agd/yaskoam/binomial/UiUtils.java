package agd.yaskoam.binomial;

import javafx.scene.control.TextField;

/**
 * @author Q-YAA
 */
public class UiUtils {

    public static int getIntValue(TextField textField) {
        return isInt(textField.textProperty().getValue()) ? Integer.parseInt(textField.textProperty().getValue()) : 0;
    }

    public static Double getDoubleValue(TextField textField) {
        return isDouble(textField.textProperty().getValue()) ? Double.parseDouble(textField.textProperty().getValue()) : 0;
    }

    public static boolean isInt(String number) {
        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
        }
        catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
