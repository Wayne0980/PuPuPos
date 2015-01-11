
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TimerFunc extends TimerTask {
	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy");
	String[] path = {"_0.jpg","_1.jpg","_2.jpg","_3.jpg","_4.jpg","_5.jpg","_6.jpg","_7.jpg","_8.jpg","_9.jpg"};
	String[] pathdate = {"_0_.png","_1_.png","_2_.png","_3_.png","_4_.png","_5_.png","_6_.png","_7_.png","_8_.png","_9_.png"};
	
	JLabel laYear = new JLabel(" ");
	JLabel laSec = new JLabel(" ");
	JLabel laMonth = new JLabel(" ");
	JLabel laDate = new JLabel(" ");
	JLabel laHour = new JLabel(" ");
	JLabel laMin = new JLabel(" ");
	JLabel ImSec_2 =  new JLabel(new ImageIcon("Img/"+path[0]));	
	JLabel ImSec_1 =  new JLabel(new ImageIcon("Img/"+path[0]));	
	JLabel ImMin_2 =  new JLabel(new ImageIcon("Img/"+path[0]));	
	JLabel ImMin_1 =  new JLabel(new ImageIcon("Img/"+path[0]));	
	JLabel ImHour_2 =  new JLabel(new ImageIcon("Img/"+path[0]));	
	JLabel ImHour_1 =  new JLabel(new ImageIcon("Img/"+path[0]));	
	JLabel ImYear_4 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImYear_3 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImYear_2 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImYear_1 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImMonth_2 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImMonth_1 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImDate_2 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel ImDate_1 =  new JLabel(new ImageIcon("Img/"+pathdate[0]));	
	JLabel Im_s =  new JLabel(new ImageIcon("Img/_s_.png"));	
	JLabel Im_s2 =  new JLabel(new ImageIcon("Img/_s_.png"));	
	JLabel Im_M =  new JLabel(new ImageIcon("Img/_M.png"));	
	
	public TimerFunc(){
		int height_ = 35,width_ = 40;
		int shiftx = 30,shifty = 70;
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		//ImSec_2.setBounds(40, 0,50,50);
		//ImSec_1.setBounds(0, 0,50,50);
		ImMin_2.setBounds((d.width/2)+width_,d.height/2+height_,50,50);
		ImMin_1.setBounds((d.width/2),d.height/2+height_,50,50);
		ImHour_2.setBounds((d.width/2)-width_-shiftx,d.height/2+height_,50,50);
		ImHour_1.setBounds((d.width/2)-(2*width_)-shiftx,d.height/2+height_,50,50);
		Im_M.setBounds((d.width/2)-width_+18,d.height/2+height_+7,20,40);
		ImYear_1.setBounds(20+(d.width/2)-(2*width_)-shiftx,d.height/2-shifty,50,50);
		ImYear_2.setBounds(20+(d.width/2)-(3*width_)-shiftx,d.height/2-shifty,50,50);
		ImYear_3.setBounds(20+(d.width/2)-(4*width_)-shiftx,d.height/2-shifty,50,50);
		ImYear_4.setBounds(20+(d.width/2)-(5*width_)-shiftx,d.height/2-shifty,50,50);
		ImMonth_1.setBounds(20+(d.width/2)-(width_),d.height/2-shifty,50,50);
		ImMonth_2.setBounds(20+(d.width/2),d.height/2-shifty,50,50);
		ImDate_1.setBounds(20+(d.width/2)+(width_)+shiftx,d.height/2-shifty,50,50);
		ImDate_2.setBounds(20+(d.width/2)+(2*width_)+shiftx,d.height/2-shifty,50,50);
		Im_s.setBounds(20+(d.width/2)-(2*width_)+20,d.height/2-shifty+5,21,40);
		Im_s2.setBounds(20+(d.width/2)+width_+12,d.height/2-shifty+5,21,40);
		
	}
		
	@ Override
	 public void run() {
		System.out.println("Task °õ¦æ®É¶¡¡G" + new Date());
		getYear(laYear);
		getMonth(laMonth);
		getSec(laSec);
		getDate(laDate);
		getMin(laMin);
		getHour(laHour);
		SetTimeImage();
	}
	public void  SetTimeImage()
	{
		
		ImSec_2.setIcon(new ImageIcon("Img/"+path[(Integer.parseInt(laSec.getText()))%10]));
		ImSec_1.setIcon(new ImageIcon("Img/"+path[(Integer.parseInt(laSec.getText()))/10]));
		ImMin_1.setIcon(new ImageIcon("Img/"+path[(Integer.parseInt(laMin.getText()))/10]));
		ImMin_2.setIcon(new ImageIcon("Img/"+path[(Integer.parseInt(laMin.getText()))%10]));
		ImHour_2.setIcon(new ImageIcon("Img/"+path[(Integer.parseInt(laHour.getText()))%10]));
		ImHour_1.setIcon(new ImageIcon("Img/"+path[(Integer.parseInt(laHour.getText()))/10]));
		ImYear_1.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt(laYear.getText()))%10]));
		ImYear_2.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt((laYear.getText()))%100)/10]));
		ImYear_3.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt((laYear.getText()))%1000)/100]));
		ImYear_4.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt(laYear.getText()))/1000]));
		
		ImMonth_2.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt(laMonth.getText()))%10]));
		ImMonth_1.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt(laMonth.getText()))/10]));
		ImDate_2.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt(laDate.getText()))%10]));
		ImDate_1.setIcon(new ImageIcon("Img/"+pathdate[(Integer.parseInt(laDate.getText()))/10]));
		
	}
	public  String getYear(JLabel laYear){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("YYYY");
	    String ctime = formatter.format(new Date());
	    laYear.setText(ctime);
	    return ctime;
    }
	public String getSec(JLabel laSec){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("ss");
	    String ctime = formatter.format(new Date());
	    laSec.setText(ctime);
	    return ctime;
	    }
	public String getMonth(JLabel laMonth){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("MM");
	    String ctime = formatter.format(new Date());
	    laMonth.setText(ctime);
	    return ctime;
	    }
	public String getDate(JLabel laDate){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("dd");
	    String ctime = formatter.format(new Date());
	    laDate.setText(ctime);
	    return ctime;
	    }
	public String getHour(JLabel laHour){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("hh");
	    String ctime = formatter.format(new Date());
	    laHour.setText(ctime);
	    return ctime;
	    }
	public String getMin(JLabel laMin){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("mm");
	    String ctime = formatter.format(new Date());
	    laMin.setText(ctime);
	    return ctime;
	    }
}
