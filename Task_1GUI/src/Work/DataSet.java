package Work;


import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataSet {
	static XYSeriesCollection dataset ;
	static XYDataset createDataset(){
        dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries(XYLineChart.funTxt.getText());
        String function=XYLineChart.funTxt.getText();
        try {
			for (int i = (int) Double.parseDouble(XYLineChart.minTxt.getText()); i < Double.parseDouble(XYLineChart.maxTxt.getText()); i++) {
				String c= Integer.toString(i);
				String function1=function.replace("x",c);
				
			    System.out.println(EvaluateEqus.eval(function1)+" --> "+ i);
				int func=(int) EvaluateEqus.eval(function1);
				series1.add(i, func);
			}
		} catch (NumberFormatException e) {
			throw new RuntimeException("Min x and Max x must be integers");
			
		}
        
        dataset.addSeries(series1);
        
     
        return dataset;
    }
}
