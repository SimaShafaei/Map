import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Zoom2 extends JLabel{
	
	private static final long serialVersionUID = 1L;
	ImageIcon[] mapLbl2=new ImageIcon[9];
	private int[] location={0,0};
	
	private int labelIndex;
	
	void setLoc(int x,int y){
		location[0]=x;
		location[1]=y;
	}
	int[] getLoc(){
		return location;
	}
	
	void setIndex(int index){
		this.labelIndex=index;
	}
	
	public Zoom2(){
		for(int i=0;i<9;i++)
			mapLbl2[i]=new ImageIcon("./PICTURES/1/map"+i+".png");
			
		
	    setVisible(true);
		
	}
	public void	 paint(Graphics g){
          super.paint(g);
          g.drawImage(mapLbl2[labelIndex].getImage(),location[0],location[1],1200,1200,this);
          
          setIcon(mapLbl2[labelIndex]);
	 
	}
	
}
