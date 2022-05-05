package Work;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.jfree.data.xy.XYDataset;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class XYLineChart extends JFrame {
	static JTextArea funTxt,minTxt,maxTxt;
	XYDataset dataset;
	JPanel chartPanel; 
	public XYLineChart() {
    	super("Function Plotter");
    	
		JLabel l=new JLabel("Function Plotter",JLabel.CENTER);
		l.setFont(new Font("Serif", Font.BOLD , 50));
		l.setForeground(new Color(0, 200, 200));
		
		JPanel panel =new JPanel(new GridLayout(2,1));
		panel.setBackground(Color.gray);
		JPanel panel2 =new JPanel(new GridBagLayout());
		panel2.setBackground(Color.gray);
		GridBagConstraints c = new GridBagConstraints();
		c.insets=new Insets(1,3,1,3);
		c.weightx=.5;
		c.weighty=.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth=3;
		panel2.add(l,c);
		
		
		JLabel funL=new JLabel();
		funL.setText("Function");	
		funL.setFont(new Font("Serif", Font.ITALIC , 30));
		funL.setForeground(new Color(100, 200, 200));
		c.anchor=GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth=1;
		panel2.add(funL,c);
		
		JLabel minL=new JLabel();
		minL.setText("Min X");	
		minL.setFont(new Font("Serif", Font.ITALIC , 30));
		minL.setForeground(new Color(100, 200, 200));
		c.gridx = 2;
		c.gridy = 2;
		panel2.add(minL,c);
		JLabel maxL=new JLabel();
		maxL.setText("Max X");	
		maxL.setFont(new Font("Serif", Font.ITALIC , 30));
		maxL.setForeground(new Color(100, 200, 200));
		c.gridx = 4;
		c.gridy = 2;
		panel2.add(maxL,c);
		funTxt=new JTextArea();
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel2.add(funTxt,c);
		minTxt=new JTextArea();
		c.gridx = 2;
		c.gridy = 4;
		panel2.add(minTxt,c);
		maxTxt=new JTextArea();
		c.gridx = 4;
		c.gridy = 4;
		panel2.add(maxTxt,c);
		JButton plot = new JButton();
		plot.setText("Plot");
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth=3;
		panel2.add(plot,c);
		plot.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				if(panel.isAncestorOf(chartPanel)) {
					panel.remove(chartPanel);
					panel.revalidate();
					panel.repaint();
				}
				try {
					
					dataset = DataSet.createDataset();
					chartPanel = CharttPanel.createChartPanel();
				}catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null,"Wrong input :"+ e1.getMessage(), "Wrong Input Explaination " , JOptionPane.INFORMATION_MESSAGE);
				}
				
				try {
					panel.add(chartPanel);
					panel.revalidate();
					panel.repaint();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
	        }  
	    });
	    panel.add(panel2);
	    
		add(panel, BorderLayout.CENTER);
		setSize(840, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
    }
    
    
    

    
}

