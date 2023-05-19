import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


class Zoom1 extends JLabel{
	private static final long serialVersionUID = 1L;
	ImageIcon[] mapLbl1=new ImageIcon[9];
	private int[] location=new int[2];
	private int labelIndex;
	
	void setIndex(int index){
		this.labelIndex=index;
	}
	
	void setLoc(int x,int y){
		location[0]=x;
		location[1]=y;
	}
	int[] getLoc(){
		return location;
	}
	
	Zoom1(){
		for (int i=0;i<9;++i){
		  mapLbl1[i]=new ImageIcon("./PICTURES/LABEL/map"+i+".png");
				
		}
		setVisible(true);
	}
	public void	 paint(Graphics g){
          super.paint(g);
          g.setColor(Color.CYAN);
          
          g.drawRect(location[0],location[1],90,90); //x,y,tool,arz
          //DrawRect rect=new DrawRect(20,SurfaceType.AnyColor,CompositType.);
		  setIcon(mapLbl1[labelIndex]);
	 
	}
	
}