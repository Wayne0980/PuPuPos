import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class funclass extends JFrame implements ActionListener {
	JFrame frm = new JFrame("出缺席紀錄");
	DBlog NameInfo = new DBlog();
	static int message_num;
	public int hight_cut = 30;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int Classnum = 0;
	public funclass(int classnum) {
		JFrame.setDefaultLookAndFeelDecorated(true);
        Classnum = classnum;
		Image image = new ImageIcon("Img/sound.png").getImage();
		frm.setIconImage(image);
		frm.setSize(d.width, d.height - hight_cut);
		frm.setLocation(0, 0);

		JPanel Mainpal = new JPanel(new BorderLayout());
		class_table(Mainpal,classnum);
		func_btn(Mainpal);
		
		lable_time(Mainpal);
		
		frm.add(Mainpal);
		frm.getRootPane().setWindowDecorationStyle(JRootPane.NONE );		  
		frm.setResizable(false);
		frm.setUndecorated(true);
		frm.setVisible(true);
	}

	public void date_table(int date, JPanel pal,int classnum) {
		// JPanel pal1 = new JPanel(new GridBagLayout());
		JPanel pal1 = new JPanel(new GridBagLayout()) {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon background = new ImageIcon("Img/upback.jpg");
				background.paintIcon(this, g, 0, 0);
			}
		};

		String str;
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		NameInfo.getclass(date,classnum);
		//System.out.println(NameInfo.IsClasstimeEmpty(date,classnum,"11:00"));
		int tmp = 0;
		int oldtmp = 0;
		int weight = 2;
		int shift = 0;
		for (int i = 0; i < 24; i++) {
			tmp = 0;

			for (int x = 0; x < NameInfo.classes[i].length(); x++) 
				tmp += NameInfo.classes[i].charAt(x);
			
			if (tmp == oldtmp && shift <1) {
				//System.out.println("==" + i + tmp + "    " + oldtmp);
				weight += 1;
				if(NameInfo.classes[i].equals("-無-"));
	    			shift = 1;
			} else {
				gbc.weightx = weight;
				//System.out.println(weight);
				oldtmp = tmp;
				gbc.gridx = i;
				shift = 0;
				// str = String.format("%d",i);
				str = NameInfo.classes[i];
				JButton btn1 = new JButton(str);
				btn1.setVerticalTextPosition(JButton.BOTTOM);
				btn1.setActionCommand(str);
				btn1.setSelected(true);
				btn1.addActionListener(this);
				pal1.add(btn1, gbc);
				pal.add(pal1, BorderLayout.CENTER);
				weight = 1;
			}
		}
	}

	public void class_table(JPanel main_tab,int classnum) {
		
		JPanel clspal = new JPanel(new GridLayout(9, 0));
		JLabel img,img2;
		img = new JLabel(new ImageIcon("Img/upback2.jpg"));
		img2 = new JLabel(new ImageIcon("Img/backback.jpg"));
		clspal.add(img);
		for (int i = 0; i < 7; i++)
			date_table(i, clspal,classnum);
		clspal.add(img2);
		main_tab.add(clspal);
	}

	private void RegBtn(JPanel Func,String name,String Command ){
		JButton btn1 = new JButton(name);
		btn1.setActionCommand(Command);
		btn1.addActionListener(this);
		Func.add(btn1);
	
	}
	public void func_btn(JPanel func) {
		JPanel Funcpal = new JPanel(new GridLayout(0, 5));
		RegBtn(Funcpal,"未加以功能","exit");
		RegBtn(Funcpal,"未加以功能","exit");
		RegBtn(Funcpal,"未加以功能","exit");
		RegBtn(Funcpal,"列印","print");
		RegBtn(Funcpal,"退出","exit2");
		func.add(Funcpal, BorderLayout.SOUTH);
	}

	public void Date_lbl(JPanel labl) {
		JLabel[] la = null;
		
		JPanel Funcpal = new JPanel(new GridLayout(7, 0)) {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				//ImageIcon background = new ImageIcon("Background5.jpg");
				//background.paintIcon(this, g, 0, 0);
			}
		};
		for (int i = 0; i < 7; i++) {
			JLabel la1 = new JLabel(NameInfo.dates[i]);
			la1.setForeground(Color.WHITE);
			Funcpal.add(la1);
		}

		labl.add(Funcpal, BorderLayout.WEST);
	}

	public void lable_time(JPanel time) {
		int xhour = 10, ymin = 0;
		int timecnt = 24;

		JPanel Funcpal = new JPanel(new GridLayout(0, timecnt + 1)) {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				ImageIcon background = new ImageIcon("Img/Background3.jpg");
				background.paintIcon(this, g, 0, 0);
			}
		};
		String offset = "";
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 1;
		JLabel la2 = new JLabel(offset);
		// JLabel la3 = new JLabel(offset);
		Funcpal.add(la2, gbc);
		gbc.weightx = 1;
		String str = String.format("%d:%d", xhour, ymin);
		str = "Class1";
		
		JLabel la1 = new JLabel(str);
		Funcpal.add(la1,gbc);
		time.add(Funcpal, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("exit2".equals(e.getActionCommand())){
			frm.dispose(); 
			
		}
		else if ("print".equals(e.getActionCommand())){
		
		}
		else{
		
			ClassPersonTable J = new ClassPersonTable(Classnum,e.getActionCommand().toString());
		}
		//System.out.println(e.getActionCommand());
	}/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub funclass f = new funclass(); }
	 */

}
