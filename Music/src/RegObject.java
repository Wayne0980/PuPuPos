import java.awt.Choice;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class RegObject {
	DBlog NameInfo = new DBlog();
	public final int MODETAB = 1;
	public final int MODEMAKE = 2;
	public final int MODENEW = 1;
	public final int MODEALTER = 2;
	public void RegObject(){
		
		
	}
	
	public void createlab(JPanel pal2,String str,int xpos,int ypos,int width,int height,int Mode){
		JLabel la1 = new JLabel(str);
		int xshfit;
		int yshfit;
		if(Mode == MODETAB){
			xshfit = 20;
			yshfit = 85;
			la1.setForeground(Color.ORANGE);
			la1.setBounds(xshfit+(xpos*width),yshfit+(ypos*height),width,height);
			
		}else{
			xshfit = 30;
			yshfit = 40;
			la1.setForeground(Color.WHITE);
			la1.setBounds(xshfit+(xpos*xshfit),yshfit+(ypos*height),width,height);
			
		}
		la1.setFont(new java.awt.Font("Dialog",1,15));   
		pal2.add(la1);

	}
	
	public void createlabteacher(JPanel pal2,String str,int xpos,int ypos,int width,int height,JLabel la,int Mode){
		int xshfit;
		int yshfit;
	    if(Mode==MODETAB){
	    	xshfit = 20;
			yshfit = 85;
			la.setForeground(Color.ORANGE);
	    }else{
	    	xshfit = 30;
		    yshfit = 40;
			la.setForeground(Color.WHITE);
	    
	    }
	
		la.setFont(new java.awt.Font("Dialog",1,15));   
		la.setBounds(xshfit+(xpos*width),yshfit+(ypos*height),width,height);
		pal2.add(la);
	}
	
	public void ChoiceTimeClass(JPanel pal2,Choice ch){
		
		ch.add("1");ch.add("1.5");
		ch.add("2");ch.add("0.5");
		ch.add(" ");
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(265,148,53,28);
		pal2.add(ch);
	}
    public void ChoiceTeacher(JPanel pal2,Choice ch){
		
		NameInfo.getname("老師基本資料");
		int i=0;
		for(i=0;i<NameInfo.datanum;i++)
			ch.add(NameInfo.names[i]);

		ch.add(" ");
		ch.setBounds(63,388+28,80,28);
		pal2.add(ch);
	}
    public void ChoiceClass(JPanel pal2,Choice ch,int Mode){
    	
		for(int i=0;i<6;i++)
			ch.add(NameInfo.Classnum[i]);
		if(Mode == MODENEW)
			ch.setBounds(65,328+28,67,28);
		else
			ch.setBounds(65,388+28,67,28);
		pal2.add(ch);
	}
    public void ChoiceTime(JPanel pal2,Choice ch){
		
		for(int i=0;i<25;i++)
			ch.add(NameInfo.Times[i]);
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(95,146,100,28);
		pal2.add(ch);
	}
    public void ChoiceDate(JPanel pal2,Choice ch){
    	
		for(int i=0;i<9;i++)
			ch.add(NameInfo.dates[i]);
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(95,146+30,100,28);
		pal2.add(ch);
	}
	
    public void ChoiceMIT(JPanel pal2,Choice ch){
		
		for(int i=0;i<13;i++)
			ch.add(NameInfo.Musical[i]);
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(65,298,80,28);
		pal2.add(ch);
	}
	
	public void ChoiceDay(JPanel pal2,Choice ch){
		
		for(int i=0;i<32;i++)
			ch.add(NameInfo.Dates[i]);
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(245,238,45,28);
		pal2.add(ch);
	}
	
	public void ChoiceMon(JPanel pal2,Choice ch){
		
		for(int i=0;i<13;i++)
			ch.add(NameInfo.Months[i]);
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(168,238,45,28);
		pal2.add(ch);
	}
	public void ChoiceGender(JPanel pal2,Choice ch){
		
		for(int i=0;i<3;i++)
			ch.add(NameInfo.Gender[i]);
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(65,268,45,28);
		pal2.add(ch);
	}
	public void ChoiceJob(JPanel pal2,Choice ch,int Mode){
		
		ch.add("學生");
		ch.add("老師");
		ch.add("工讀生");
		ch.add(" ");
		//ch.addItemListener((ItemListener) this);
		if(Mode == MODEALTER)
			ch.setBounds(65,298+28,50,28);
		else
			ch.setBounds(65,359+28,50,28);
		pal2.add(ch);
		ch.setEnabled(false);
	}
	
	
	
}
