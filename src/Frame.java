import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	Page[][] initLabel= new Page[3][3];
	 Zoom1 map1=new Zoom1();
	 Zoom2 map2=new Zoom2();
	 Button arrowKeyup=new Button(map1,map2);
	 Button arrowKeydown=new Button(map1,map2);
	 Button arrowKeyRight=new Button(map1,map2);
	 Button arrowKeyLeft=new Button(map1,map2);
	public Frame() {
//====================================================================		
		map1.setSize(180,180);	
	    map1.setLocation(10,220);
	    getContentPane().add(map1);
        map2.setSize(600,600);
        map2.setLocation(200,5);
        getContentPane().add(map2);
 //=================================================================     
        arrowKeyup.setSize(50,50);
        getContentPane().add(arrowKeyup);
        arrowKeyup.setLocation(75,420);
        arrowKeyup.setText("U");
        arrowKeydown.setSize(50,50);
        getContentPane().add(arrowKeydown);
        arrowKeydown.setText("D");
        arrowKeydown.setLocation(75,520); 
        arrowKeyRight.setSize(50,50);
        arrowKeyRight.setText("R");
        getContentPane().add(arrowKeyRight);
        arrowKeyRight.setLocation(125,470);
        arrowKeyLeft.setSize(50,50);
        arrowKeyLeft.setText("L");
        getContentPane().add(arrowKeyLeft);
        arrowKeyLeft.setLocation(25,470);
//=======================================================================
        for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				 initLabel[i][j] = new Page(initLabel,map1,map2);
				 initLabel[i][j].setIndex(i*3+j);
					 initLabel[i][j].setSize(60, 60);
				 initLabel[i][j].setLocation(10+60*j, 30+60*i);
				 getContentPane().add(initLabel[i][j]);
	
			}
        }
 //=========================================================================        
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width-800)/2,(d.height-630)/2);
		setSize(800,630);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	
	}
	public static void main(String[] args) {
	new Frame();
	}

}
