import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class PersonInfo extends JFrame implements ActionListener {
	JFrame frm = new JFrame("師生資料查詢");
	JLabel img;
	String strPerson = null;
	//String strStudent[]={"","","","","","","","","","","","","","","","","","","","","","",""};
	String[] names = new String[999];
	AreyousureDelete J = new AreyousureDelete();
	ArrayList<String> Idex = new ArrayList<String>();
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	JTextField tf  = new JTextField();
	JFrame frm_ = new JFrame("Music");
	DBlog NameInfo = new DBlog();
	JButton btn1 = new JButton(new ImageIcon("Img/teacher.png")) {
		 public void paint(Graphics g) {
              Graphics2D g2 = (Graphics2D) g.create();
              g2.setComposite(AlphaComposite.getInstance(
                      AlphaComposite.SRC_OVER, 1.0f));
              super.paint(g2);
              g2.dispose();
          }
	};
	JButton btn2 = new JButton(new ImageIcon("Img/student.png")) {
		 public void paint(Graphics g) {
             Graphics2D g2 = (Graphics2D) g.create();
             g2.setComposite(AlphaComposite.getInstance(
                     AlphaComposite.SRC_OVER, 1.0f));
             super.paint(g2);
             g2.dispose();
         }
	};
	
	
	JButton btn3 = new JButton(new ImageIcon("Img/parter.png")) {
		 public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 1.0f));
            super.paint(g2);
            g2.dispose();
        }
	};
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	
	JComboBox cbInput = new JComboBox(model) {
		public Dimension getPreferredSize() {
			return new Dimension(super.getPreferredSize().width, 0);
		}
	};
	
	private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		 cbInput.putClientProperty("is_adjusting", adjusting);		
	}
	public void createfrm_(String str){
		JPanel pal2 = new JPanel(null);
		JPanel Mainpal = new JPanel(new BorderLayout());
		
		int frmwidth = 300,frmheight = 205;

		Image image = new ImageIcon("Img/sound.png").getImage();
		JLabel la1 = new JLabel("姓名:");

		NameInfo.getname(str+"基本資料");
		int i=0;
		for(i=0;i<NameInfo.datanum;i++){
			//tmp1 = NameInfo.names[i].substring(0,1);	
			Idex.add(NameInfo.names[i]);
			System.out.println(NameInfo.names[i]);
			names[i] = NameInfo.names[i];
		}
		
	    RegComBox();
	    RegBtn("刪除","delete",3,pal2);
		RegBtn("退出","close",4,pal2);
		RegBtn("搜尋","tchsearch",2,pal2);
		RegBtn("修改","editperson",1,pal2);
		RegBtn("新增","addperson",0,pal2);
		la1.setForeground(Color.ORANGE);
		la1.setFont(new java.awt.Font("Dialog",1,15));   
		la1.setBounds(20,160,80,30);

		pal2.setSize(frmwidth,frmheight);	
		img = new JLabel(new ImageIcon("Img/CIA.png"));
		img.setBounds(0, 0,frmwidth,frmheight);
		RegTextFeild();
		pal2.add(tf);
		pal2.add(la1);
		pal2.add(img);
    	
		Mainpal.add(pal2,BorderLayout.CENTER);
		SetFrm(frmwidth,frmheight,image,Mainpal);
		strPerson = str;
	}
	
	public PersonInfo(){
		
		//createfrm_(str);
		
	}
	public void PersonCheck(){
		Container content;	
		JLabel img;
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	    JFrame.setDefaultLookAndFeelDecorated(true);		
		JPanel pal2 = new JPanel(null);
		JPanel Mainpal = new JPanel(new BorderLayout());
		img = new JLabel(new ImageIcon("Img/choseperson.jpg"));
	    img.setBounds(0, 0,339,177);
		pal2.setSize(339,177);
		
		btnset();
		pal2.add(btn1);
	 	pal2.add(btn2);
		pal2.add(btn3);
		pal2.add(img);
		Mainpal.add(pal2,BorderLayout.CENTER);
	
		Image image = new ImageIcon("Img/sound.png").getImage();
		frm_.setIconImage(image);
		frm_.setSize(339,177);	
		frm_.getRootPane().setWindowDecorationStyle(JRootPane.NONE );
		frm_.setLocation((d.width - 339)/2, ((d.height-177)/2)+30);
	    
		content = frm_.getContentPane();
		content.add(Mainpal);
		frm_.setAlwaysOnTop(true);
	    frm_.setResizable(false);
	    frm_.setUndecorated(true);		
		frm_.setVisible(true);	
	}
	public void btnset(){
		
		int btnwidth = 100,btnheight = 100;
		Color c = new Color(0,0,0);//背影颜色随便设任意值,只起占位作用。
		int btnposx = 20;//((d.width/2)-360);
		int btnposy = 60;//((d.height/2)+150);
		btn1.setActionCommand("teacher");
		
		btn1.addActionListener(this);
		btn1.setOpaque(false);//设置透明背影
		btn1.setBackground(c);//必须设置否则不会出现透明背影
		btn2.setActionCommand("student");
		btn2.setSelected(true);
		btn2.addActionListener(this);
		btn2.setOpaque(false);//设置透明背影
		btn2.setBackground(c);//必须设置否则不会出现透明背影
		
		btn3.setActionCommand("parter");
		btn3.addActionListener(this);
		btn3.setSelected(true);
		btn3.setOpaque(false);//设置透明背影
		btn3.setBackground(c);//必须设置否则不会出现透明背影
		//Insets insets = frm.getInsets();
		Dimension size = btn1.getPreferredSize();
		btn1.setBounds(btnposx ,btnposy,btnwidth, btnheight);
		size = btn2.getPreferredSize();
		btn2.setBounds(btnposx+btnwidth , btnposy,btnwidth, btnheight);
		size = btn3.getPreferredSize();
		btn3.setBounds(btnposx+(2*btnwidth) ,btnposy,btnwidth,btnheight);
	}
	private void RegComBox()
	{
		cbInput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.SELECTED){
					if(cbInput.getSelectedIndex()==0){
					}
					else
						tf.setText(names[cbInput.getSelectedIndex()]);
				}
			}
		});	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("close".equals(e.getActionCommand())){
			
			frm.dispose();
		}
		if("teacher".equals(e.getActionCommand())){
					
			frm_.dispose();
			createfrm_("老師");
		}
		if("student".equals(e.getActionCommand())){
			
			frm_.dispose();
			createfrm_("學生");
		}
		if("parter".equals(e.getActionCommand())){
			
			frm_.dispose();
			createfrm_("工讀生");
		}
		if("delete".equals(e.getActionCommand())){
			
			if(tf.getText().toString().equals("")){
				alterPercon J = new alterPercon();	
				J.NoEnter();
				
			}
			else{
			    J.deleteStr = tf.getText().toString();
				frm.dispose();				
				NameInfo.getpersondata(J.deleteStr,NameInfo.PreInfor,strPerson);
				//System.out.println(NameInfo.PreInfor[11]);
				J.createdeletefrm_(NameInfo.PreInfor[11]);
			}
		}
		if("tchsearch".equals(e.getActionCommand())){
			//TODO:搜尋資料	
			if(tf.getText().toString().equals("")){
				alterPercon J = new alterPercon();	
				J.NoEnter();		
			}
			else{		
				SearchPerson J = new SearchPerson (tf.getText(),strPerson);
			}
		}
		if("addperson".equals(e.getActionCommand())){
			// TODO:跳出新增視窗
			frm.dispose();
			AddNewPercon J = new AddNewPercon();
			J.createfrm(strPerson);
		}
		if("editperson".equals(e.getActionCommand())){
			// TODO:跳出新增視窗			
			if(tf.getText().toString().equals("")){
				alterPercon J = new alterPercon();	
				J.NoEnter();		
			}
			else{
				frm.dispose();
				alterPercon J = new alterPercon();	
				J.createfrm(tf.getText(),strPerson);
			}
		}
	}
		
	
	public void SetFrm(int frmwidth,int frmheight,Image image,JPanel Mainpal)
	{
		Container content;
		content = frm.getContentPane();
		JFrame.setDefaultLookAndFeelDecorated(true);
		content.add(Mainpal);
		frm.setSize(frmwidth,frmheight);
		frm.setIconImage(image);
		frm.getRootPane().setWindowDecorationStyle(JRootPane.NONE );
		frm.setAlwaysOnTop(true);
		frm.setLocation((d.width - frmwidth)/2, ((d.height-frmheight)/2)+30);
	    frm.setResizable(false);
	    frm.setUndecorated(true);		
		frm.setVisible(true);
		
	}
	private void RegTextFeild()
	{
		tf.setLayout(new BorderLayout());
		tf.add(cbInput, BorderLayout.SOUTH);
		tf.setBounds(60, 160, 140, 25);
		tf.addActionListener(this);
		tf.selectAll();
		tf.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				updateList();
				//System.out.println("輸入\n");	
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				updateList();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				updateList();
				
			}
			private void updateList() {
				 setAdjusting(cbInput, true);
				 model.removeAllElements();
				 String input = tf.getText();
				 
				 if (!input.isEmpty()) {
					 for (String item : Idex) {
						 //if (item.toLowerCase().startsWith(input.toLowerCase())) {
							 model.addElement(item);
							// System.out.println(item);
						// }
					 }
				 }
				 cbInput.setPopupVisible(model.getSize() > 0);	
				 setAdjusting(cbInput, false);
			}		
		});	
	}
	public void RegBtn(String name,String command,int yPos,JPanel pal)
	{
		JButton btn = new JButton(name);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setForeground(Color.ORANGE);
		btn.setBackground(Color.BLACK);
		btn.setActionCommand(command);
		btn.setSelected(true);
		btn.addActionListener(this);
		btn.setBounds(212,20+(yPos*35),80,30);
		pal.add(btn);
	}/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub funclass f = new funclass(); }
	 */
}
