import java.awt.AWTEvent;
import javax.swing.JButton;


public class Button extends JButton {

	private static final long serialVersionUID = 1L;
	Zoom1 zoom1Instance;
	Zoom2 zoom2Instance;
    
	
	Button(Zoom1 zm1, Zoom2 zm2){
		enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK+AWTEvent.MOUSE_EVENT_MASK);
		zoom1Instance=zm1;
		zoom2Instance=zm2;
		setLayout(null);
		setVisible(true); 
   }
   public void processEvent(AWTEvent ev){
	   int[] location1,location2;
	   location1=zoom1Instance.getLoc();
	   location2=zoom2Instance.getLoc();
	   if(ev.getID()==500){
			if(((Button)(ev.getSource())).getText().equals("R")){
				if(location1[0]<=84){
					zoom1Instance.setLoc(location1[0]+6, location1[1]);
					zoom2Instance.setLoc(location2[0]-40, location2[1]);
				}
			}
			if(((Button)(ev.getSource())).getText().equals("L")){
				if(location1[0]>0){
					zoom1Instance.setLoc(location1[0]-6, location1[1]);
					zoom2Instance.setLoc(location2[0]+40, location2[1]);
				}
				
			}
			if(((Button)(ev.getSource())).getText().equals("U")){
				if(location1[1]>0){
					zoom1Instance.setLoc(location1[0], location1[1]-6);
					zoom2Instance.setLoc(location2[0], location2[1]+40);
				}
				
			}
			if(((Button)(ev.getSource())).getText().equals("D")){
				if(location1[1]<=84){
					zoom1Instance.setLoc(location1[0], location1[1]+6);
					zoom2Instance.setLoc(location2[0], location2[1]-40);
				}
				
			}
			zoom1Instance.repaint();
			zoom2Instance.repaint();

				
		super.processEvent(ev);
		}
	
	
	}
}
