package Work;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class CharttPanel {
	static JPanel createChartPanel() {
        String chartTitle = "Function Plot";
        String xAxisLabel = "X";
        String yAxisLabel = "Y";
     
     
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, DataSet.dataset);
        customizeChart(chart);
        return new ChartPanel(chart);
        
    }
    static void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// sets paint color for each series
//		renderer.setSeriesPaint(0, Color.RED);
//		renderer.setSeriesPaint(1, Color.GREEN);
//		renderer.setSeriesPaint(2, Color.YELLOW);

		// sets thickness for series (using strokes)
//		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
//		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
//		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		
		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		
		// sets renderer for lines
		plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.DARK_GRAY);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
    
}
