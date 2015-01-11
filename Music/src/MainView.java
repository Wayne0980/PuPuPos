
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.Timer;

public class MainView extends JFrame implements ActionListener{
	//JButton btn1 = new JButton("開啟檔案");
	Timer timer= new Timer(); 
	JButton btn1 = new JButton(new ImageIcon("Img/open.png")) {
		 public void paint(Graphics g) {
               Graphics2D g2 = (Graphics2D) g.create();
               g2.setComposite(AlphaComposite.getInstance(
                       AlphaComposite.SRC_OVER, 1.0f));
               super.paint(g2);
               g2.dispose();
           }
	};
	JButton btn2 = new JButton(new ImageIcon("Img/board1.png")) {
		 public void paint(Graphics g) {
              Graphics2D g2 = (Graphics2D) g.create();
              g2.setComposite(AlphaComposite.getInstance(
                      AlphaComposite.SRC_OVER, 1.0f));
              super.paint(g2);
              g2.dispose();
          }
	};
	
	
	JButton btn4 = new JButton(new ImageIcon("Img/person.png")) {
		 public void paint(Graphics g) {
             Graphics2D g2 = (Graphics2D) g.create();
             g2.setComposite(AlphaComposite.getInstance(
                     AlphaComposite.SRC_OVER, 1.0f));
             super.paint(g2);
             g2.dispose();
         }
	};
	JButton btn3 = new JButton(new ImageIcon("Img/exit.png")) {
		 public void paint(Graphics g) {
              Graphics2D g2 = (Graphics2D) g.create();
              g2.setComposite(AlphaComposite.getInstance(
                      AlphaComposite.SRC_OVER, 1.0f));
              super.paint(g2);
              g2.dispose();
          }
	};
	
	Container content;
	JFrame frm = new JFrame("Music");
	String str;
	static int message_num;
	public int hight_cut = 30;
	JLabel img;

	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	private void createlab(JPanel pal2,String str,int xpos,int ypos,int width,int height,JLabel la1){
		
		int xshfit = 0;
		int yshfit = 0;
		la1.setText(str);
		la1.setForeground(Color.ORANGE);
		la1.setFont(new java.awt.Font("Dialog",1,15));   
		la1.setBounds(xshfit+(xpos*width),yshfit+(ypos*height),width,height);
		pal2.add(la1);

	}
	public MainView(){
		
		JFrame.setDefaultLookAndFeelDecorated(true);		
		
		JPanel pal2 = new JPanel(null);
		JPanel Mainpal = new JPanel(new BorderLayout());
		
		pal2.setSize(d.width,d.height);
		img = new JLabel(new ImageIcon("Img/BK1.jpg"));
		btnset();
		TimerFunc TimFun = new TimerFunc();
		/*
		createlab(pal2," ",0,0,100,20,TimFun.laYear);
		createlab(pal2," ",0,1,100,20,TimFun.laMonth);
		createlab(pal2," ",0,2,100,20,TimFun.laDate);
		createlab(pal2," ",0,3,100,20,TimFun.laHour);
		createlab(pal2," ",0,4,100,20,TimFun.laMin);
		createlab(pal2," ",0,5,100,20,TimFun.laSec);
		*/
		pal2.add(btn1);
	 	pal2.add(btn2);
	 	pal2.add(btn4);
		pal2.add(btn3);
		pal2.add(TimFun.ImMin_1);
		pal2.add(TimFun.ImMin_2);
		pal2.add(TimFun.ImHour_1);
		pal2.add(TimFun.ImHour_2);
		pal2.add(TimFun.ImYear_1);
		pal2.add(TimFun.ImYear_2);
		pal2.add(TimFun.ImYear_3);
		pal2.add(TimFun.ImYear_4);
		pal2.add(TimFun.ImMonth_1);
		pal2.add(TimFun.ImMonth_2);
		pal2.add(TimFun.ImDate_1);
		pal2.add(TimFun.ImDate_2);
		pal2.add(TimFun.Im_s);pal2.add(TimFun.Im_s2);
		pal2.add(TimFun.Im_M);
		pal2.add(img);
		
		timer.schedule(TimFun, 1000, 1000);
		
		Mainpal.add(pal2,BorderLayout.CENTER);
		Image image = new ImageIcon("Img/sound.png").getImage();
		frm.setIconImage(image);
		frm.setSize(d.width,d.height-hight_cut);	
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frm.setLocation(0,0);
	    
		content = frm.getContentPane();
		content.add(Mainpal);
		
	    frm.setResizable(false);
	    frm.setUndecorated(true);		
		frm.setVisible(true);	
	}
	public void btnset(){
		
		int btnwidth = 160,btnheight = 120;
		Color c = new Color(0,0,0);//背影颜色随便设任意值,只起占位作用。
		int btnposx = ((d.width/2)-360);
		int btnposy = ((d.height/2)+150);
		btn1.setActionCommand("loadmusic");
		
		btn1.addActionListener(this);
		btn1.setOpaque(false);//设置透明背影
		btn1.setBackground(c);//必须设置否则不会出现透明背影
		btn2.setActionCommand("play");
		//btn2.setSelected(true);
		btn2.addActionListener(this);
		btn2.setOpaque(false);//设置透明背影
		btn2.setBackground(c);//必须设置否则不会出现透明背影
		
		btn3.setActionCommand("exit");
		btn3.addActionListener(this);
		//btn3.setSelected(true);
		btn3.setOpaque(false);//设置透明背影
		btn3.setBackground(c);//必须设置否则不会出现透明背影
		btn4.setActionCommand("person");
		btn4.addActionListener(this);
		//btn3.setSelected(true);
		btn4.setOpaque(false);//设置透明背影
		btn4.setBackground(c);//必须设置否则不会出现透明背影
		//Insets insets = frm.getInsets();
		Dimension size = btn1.getPreferredSize();
		img.setBounds(0, 0,d.width,d.height);
		btn1.setBounds(btnposx ,btnposy,btnwidth, btnheight);
		size = btn2.getPreferredSize();
		btn2.setBounds(btnposx+btnwidth , btnposy,btnwidth, btnheight);
		size = btn4.getPreferredSize();
		btn4.setBounds(btnposx+(2*btnwidth) ,btnposy,btnwidth,btnheight);
		size = btn3.getPreferredSize();
		btn3.setBounds(btnposx+(3*btnwidth) ,btnposy,btnwidth,btnheight);
	}
	 public void btnFileAction () {
	        FileDialog fd = new FileDialog(this, "", FileDialog.LOAD);
	        fd.setVisible(true);
	        String file = fd.getFile();
	        if (file == null)
	            return;
	        file = fd.getDirectory() + file;
	        try {
	            Runtime.getRuntime().exec(
	                    "cmd.exe /c start rundll32 url.dll,FileProtocolHandler "
	                            + file);
	        } catch (IOException e) { 
	            e.printStackTrace();
	        } 
	    }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if("loadmusic".equals(e.getActionCommand())){
			btnFileAction ();
		}
		if("play".equals(e.getActionCommand())){
			Class_Table play = new Class_Table();
		}
		if("person".equals(e.getActionCommand())){
			PersonInfo info = new PersonInfo();
			info.PersonCheck();
			System.out.println("按了喔");
		}
		if("exit".equals(e.getActionCommand())){
			frm.dispose(); 
			timer.cancel();
		}
	}
	
	public void JDBC(){
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		String tableName = "MusicCDDesc";
		Connection connDB = null;
		try{
			Class.forName(strDriver);
			System.out.println("驅動成功");
			String strURL = new String("jdbc:odbc:Library");
			connDB = DriverManager.getConnection(url);
			System.out.println("連線成功");
			Statement stat = connDB.createStatement();
			ResultSet rsName = stat.executeQuery(
					"SELECT 備忘錄 FROM 備忘錄  ORDER BY 編號  DESC"
					);
			while(rsName.next()){
				message_num++;
				//System.out.println(rsName.getString("備忘錄")+"");
				str = rsName.getString("備忘錄")+"";
				label_message();
				//System.out.println(rsName.getString("住址"));	
			}
		}
		catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
		catch(SQLException sqle){
			System.out.println(sqle);
		}
	}
	// 這個函式寫入播忘錄的資料，NUM是顯示幾筆
	public void label_message(){
			JLabel strtemp = new JLabel(str);
			System.out.println(str);
			Font font = new Font("標楷體", Font.BOLD, 25);
			strtemp.setFont(font);
			strtemp.setSize(200,350);
			strtemp.setLocation(100,208+(message_num-1)*30);
			content.add(strtemp);
	}
}

