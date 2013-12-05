package agd.yaskoam.binomial;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

/**
 * @author Q-YAA
 */
public class MainPanel extends BaseComponent {

    @FXML
    private SettingsPanel settingsPanel;

    @FXML
    private ProbabilityFunctionChartPanel probabilityChartPanel;

    @FXML
    private DistributionFunctionChartPanel distributionChartPanel;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {

        probabilityChartPanel.nProperty().bind(settingsPanel.nProperty());
        probabilityChartPanel.pProperty().bind(settingsPanel.pProperty());

        distributionChartPanel.nProperty().bind(settingsPanel.nProperty());
        distributionChartPanel.pProperty().bind(settingsPanel.pProperty());
    }
}
