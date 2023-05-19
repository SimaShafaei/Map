import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Page extends JLabel {
	
	ImageIcon[] pushLbl=new ImageIcon[9];	
	ImageIcon[] bwLbl=new ImageIcon[9];
	ImageIcon[] colorLbl=new ImageIcon[9];
	Page[][] allInstance;
	Zoom1 zoom1Instance;
	Zoom2 zoom2Instance;
	int labelIndex;
	static int state[]={2,0,0,0,0,0,0,0,0};//new int[9];
	
	
	void setState(int[] s){
		state=s;        // 2 for click, 1 for mouse entered, 0 for un selected
	}
	
	void setIndex(int index){
		labelIndex=index;
	}
	public Page(Page[][] allInstance, Zoom1 zm1, Zoom2 zm2){
		zoom1Instance=zm1;
		zoom2Instance=zm2;
		this.allInstance=allInstance;
		 enableEvents(AWTEvent.MOUSE_EVENT_MASK+AWTEvent.MOUSE_MOTION_EVENT_MASK);

	   for (int i=0;i<9;++i){
		  pushLbl[i]=new ImageIcon("./PICTURES/Button/push"+i+".jpg");
		  bwLbl[i]=new ImageIcon("./PICTURES/Button/bw"+i+".jpg");
		  colorLbl[i]=new ImageIcon("./PICTURES/Button/color"+i+".jpg");
		  setVisible(true);
	   }
	   
	}
public void paint(Graphics g){
	super.paint(g);
	for(int i=0;i<9;i++)
		switch(state[labelIndex]){
		case 0:
			setIcon(bwLbl[labelIndex]);
			break;
		case 1: 
			setIcon(pushLbl[labelIndex]);
			break;
		case 2:
			setIcon(colorLbl[labelIndex]);
			break;
			}
	}
public void processMouseEvent(MouseEvent ev){
	int[] tempState=state;
    if(ev.getID()==MouseEvent.MOUSE_ENTERED  && tempState[labelIndex]!=2){
    	tempState[labelIndex]=1;
    	setState(tempState);    	
    }
    if(ev.getID()==MouseEvent.MOUSE_EXITED && tempState[labelIndex]!=2){
    	tempState[labelIndex]=0;
    	setState(tempState);
    }
    if(ev.getID()==MouseEvent.MOUSE_CLICKED){
     	tempState=new int[9];
    	tempState[labelIndex]=2;
    	setState(tempState);
    	for(int m=0;m<3;++m){
    		for(int n=0;n<3;++n){
    			allInstance[m][n].repaint();
    		}
    	}
    	
    	// change picture of zoom1 and zoom2:
    	zoom1Instance.setIndex(labelIndex);
    	zoom1Instance.setLoc(0, 0);
    	zoom1Instance.repaint();
    	
    	zoom2Instance.setIndex(labelIndex);
    	zoom2Instance.setLoc(0,0);
    	zoom2Instance.repaint();
    }
    this.repaint();
    super.processMouseEvent(ev);
	
	
}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
