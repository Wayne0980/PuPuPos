import java.awt.BorderLayout;
import java.awt.Choice;
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
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ClassPersonTable extends JFrame implements ActionListener {	
	JFrame frm = new JFrame("學生資料");
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	public int hight_cut = 30;
	JLabel img;
	Choice ch1 = new Choice();
	DBlog NameInfo = new DBlog();
	JPanel pal4 = new JPanel(null);
	RegObject Reg = new RegObject();
	public ClassPersonTable(int classnum,String str) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		String[] temp = null;
		JPanel Mainpal = new JPanel(new BorderLayout());
		int frmwidth = 430,frmheight = 630;
		Image image = new ImageIcon("Img/sound.png").getImage();
		pal4.setSize(frmwidth,frmheight);	
		img = new JLabel(new ImageIcon("Img/ClaTbP.jpg"));
		img.setBounds(0, 0,frmwidth,frmheight);
		RegBtn("退出","close",8,pal4);
	    temp = str.split("-");
	    System.out.println(temp[0]);
		NameInfo.getpersondata(temp[0],NameInfo.PreInfor,"學生");
		
		//System.out.println(NameInfo.strStudent[0]);
		Reg.createlab(pal4,"姓名:",0,0,40,20,Reg.MODETABCLASS);Reg.createlab(pal4,NameInfo.PreInfor[2],1,0,100,20,Reg.MODETABCLASS);
		Reg.createlab(pal4,"電話:",0,1,40,20,Reg.MODETABCLASS);Reg.createlab(pal4,NameInfo.PreInfor[3],1,1,100,20,Reg.MODETABCLASS);
		Reg.createlab(pal4,"手機:",0,2,40,20,Reg.MODETABCLASS);Reg.createlab(pal4,NameInfo.PreInfor[5],1,2,100,20,Reg.MODETABCLASS);
		Reg.createlab(pal4,"樂器:",0,3,40,20,Reg.MODETABCLASS);Reg.createlab(pal4,NameInfo.PreInfor[10],1,3,100,20,Reg.MODETABCLASS);
		Reg.createlab(pal4,"老師:",0,4,40,20,Reg.MODETABCLASS);Reg.createlab(pal4,NameInfo.PreInfor[12],1,4,100,20,Reg.MODETABCLASS);
		Reg.createlab(pal4,"出席狀況:",0,5,80,20,Reg.MODETABCLASS);
		ChoiceClassSign(pal4,ch1);
		pal4.add(img);
		Mainpal.add(pal4,BorderLayout.CENTER);
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
	private void ChoiceClassSign(JPanel pal2,Choice ch){
		
		ch.add("簽到");ch.add("請假");
		ch.add("調課");ch.add("曠課");
		ch.add(" ");
		//ch.addItemListener((ItemListener) this);
		ch.setBounds(140,143,70,28);
		pal2.add(ch);
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
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("close".equals(e.getActionCommand())){
			frm.dispose();
		}
	}
	
}
