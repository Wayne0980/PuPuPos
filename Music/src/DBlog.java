import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBlog {
	public final int _NAME = 0;
	public final int _TEL = 1;
	public final int _CELLPHONE = 2;
	public final int _BIRTHDAY = 3;
	public final int _TEACHER = 4;
	public final int _EMAIL = 5;
	public final int _CLASSTIME = 6;
	public final int _GENDER = 7;
	public final int _MONTH = 8;
	public final int _DAY = 9;
	public final int _MUSICAL = 10;
	public final int _IDSTATUS = 11;
	public final int _CLASS = 12;
	public final int _CLASS_DATE = 13;
	public final int _CLASS_HOUR = 14;
	String[] names = new String[999];
	String ClasstimeName = null;
	String[] classes = new String[999];
	String[] str2 = {"�m�W","�q��","�W�Үɬq","���","�~","��","��","�ʧO","�־�","����","�Юv","mail","�Ы�","�W�Ҥ��","�W�Үɼ�","end","",""};
	//String strStudent[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	String  PreInfor[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	int datanum = 0;
	public final String[] dates = { "�P���@", "�P���G", "�P���T", "�P���|", "�P����", "�P����", "�P����" ,"�Ȱ���"," "};
	public final String[] Classnum = {"�ЫǤ@","�ЫǤG","�ЫǤT","�Ыǥ|","�ЫǤ�"," "};
	public final String[] Times = {"10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30"," "};
	public final String[] Months = {"1","2","3","4","5","6","7","8","9","10","11","12"," "};
	public final String[] Dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"," "};
	public final String[] Gender = {"�k","�k"," "};
	public final String[] Musical = {"�j����^","��h���^","�q�N�L","�j��N�L","�����N�L","����","�Q�J�R�R","��h��","��c��","�p���^","����","��L"," "};
	String Index = null;
	String PersonST = null;
	Connection connDB = null;
	public int Test()
	{
		
		return 4;
	}
	public int getclasstimenumInt(String strIn,String[] strOut,String str2) {
		int x = 0;
		getpersondata(strIn,strOut,str2);
		System.out.println("�}�l�o");
		System.out.println(strOut[16]);
		switch(strOut[16]){
			case "2":
				x = 4;
				break;
			case "1":
				x = 2;
				break;
			case "1.5":
				x = 3;
				break;
			case "0.5":
				x = 1;
				break;
		
		}
		return x;
	}
	public void getpersondata(String strIn,String[] strOut,String str2) {
	   
		
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		
		String str = null;
		int i = 0;
			try {
				String path = "SELECT * FROM "+str2+"�򥻸�� WHERE �m�W='"+strIn+"'";
				Class.forName(strDriver);
				connDB = DriverManager.getConnection(url);	
				
				Statement stat = connDB.createStatement();
				ResultSet rsName = stat.executeQuery(path);
				rsName.next();	
				i = 2;
				while (i<18)
				{		
					str = rsName.getString(i);//str2[i]) + "";	
					strOut[i] = str;
					//strStudent[i] = str;
					
					i++;
						
				}
				stat.close();
				rsName.close();
				connDB.close();
			} catch (ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			} catch (SQLException sqle) {
				System.out.println(sqle);
			}
		
}

	public void getclass(int date,int classnum) {
	   
		
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		
		String path = "SELECT " + dates[date] + " FROM "+Classnum[classnum]+" ORDER BY �s�� ";//
		String str = null;
		
		int i = 0;
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);	
			//System.out.println("�s�u���\");
			Statement stat = connDB.createStatement();
			ResultSet rsName = stat.executeQuery(path);
			while (rsName.next()) {
				
				str = rsName.getString(dates[date]) + "";
				//System.out.println(str);
				classes[i] = str;
				i++;
			}
			//System.out.println("����");
			stat.close();
			rsName.close();
			connDB.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

	}
	public void getclasstime(int date,int classnum) {
	   
		
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		
		String path = "SELECT �ɶ� FROM "+Classnum[classnum]+" ORDER BY �s�� ";//
		String str = null;
		
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);	
			//System.out.println("�s�u���\");
			Statement stat = connDB.createStatement();
			ResultSet rsName = stat.executeQuery(path);
			while (rsName.next()) {
				
				str = rsName.getString("�ɶ�");
				//System.out.println(str);
				
			}
			
			stat.close();
			rsName.close();
			connDB.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

	}
    public int returnclasstimenum(int date,int classnum , String Strtime) {
    	int num = 0;
    	String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		
		String path = "SELECT �ɶ� FROM "+Classnum[classnum]+" ORDER BY �s�� ";//
		String str = null;
		
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);	
			//System.out.println("�s�u���\");
			Statement stat = connDB.createStatement();
			ResultSet rsName = stat.executeQuery(path);
			while (rsName.next()) {
				
				str = rsName.getString("�ɶ�");
				if(str.equals(Strtime)){
					
					return num;
				}
				num++;
			}
			
			stat.close();
			rsName.close();
			connDB.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		num = 0;
		return num;

	}
    public String returnclasstimeName(int date,int classnum ,String strtime) {
    	for(int i=0;i<24;i++){
    		classes[i] = " ";
    	}
    	getclass(date,classnum);
		return classes[returnclasstimenum(date,classnum,strtime)];
	}
    
    public int IsClasstimeEmpty(int date,int classnum ,String strtime,String user) {
    	int yes = 0;
    	String str;
    	String[] str2 = null;
    	String[] str3 = null;
    	str2 = user.split("-");
    	str = returnclasstimeName(date,classnum,strtime);
    	str3 = str.split("-");
    	
    	ClasstimeName = str;
    	System.out.println(str);
    	if(str.equals(" ")||str.equals("-�L-")||str3[0].equals(str2[0])||str.equals(null))
    		yes = 1;
		return  yes;

	}
    
	public String GetLastIndex(int person){
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		datanum = 0;
		String path = "SELECT �Ӹ���� FROM �t�θ�� ORDER BY �s�� ASC";//
		String str = null;
		//Connection connDB = null;
		
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);
			Statement stat = connDB.createStatement();
			ResultSet rsName = stat.executeQuery(path);
			while (rsName.next()) {
				
				str = rsName.getString("�Ӹ����");
				//System.out.println(str);
				names[datanum] = str;
				datanum++;
			}
			
			rsName.close();
			connDB.close();
			stat.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return names[person];
	}
public void getname(String strTable) {
	   
		
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		datanum = 0;
		String path = "SELECT �m�W FROM "+strTable+" ORDER BY �s�� ASC";//
		String str = null;
		//Connection connDB = null;
		
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);
			
			Statement stat = connDB.createStatement();
			ResultSet rsName = stat.executeQuery(path);
			while (rsName.next()) {
				//System.out.println("�򥻸��");
				str = rsName.getString("�m�W");
				//System.out.println(str);
				names[datanum] = str;
				datanum++;
			}
			
			rsName.close();
			connDB.close();
			stat.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

	}
public void getIndex(String strTable , String strName,String SelectStr) {
	   
	
	String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
	datanum = 0;
	String path = "SELECT �s�� FROM "+strTable+" ORDER BY �s�� ASC";//
	String str = null;
	//Connection connDB = null;
	int x = 0;
	String[] strIndex = new String[999];

	try {
		Class.forName(strDriver);
		connDB = DriverManager.getConnection(url);
		
		Statement stat = connDB.createStatement();
		ResultSet rsName = stat.executeQuery(path);
		
		while (rsName.next()) {	    
			strIndex[x] = rsName.getString("�s��");
			x++;
		}
		
		rsName.close();
		connDB.close();
		stat.close();
	} catch (ClassNotFoundException cnfe) {
		System.out.println(cnfe);
	} catch (SQLException sqle) {
		System.out.println(sqle);
	}	
	path = "SELECT "+SelectStr+" FROM "+strTable+" ORDER BY �s�� ASC";//
	x=0;
	try {
		Class.forName(strDriver);
		connDB = DriverManager.getConnection(url);
		Statement stat = connDB.createStatement();
		ResultSet rsName = stat.executeQuery(path);
		
		while (rsName.next()) {
			//System.out.println("�򥻸��");
			str = rsName.getString(SelectStr);
			//System.out.println(str);
			x++;
			if(str.equals(strName))
			{
				Index = strIndex[x-1];
				//System.out.println(Index);
			
			
			}//System.out.println(rsName.getString("�q��"));
		}
		
		rsName.close();
		connDB.close();
		stat.close();
	} catch (ClassNotFoundException cnfe) {
		System.out.println(cnfe);
	} catch (SQLException sqle) {
		System.out.println(sqle);
	}

}
	public void insertDBLog(String strTable,String strIdx,String[] strInsert){//,String strIdxto,String strData){
		
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		String path = "SELECT �m�W FROM "+strTable+" ORDER BY �s�� ASC";//
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);
			Statement stat = connDB.createStatement();
			//for(int i=0;i<12;i++)
				//System.out.println(strInsert[i]);
			
			path = "Insert into "+strTable+"(�s��,�m�W,�q��,�W�Үɬq,���,�~,��,��,�ʧO,�־�,����,�Юv,mail,�Ы�,�W�Ҥ��,�W�Үɼ�) values ('"+strIdx+"','"+strInsert[0]+"','"+strInsert[1]+"','"+strInsert[6]+"','"+strInsert[2]+"','"+strInsert[3]+"','"+strInsert[8]+"','"+strInsert[9]+"','"+strInsert[7]+"','"+strInsert[10]+"','"+strInsert[11]+"','"+strInsert[4]+"','"+strInsert[5]+"','"+strInsert[12]+"','"+strInsert[13]+"','"+strInsert[14]+"')";
		
			int a = stat.executeUpdate(path);
			PreparedStatement pst = null;
			connDB.close();
			stat.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public String ReturnMIT(String str)
	{
		String rtstr = null;
		if(str.equals("�j����^")){
			rtstr = "-CP";
			return rtstr;
		
		}
		if(str.equals("��h���^")){
			rtstr = "-JP";
			return rtstr;
		}
		if(str.equals("�q�N�L")){
			rtstr = "-EG";
			return rtstr;
		}
		if(str.equals("�j��N�L")){
			rtstr = "-CG";
			return rtstr;
		}
		if(str.equals("�����N�L")){
			rtstr = "-AG";
			return rtstr;
		}
		if(str.equals("����")){
			rtstr = "-BS";
			return rtstr;
		}
		if(str.equals("�Q�J�R�R")){
			rtstr = "-UK";
			return rtstr;
		}
		if(str.equals("��h��")){
			rtstr = "-DR";
			return rtstr;
		}
		if(str.equals("��c��")){
			rtstr = "-CJ";
			return rtstr;
		}
		if(str.equals("�p���^")){
			rtstr = "-VL";
			return rtstr;
		}
		if(str.equals("����")){
			rtstr = "-FU";
			return rtstr;
		}
		if(str.equals("��L")){
			rtstr = "-OT";
			return rtstr;
		}
	    
		return " ";
	}
	public void updateDBLog(String strTable,String strFormData,String strId,String StrUpdate,String strWhere){
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		String path = null;// "SELECT "+title+" FROM "+strTable+" ORDER BY �s�� ASC";//
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);
			Statement stat = connDB.createStatement();
			
			path = "UPDATE "+strTable+" set "+strFormData+" = '"+StrUpdate+"'"+"where "+strWhere+" ="+strId+""; 
			
			stat.executeUpdate(path);
			
			connDB.close();
			stat.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void updateDBLogIndex(String strTable,String strFormData,String strId,String StrUpdate){
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		String path = null;//"SELECT �Ӹ����FROM �t�θ�� ORDER BY �s�� ASC";//
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);
			Statement stat = connDB.createStatement();		
			path = "UPDATE "+strTable+" set "+strFormData+" = '"+StrUpdate+"'"+"where �s�� =1"; 		
			stat.executeUpdate(path);		
			connDB.close();
			stat.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public void deleteDBLog(String strTable,String strId)
	{
		String strDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Library.mdb";
		String path = "SELECT �m�W FROM "+strTable+" ORDER BY �s�� ASC";//
		try {
			Class.forName(strDriver);
			connDB = DriverManager.getConnection(url);
			Statement stat = connDB.createStatement();
			
			path = "DELETE FROM "+strTable+" WHERE �s�� = "+strId+"";
			stat.executeUpdate(path);
			connDB.close();
			stat.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
}
