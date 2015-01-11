import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

public class AddNewPercon extends JFrame implements ActionListener,ItemListener{
	DBlog NameInfo = new DBlog();
	RegObject Reg = new RegObject();
	JPanel pal3 = null;
	JFrame frm2 = null;
	JFrame frm = new JFrame("師生資料查詢");
	JPanel Mainpal = new JPanel(new BorderLayout());
	JPanel pal2 = new JPanel(null);
	JTextField tf  = new JTextField();
	JTextField tf1  = new JTextField();
	JTextField tf2  = new JTextField();
	JTextField tf3  = new JTextField();
	
	JTextField tf5  = new JTextField();
	String strPerson = null;
	Choice ch1 = new Choice();
	Choice ch2 = new Choice();
	Choice ch3 = new Choice();
	Choice ch4 = new Choice();
	Choice ch5 = new Choice();
	Choice ch6 = new Choice();
	Choice ch7 = new Choice();
	Choice ch8 = new Choice();
	Choice ch9 = new Choice();
	Choice ch10 = new Choice();
	JLabel la2 = new JLabel("教師:");
	JLabel la3 = new JLabel("教師:");
	public AddNewPercon(){
		
		
	}
	public void AddPerConfrim() {
		int frmwidth2 = 450, frmheight2 = 450;
		
		frm2 = new JFrame("資料明細");
		pal3 = new JPanel(null);
		JLabel img;
		JPanel Mainpal = new JPanel(new BorderLayout());
		img = new JLabel(new ImageIcon("Img/addconfire.jpg"));
		img.setBounds(0, 0, frmwidth2, frmheight2);
		
		RegLab2();
		RegBtn("確定", "enter2", 11, pal3);
		RegBtn("取消", "close2", 10, pal3);
		pal3.add(img);
		Mainpal.add(pal3, BorderLayout.CENTER);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Container content;
		content = frm2.getContentPane();
		JFrame.setDefaultLookAndFeelDecorated(true);
		content.add(Mainpal);
		frm.setAlwaysOnTop(false);
		frm2.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frm2.setSize(frmwidth2, frmheight2);
		frm2.setLocation(((d.width - frmwidth2) / 2)+40, 40+(((d.height - frmheight2) / 2)));
		frm2.setResizable(true);
		frm2.setAlwaysOnTop(true);
		frm2.setVisible(true);
	}

	public void RegLab2() {
		
		Reg.createlab(pal3, "姓名:", 0, 0, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._NAME], 2, 0,100, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "電話:", 0, 1, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._TEL], 2, 1, 160, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "上課時段:", 0, 2, 70, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._CLASSTIME], 3, 2, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "時數:", 6, 2, 70, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._CLASS_HOUR], 8, 2, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "上課日期:", 0, 3, 70, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._CLASS_DATE], 3, 3, 60, 30,Reg.MODEMAKE);
		
		Reg.createlab(pal3, "手機:", 0, 4, 80, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._CELLPHONE], 2, 4, 120, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "生日:", 0, 5, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._BIRTHDAY], 2, 5, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "月:", 4, 5, 20, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._MONTH], 5, 5, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "日:", 6, 5, 20, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._DAY], 7, 5, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "性別:", 0, 6, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._GENDER], 2, 6, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "樂器:", 0, 7, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._MUSICAL], 2, 7, 80, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "身份:", 0, 10, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._IDSTATUS], 2, 10, 60, 30,Reg.MODEMAKE);
		Reg.createlabteacher(pal3, "教師:", 0, 11, 40, 30, la2,Reg.MODEMAKE);
		
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._TEACHER], 2, 11, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "E-mail:", 0, 8, 60, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._EMAIL], 2, 8, 300, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, "教室:", 0, 9, 40, 30,Reg.MODEMAKE);
		Reg.createlab(pal3, NameInfo.PreInfor[NameInfo._CLASS], 2, 9, 60, 30,Reg.MODEMAKE);

	}

	private void RegBtn(String name, String command, int yPos, JPanel pal) {
		JButton btn = new JButton(name);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setForeground(Color.BLACK);
		btn.setBackground(Color.WHITE);
		btn.setActionCommand(command);
		btn.setSelected(true);
		btn.addActionListener(this);
		btn.setBounds(360, 20 + (yPos * 35), 70, 30);
		pal.add(btn);
	}

	private void RegPerBtn(String name,String command,int xPos,int yPos,JPanel pal)
	{
		JButton btn = new JButton(name);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setForeground(Color.ORANGE);
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
		
		if("close".equals(e.getActionCommand())){
			
			closefrm();
			PersonInfo J = new PersonInfo ();
		    
		}
		
		if("enter".equals(e.getActionCommand())){	
			
			if(tf.getText().toString().equals("")){
			 frm.setAlwaysOnTop(false);
			 JOptionPane.showMessageDialog(null, "姓名不能空白");
			}else{
				for(int j=0;j<ch10.getSelectedIndex()+2;j++){
					int i = ch1.getSelectedIndex();
					String strCh1 = ch1.getItem(i+j);
					if(NameInfo.IsClasstimeEmpty(ch9.getSelectedIndex(),ch7.getSelectedIndex(),strCh1,tf.getText())==0)
					{
						frm.setAlwaysOnTop(false); 
						JOptionPane.showMessageDialog(null, "該時段有人 : "+NameInfo.ClasstimeName );
						return;						
					}
				}
				DataInput();	
				AddPerConfrim();
			}
		}
		if("enter2".equals(e.getActionCommand())){	
			frm2.dispose();
			closefrm();	
			Input();
			PersonInfo J = new PersonInfo ();
		}
		if("close2".equals(e.getActionCommand())){	
			frm2.dispose();
			frm.setAlwaysOnTop(true);
		}
	}
	public int Input(){
		String str = null;
		int x = 1;
		if(NameInfo.PreInfor[NameInfo._IDSTATUS].equals('3'))
			x = 0;
		str = NameInfo.GetLastIndex(x);
		if(str == "")
			str = "0";
		int intValue = (Integer.valueOf(str) + 1);
		String stringValue = Integer.toString(intValue);
		if(NameInfo.PreInfor[NameInfo._IDSTATUS].equals('3'))
			NameInfo.updateDBLog("系統資料","個資指數","3",stringValue,"編號");
		else
			NameInfo.updateDBLog("系統資料","個資指數","4",stringValue,"編號");
		
		NameInfo.insertDBLog(NameInfo.PreInfor[NameInfo._CLASS]+"基本資料",stringValue,NameInfo.PreInfor);
        String neckname = null;
        if(NameInfo.PreInfor[NameInfo._IDSTATUS].equals("學生")){
        	for(int i=1;i<ch10.getSelectedIndex()+3;i++){
        		neckname = NameInfo.ReturnMIT(NameInfo.PreInfor[NameInfo._MUSICAL]);
        		NameInfo.updateDBLog(NameInfo.PreInfor[NameInfo._CLASS],NameInfo.PreInfor[NameInfo._CLASS_DATE],Integer.toString(ch1.getSelectedIndex()+i),NameInfo.PreInfor[NameInfo._NAME]+neckname,"編號");
        	}
        }
		return 1;
	}
	public void closefrm(){
		frm.dispose();
	}
	public void DataInput()
	{	
		NameInfo.PreInfor[NameInfo._NAME] = tf.getText();NameInfo.PreInfor[NameInfo._TEL] = tf1.getText();NameInfo.PreInfor[NameInfo._CELLPHONE] = tf2.getText();NameInfo.PreInfor[NameInfo._BIRTHDAY] = tf3.getText();
		NameInfo.PreInfor[NameInfo._TEACHER] = ch8.getSelectedItem();NameInfo.PreInfor[NameInfo._EMAIL] = tf5.getText();
		NameInfo.PreInfor[NameInfo._CLASSTIME] = ch1.getSelectedItem();NameInfo.PreInfor[NameInfo._GENDER] = ch2.getSelectedItem();
		NameInfo.PreInfor[NameInfo._MONTH] = ch3.getSelectedItem();NameInfo.PreInfor[NameInfo._DAY] = ch4.getSelectedItem();
		NameInfo.PreInfor[NameInfo._MUSICAL] = ch5.getSelectedItem();NameInfo.PreInfor[NameInfo._IDSTATUS] = ch6.getSelectedItem();
		NameInfo.PreInfor[NameInfo._CLASS] = ch7.getSelectedItem();NameInfo.PreInfor[NameInfo._CLASS_DATE] = ch9.getSelectedItem();NameInfo.PreInfor[NameInfo._CLASS_HOUR] = ch10.getSelectedItem();
		
		if(ch6.getSelectedItem().equals("老師"))
			NameInfo.PreInfor[NameInfo._TEACHER] =NameInfo.PreInfor[NameInfo._CLASS_DATE] =NameInfo.PreInfor[NameInfo._CLASSTIME]=NameInfo.PreInfor[NameInfo._CLASS_HOUR]=NameInfo.PreInfor[NameInfo._CLASS] = " ";
	}
	
	private void SamethingLocked(boolean b)
	{
		ch8.setVisible(b);
    	la2.setVisible(b);
    	ch7.setVisible(b);
       	ch9.setVisible(b);
       	ch10.setVisible(b);
       	ch1.setVisible(b);	
	}
	public void itemStateChanged(ItemEvent e) {
        Choice c = (Choice) e.getSource();
        
        if (c.getSelectedItem() == "老師") 
        	SamethingLocked(false);
			
        if (c.getSelectedItem() == "學生") 
        	SamethingLocked(true);    
    }

	public void createfrm(String str){
		strPerson = str;
		JLabel img;
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int frmwidth = 600,frmheight = 600;
		
		pal2.setSize(frmwidth,frmheight);	
		img = new JLabel(new ImageIcon("Img/gibson.jpg"));		
		img.setBounds(0, 0,frmwidth,frmheight);
		RegPerBtn("確定","enter",3,10,pal2);
		RegPerBtn("退出","close",4,10,pal2);
		RegLab();
		Reg.ChoiceTime(pal2,ch1);
		
		RegTextFeild(0,0,120,25,tf,0);
		RegTextFeild(0,1,120,25,tf1,0);
		RegTextFeild(0,4,120,25,tf2,0);
		RegTextFeild(0,5,65,25,tf3,0);
		//RegTextFeild(0,8,120,25,tf4,0);
		RegTextFeild(0,8,216,25,tf5,1);
		
		tf3.setText("2014");
		Reg.ChoiceGender(pal2,ch2);
		Reg.ChoiceMon(pal2,ch3);
		Reg.ChoiceDay(pal2,ch4);
		Reg.ChoiceMIT(pal2,ch5);
		Reg.ChoiceJob(pal2,ch6,Reg.MODENEW);
		Reg.ChoiceClass(pal2,ch7,Reg.MODENEW);
		Reg.ChoiceTeacher(pal2,ch8);
		Reg.ChoiceDate(pal2,ch9);
		Reg.ChoiceTimeClass(pal2,ch10);
		pal2.add(img);
		ch6.select(strPerson);
		if(strPerson.equals("老師"))		 
			SamethingLocked(false);
		
		Mainpal.add(pal2,BorderLayout.CENTER);
		Container content;
		content = frm.getContentPane();
		JFrame.setDefaultLookAndFeelDecorated(true);
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		content.add(Mainpal);
		frm.setSize(frmwidth,frmheight);
		
		frm.getRootPane().setWindowDecorationStyle(JRootPane.NONE );
		frm.setAlwaysOnTop(true);
		frm.setLocation((d.width - frmwidth)/2, (d.height-frmheight)/2);
	    frm.setResizable(false);
	    frm.setUndecorated(true);		
		frm.setVisible(true);
	}
	public void RegLab(){
		Reg.createlab(pal2,"姓名:",0,0,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"電話:",0,1,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"上課時段:",0,2,70,30,Reg.MODETAB);Reg.createlab(pal2,"時數",5,2,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"上課日期:",0,3,70,30,Reg.MODETAB);
		Reg.createlab(pal2,"手機:",0,4,80,30,Reg.MODETAB);
		Reg.createlab(pal2,"生日:",0,5,40,30,Reg.MODETAB);Reg.createlab(pal2,"月:",6,5,20,30,Reg.MODETAB);Reg.createlab(pal2,"日:",10,5,20,30,Reg.MODETAB);
		Reg.createlab(pal2,"性別:",0,6,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"樂器:",0,7,40,30,Reg.MODETAB);
		Reg.createlab(pal2,"身份:",0,10,40,30,Reg.MODETAB);
		Reg.createlabteacher(pal2,"教師:",0,11,40,30,la3,Reg.MODETAB);
		Reg.createlab(pal2,"E-mail:",0,8,60,30,Reg.MODETAB);
		Reg.createlab(pal2,"教室:",0,9,40,30,Reg.MODETAB);
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
