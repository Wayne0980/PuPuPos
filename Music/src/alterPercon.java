import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class alterPercon  extends JFrame implements ActionListener{
	int Save = 0;
	DBlog NameInfo = new DBlog();
	RegObject Reg = new RegObject();
	Choice ch1 = new Choice();
	Choice ch2 = new Choice();
	Choice ch4 = new Choice();
	Choice ch5 = new Choice();
	Choice ch3 = new Choice();
	Choice ch6 = new Choice();
	Choice ch7 = new Choice();
	Choice ch8 = new Choice();
	Choice ch9 = new Choice();
	Choice ch10 = new Choice();
	JFrame frm = new JFrame("師生資料查詢");
	int OldClasstime = 0;
	String strperson = null;
	String Oldtime = null;
	String Oldclass = null;
	String OldStrdate = null;
	int Oldclassnum = 0;
	int Olddate = 0;
	
	JPanel Mainpal = new JPanel(new BorderLayout());
	JPanel pal2 = new JPanel(null);
	JFrame frm2 = new JFrame("沒有輸入資料");
	JTextField tf  = new JTextField();
	JTextField tf1  = new JTextField();
	JTextField tf2  = new JTextField();
	JTextField tf3  = new JTextField();
	JTextField tf4  = new JTextField();
	JTextField tf5  = new JTextField();
	public void NoEnter(){		
		frm2.setSize(270,152);
		JLabel img;
		pal2.setSize(270,152);	
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		img = new JLabel(new ImageIcon("Img/NoData.png"));		
		img.setBounds(0, 0,270,152);
		JButton btn = new JButton("確定");
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setForeground(Color.BLACK);
		btn.setBackground(Color.WHITE);
		btn.setActionCommand("NODATAOK");
		btn.setSelected(true);
		btn.setBounds(170,115,80,25);
		btn.addActionListener(this);
		pal2.add(btn);
        pal2.add(img);
		
		Mainpal.add(pal2,BorderLayout.CENTER);
		
		Container content;	
		content = frm2.getContentPane();
		content.add(Mainpal);
		JFrame.setDefaultLookAndFeelDecorated(true);	
		frm2.setAlwaysOnTop(true);
		frm2.getRootPane().setWindowDecorationStyle(JRootPane.NONE );
		frm2.setLocation((d.width - 270)/2, (d.height-152)/2);
	    frm2.setResizable(false);
	    frm2.setUndecorated(true);		
		frm2.setVisible(true);
	}
	public alterPercon(){
		
		
	}
	private void RegPerBtn(String name,String command,int xPos,int yPos,JPanel pal)
	{
		JButton btn = new JButton(name);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setForeground(Color.GRAY);
		btn.setBackground(Color.BLACK);
		btn.setActionCommand(command);
		btn.setSelected(true);
		btn.addActionListener(this);
		btn.setBounds(70+(xPos*100),25+(yPos*50),100,50);
		pal.add(btn);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("close2".equals(e.getActionCommand()))	
			frm.dispose();
		
		if("NODATAOK".equals(e.getActionCommand()))
			frm2.dispose();
		
		if("enter".equals(e.getActionCommand())){			
			
			if(tf.getText().toString().equals("")){
			 frm.setAlwaysOnTop(false);
			 JOptionPane.showMessageDialog(null, "姓名不能空白");
			}
			else{
				for(int j=0;j<ch10.getSelectedIndex()+2;j++){
					int i = ch1.getSelectedIndex();
					String strCh1 = ch1.getItem(i+j);
					if(NameInfo.IsClasstimeEmpty(ch9.getSelectedIndex(),ch5.getSelectedIndex(),strCh1,tf.getText())==0)
					{
						frm.setAlwaysOnTop(false); 
						JOptionPane.showMessageDialog(null, "該時段有人 : "+NameInfo.ClasstimeName );
						return ;
					}
				}
				
				frm.dispose();
				int num = 0;
				String strtmp = null;
				for(int j=0;j<OldClasstime+2;j++){
					num = NameInfo.returnclasstimenum(Olddate,Oldclassnum , Oldtime)+1+j;
					strtmp = Integer.toString(num);
					NameInfo.updateDBLog(Oldclass ,OldStrdate,strtmp,"-無-","編號");
					
				}
				getalterset(strperson);
				PersonInfo J = new PersonInfo();
				J.createfrm_(strperson);
			}
		}
	}
	
	private void getalterset(String str){
		NameInfo.PreInfor[NameInfo._NAME] = tf.getText();
		NameInfo.PreInfor[NameInfo._TEL] = tf1.getText();
		NameInfo.PreInfor[NameInfo._BIRTHDAY] = tf2.getText();
		NameInfo.PreInfor[NameInfo._TEACHER] = tf3.getText();
		NameInfo.PreInfor[NameInfo._IDSTATUS] = tf5.getText();		
		NameInfo.PreInfor[NameInfo._CELLPHONE] = ch1.getSelectedItem();
		NameInfo.PreInfor[NameInfo._EMAIL] = ch3.getSelectedItem();
		NameInfo.PreInfor[NameInfo._CLASSTIME] = ch2.getSelectedItem();
		NameInfo.PreInfor[NameInfo._GENDER] = ch4.getSelectedItem();
		NameInfo.PreInfor[NameInfo._CLASS] = ch5.getSelectedItem();
		NameInfo.PreInfor[NameInfo._MONTH] = ch6.getSelectedItem();
		NameInfo.PreInfor[NameInfo._DAY] = ch7.getSelectedItem();
		NameInfo.PreInfor[NameInfo._MUSICAL] = ch8.getSelectedItem();
		NameInfo.PreInfor[NameInfo._CLASS_DATE] = ch9.getSelectedItem();
		NameInfo.PreInfor[NameInfo._CLASS_HOUR] = ch10.getSelectedItem();
		int i=0;
		NameInfo.getIndex(str+"基本資料",NameInfo.PreInfor[NameInfo._NAME],"姓名");
		for(i=0;i<15;i++)
			NameInfo.updateDBLog(str+"基本資料",NameInfo.str2[i],NameInfo.Index,NameInfo.PreInfor[i],"編號");
			
		if(Save == 1){
			String neckname = null;
			for(i=0;i<ch10.getSelectedIndex();i++){				
				neckname = NameInfo.ReturnMIT(NameInfo.PreInfor[NameInfo._MONTH]);
				NameInfo.updateDBLog(NameInfo.PreInfor[NameInfo._CLASS],NameInfo.PreInfor[NameInfo._CLASS_DATE],Integer.toString(ch1.getSelectedIndex()+1+i),NameInfo.PreInfor[NameInfo._NAME]+neckname,"編號");
			}
		}
	}
	
	public void createfrm(String str,String str2){
		
		JLabel img;
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		
		int frmwidth = 600,frmheight = 600;
		strperson = str2;
		NameInfo.getpersondata(str,NameInfo.PreInfor,str2);
		
		pal2.setSize(frmwidth,frmheight);	
		img = new JLabel(new ImageIcon("Img/paino.jpg"));		
		img.setBounds(0, 0,frmwidth,frmheight);
		RegPerBtn("確定","enter",3,10,pal2);
		RegPerBtn("退出","close2",4,10,pal2);
		RegLab();
		Reg.ChoiceTime(pal2,ch1);
		RegTextFeild(0,0,120,25,tf,0);
		tf.setEnabled(false);
		RegTextFeild(0,1,120,25,tf1,0);
		RegTextFeild(0,4,120,25,tf2,0);
		RegTextFeild(0,5,65,25,tf3,0);
		//RegTextFeild(0,8,120,25,tf4,0);
		RegTextFeild(0,10,216,25,tf5,1);
		tf.setText(NameInfo.PreInfor[NameInfo._NAME+2]);
		tf1.setText(NameInfo.PreInfor[NameInfo._TEL+2]);
		tf2.setText(NameInfo.PreInfor[NameInfo._BIRTHDAY+2]);
		tf3.setText(NameInfo.PreInfor[NameInfo._TEACHER+2]);
		//tf4.setText(strStudent[12]);
		tf5.setText(NameInfo.PreInfor[NameInfo._IDSTATUS+2]);
		Reg.ChoiceGender(pal2,ch4);
		Reg.ChoiceMon(pal2,ch3);
		Reg.ChoiceDay(pal2,ch2);
		Reg.ChoiceMIT(pal2,ch6);
		Reg.ChoiceJob(pal2,ch7,Reg.MODEALTER);
		Reg.ChoiceClass(pal2,ch5,Reg.MODEALTER);
		Reg.ChoiceTeacher(pal2,ch8);
		Reg.ChoiceDate(pal2,ch9);
		Reg.ChoiceTimeClass(pal2,ch10);
		pal2.add(img);
		Mainpal.add(pal2,BorderLayout.CENTER);
		Container content;
		content = frm.getContentPane();
		JFrame.setDefaultLookAndFeelDecorated(true);
		ch1.select(NameInfo.PreInfor[NameInfo._CELLPHONE+2]);
		ch3.select(NameInfo.PreInfor[NameInfo._EMAIL+2]);
		ch2.select(NameInfo.PreInfor[NameInfo._CLASSTIME+2]);
		ch4.select(NameInfo.PreInfor[NameInfo._GENDER+2]);
		ch5.select(NameInfo.PreInfor[NameInfo._CLASS+2]);
		ch6.select(NameInfo.PreInfor[NameInfo._MONTH+2]);
		ch7.select(NameInfo.PreInfor[NameInfo._DAY+2]);
		ch8.select(NameInfo.PreInfor[NameInfo._MUSICAL+2]);
		ch9.select(NameInfo.PreInfor[NameInfo._CLASS_DATE+2]);
		ch10.select(NameInfo.PreInfor[NameInfo._CLASS_HOUR+2]);
		Oldtime = NameInfo.PreInfor[NameInfo._CELLPHONE+2];
		Olddate = ch9.getSelectedIndex();
		Oldclassnum = ch5.getSelectedIndex();
		Oldclass = ch5.getSelectedItem();
		OldStrdate = ch9.getSelectedItem();
		OldClasstime = ch10.getSelectedIndex();
		content.add(Mainpal);
		
		if(NameInfo.PreInfor[11].equals("老師"))
		{		
			ch5.setEnabled(false);
			ch7.setEnabled(false);
			ch8.setEnabled(false);
			ch9.setEnabled(false);
			ch10.setEnabled(false);
			ch1.setEnabled(false);
			ch1.select(" ");
			ch10.select(" ");
			ch9.select(" ");
			ch8.select(" ");
			//ch7.select(" ");
			ch5.select(" ");
			Save = 0;
		}else
			Save = 1;
		
		frm.setSize(frmwidth,frmheight);
		
		frm.getRootPane().setWindowDecorationStyle(JRootPane.NONE );
		frm.setAlwaysOnTop(true);
		frm.setLocation((d.width - frmwidth)/2, (d.height-frmheight)/2);
	    frm.setResizable(false);
	    frm.setUndecorated(true);		
		frm.setVisible(true);
	}
	private void RegLab(){
		Reg.createlab(pal2,"姓名:",0,0,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"電話:",0,1,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"上課時段:",0,2,70,30,Reg.MODETAB);Reg.createlab(pal2,"時數",5,2,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"上課日期:",0,3,70,30,Reg.MODETAB);
		Reg.createlab(pal2,"手機:",0,4,80,30,Reg.MODETAB);
		Reg.createlab(pal2,"生日:",0,5,40,30,Reg.MODETAB);Reg.createlab(pal2,"月:",6,5,20,30,Reg.MODETAB);Reg.createlab(pal2,"日:",10,5,20,30,Reg.MODETAB);
		Reg.createlab(pal2,"性別:",0,6,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"樂器:",0,7,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"身份:",0,8,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"教師:",0,9,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"E-mail:",0,10,60,30,Reg.MODETAB);
		Reg.createlab(pal2,"教室:",0,11,40,30,Reg.MODETAB);
	}
	private void RegTextFeild(int xpos , int ypos , int width,int height,JTextField tf_,int type)
	{
		
		tf_.setLayout(new BorderLayout());
		
		int xshfit = 65;
		if(type == 1)
			xshfit = 75;
		int yshfit = 85;
		tf_.setBounds(xshfit+(xpos*width),yshfit+(ypos*(height+5)), width, height);
		tf_.addActionListener(this);
		
		tf_.selectAll();
		
		tf_.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				if(e.getDocument()== tf1.getDocument()){
					System.out.println("修改tf1\n");
				}
				if(e.getDocument()== tf.getDocument()){
					System.out.println("修改tf\n");
				}
				if(e.getDocument()== tf2.getDocument()){
					System.out.println("修改tf2\n");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getDocument()== tf1.getDocument()){
					System.out.println("修改tf1\n");
				}
				if(arg0.getDocument()== tf.getDocument()){
					System.out.println("修改tf\n");
				}
				if(arg0.getDocument()== tf2.getDocument()){
					System.out.println("修改tf2\n");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
				System.out.println("刪除\n");
			}			
		});
		pal2.add(tf_);
	}
}
