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


public class AreyousureDelete extends JFrame implements ActionListener {
	JFrame frm2 = new JFrame();
	String ST = null;
	String strStudent[]={"","","","","","","","","","","","","","","","","","","","","","",""};
	String deleteStr = null;
	JLabel img;
	DBlog NameInfo = new DBlog();
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	public void RegBtn4(String name,String command,int yPos,JPanel pal)
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
	public void createdeletefrm_(String str){
		JPanel pal4 = new JPanel(null);
		JPanel Mainpal4 = new JPanel(new BorderLayout());
		
		int frmwidth = 300,frmheight = 205;
		Image image = new ImageIcon("Img/sound.png").getImage();
		JLabel la1 = new JLabel("姓名:");

		RegBtn4("退出","close4",3,pal4);
		RegBtn4("確定","delete4",4,pal4);

		pal4.setSize(frmwidth,frmheight);	
		img = new JLabel(new ImageIcon("Img/delete4.jpg"));
		img.setBounds(0, 0,frmwidth,frmheight);
		
		
		pal4.add(la1);
		pal4.add(img);
		ST = str;
		Mainpal4.add(pal4,BorderLayout.CENTER);
		SetFrm2(frmwidth,frmheight,image,Mainpal4,frm2);
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("close4".equals(e.getActionCommand())){
			frm2.dispose();
			PersonInfo J = new PersonInfo ();
		}
		if("delete4".equals(e.getActionCommand())){
			//NameInfo.getpersondata(deleteStr,strStudent,ST);
			
			for(int i=0;i<NameInfo.getclasstimenumInt(deleteStr,strStudent,ST);i++){
				NameInfo.getIndex(strStudent[14],deleteStr,strStudent[15]);
				NameInfo.updateDBLog(strStudent[14],strStudent[15],(NameInfo.Index),"-無-","編號");
			}
			
		    NameInfo.getIndex(ST+"基本資料",deleteStr,"姓名");			
			NameInfo.deleteDBLog(ST+"基本資料",NameInfo.Index);
			
			frm2.dispose();
			PersonInfo J = new PersonInfo ();
		}
	}
	public void SetFrm2(int frmwidth,int frmheight,Image image,JPanel Mainpal,JFrame frm)
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
