import java.awt.AlphaComposite;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Class_Table extends JFrame implements ActionListener{//extends MainView {
	private static final JPanel GridBagConstraints = null;
	int y = 26;
	int x = 7;
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	//int width=d.width-100,hight = (d.height-100)/2;
	int width=496,hight = 150;
	JLabel img;
	JFrame frm = new JFrame("Class");	
	
	JButton btn1 = new JButton(new ImageIcon("Img/class1.png")) {
		 public void paint(Graphics g) {
              Graphics2D g2 = (Graphics2D) g.create();
              g2.setComposite(AlphaComposite.getInstance(
                      AlphaComposite.SRC_OVER, 1.0f));
              super.paint(g2);
              g2.dispose();
          }
	};
	
	JButton btn2 = new JButton(new ImageIcon("Img/class2.png")) {
		 public void paint(Graphics g) {
              Graphics2D g2 = (Graphics2D) g.create();
              g2.setComposite(AlphaComposite.getInstance(
                      AlphaComposite.SRC_OVER, 1.0f));
              super.paint(g2);
              g2.dispose();
          }
	};
	JButton btn3 = new JButton(new ImageIcon("Img/btnexit.png")) {
		 public void paint(Graphics g) {
             Graphics2D g2 = (Graphics2D) g.create();
             g2.setComposite(AlphaComposite.getInstance(
                     AlphaComposite.SRC_OVER, 1.0f));
             super.paint(g2);
             g2.dispose();
         }
	};
	
	public Class_Table() {
		//JFrame.setDefaultLookAndFeelDecorated(true);		
		add_Frm();
	}

	public void btnset(){
		
		int btnwidth = 160,btnheight = 120;
		Color c = new Color(0,0,0);//背影颜色随便设任意值,只起占位作用。
		int btnposx = 10;//200;
		int btnposy = 15;//(230);
		
		img.setBounds(0, 0,width,hight);
		//img.setBounds(0, 0,496,170);
		btn1.setActionCommand("class1");
		
		btn1.addActionListener(this);
		btn1.setOpaque(false);//设置透明背影
		btn1.setBackground(c);//必须设置否则不会出现透明背影
		Dimension size = btn1.getPreferredSize();
		
		//btn1.setBounds(btnposx+(btnwidth) ,btnposy,btnwidth,btnheight);
		btn1.setBounds(btnposx ,btnposy,btnwidth,btnheight);
		btn2.setActionCommand("class2");
		
		btn2.addActionListener(this);
		btn2.setOpaque(false);//设置透明背影
		btn2.setBackground(c);//必须设置否则不会出现透明背影
		
		btn2.setBounds(btnposx+(1*btnwidth) ,btnposy,btnwidth,btnheight);
		
		btn3.setActionCommand("exit");
		btn3.addActionListener(this);
		//btn3.setSelected(true);
		btn3.setOpaque(false);//设置透明背影
		btn3.setBackground(c);//必须设置否则不会出现透明背影
		btn3.setBounds(btnposx+(2*btnwidth) ,btnposy,btnwidth,btnheight);
		
	}
	public void add_Frm () {
			
		Container content;
		
		JPanel pal2 = new JPanel(null);
		JPanel Mainpal = new JPanel(new BorderLayout());
		
		pal2.setSize(d.width,d.height);
		img = new JLabel(new ImageIcon("Img/image_1.jpg"));
		
		btnset();
		pal2.add(btn1);
		pal2.add(btn2);
		pal2.add(btn3);
		pal2.add(img);
		Mainpal.add(pal2,BorderLayout.CENTER);
		JFrame.setDefaultLookAndFeelDecorated(true);

		content = frm.getContentPane();
		content.add(Mainpal);
	
		frm.setSize(width,hight);
		//frm.setSize(496,197);
		Image image = new ImageIcon("Img/sound.png").getImage();
		frm.setIconImage(image);
		frm.getRootPane().setWindowDecorationStyle(JRootPane.NONE );
	    frm.setLocation((d.width-width)/2,((d.height-hight)/2)+20);
		//frm.setLocation(0,0);
		frm.setResizable(false);
	    frm.setUndecorated(true);
	    frm.setVisible(true);
	    
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if("exit".equals(arg0.getActionCommand())){
			frm.dispose(); 
			
		}
		if("class1".equals(arg0.getActionCommand())){
			frm.dispose(); 
			funclass f = new funclass(0);
		}
		if("class2".equals(arg0.getActionCommand())){
			frm.dispose(); 
			funclass f = new funclass(1);
			
		}
	}
}
