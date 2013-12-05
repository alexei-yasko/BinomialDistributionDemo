package agd.yaskoam.binomial;

import org.apache.commons.math3.distribution.BinomialDistribution;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * @author Q-YAA
 */
public class ProbabilityFunctionChartPanel extends BaseComponent {

    @FXML
    private BarChart<String, Double> probabilityChart;

    private DoubleProperty nProperty = new SimpleDoubleProperty();

    private DoubleProperty pProperty = new SimpleDoubleProperty();

    public ProbabilityFunctionChartPanel() {
        nProperty.addListener(new ParametersChangedListener());
        pProperty.addListener(new ParametersChangedListener());
    }

    public DoubleProperty nProperty() {
        return nProperty;
    }

    public DoubleProperty pProperty() {
        return pProperty;
    }

    private void updateChart(int n, double p) {
        BinomialDistribution binomialDistribution = new BinomialDistribution(n, p);

        XYChart.Series<String, Double> series = new XYChart.Series<>();

        for (int i = 0; i <= n; i++) {

            double probability = binomialDistribution.probability(i);
            series.getData().add(new XYChart.Data<>(Integer.toString(i), probability));
        }

        probabilityChart.getData().clear();
        probabilityChart.getData().add(series);
    }

    private class ParametersChangedListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> value, Number number, Number number2) {
            updateChart(nProperty.intValue(), pProperty.get());
        }
    }
}
