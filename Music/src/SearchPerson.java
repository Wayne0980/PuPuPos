import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;


public class SearchPerson  extends JFrame implements ActionListener {
	DBlog NameInfo = new DBlog();
	JFrame frm = new JFrame("資料查詢");
	JPanel pal2 = new JPanel(null);
	String [] PreInfor = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""} ;
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	JLabel la2 = new JLabel("教師:");
	public SearchPerson(String str ,String strPerson){
		
		JPanel Mainpal = new JPanel(new BorderLayout());
		JLabel img;
		int frmwidth = 450,frmheight = 450;
		Image image = new ImageIcon("Img/sound.png").getImage();
		img = new JLabel(new ImageIcon("Img/addconfire.jpg"));
		img.setBounds(0, 0, frmwidth, frmheight);		
		RegBtn("確定","enter",11,pal2);
		pal2.setSize(frmwidth,frmheight);
		NameInfo.getpersondata(str,PreInfor,strPerson);
		RegLab2();
		pal2.add(img);
		Mainpal.add(pal2,BorderLayout.CENTER);
	
		SetFrm(frmwidth,frmheight,image,Mainpal);
	}
	public void RegLab2() {
		//NameInfo.getsavedata();
		//for(int i=0;i<12;i++)
			  //System.out.println(PreInfor[i]);
		createlab2(pal2, "姓名:", 0, 0, 40, 30);
		createlab2(pal2, PreInfor[2], 2, 0, 100, 30);
		createlab2(pal2, "電話:", 0, 1, 40, 30);
		createlab2(pal2, PreInfor[3], 2, 1, 160, 30);
		createlab2(pal2, "上課時段:", 0, 2, 70, 30);createlab2(pal2, "時數:", 6, 2, 70, 30);
		createlab2(pal2, PreInfor[16], 8, 2, 60, 30);
		createlab2(pal2, PreInfor[4], 3, 2, 60, 30);
		
		
		createlab2(pal2, "上課日期:", 0, 3, 70, 30);
		createlab2(pal2, PreInfor[15], 3, 3, 60, 30);
		
		createlab2(pal2, "手機:", 0, 4, 80, 30);
		createlab2(pal2, PreInfor[5], 2, 4, 120, 30);
		createlab2(pal2, "生日:", 0, 5, 40, 30);
		createlab2(pal2, PreInfor[6], 2, 5, 60, 30);
		createlab2(pal2, "月:", 4, 5, 20, 30);
		createlab2(pal2, PreInfor[7], 5, 5, 60, 30);
		createlab2(pal2, "日:", 6, 5, 20, 30);
		createlab2(pal2, PreInfor[8], 7, 5, 60, 30);
		createlab2(pal2, "性別:", 0, 6, 40, 30);
		createlab2(pal2, PreInfor[9], 2, 6, 60, 30);
		createlab2(pal2, "樂器:", 0, 7, 40, 30);
		createlab2(pal2, PreInfor[10], 2, 7, 80, 30);
		createlab2(pal2, "身份:", 0, 10, 40, 30);
		createlab2(pal2, PreInfor[11], 2, 10, 60, 30);
		createlabteacher2(pal2, "教師:", 0, 11, 40, 30, la2);
		
		createlab2(pal2, PreInfor[12], 2, 11, 60, 30);
		createlab2(pal2, "E-mail:", 0, 8, 60, 30);
		createlab2(pal2, PreInfor[13], 2, 8, 300, 30);
		createlab2(pal2, "教室:", 0, 9, 40, 30);
		createlab2(pal2, PreInfor[14], 2, 9, 60, 30);

	}
	private void createlab2(JPanel pal2, String str, int xpos, int ypos,
			int width, int height) {
		JLabel la1 = new JLabel(str);
		int xshfit = 30;
		int yshfit = 40;
		la1.setForeground(Color.WHITE);
		la1.setFont(new java.awt.Font("Dialog", 1, 15));
		la1.setBounds(xshfit + (xpos * xshfit), yshfit + (ypos * height), width,
				height);
		pal2.add(la1);

	}

	private void createlabteacher2(JPanel pal2, String str, int xpos, int ypos,
			int width, int height, JLabel la) {

		int xshfit = 30;
		int yshfit = 40;
		la.setForeground(Color.WHITE);
		la.setFont(new java.awt.Font("Dialog", 1, 15));
		la.setBounds(xshfit + (xpos * width), yshfit + (ypos * height), width,
				height);
		pal2.add(la);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("enter".equals(e.getActionCommand())){
			
			frm.dispose();
		}
	}
	private void RegBtn(String name,String command,int yPos,JPanel pal)
	{
		JButton btn = new JButton(name);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setForeground(Color.ORANGE);
		btn.setBackground(Color.BLACK);
		btn.setActionCommand(command);
		btn.setSelected(true);
		btn.addActionListener(this);
		btn.setBounds(360,20+(yPos*35),80,30);
		pal.add(btn);
	}
	

	private void SetFrm(int frmwidth,int frmheight,Image image,JPanel Mainpal)
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
}
