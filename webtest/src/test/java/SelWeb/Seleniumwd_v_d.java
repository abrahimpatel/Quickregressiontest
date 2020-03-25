package SelWeb;

/*################################################################# #####################################
'Project Name		: Automation framework for Selenium Web Driver
'Author		       	: Automation
'Version	    	: V 2.0
'Date of Creation	: 18-Jan-2014
'#######################################################################################################
 */
//V2- Enhanced with context support
import static org.junit.Assert.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import org.junit.After;
import org.junit.Test;
import jxl.Sheet;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.io.FileUtils;
//import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert; //Updated on 16.12.2013 for Dialog support
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;//Updated on 16.12.2013 for Dialog support
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Screen;

//import Relaese14JAN2014.Setting;

//import com.thoughtworks.selenium.Selenium;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet; //Updated on 16.12.2013 for page support
import java.util.Iterator; //Updated on 16.12.2013 for page support
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set; //Updated on 16.12.2013 for page support
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.lang.System;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class Seleniumwd_v_d {
	static int locatorError = 0;
	static int ScreenshotTypeFlag = 0;
	String browserver = null;
	String mm = null;
	String dd = null;
	String yyyy = null;
	String monthpart;
	String monthpartjap;
	static RemoteWebDriver D8=null;
	Setting setObj = new Setting(); // Updated on 16.12.2013
	
	String BrowserName;
	static String execpath;
	
	int varUpdateReport;
	int today = 0;
	String selectedDateClass = "";
	int lastSelecteddateJQ = 0;
	int lastSelectedmonthJQ = 0;
	int lastSelectedyearJQ = 0;
	static int conditionline = 0;

	static String SuiteName="";
	static boolean ExcutionComplete=false;
	
static int s=1;
static int ttlscrpttestcnter=0; 
static int perc_pass=0;
static int perc_fail=0;
static int tescripts=0;
static int tefscripts=0;
static int tepscripts=0;
static int tesscripts=0;
static String fileName;
static String initialstrtTime ="";

static String crntScript="";

//----------LogExcel----
static Workbook wbook;
static WritableWorkbook wwbCopy;
static String ExecutedTestCasesSheet;
static WritableSheet shSheet;
static boolean logsheet=false;
static Label labTemp3;
static Label labTemp4;
static Formula f;

static String lowerversion = "Yes";

static String exeTimeStamp="";
static String initialexeTimeStamp="";
static String imagetext = null;
static String userInput = null;
	static String ORPath =null;

	static int totalTest=0;
	static float Pprstg=0;
	static float Fprstg=0;
	static float Mprstg=0;

	static int totaltcntr =0;
	static int g_passcntr =0;
	static int t_testpasscntr =0;
	static int t_testfailcntr =0;
	static int t_testnotruncntr =0;
	static int g_failcntr =0;
	static int g_missingcntr =0;
	static int g_notextcntr =0;
    static int passcntr = 0;
    static int failcntr = 0;
    static int missingcntr = 0;

    static String PiechartP = "";
    
	//Setting setObj=new Setting(); // Updated on 16.12.2013
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static BufferedWriter bw2 = null; //Summary report
	//static WebDriver D8;
	Date cur_dt = null;
	Date start_dt = null;
	String TestSuite;
	String TestScript;
	String ObjectRepository;
	int startrow = 0;
	static String ReportsPath;
	static String strResultPath;
	static String[] TCNm = null;
	static String  MTCNm = null;
	static String exeStatus = "True";
	static String TestReport;
	static int rowcnt;
	static int dtrownum = 1;
	static int ORrowcount = 0;
	static String ORvalname = "";
	static String ORvalue = "";
	static String Action = "";
	static String cCellData = "";
	static String dCellData = "";
	static String htmlname = "";
	static String cCellObjType="";//included on 29-Nov-2013 for storing object Type
	static String cCellObjName=""; //included on 29-Nov-2013 for storing object name
	String[] cCellDataVal = null;
	String[] dCellDataVal = null;
	String ObjectSet;
	String[] ObjectSet1 = null;
	String ObjectSet2 = "";
	String ObjectSetVal = "";
	static Sheet DTsheet = null;
	static Sheet ORsheet;
	String Searchtext;
	String parentWindowHandle;//Updated on 16.12.2013 for page support
	String windowHandle;//Updated on 16.12.2013 for page support
	String ieDriverPath;//Updated on 16.12.2013 for outside browser setting
	String tempTestReportPath;//Updated on 16.12.2013 for outside temporary report path
	static int iflag = 0;
	static int screenshotflag = 0;
	static int loopflag = 0;
	static int j = 0;
	static int loopsize = -1;
	int[] loopstart = new int[1];
	int[] loopcount = new int[1];
	int[] loopend = new int[1];
	static int[] loopcnt = new int[1];
	static int[] dtrownumloop = new int[1];
	boolean captureperform = false;
	static boolean capturecheckvalue = false;
	static boolean capturestorevalue = false;
	static Sheet TScsheet;
	static Workbook TScworkbook;
	static int TScrowcount = 0;
	static int callTScrowcount = 0;
	static int loopnum = 1;
	static int windowFound=0;
	static String TScname;
	static String ActionVal;
	String BrowserType;// Assign with either FF or IE
	public static WorkbookSettings wsb;
	public static WritableSheet workSheet = null ;
	public static WritableWorkbook workbook = null;
	public static WritableSheet wsd;
	public static WritableWorkbook wwb;
	static String summaryR = null;
	static String htmlname1  = null;
	static int DTcolumncount = 0;
	static WebElement elem = null; 
	Alert dialogSwitch=null;	// Updated on	20-Dec-2013	
	static String fixtime ="";
	static String sumarypath ="";
	static String strtTime ="";
	static String endTime="";
	static String test_time="";
	static Properties CONFIG;
	static Logger APPICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
	static MimeBodyPart messageBodyPart;
	static Multipart multipart;
	
	static String callscriptPath;
	//static String reporttime;
	
	static String reporttime;
	static String strcaptureerrormessage;
	
	static File fss=null;
	static boolean chkInvalBrsr=false;
	//static Screen Image;
	
 //  Updated on on 16.12.2013
	private static Map<String, String> map = new HashMap<String, String>();
	private static Map<String, Float> mapint = new HashMap<String, Float>();

	/*
	 * This function reads the selenium utility file and identifies where Object
	 * Repository, Test Suite & Test Scripts are located
	 */

	public static void main(String[] args) throws Throwable {
		Seleniumwd_v_d s = new Seleniumwd_v_d();
		try{
			s.func_captureinitialTime();
			s.ReadUtilFile();
			s.close();
			//s.Func_ExcutionLogs("success");
		}catch(IOException e){
			e.printStackTrace();
			s.close();
		}
	}
	
	public void func_captureinitialTime()
	{
		// Report header
		start_dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(start_dt);
		DateFormat exedateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		initialexeTimeStamp = exedateFormat.format(start_dt);
	}

	@Test
	public void ReadUtilFile() throws Exception
	{
		Date crnttime = new Date();
		DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
		
		DateFormat reportdate = new SimpleDateFormat("DD-MM-YYYY-HH:mm:ss");
		String rptime=reportdate.format(crnttime);
		reporttime=rptime;
		String strTime = timeformat.format(crnttime);
		initialstrtTime = strTime;
		
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream("C:\\TP\\config\\config.properties");
		CONFIG.load(fs);
		
		Workbook w1 = null;
		try
		{
			w1 = Workbook.getWorkbook(new File(CONFIG.getProperty("UtilityFilePath")));
		}
		catch (BiffException e) 
		{ // TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e);
		} 
		catch (IOException e)
		{ // TODO Auto-generated catch block
			System.out.println("Give the correct setting file path in Setting.java");
			e.printStackTrace();
			System.out.print(e);
		}
		try
		{
			Sheet sheet = w1.getSheet(0);
			TestSuite = sheet.getCell(1, 1).getContents();
			TestScript = sheet.getCell(1, 2).getContents();
			ObjectRepository = sheet.getCell(1, 3).getContents();
			ReportsPath = sheet.getCell(1, 5).getContents();
			TestReport = sheet.getCell(1, 6).getContents();
			BrowserType=sheet.getCell(1,7).getContents(); // Change pass by broser type 
			ieDriverPath=sheet.getCell(1,8).getContents();
			tempTestReportPath=sheet.getCell(1,9).getContents();
			//---- For getting suite name--------------
			File F = new File(TestSuite);
			SuiteName = F.getName();
			String[] TSName = SuiteName.split(".xls");
			SuiteName=TSName[0];
			//------------------------------------------
			for (int z = 0; z < 1; z++) 
			{
				loopstart[z] = 0;
				loopend[z] = 0;
				loopcnt[z] = 0;
				dtrownumloop[z] = 1;
				loopcount[z] = 0;
			}
			switch (BrowserType.toUpperCase())
			{
				case "IE":
						System.setProperty("webdriver.ie.driver",ieDriverPath);
						// Changed on 16/12/2013
						DesiredCapabilities capability = DesiredCapabilities
						.internetExplorer();
						capability
						.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
						capability.setCapability("useLegacyInternalServer", true);
						D8 = new InternetExplorerDriver(capability);
						D8.getWindowHandle();
						D8.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						D8.manage().window().maximize();
						break;
				case "FF":
						ProfilesIni profile = new ProfilesIni();

						FirefoxProfile myprofile = profile.getProfile("default");

						myprofile.setPreference("plugin.state.java", 2); // This we are using it for enabling java in Firefox browser

						FirefoxOptions foptions = new FirefoxOptions();
						foptions.setProfile(myprofile);

						if (lowerversion.equalsIgnoreCase("Yes")) { //"lowerversion" we are reading it from property file.
							foptions.setCapability("marionette", false); // Code line for lower version
						}

						D8 = new FirefoxDriver(foptions);	
/*						D8 = new FirefoxDriver();
						D8.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						D8.manage().window().maximize();*/
						break;						
				case "GC":
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			       	System.setProperty("webdriver.chrome.driver",ieDriverPath );
			        capabilities.setCapability("useLegacyInternalServer", true);
			        //capabilities.setCapability("useLegacyInternalServer", true);
			        capabilities.setCapability("ignoreZoomSetting ", true);
			        capabilities.setCapability("ignoreProtectedModeSettings ", true);
			        capabilities.setCapability("javascriptEnabled ", true);
			        capabilities.setCapability("handlesAlerts ", true);
			        capabilities.setCapability("cssSelectorsEnabled ", true);
			        
			        //URL url=new URL("http://localhost:4444/wd/hub"); //Important--
			        //URL nodUrl =
			        //DesiredCapabilities capability=new DesiredCapabilities();
			        //capabilities.setBrowserName("internet explorer");//internet explorer //Important--
			        //capabilities.setBrowserName("chrome");//internet explorer
			        //D8=new RemoteWebDriver(new URL("http://10.11.1.86:5558/wd/hub"),capabilities); //Important--
			        //D8=new RemoteWebDriver(new URL("http://10.11.1.92:5555/wd/hub"),capabilities); //Important--
			        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			        D8 = new ChromeDriver(capabilities);
					D8.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					D8.manage().window().maximize();				
					break;					    
			  	case "SF":	  		
			  		D8 = new SafariDriver();
			  		D8.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  		D8.manage().window().maximize();
			  		break;
				default:
						System.out.println("Error : Invalid browser type");
						strcaptureerrormessage = "Invalid browser type";
						func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);; // Log execution results in the log excel files
						chkInvalBrsr=true;
			}	
				FindExecTestscript(TestSuite, TestScript, ObjectRepository);
			}
		catch (Exception e)
		{
			System.out.println("Check the Test Suite file contents");
			System.out.println("Error message :"+e.getMessage());
			strcaptureerrormessage = e.getMessage();
			func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);;
		}
	}
	public void FindExecTestscript(String TestSuite, String TestScript,String ObjectRepository) throws Exception 
	{
		try
		{
			int TSrowcount = 0;
			FileInputStream fs = null;
			WorkbookSettings ws = null;
			
			System.out.println("TestSuite"+TestSuite);
			fs = new FileInputStream(new File(TestSuite));
			ws = new WorkbookSettings();
			ws.setLocale(new Locale("en", "EN"));
			Workbook TSworkbook = Workbook.getWorkbook(fs, ws);
			Sheet TSsheet = TSworkbook.getSheet(0);
			TSrowcount = TSsheet.getRows();
			cur_dt = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String strTimeStamp = dateFormat.format(cur_dt);
			fixtime = strTimeStamp;
			
			String rp = ReportsPath;
			//sumarypath = rp;
			if (rp == "") 
			{
				// if results path is passed as null, by
				// default 'C:\' drive is used
				// Updated on on 12/16/2013
				rp=tempTestReportPath;
			}

			if (!rp.endsWith("\\"))
			{ // checks whether the path ends with
				// '/'
				rp = rp + "\\";
			}
//			// TCNm = scriptName.split("\\.");
				strResultPath = rp + "Log";
				System.out.println(strResultPath);
				htmlname1 = rp + "Log" + "/Test_Suite_" + strTimeStamp
						+ ".html";
				summaryR= rp + "Log" + "/Test_Suite_" + strTimeStamp
						+ ".xls";
				PiechartP= rp + "Log" + "/Test_Suite_" + strTimeStamp
						+ ".jpg";
				
				//htmlsummaryR= rp + "Log" + "/Test_Suite_" + strTimeStamp
					//	+ ".html";
				
				File f = new File(strResultPath);
				System.out.println(f.getAbsolutePath());
				if (strResultPath!=f.getAbsolutePath().toString())
				{
					System.out.println("Report will be printed in the following path since THE REPORT PATH WAS NOT GIVEN / THE GIVEN PATH IS INCORRECT.");
					System.out.println(f.getAbsolutePath().toString() );
				}
				f.mkdirs();
				//bw1 = new BufferedWriter(new FileWriter(htmlname1));
				//bw1.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
				//bw1.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
				//bw1.write("<TR><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=0.5><B>Testcase Name</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=5%><FONT FACE=VERDANA COLOR=WHITE SIZE=0.5><B>Status</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=5%><FONT FACE=VERDANA COLOR=WHITE SIZE=0.5><B>Logs</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=5%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Time</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=5%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Passed</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=5%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Failed</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=5%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Missed</B></FONT></TD></TR>"*/);
				
				bw2 = new BufferedWriter(new FileWriter(htmlname1));
				bw2.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%><TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%><TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2%><B>Test Summary Report</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2%><B>Test Suite :"+SuiteName+"</B></FONT></TD></TR>");
				bw2.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%><TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=2%><FONT FACE=VERDANA COLOR=BLACK SIZE=1%><B><Center>Sr no.</Center></B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=30%><FONT FACE=VERDANA COLOR=BLACK SIZE=1%><B><Center>Test Scripts</Center></B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=1%><B><Center>Date Time(DD-MM-YYYY-HH-MM-SS)</Center></B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=1%><B><Center>Test Duration(H:M:S)</Center></B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=5%><FONT FACE=VERDANA COLOR=BLUE SIZE=1%><B><Center>Logs</Center></B></FONT></TD><TD BGCOLOR=#008000 WIDTH=8%><FONT FACE=VERDANA COLOR=WHITE SIZE=1%><B><Center>Pass(Count)</Center></B></FONT></TD><TD BGCOLOR=#FF0000 WIDTH=8%><FONT FACE=VERDANA COLOR=WHITE SIZE=1%><B><Center>Fail(Count)</Center></B></FONT></TD><TD BGCOLOR=#FFC300 WIDTH=8%><FONT FACE=VERDANA COLOR=WHITE SIZE=1%><B><Center>Missed(Count)</Center></B></FONT></TD><TD BGCOLOR=BLUE WIDTH=8%><FONT FACE=VERDANA COLOR=WHITE SIZE=1%><B><Center>Total(Count)</Center></B></FONT></TD></TD><TD BGCOLOR=#FFCC99 WIDTH=8%><FONT FACE=VERDANA COLOR=BLACK SIZE=1%><B><Center>Status</Center></B></FONT></TD></TR>");
				//bw1.write("<TR><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZ			
				Func_create_summary_report () ;

			for (int i = 0; i < TSsheet.getRows(); i++) 
			{
				tescripts++;
				Func_strtTime_cntr();
				System.out.println("TestSuite"+TSsheet.getRows());
				String TSvalidate = "r";
				if (((TSsheet.getCell(0, i).getContents()).equalsIgnoreCase(TSvalidate) == true))
				{
					System.out.println("Suit if condition"+TSsheet.getRows());
					String ScriptName = TSsheet.getCell(1, i).getContents();
					crntScript = ScriptName;
					System.out.println("ScriptName"+ScriptName);
					/* For handle invalid test script name 
					 * Get Script Name check it is showing .xls
					 */
					if (ScriptName.trim().contains(".xls"))
					{
						ExecKeywordScript(ScriptName, TestScript, ObjectRepository);	
						Func_endTime_cntr();
						if (exeStatus.equalsIgnoreCase("Failed"))
						{
							Func_Test_Duration(strtTime,endTime);
							Func_insert_summary_data(s+1,"Fail");
							Func_Insert_Summary_In_html("fail");			
							s++;
							System.out.println("ttlscrpttestcnter: "+ttlscrpttestcnter);
						    passcntr = 0; //--pass test action counter
						    failcntr = 0; //--fail test action counter
						    missingcntr = 0; //--missing test action counter
						    ttlscrpttestcnter=0; //--Total test action counter
						    tefscripts++; //--total fail script counter
						    APPICATION_LOGS.debug("Unsuccessfully execute test script: "+ScriptName);
						} 
						else
						{
							Func_Test_Duration(strtTime,endTime);
							Func_insert_summary_data(s+1,"Pass"); // Excel Summary report in sheet
							Func_Insert_Summary_In_html("pass");  // Html summary report html file
							System.out.println("ttlscrpttestcnter: "+ttlscrpttestcnter);
						    s++;
						    passcntr = 0;
						    failcntr = 0;
						    missingcntr = 0;
						    ttlscrpttestcnter=0;
						    tepscripts++;
						    APPICATION_LOGS.debug("Successfully execute test script: "+ScriptName);
						}						
					}else{
						Func_insert_summary_data(s+1,"Not execute");
						//Func_Insert_Summary_In_html("notexecute");
						s++;
						g_notextcntr++;
					}	
				} else{
					//Func_insert_summary_data(s=i+2,"Skip");
					tesscripts++;
				}
			} 
			try{
				Func_Create_pie_chart(t_testpasscntr, t_testfailcntr,t_testnotruncntr); //
				//Func_Create_pie_chart(g_passcntr, g_failcntr,g_missingcntr)
			}catch(Exception e){
				APPICATION_LOGS.debug("Pie Chartion fail: "+e);
			}
			
			Func_Test_Duration(initialstrtTime,endTime);
			Func_Insert_Overall_Test_Status();
			Func_Insert_Overall_Test_Status_html();
			//Func_Insert_Summary_In_html("Consolidate");					
			//bw1.close();
			//Func_Insert_Summary_In_html("Consolidate");
			bw2.close();	
			
			
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("The Given Report path is not accessible. Please check the report path");
			System.out.println(e);
			bw.close();
			//bw1.close();
			bw2.close();
/*			strcaptureerrormessage = e.getMessage();
			//Func_ExcutionLogs("error");*/
		}
	}
	
	public static void Func_Insert_Summary_In_html (String status) throws IOException{
		
		String testname = MTCNm.trim();
		perc_pass=0;
		perc_fail=0;
		if (ttlscrpttestcnter > 0)
		{
			perc_pass =  (passcntr*100)/ttlscrpttestcnter;
			perc_fail =  (failcntr*100)/ttlscrpttestcnter;
		}
		//Integer perc_notrun = (t_testnotruncntr*100)/ttlscrpttestcnter;
			
		if (status.equalsIgnoreCase("fail")){
			exeStatus="Failed";
			bw2.newLine();
			bw2.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=1%><Center>"
					+ (s)
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=1%>"
					+ TCNm[0] // test script
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1%><Center>"
					+ exeTimeStamp // date
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLACK><Center>"
					+ test_time // test duration
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLUE>"
					+ "<a href="+sumarypath+"><Center>logs<Center></a>"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = GREEN><Center>"
					+ passcntr // Pass count+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = RED><Center>"
					+ failcntr // Fail count //+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = ORANGE><Center>"
					+ missingcntr // missed count+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLUE><Center>"
					+ ttlscrpttestcnter // Total no. of test + "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=RED WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = WHITE><Center>"
					+ exeStatus+"("+perc_fail + "%)</Center></FONT></TD></TR>"); // Final status
			t_testfailcntr++;
		
		}else if (status.equalsIgnoreCase("pass")){
			exeStatus="Passed";
			bw2.newLine();
			bw2.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=1%><Center>"
					+ (s)
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=1%>"
					+ TCNm[0] // test script
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1%><Center>"
					+ exeTimeStamp // date
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLACK><Center>"
					+ test_time // test duration
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLUE>"
					+ "<a href="+sumarypath+"><Center>logs<Center></a>"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = GREEN><Center>"
					+ passcntr // Pass count+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = RED><Center>"
					+ failcntr // Fail count //+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = ORANGE><Center>"
					+ missingcntr // missed count+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLUE><Center>"
					+ ttlscrpttestcnter // Total no. of test + "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=GREEN WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = WHITE><Center>"
					+ exeStatus +"("+perc_pass + "%)</Center></FONT></TD></TR>"); // Final status
			t_testpasscntr++;
			
		}else if (status.equalsIgnoreCase("notexecute")){
			exeStatus="Not Run";
		  /*bw2.newLine();
			bw2.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=1%><Center>"
					+ (s)
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=1%>"
					+ TCNm[0] + "</Center></FONT></TD></TR>"); // Final status
		 */System.out.println("not executed:");
			/*t_testnotruncntr++;// test script
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1%><Center>"
					+ "NA" // date
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLACK><Center>"
					+ "NA" // test duration
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLUE>"
					+ "NA"
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = GREEN><Center>"
					+ "NA" // Pass count+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = RED><Center>"
					+ "NA" // Fail count //+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = ORANGE><Center>"
					+ "NA" // missed count+ "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = BLUE><Center>"
					+ "NA" // Total no. of test + "</FONT></TD></TR>");
					+ "</Center></FONT></TD><TD BGCOLOR=GREEN WIDTH=30%><FONT FACE=VERDANA SIZE=1% COLOR = WHITE><Center>"
					+ "Not run" + "</Center></FONT></TD></TR>"); // Final status
*/			t_testnotruncntr++;
			//bw2.close();	
		}
	}	
	 public static void Func_Create_pie_chart(int pass, int fail,int missing)throws IOException, WriteException{	
				DefaultPieDataset pieDataset = new DefaultPieDataset();
			/**
			 * Filling the data Visit of Sanjaal.com on a random day by Browser
			 */	
			if (totaltcntr==0)	{		
				APPICATION_LOGS.debug("Test Not executed");
			}else{
				totalTest = totaltcntr;
				Pprstg = (float)(pass*100)/(tepscripts+tefscripts+t_testnotruncntr); //totalTest
				Fprstg = (float)(fail*100)/(tepscripts+tefscripts+t_testnotruncntr);//totalTest;
				Mprstg = (float)(missing*100)/(tepscripts+tefscripts+t_testnotruncntr);//totalTest;

		        BigDecimal bdPprstg = new BigDecimal(Float.toString(Pprstg));
		        bdPprstg = bdPprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
		        BigDecimal bdFprstg = new BigDecimal(Float.toString(Fprstg));
		        bdFprstg = bdFprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
		        BigDecimal bdMprstg = new BigDecimal(Float.toString(Mprstg));
		        bdMprstg = bdMprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
		        
				System.out.println("Pprstg"+bdPprstg);
				System.out.println("Fprstg"+bdFprstg);
				System.out.println("Mprstg"+bdMprstg);	
				pieDataset.setValue("Total no. of Tests Executed="+(tepscripts+tefscripts+t_testnotruncntr), totalTest);
				pieDataset.setValue("Total no. of tests Not executed="+missing+"("+bdMprstg+"%"+")",missing );
				pieDataset.setValue("Total no. of tests Fail="+fail+"("+bdFprstg+"%"+")", fail);
				pieDataset.setValue("Total no. of tests Pass="+pass+"("+bdPprstg+"%"+")", pass);
				//return pieDataset;
				/**
				 * createPieChart3D method Parameters: --java.lang.String title,
				 * --PieDataset dataset, --boolean legend, --boolean tooltips, --boolean
				 * urls
				 */
				JFreeChart chart = ChartFactory.createPieChart3D(
						"Test Status : ", pieDataset, true, true, true);	
				PiePlot3D p = (PiePlot3D) chart.getPlot();	
		        p.setStartAngle(290);
		        p.setDirection(Rotation.CLOCKWISE);
				p.setForegroundAlpha(0.6f);
				p.setBackgroundAlpha(0.2f);
				p.setNoDataMessage("No data to display");
				//p.setSectionPaint("Total no. of run tests="+totalTest,Color.WHITE);
		        //p.setSectionPaint("Total no. of tests Pass="+pass+"("+bdPprstg+"%"+")",Color.GREEN);
		        //p.setSectionPaint("Total no. of tests not run="+missing+"("+bdMprstg+"%"+")",Color.YELLOW);
		        //p.setSectionPaint("Total no. of tests Fail="+fail+"("+bdFprstg+"%"+")",Color.red);
				chart.setBackgroundPaint(Color.WHITE);
				chart.setAntiAlias(true);
				chart.setBorderVisible(true);
				chart.setNotify(true);
				//chart.setTextAntiAlias(true);		
				String fileName = PiechartP;
				try {
					/**
					 * This utility saves the JFreeChart as a JPEG First Parameter:
					 * FileName Second Parameter: Chart To Save Third Parameter: Height
					 * Of Picture Fourth Parameter: Width Of Picture
					 */
					 ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 400);
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Problem occurred creating chart.");
				}	
			}	
	 }
	
	 public static void Func_strtTime_cntr () throws IOException, WriteException{ 
			Date crnttime = new Date();
			DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
			String strTime = timeformat.format(crnttime);
			strtTime = strTime;
	 } 
	 
	 public static void Func_endTime_cntr () throws IOException, WriteException{  
			Date crnttime = new Date();
			DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
			String crntTime = timeformat.format(crnttime);
			endTime = crntTime;
	 }
	 
	public static void customize_func()
	{		
		D8.findElement(By.xpath("/html/body/div/div/div/div/a[4]")).click();
	}
	 
	 public static void Func_Test_Duration(String Starttime, String EndTime)throws IOException, WriteException{ 
		    String dateStart = Starttime;
			String dateStop = EndTime;
			//HH converts hour in 24 hours format (0-23), day calculation
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss"); 
			Date d1 = null;
			Date d2 = null;
			try {
			
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);
				//in milliseconds
				long diff = d2.getTime() - d1.getTime();
				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				//long diffDays = diff / (24 * 60 * 60 * 1000);
				test_time = String.valueOf(diffHours)+":"+String.valueOf(diffMinutes)+":"+String.valueOf(diffSeconds);		
				//System.out.print(diffDays + " days, ");
				System.out.print(diffHours + " hours, ");
				System.out.print(diffMinutes + " minutes, ");
				System.out.print(diffSeconds + " seconds.");
				System.out.println(test_time + " seconds.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public static void Func_execution_logs(String suite, String strttime, String Stas, String testsum) throws IOException, WriteException, BiffException
	 {

		    Workbook logbook =null;
		 	WritableWorkbook workbook=null;
		 	WritableSheet writablesheet1=null;
		 	//strResultPath "\\TestLog1.xls";
		 	fss = new File(ReportsPath+"\\ExecutionLogs.xls");
		 	if (!fss.exists())
		 	{
			    workbook = Workbook.createWorkbook(new File(fss.toString()));
			    writablesheet1 = workbook.createSheet("Sheet1", 0);
			    
			    writablesheet1.setColumnView(0, 60);
			    writablesheet1.setColumnView(1, 24);
			    writablesheet1.setColumnView(2, 12);
			    writablesheet1.setColumnView(3, 16);
			   // writablesheet1.setColumnView(4, 16);
			    
			    Label label1 = new Label(0, 0, "Test Suite");
			    writablesheet1.addCell(label1);
			    Label label2 = new Label(1, 0, "Execution date time");
			    writablesheet1.addCell(label2);
			    Label label3 = new Label(2, 0, "Status");
			    writablesheet1.addCell(label3);
			    Label label4 = new Label(3, 0, "Test summary");
			    writablesheet1.addCell(label4);
			    
			    Label label5 = new Label(0, 1, suite);
			    writablesheet1.addCell(label5);
			    Label label6 = new Label(1, 1, strttime);
			    writablesheet1.addCell(label6);
			    Label label7 = new Label(2, 1, Stas);
			    writablesheet1.addCell(label7);
			    
			    WritableFont fslc=new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD);
			    fslc.setColour(Colour.DARK_BLUE);
			    fslc.setUnderlineStyle(UnderlineStyle.DOUBLE);
			    
			    WritableCellFormat cfflc=new WritableCellFormat(fslc);
			    cfflc.setBackground(Colour.GREY_25_PERCENT, Pattern.SOLID);
			    cfflc.setAlignment(jxl.format.Alignment.CENTRE);
			    cfflc.setWrap(false);
			    cfflc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
			    jxl.format.Colour.WHITE);
			    cfflc.setWrap(false);
				     //------------------------------------------------------------------------------
			    WritableCellFormat link = new WritableCellFormat(cfflc);
			  	Formula f=new Formula(3,1,"HYPERLINK(\""+testsum+"\","+"\"Logs\")",link);         // creating formula for moving on to web throught hyperlinks using Formula class
			    writablesheet1.addCell(f);	
			    
			    workbook.write();
			    workbook.close();
		 	}else		
		 	{
		 		
		        try {
		            File exlFile = new File(ReportsPath+"\\ExecutionLogs.xls");
		            Workbook openexcel= Workbook.getWorkbook(exlFile);
		            WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);
		            //WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);
		            WritableSheet writableSheet = writableWorkbook.createSheet(
		                    "Sheet1", 0);
		 
		            //Create Cells with contents of different data types. 
		            //Also specify the Cell coordinates in the constructor
		            int DTrowcount = writableSheet.getRows();
		            
		            Label label1 = new Label(0, DTrowcount, suite);
		            writableSheet.addCell(label1);
				    Label label2 = new Label(1, DTrowcount, strttime);
				    writableSheet.addCell(label2);
				    Label label3 = new Label(2, DTrowcount, Stas);
				    writableSheet.addCell(label3);
				    
				    WritableFont fslc=new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD);
				    fslc.setColour(Colour.DARK_BLUE);
				    fslc.setUnderlineStyle(UnderlineStyle.DOUBLE);
				    
				    WritableCellFormat cfflc=new WritableCellFormat(fslc);
				    cfflc.setBackground(Colour.GREY_25_PERCENT, Pattern.SOLID);
				    cfflc.setAlignment(jxl.format.Alignment.CENTRE);
				    cfflc.setWrap(false);
				    cfflc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
				    jxl.format.Colour.WHITE);
				    cfflc.setWrap(false);
					     //------------------------------------------------------------------------------
				    WritableCellFormat link = new WritableCellFormat(cfflc);
				    Formula h=new Formula(3,DTrowcount,"HYPERLINK(\""+testsum+"\","+"\"Logs\")",link);        // creating formula for moving on to web throught hyperlinks using Formula class
				    writablesheet1.addCell(h);	
				    writableWorkbook.write();
				    writableWorkbook.close();
		            	            
	/*	            Label label = new Label(0, 0, "Label (String)");
		            DateTime date = new DateTime(1, 0, new Date());
		            Boolean bool = new Boolean(2, 0, true);
		            Number num = new Number(3, 0, 9.99);
		 
		            //Add the created Cells to the sheet
		            writableSheet.addCell(label);
		            writableSheet.addCell(date);
		            writableSheet.addCell(bool);
		            writableSheet.addCell(num);
		 
		            //Write and close the workbook
		            writableWorkbook.write();
		            writableWorkbook.close();*/
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		 	 		
		 	}	
	 }
	 
	 private static File FileInputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void Func_Insert_Overall_Test_Status () throws BiffException, IOException, WriteException{
			
			Workbook workbook = Workbook.getWorkbook(new File(summaryR));
			WritableWorkbook copy = Workbook.createWorkbook(new File(summaryR), workbook);
			WritableSheet sheet2 = copy.getSheet(1); 
	        WritableFont normalFont = new WritableFont(WritableFont.createFont("MS Sans Serif"),
	                WritableFont.DEFAULT_POINT_SIZE,
	                WritableFont.NO_BOLD,  false,
	                UnderlineStyle.NO_UNDERLINE);
	        
	        WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
	        WritableFont wfobj=new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
	        wfobj.setColour(Colour.WHITE);
		    WritableCellFormat cfobj=new WritableCellFormat(wfobj);
		    WritableCellFormat alernate=new WritableCellFormat(wfobj);
		    WritableCellFormat PT=new WritableCellFormat(wfobj);
		    WritableCellFormat FT=new WritableCellFormat(wfobj); 
		    WritableCellFormat MT=new WritableCellFormat(wfobj);
		    WritableCellFormat TT=new WritableCellFormat(wfobj); 
	        normalFormat.setWrap(true);
	        cfobj.setAlignment(jxl.format.Alignment.CENTRE);
	        
	        cfobj.setVerticalAlignment(VerticalAlignment.CENTRE);
	        cfobj.setWrap(false);
	        cfobj.setShrinkToFit(true);
	        cfobj.setBackground(Colour.DARK_BLUE,Pattern.SOLID);   
	        cfobj.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	        jxl.format.Colour.WHITE);
	        
	        alernate.setAlignment(jxl.format.Alignment.CENTRE);
	        
	        alernate.setVerticalAlignment(VerticalAlignment.CENTRE);
	        alernate.setWrap(false);
	        alernate.setShrinkToFit(true);
	        alernate.setBackground(Colour.BLUE_GREY,Pattern.SOLID);   
	        alernate.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	        jxl.format.Colour.WHITE);
	       
	        normalFormat.setWrap(true);
	        PT.setAlignment(jxl.format.Alignment.CENTRE);

	        PT.setVerticalAlignment(VerticalAlignment.CENTRE);
	        PT.setWrap(false);
	        PT.setShrinkToFit(true);
	        PT.setBackground(Colour.SEA_GREEN,Pattern.SOLID);   
	        PT.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	        jxl.format.Colour.BLACK);
	        
	        normalFormat.setWrap(true);
	        FT.setAlignment(jxl.format.Alignment.CENTRE);

	        FT.setVerticalAlignment(VerticalAlignment.CENTRE);
	        FT.setWrap(false);
	        FT.setShrinkToFit(true);
	        FT.setBackground(Colour.RED,Pattern.SOLID);   
	        FT.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	        jxl.format.Colour.BLACK);
	        
	        normalFormat.setWrap(true);
	        MT.setAlignment(jxl.format.Alignment.CENTRE);
	     
	        MT.setVerticalAlignment(VerticalAlignment.CENTRE);
	        MT.setWrap(false);
	        MT.setShrinkToFit(true);
	        MT.setBackground(Colour.ORANGE,Pattern.SOLID);   
	        MT.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	        jxl.format.Colour.BLACK);
	        
	        normalFormat.setWrap(true);
	        TT.setAlignment(jxl.format.Alignment.CENTRE);
	       // normalFormat.setAlignment(jxl.format.Alignment.FILL);
	        TT.setVerticalAlignment(VerticalAlignment.CENTRE);
	        TT.setWrap(false);
	        TT.setShrinkToFit(true);
	        TT.setBackground(Colour.BLUE2,Pattern.SOLID);   
	        TT.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	        jxl.format.Colour.BLACK);
	        
	        //-----For get two decimal points---------
	        BigDecimal bdPprstg = new BigDecimal(Float.toString(Pprstg));
	        bdPprstg = bdPprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
	        BigDecimal bdFprstg = new BigDecimal(Float.toString(Fprstg));
	        bdFprstg = bdFprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
	        BigDecimal bdMprstg = new BigDecimal(Float.toString(Mprstg));
	        bdMprstg = bdMprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
	        
	        sheet2.setColumnView(12, 12);
	        sheet2.setColumnView(13, 20);
	        
	        sheet2.mergeCells(2, 0, 5, 0);
	        sheet2.addCell(new jxl.write.Label(2,0,"Total no. of Pass scripts",alernate));
	        sheet2.addCell(new jxl.write.Label(6,0,String.valueOf(tepscripts),alernate));
	        sheet2.mergeCells(2, 1, 5, 1);
	        sheet2.addCell(new jxl.write.Label(2,1,"Total no. of Fail scripts",cfobj));
	        sheet2.addCell(new jxl.write.Label(6,1,String.valueOf(tefscripts+g_notextcntr),cfobj));
	        sheet2.mergeCells(2, 2, 5, 2);
	        sheet2.addCell(new jxl.write.Label(2,2,"Total no. of Skip scripts",alernate));
	        sheet2.addCell(new jxl.write.Label(6,2,String.valueOf(tesscripts-1),alernate));
	        sheet2.mergeCells(2, 3, 5, 3);
	        sheet2.addCell(new jxl.write.Label(2,3,"Total no. of Test Scripts",cfobj));
	        sheet2.addCell(new jxl.write.Label(6,3,String.valueOf(tescripts-1),cfobj));
	        sheet2.mergeCells(10, 0, 13, 0);
	        sheet2.addCell(new jxl.write.Label(10,0,"Total Test Execution Time",cfobj));
	        sheet2.mergeCells(10, 1, 13, 1);
	        sheet2.addCell(new jxl.write.Label(10,1,test_time,alernate));
	        sheet2.addCell(new jxl.write.Label(10,2,"Pass(%)",cfobj));
	        sheet2.addCell(new jxl.write.Label(10,3,String.valueOf(bdPprstg),PT));
	        sheet2.addCell(new jxl.write.Label(11,2,"Fail(%)",alernate));
	        sheet2.addCell(new jxl.write.Label(11,3,String.valueOf(bdFprstg),FT));
	        sheet2.addCell(new jxl.write.Label(12,2,"Missed(%)",cfobj));
	        sheet2.addCell(new jxl.write.Label(12,3,String.valueOf(bdMprstg),MT));
	        sheet2.addCell(new jxl.write.Label(13,2,"Total no. Of Tests",alernate));
	        sheet2.addCell(new jxl.write.Label(13,3,String.valueOf(totalTest),TT));
	        
	        java.io.File imageFile = new java.io.File(PiechartP);  
	        System.out.println("imageFile :"+imageFile);
	        BufferedImage input = ImageIO.read(imageFile);  
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	        ImageIO.write(input, "PNG", baos);  
	        sheet2.addImage(new WritableImage(2,4,12,  
	        24,baos.toByteArray()));  
	        copy.write();
	        copy.close();
		}
	 
	 
	 
	 public static void Func_Insert_Overall_Test_Status_html() throws IOException
	 {
		 
		 Integer totltestscript= (tepscripts+tefscripts+t_testnotruncntr);
	        try{
		        BigDecimal bdPprstg = new BigDecimal(Float.toString(Pprstg));
		        bdPprstg = bdPprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
		        BigDecimal bdFprstg = new BigDecimal(Float.toString(Fprstg));
		        bdFprstg = bdFprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
		        BigDecimal bdMprstg = new BigDecimal(Float.toString(Mprstg));
		        bdMprstg = bdMprstg.setScale(2, BigDecimal.ROUND_HALF_UP); 
		        
				bw2.newLine();
				//bw2.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%><TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%><TR><TD BGCOLOR=#66699 WIDTH=50%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Consolidated Report</B></FONT></TD></TR>");
				bw2.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%><TR COLS=6><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><Center>" +
						"Total Execution Time</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=GREEN SIZE=2><B><Center>" +
						"Pass(%)</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=RED SIZE=2><B><Center>" +
						"Fail(%)</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><Center>" +
						"Not executed(%)</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=BLUE SIZE=2><B><Center>" +
						"Total no. of test(count)</Center></B></FONT></TD></TR>");		
				bw2.write("<TR COLS=6><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><Center>" 
						+test_time
						+"</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=GREEN SIZE=2><B>" 
						+"<Center>"
						+bdPprstg
						+"</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=RED SIZE=2><B>" 
						+"<Center>"
						+bdFprstg
						+"</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" 
						+"<Center>"
						+bdMprstg+"</Center></B></FONT></TD><TD BGCOLOR=WHITE WIDTH=20%><FONT FACE=VERDANA COLOR=BLUE SIZE=2><B>" 
						+"<Center>"
						+totltestscript+"</Center></B></FONT></TD></TR>"); //totalTest    <FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><Center><h2>Consolidated Test Status</h2></Center></B></FONT>
				bw2.newLine();
				bw2.write("<marquee bgcolor=YELLOW>Note: Click on the Log Link to see test logs. Pass(Count)is no. of pass test steps, Fail(Count)is no. of fail test steps and Missed(Count)is no. of missed test steps in the test scripts</marquee>");
				bw2.write("<html><body><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><Center><h2>Consolidated Test Status</h2></Center></B></FONT></h2><a href="
				+PiechartP
				+"><Center>PieChart</Center></a></body></html>");
	            //<h2>Consolidated Test Status </h2>
	        }catch(Exception e)
	        {
	        	System.out.println("Func_Insert_Overall_Test_Status_html :"+ e.getMessage());
	        }
	       
	 }
	 
	 
	
	public static void Func_create_summary_report () throws IOException, WriteException, BiffException{
		Date curdt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		String strTimeStamp = dateFormat.format(curdt);
		System.out.println("summaryR"+summaryR);
		
		wsb = new WorkbookSettings();
        workbook = Workbook.createWorkbook(new File(summaryR), wsb);
        workSheet = workbook.createSheet("Test Execution Summary Report" ,0);
        WritableSheet workSheet2 = workbook.createSheet("Consolidated Test Status" ,1);
        SheetSettings sh = workSheet.getSettings();
        //-------------Creating Writable font to be used in the report--------------------------- 
        WritableFont normalFont = new WritableFont(WritableFont.createFont("MS Sans Serif"),
        WritableFont.DEFAULT_POINT_SIZE,
        WritableFont.NO_BOLD,  false,
        UnderlineStyle.NO_UNDERLINE);
        WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
        WritableFont wfobj=new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
        wfobj.setColour(Colour.WHITE);
        WritableFont small=new WritableFont(WritableFont.TIMES, 8, WritableFont.BOLD);
        small.setColour(Colour.WHITE);
        
        WritableCellFormat smallfont=new WritableCellFormat(small);
	    WritableCellFormat cfobj=new WritableCellFormat(wfobj); 
	    WritableCellFormat cfobe=new WritableCellFormat(wfobj); 
        normalFormat.setWrap(true);
        cfobj.setAlignment(jxl.format.Alignment.CENTRE);
       // normalFormat.setAlignment(jxl.format.Alignment.FILL);
        cfobj.setVerticalAlignment(VerticalAlignment.CENTRE);
        cfobj.setWrap(false);
        cfobj.setShrinkToFit(true);
        cfobj.setBackground(Colour.BROWN,Pattern.SOLID);   
        cfobj.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        smallfont.setAlignment(jxl.format.Alignment.CENTRE);
        smallfont.setVerticalAlignment(VerticalAlignment.CENTRE);
        smallfont.setWrap(false);
        smallfont.setShrinkToFit(true);
        smallfont.setBackground(Colour.BROWN,Pattern.SOLID);   
        smallfont.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        cfobe.setAlignment(jxl.format.Alignment.CENTRE);
        cfobe.setVerticalAlignment(VerticalAlignment.CENTRE);
        cfobe.setWrap(false);
        cfobe.setShrinkToFit(true);
        cfobe.setBackground(Colour.BLUE_GREY,Pattern.SOLID);   
        cfobe.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,	
        jxl.format.Colour.WHITE);
        WritableCellFormat middle = new WritableCellFormat(cfobe);
        
        WritableCellFeatures ccpt = new WritableCellFeatures();
        ccpt.setComment("Total no. of tests actions Passed in test script.");
        WritableCellFeatures ccft = new WritableCellFeatures();
        ccft.setComment("Total no. of tests actions Failed in test script.");
        WritableCellFeatures ccmt = new WritableCellFeatures();
        ccmt.setComment("Total no. of tests actions Missed in test script.");
        WritableCellFeatures cctt = new WritableCellFeatures();
        cctt.setComment("Total no. of tests actions executed in test script.");
        
        workSheet.setColumnView(0, 24);
        workSheet.setColumnView(1, 60);
        workSheet.setColumnView(2, 10);
        workSheet.setColumnView(3, 16);
        workSheet.setColumnView(4, 16);
        workSheet.mergeCells(1, 0, 3, 0);
        workSheet.addCell(new jxl.write.Label(1,0,"Test Execution Summary",middle));
        workSheet.addCell(new jxl.write.Label(0,0,"Exe. Date/Time",cfobj));
        workSheet.addCell(new jxl.write.Label(0,1,"DD-MM-YYYY-HH-MM-SS",smallfont));
        workSheet.addCell(new jxl.write.Label(1,1,"Test Cases",cfobj));//String.valueOf(TCNm[0])
        workSheet.addCell(new jxl.write.Label(2,1,"Status",cfobj));//exeStatus
        workSheet.addCell(new jxl.write.Label(3,1,"Test Logs",cfobj));//exeStatus
        workSheet.addCell(new jxl.write.Label(4,0,"Test Dueration",cfobj));//exeStatus
        workSheet.addCell(new jxl.write.Label(4,1,"HH:MM:SS",smallfont));
        workSheet.mergeCells(5,0,8,0);
        
        workSheet.addCell(new jxl.write.Label(5,0,"Test Results",middle));
   	    Label pass = new Label(5, 1, "Passed",cfobj);
   	    workSheet.addCell(pass);
   	    pass.setCellFeatures(ccpt);
   	    Label fail = new Label(7, 1, "Failed",cfobj);
   	    workSheet.addCell(fail);
   	    fail.setCellFeatures(ccft);
   	    Label miss = new Label(6, 1, "Missed",cfobj);
   	    workSheet.addCell(miss);
   	    miss.setCellFeatures(ccmt);
   	    Label total = new Label(8, 1, "Total",cfobj);
   	    workSheet.addCell(total);
   	    total.setCellFeatures(cctt);
 
        workbook.write();
        workbook.close();
        
       //      
	}
		
	public static void Func_insert_summary_data (int n, String status) throws BiffException, IOException, WriteException{
		Workbook workbook = Workbook.getWorkbook(new File(summaryR));
		WritableWorkbook copy = Workbook.createWorkbook(new File(summaryR), workbook);
		WritableSheet worksheet1 = copy.getSheet(0); 
        WritableFont normalFont = new WritableFont(WritableFont.createFont("MS Sans Serif"),
                WritableFont.DEFAULT_POINT_SIZE,
                WritableFont.NO_BOLD,  false,
                UnderlineStyle.NO_UNDERLINE);
        WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
        WritableFont wfobj=new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
        wfobj.setColour(Colour.WHITE);

        WritableFont highl=new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
        highl.setColour(Colour.WHITE);
        
        WritableFont warning=new WritableFont(WritableFont.TIMES, 12, WritableFont.NO_BOLD);
        warning.setColour(Colour.BROWN);
 
	    WritableCellFormat cfobj=new WritableCellFormat(wfobj);
	    WritableCellFormat cfpc=new WritableCellFormat(wfobj);
	    WritableCellFormat cffc=new WritableCellFormat(wfobj);
	    WritableCellFormat cfsc=new WritableCellFormat(wfobj);
	    WritableCellFormat cmsc=new WritableCellFormat(wfobj);
	    WritableCellFormat highlight=new WritableCellFormat(highl);
	    WritableCellFormat warn=new WritableCellFormat(warning)
	    ;
        normalFormat.setWrap(true);
        cfobj.setAlignment(jxl.format.Alignment.CENTRE);
        cfobj.setVerticalAlignment(VerticalAlignment.CENTRE);
        cfobj.setWrap(false);
        cfobj.setShrinkToFit(true);
        cfobj.setBackground(Colour.BROWN,Pattern.SOLID);   
        cfobj.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);

        normalFormat.setWrap(true);
        cfpc.setAlignment(jxl.format.Alignment.CENTRE);
        cfpc.setVerticalAlignment(VerticalAlignment.CENTRE);
        cfpc.setWrap(false);
        cfpc.setShrinkToFit(true);
        cfpc.setBackground(Colour.GREEN,Pattern.SOLID);   
        cfpc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        cffc.setAlignment(jxl.format.Alignment.CENTRE);
        cffc.setVerticalAlignment(VerticalAlignment.CENTRE);
        cffc.setWrap(false);
        cffc.setShrinkToFit(true);
        cffc.setBackground(Colour.RED,Pattern.SOLID);   
        cffc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        cfsc.setAlignment(jxl.format.Alignment.CENTRE);
        cfsc.setVerticalAlignment(VerticalAlignment.CENTRE);
        cfsc.setWrap(false);
        cfsc.setShrinkToFit(true);
        cfsc.setBackground(Colour.YELLOW,Pattern.SOLID);   
        cfsc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        highlight.setAlignment(jxl.format.Alignment.CENTRE);
        highlight.setVerticalAlignment(VerticalAlignment.CENTRE);
        highlight.setWrap(false);
        highlight.setShrinkToFit(true);
        highlight.setBackground(Colour.GREY_40_PERCENT,Pattern.SOLID);   
        highlight.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        warn.setAlignment(jxl.format.Alignment.CENTRE);
        warn.setVerticalAlignment(VerticalAlignment.CENTRE);
        warn.setWrap(false);
        warn.setShrinkToFit(true);
        warn.setBackground(Colour.GRAY_25,Pattern.SOLID);   
        warn.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
        normalFormat.setWrap(true);
        cmsc.setAlignment(jxl.format.Alignment.CENTRE);
        cmsc.setVerticalAlignment(VerticalAlignment.CENTRE);
        cmsc.setWrap(false);
        cmsc.setShrinkToFit(true);
        cmsc.setBackground(Colour.ORANGE,Pattern.SOLID);   
        cmsc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
        jxl.format.Colour.WHITE);
        
	  WritableFont linkFor = new WritableFont(WritableFont.createFont("MS Sans Serif"),
	                WritableFont.DEFAULT_POINT_SIZE,
	                WritableFont.NO_BOLD,  false,
	                UnderlineStyle.NO_UNDERLINE); 
      
      WritableCellFormat linkFormate = new WritableCellFormat(linkFor);
      WritableFont fslc=new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD);
      fslc.setColour(Colour.DARK_BLUE);
      fslc.setUnderlineStyle(UnderlineStyle.DOUBLE);
      WritableCellFormat cfflc=new WritableCellFormat(fslc);
      cfflc.setBackground(Colour.GREY_25_PERCENT, Pattern.SOLID);
      cfflc.setAlignment(jxl.format.Alignment.CENTRE);
      cfflc.setWrap(false);
      cfflc.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,//Check this
      jxl.format.Colour.WHITE);
      cfflc.setWrap(false);
	     //------------------------------------------------------------------------------
      WritableCellFormat link = new WritableCellFormat(cfflc);
      
      WritableCellFeatures wcf = new WritableCellFeatures();
      wcf.setComment("Click on the link to see the results logs.");

        if (status.trim().equalsIgnoreCase("Pass")){
        	//exeTimeStamp
        	worksheet1.addCell(new jxl.write.Label(0,n,exeTimeStamp,highlight));//String.valueOf(TCNm[0])
        	worksheet1.addCell(new jxl.write.Label(1,n,String.valueOf(TCNm[0]),highlight));//String.valueOf(TCNm[0])
        	worksheet1.addCell(new jxl.write.Label(2,n,exeStatus,cfpc));//exeStatus
        	Formula f=new Formula(3,n,"HYPERLINK(\""+sumarypath+"\","+"\"Logs\")",link);         // creating formula for moving on to web throught hyperlinks using Formula class
        	f.setCellFeatures(wcf);
        	worksheet1.addCell(f);	
        	worksheet1.addCell(new jxl.write.Label(4,n,test_time,highlight));//exeStatusl
        	worksheet1.addCell(new jxl.write.Label(5,n,String.valueOf(passcntr),cfpc));//exeStatus
        	worksheet1.addCell(new jxl.write.Label(6,n,String.valueOf(missingcntr ),cmsc));//exeStatus
        	worksheet1.addCell(new jxl.write.Label(7,n,String.valueOf(failcntr  ),cffc));//exeStatus
        	worksheet1.addCell(new jxl.write.Label(8,n,String.valueOf(ttlscrpttestcnter  ),highlight));//exeStatus
        	
        } else if(status.trim().equalsIgnoreCase("Fail")){
        	worksheet1.addCell(new jxl.write.Label(0,n,exeTimeStamp,highlight));//String.valueOf(TCNm[0])
            worksheet1.addCell(new jxl.write.Label(1,n,String.valueOf(TCNm[0]),highlight));//String.valueOf(TCNm[0])
            worksheet1.addCell(new jxl.write.Label(2,n,exeStatus,cffc));//exeStatus
            Formula f=new Formula(3,n,"HYPERLINK(\""+sumarypath+"\","+"\"Logs\")",link);         // creating formula for moving on to web throught hyperlinks using Formula class
        	f.setCellFeatures(wcf);
        	worksheet1.addCell(f);	
            worksheet1.addCell(new jxl.write.Label(4,n,test_time,highlight));//exeStatus
            worksheet1.addCell(new jxl.write.Label(5,n,String.valueOf(passcntr),cfpc));//exeStatus
        	worksheet1.addCell(new jxl.write.Label(6,n,String.valueOf(missingcntr ),cmsc));//exeStatus
        	worksheet1.addCell(new jxl.write.Label(7,n,String.valueOf(failcntr  ),cffc));//exeStatus
        	worksheet1.addCell(new jxl.write.Label(8,n,String.valueOf(ttlscrpttestcnter  ),highlight));//exeStatus
        }else if(status.trim().equalsIgnoreCase("Not execute")) {
        	worksheet1.addCell(new jxl.write.Label(0,n,exeTimeStamp,highlight));//String.valueOf(TCNm[0])
        	worksheet1.addCell(new jxl.write.Label(1,n,crntScript,highlight));//String.valueOf(TCNm[0])
            worksheet1.addCell(new jxl.write.Label(2,n,"Failed",cffc));//exeStatus
            worksheet1.mergeCells(3, n, 8, n);
            worksheet1.addCell(new jxl.write.Label(3,n,"Warn: Script not executed pl. check script Name/Path whether it proper or not",warn));//exeStatus     
        }
        //f.setCellFeatures(wcf);
        copy.write();
        copy.close();
	}
	public static void Func_InputBox(String j) {
		 	j = JOptionPane.showInputDialog("Please insert input in the text box :");
	        userInput = j;
	        System.out.println("insert_Value :"+userInput);
	    }

	public void ExecKeywordScript(String scriptName, String TestScript, String ObjectRepository) throws Exception

	{
		// Report header
		cur_dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);
		DateFormat exedateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		exeTimeStamp = exedateFormat.format(cur_dt);

		if (ReportsPath == "") 
		{							
			ReportsPath = tempTestReportPath;
		}

		if (!ReportsPath.endsWith("\\")) 

		{ 									
			ReportsPath = ReportsPath + "\\";
		}
		TCNm = scriptName.split("\\.");
		MTCNm=TCNm[0].replace(" ", "_");
		
		strResultPath = ReportsPath + "Log" + "/" + MTCNm + "/"; //TCNm[0]
		String htmlname = ReportsPath + "Log" + "/" + MTCNm + "/" //TCNm[0]
				+ strTimeStamp + ".html";
		sumarypath=htmlname;
		
		File f = new File(strResultPath);
		f.mkdirs();
		bw = new BufferedWriter(new FileWriter(htmlname));
		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Test Screenshots:</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#CEECF5><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "<a href=\"file:///"+TestReport+TCNm[0]+"\">"+ TCNm[0] + "</a>"+ "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Row</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Keyword</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Object</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Action</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD></TR>");

		exeStatus = "Pass";
		String scriptPath = TestScript + scriptName;
		TScname = scriptName;
		FileInputStream fs1 = null;
		WorkbookSettings ws1 = null;
		fs1 = new FileInputStream(new File(scriptPath));
		ws1 = new WorkbookSettings();
		ws1.setLocale(new Locale("en", "EN"));
		Workbook TScworkbook = Workbook.getWorkbook(fs1, ws1);
		Sheet TScsheet = TScworkbook.getSheet(0);
		TScrowcount = TScsheet.getRows();

		rowcnt = 0;

		for (j = 0; j < TScrowcount; j++) 
		{
			System.out.println("TScrowcount"+TScrowcount);
            ORvalname = null;
            ORvalue = null;
			
			rowcnt = rowcnt + 1;
			String TSvalidate = "r";
			if (((TScsheet.getCell(0, j).getContents()).equalsIgnoreCase(TSvalidate) == true))

			{
				Action = TScsheet.getCell(1, j).getContents();
				cCellData = TScsheet.getCell(2, j).getContents();
				dCellData = TScsheet.getCell(3, j).getContents();
				ORPath = ObjectRepository;   // Aling data base path
				System.out.println("ORPath"+ORPath);// OR Path


				try 
				{	

					ActionVal = Action.toLowerCase();
					iflag = 0;
					//----Open data base for Object repository
				}
				catch (Exception e) 

				{
					fail("Excel file of Open2Test is not correct."); //--rahim
					System.out.print(e);
					strcaptureerrormessage = "Excel file of Test is not correct."+e.getMessage();
					func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);;	
				}
				bcellAction(scriptName);
			}
		}
		bw.close();
	}
	public static void screenshot(int loopn, int rown, String Sname) throws Exception 
	{
		try 
		{
			screenshotflag = screenshotflag + 1;
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
			Date date = new Date();
			String filenamer = "";
			String strTime = dateFormat.format(date);
			Sname = Sname.substring(0, Sname.indexOf("."));
			File screenshot = ((TakesScreenshot) D8)
					.getScreenshotAs(OutputType.FILE);
			TestReport = TestReport.toLowerCase();
			if (TestReport == "")
				TestReport = ReportsPath;
			if (!(TestReport.contains("screen")))
				TestReport = TestReport + "Screenshot/";
			if (loopflag == 0)
			{
				filenamer = TestReport + Sname + "/" + Sname + "_"
						+ screenshotflag + "_rowno_" + (j + 1) + "_" + strTime
						+ ".png";
			}
			else
			{
				filenamer = TestReport + Sname + "/" + Sname + "_"
						+ screenshotflag + "_loop_" + (loopcnt[loopsize] + 1)
						+ "_rowno_" + (j + 1) + "_" + strTime + ".png";
			}
			FileUtils.copyFile(screenshot, new File(filenamer));
			//FileUtils.
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public static void Update_Report(String Res_type) throws IOException
	{
		String str_time;
		String[] str_rep = new String[2];
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);

		if (Res_type.startsWith("executed")) 
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#008000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Passed" + "</FONT></TD></TR>");
			passcntr++;
			g_passcntr++;
			totaltcntr++;
			ttlscrpttestcnter++;
		}
		else if (Res_type.startsWith("failed"))
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			failcntr++;
			totaltcntr++;
			g_failcntr++;
			ttlscrpttestcnter++;
		} 
		else if (Res_type.startsWith("NoWindowFound"))
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Fail" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number: "
					+ (j + 1)
					+ ". Description: The Window not Found</div></th></FONT></TR>");
			failcntr++;
			totaltcntr++;
			g_failcntr++;
			ttlscrpttestcnter++;
		} 
		else if (Res_type.startsWith("loop")) 
		{
		
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=BLUE><div align=left></FONT><FONT FACE=VERDANA SIZE=2 COLOR = BLUE>"
					+ Res_type + "</div></th></FONT></TR>");
		}
		else if (Res_type.startsWith("missing")) 
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FFA500 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number "
					+ (j + 1)
					+ ".Description: The Datatable column name not found</div></th></FONT></TR>");
			missingcntr++;
			totaltcntr++;
			g_missingcntr++;
			ttlscrpttestcnter++;
		}
		else if (Res_type.startsWith("ObjectLocator"))
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FFA500 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number "
					+ (j + 1)
					+ ". Description: Object Locator is wrong or not supported. Supported Locators are Id,Name,Xpath& CSS</div></th></FONT></TR>");
		}
		else if (Res_type.startsWith("tooManyArguments"))
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED >"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "WARNING" + "</FONT></TD></TR>");
					bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>WARNING @ Line NO:  "
					+ (j + 1)
					+ ". Pass only one argument if you are using data or environment variables. Otherwise only the first variable will be considered</div></th></FONT></TR>");
					failcntr++;
					totaltcntr++;
					g_failcntr++;
					ttlscrpttestcnter++;
		} 
		else if (Res_type.startsWith("NoBlankAvailable"))
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED >"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
					bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error @ Line NO:  "
					+ (j + 1)
					+ ". No Blank Value is available in the Element</div></th></FONT></TR>");
					failcntr++;
					g_failcntr++;
					totaltcntr++;
					ttlscrpttestcnter++;
		} 
		
		else if (Res_type.startsWith("callactionstart")) 
		{
		bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=BLUE><div align=left></FONT><FONT FACE=VERDANA SIZE=2 COLOR = BLUE>"
				+ " Start of CallAction : '"
				+ callscriptPath
				+ "' execution" + "</div></th></FONT></TR>");
		
		} 
		else if (Res_type.startsWith("callactionend")) 
		{

		bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=BLUE><div align=left></FONT><FONT FACE=VERDANA SIZE=2 COLOR = BLUE>"
				+ " End of CallAction : '"
				+ callscriptPath
				+ "' execution" + "</div></th></FONT></TR>");
		} 
		else if (Res_type.startsWith("callactionfnf")) 
		{
		exeStatus = "Failed";
		bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"

				+ (j + 1)
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
				+ Action
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
				+ cCellData
				+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
				+ dCellData
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
				+ str_time
				+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
				+ "Fail" + "</FONT></TD></TR>");
		bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number: "
				+ (j + 1)
				+ ". Description: The Action(TestScript) name given is not available in the given path. Check the file path and action name.</div></th></FONT></TR>");
				failcntr++;
				totaltcntr++;
				g_failcntr++;
				ttlscrpttestcnter++;
		
		} 
		else if (Res_type.startsWith("callactionff")) 
		{
		exeStatus = "Failed";
		bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"

				+ (j + 1)
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
				+ Action
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
				+ cCellData
				+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
				+ dCellData
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
				+ str_time
				+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
				+ "Fail" + "</FONT></TD></TR>");
		bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number: "
				+ (j + 1)
				+ ". Description: The Action(TestScript) format is not in supported. Give the file name with xls extension only.</div></th></FONT></TR>");
				failcntr++;
				totaltcntr++;
				g_failcntr++;
				ttlscrpttestcnter++;
		} 
		else if (Res_type.equalsIgnoreCase("userdefined")) 
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in  test step number. "
					+ (j + 1)
					+ ". "
					+ "Function is not executed. Error exists in  User Defined function. Correct the User Defined Function</div></th></FONT></TR>");
		}		
		
	}
	public static void Update_Report(String Res_type, Exception e)throws IOException
	{
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		exeStatus = "Failed";
		if (Res_type.startsWith("failed"))
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ dCellData
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left></FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ e.toString().substring(
							e.toString().indexOf(":") + 1,
							e.toString().indexOf(".",
									e.toString().indexOf(":") + 1) + 1)
					+ "</div></th></FONT></TR>");
			failcntr++;
			totaltcntr++;
			g_failcntr++;
			ttlscrpttestcnter++;
		}
	}

	public static void Update_Report(String Res_type, String ObjectSet, String ObjectSetVal) throws IOException ////Updated on 16.12.2013 for Adding the values instead variable names in the report
	{
		String str_time;
		String[] str_rep = new String[2];
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("executed") && ObjectSet.equalsIgnoreCase("page")) 
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ ObjectSet +" ; "+ObjectSetVal
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#008000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Passed" + "</FONT></TD></TR>");
			passcntr++;
			totaltcntr++;
			g_passcntr++;
			ttlscrpttestcnter++;
		}
		else if (Res_type.startsWith("executed")) 
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ ObjectSet +" : "+ObjectSetVal
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#008000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Passed" + "</FONT></TD></TR>");
			passcntr++;
			g_passcntr++;
			totaltcntr++;
			ttlscrpttestcnter++;
		}
		else if (Res_type.startsWith("NoWindowFound")&& ObjectSet.equalsIgnoreCase("page"))
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ ObjectSet +" ; "+ObjectSetVal
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number: "
					+ (j + 1)
					+ ". Description: The Window not Found</div></th></FONT></TR>");
			failcntr++;
			totaltcntr++;
			g_failcntr++;
			ttlscrpttestcnter++;
		} 
		
		else if (Res_type.startsWith("failed"))
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ ObjectSet +" : "+ObjectSetVal
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			failcntr++;
			g_failcntr++;
			totaltcntr++;
			ttlscrpttestcnter++;
		} 
		else if (Res_type.startsWith("loop")) 
		{
		
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=BLUE><div align=left></FONT><FONT FACE=VERDANA SIZE=2 COLOR = BLUE>"
					+ Res_type + "</div></th></FONT></TR>");
		}
		else if (Res_type.startsWith("missing")) 
		{
			exeStatus = "Failed";
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ ObjectSet +" : "+ObjectSetVal
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FFA500 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number "
					+ (j + 1)
					+ ". Description: The Datatable column name not found</div></th></FONT></TR>");
			missingcntr++;
			totaltcntr++;
			g_missingcntr++;
			ttlscrpttestcnter++;
		}
		else if (Res_type.startsWith("ObjectLocator"))
		{
			bw.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=17%><FONT FACE=VERDANA SIZE=2>"
					+ Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ cCellData
					+ "</FONT></TD></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ ObjectSet +" : "+ObjectSetVal
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#FF0000 WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = WHITE>"
					+ "Failed" + "</FONT></TD></TR>");
			bw.write("<TR COLS=6><th colspan= 6 BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE='WINGDINGS 2' SIZE=3 COLOR=RED><div align=left>X </FONT><FONT FACE=VERDANA SIZE=2 COLOR = RED>Error Occurred in Keyword test step number "
					+ (j + 1)
					+ ". Description: Object Locator is wrong or not supported. Supported Locators are Id,Name,Xpath& CSS</div></th></FONT></TR>");
		}
		
	}
	private static void Func_StoreCheck() throws Exception 
	{
		// TODO Auto-generated method stub

		try 
		{
			String actval = null;
			String expval=null;
			Boolean boolval = null;
			String varname;
			String[] cCellDataValCh = cCellData.split(";");
			String objectType= cCellDataValCh[0];
			String ObjectValCh="";
			try
			{
				//Inserted on 16/12/2012. For holding Object Type
				ObjectValCh = cCellDataValCh[1];
				//Inserted on 16/12/2012. For Holding Object Name
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				ObjectValCh="";
			}
			String[] dCellDataValCh = dCellData.split(":");
			String ObjectSetCh = dCellDataValCh[0];
			String ObjectSetValCh = "";
			int DTcolumncountCh = 0;
			//System.out.println(ObjectValCh);
			// DTcolumncountCh = DTsheet.getColumns();
			if(objectType.equalsIgnoreCase("textelement"))
			{
					ObjectSetValCh=dCellData.replaceFirst("text:", "");
					//System.out.println(ObjectSetValCh);
			}
			else
			{
				
				if (dCellDataValCh.length == 2)
				{
					ObjectSetValCh = dCellDataValCh[1];
				}
			}
			if (ObjectSetValCh.substring(0, 1).equalsIgnoreCase("#")) 
			{
				if(map.get(ObjectSetValCh.substring(1,(ObjectSetValCh.length())))!=null)
				{
					ObjectSetValCh = map.get(ObjectSetValCh.substring(1,(ObjectSetValCh.length())));
					
				}
				else
				{
					ObjectSetValCh="";
				}
			} 
			if(!objectType.equalsIgnoreCase("page")&&!objectType.equalsIgnoreCase("dialog"))
			{
				for (int k = 0; k < ORrowcount; k++)
				{
					String ORName = ORsheet.getCell(1, k).getContents();
				//System.out.println(ObjectValCh);

					if(((ORsheet.getCell(1, k).getContents())
						.equalsIgnoreCase(ObjectValCh) == true))
					{
						String[] ORcellData = new String[3];
						ORcellData = (ORsheet.getCell(4, k).getContents())
							.split("=");
						ORvalname = ORcellData[0];
						ORvalue = ORcellData[1];
						k = ORrowcount + 1;
					//System.out.println(ORvalname + " "+ORvalue);
					}
				}
			}
			if (ObjectSetValCh.contains("dt_"))
			{
				String ObjectSetValtableheader[] = ObjectSetValCh.split("_");
				int column = 0;
				String Searchtext = ObjectSetValtableheader[1];
			    DTcolumncountCh = DTsheet.getColumns();

				for (column = 0; column < DTcolumncountCh; column++) 
				{
			        if (Searchtext.equalsIgnoreCase(DTsheet.getCell(column, 0)
			        	       .getContents()) == true) 
			        {
			        	      ObjectSetValCh = DTsheet.getCell(column, dtrownum).getContents();
			        	      System.out.println("ObjectSetValCh :"+ObjectSetValCh);

			        	      iflag = 1;
								if(ObjectSetValCh.length()==0)
								{
									ObjectSetValCh="";
								}
					}

				}
				if (iflag == 0)
				{
					ORvalname = "exit";
				}
			}
			
			switch (ObjectSetCh.toLowerCase()) 
			{
				case "enabled":
					Func_FindObj(ORvalname, ORvalue);
					boolval = elem.isEnabled();
					actval = boolval.toString();
					break;
				case "text":
					Func_FindObj(ORvalname, ORvalue);
					if(objectType.equalsIgnoreCase("textelement"))
					{
						actval=elem.getText();
					}
					else
					{
						actval = elem.getAttribute("value");
					}
					break;
				case "textpopup":
					Alert a = D8.switchTo().alert();
					actval = a.getText();
					a.accept();
					break;		
				case "value":
					Func_FindObj(ORvalname, ORvalue);
					actval = new Select(elem).getFirstSelectedOption().getText().toString();
					break;
				case "visible":
					Func_FindObj(ORvalname, ORvalue);
					boolval = elem.isDisplayed();
					actval = boolval.toString();
					break;
				case "checked":
					Func_FindObj(ORvalname, ORvalue);
					boolval = elem.isSelected();
					actval = boolval.toString();
					break;
				case "linktext":
					Func_FindObj(ORvalname, ORvalue);
					actval = elem.getText();
					break;
				case "pagetitle":
					if(ObjectValCh!="")
					{
						actval =ObjectValCh;
					}
					else
					{
						actval=D8.getTitle();
					}
					//System.out.println("NNNN"+actval);
					break;
				case "exist":
					boolval=false;
					actval=boolval.toString();

					if((objectType.equalsIgnoreCase("page"))==true && (D8.getTitle().toString().equalsIgnoreCase(ObjectValCh))==true)
					{
						//System.out.println("For In Exist");
						actval="true";
					}
					else
					{
						if(objectType.equalsIgnoreCase("page"))
						{
							String currentWindowHandle=D8.getWindowHandle(); 
							int windowFound=0;
							WebDriver newWindow = null;
							Set<String> al = new HashSet<String>();
							al = D8.getWindowHandles();
							Iterator<String> windowIterator = al.iterator();
							
							if(D8.getTitle().toString().equalsIgnoreCase(ObjectValCh)!=true)
								{
									while (windowIterator.hasNext()) 
									{
										String windowHandle = windowIterator.next();
										newWindow = D8.switchTo().window(windowHandle);
										if (newWindow.getTitle().toString().equalsIgnoreCase(ObjectValCh)==true) 
										{
											boolval=true;
											actval=boolval.toString();
											windowFound=1;
											break;
										}												
									}
									if(windowFound!=1)
									{
										boolval=false;
										
										actval=boolval.toString();
									}
									D8.switchTo().window(currentWindowHandle);
								}
						
						}
						else
						{
							if (objectType.equalsIgnoreCase("dialog")==true)
							{
								try
								{
									System.out.println("NUM");
									Alert dialogExist= null;
									dialogExist=D8.switchTo().alert();
									if(dialogExist.toString()!=null)
									{
										boolval=true;
										actval=boolval.toString();
										System.out.println("actval :"+actval);
									}
									else
									{
										boolval=false;
										actval=boolval.toString();
									}
								}
								catch( NoAlertPresentException e)
								{
										boolval=false;
										actval=boolval.toString();
									
								}
							}
						}
					}						
					break;				
				default:
					actval = "Invalid syntax";
					break;
			}

			if ((ActionVal).equalsIgnoreCase("check"))
			{
				expval = ObjectSetValCh;
				if (expval.equalsIgnoreCase("On"))
					expval = "True";
				else if (expval.equalsIgnoreCase("Off"))
					expval = "False";

				if (expval.equalsIgnoreCase(actval)) 
				{
					System.out.println("Actual value matches with expected value. Actual value is "	+ actval);
					Update_Report("executed", ObjectSetCh, ObjectSetValCh);
					APPICATION_LOGS.debug("Actual value matches with expected value. Actual value is "	+ actval);
					if (capturecheckvalue == true)
					{
						screenshot(loopnum, TScrowcount, TScname);
					}

				}
				else 
				{
					System.out.println("Actual value doesn't match with expected value. Actual value is "+ actval);
					APPICATION_LOGS.debug("Actual value matches with expected value. Actual value is "	+ actval);

					if (ORvalname == "exit") 
					{
						Update_Report("missing", ObjectSetCh, ObjectSetValCh);

					} 
					else 
					{
						Update_Report("failed", ObjectSetCh, ObjectSetValCh);
					}
					if (capturecheckvalue == true)
					{
						screenshot(loopnum, TScrowcount, TScname);
					}
				}
			}
			else if ((ActionVal).equalsIgnoreCase("storevalue"))

			{
				varname = ObjectSetValCh;
				if (actval.equalsIgnoreCase("Invalid syntax"))
				{
					Update_Report("missing",ObjectSetCh, ObjectSetValCh);

				}
				else 
				{
					if (map.containsKey(varname))
					{
						map.put(varname, actval);
						Update_Report("executed", ObjectSetCh, ObjectSetValCh);
						System.out
								.println("Overwriting the value of the variable "
										+ varname
										+ " to store the value as mentioned in the test case row number"
										+ rowcnt);
						map.remove(varname);

					} 
					else 
					{
						map.put(varname, actval);
						Update_Report("executed",ObjectSetCh, ObjectSetValCh);
						System.out
								.println("Overwriting the value of the variable "
										+ varname
										+ " to store the value as mentioned in the test case row number"
										+ rowcnt);
						if (ORvalname == "exit")
						{
							Update_Report("missing",ObjectSetCh, ObjectSetValCh);

						}
						else 
						{
							
						}
					}
				}
				if (capturestorevalue == true)
				{
					screenshot(loopnum, TScrowcount, TScname);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@After
	public void close() throws Exception

	{
		try 
		{	
			System.out.println("Test end.");
			D8.quit();
			//func_updateLog("success",SuiteName,initialexeTimeStamp,htmlname1);;
			//Sent_Mail();
			ExcutionComplete = true;
		}
			
		catch (Exception e) //UnhandledAlert
		{
			ExcutionComplete = false;
			System.out.println(e);
			System.out.println("Because of specification of SeleniumWebDriver, downloading may be failed.");
			System.out.println("Please confirm the report file and screenshot about test result.");
			//--Sent_Mail();
			strcaptureerrormessage=e.getMessage();
			if (strcaptureerrormessage==null)
			{
				strcaptureerrormessage="Error Occurred";
			}
			func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);;
		}
		
		if (ExcutionComplete == true)
		{
			func_updateLog("success",SuiteName,initialexeTimeStamp,htmlname1);;
		}
	}
	
	private static void Func_FindObj(String strObjtype, String strObjpath) throws Exception 

	{
		try
		
		{
			if (strObjtype.length() > 0 && strObjpath.length() > 0) 
			{
				if (strObjtype.equalsIgnoreCase("id")) 
				{
					elem = D8.findElement(By.id(strObjpath));
				} 
				else if (strObjtype.equalsIgnoreCase("name"))
				{
					elem = D8.findElement(By.name(strObjpath));
				} 
				else if (strObjtype.equalsIgnoreCase("xpath"))
				{
					elem = D8.findElement(By.xpath(strObjpath));
				} 
				else if (strObjtype.equalsIgnoreCase("link")) 
				{
					elem = D8.findElement(By.linkText(strObjpath.toString()));
				}
				else if (strObjtype.equalsIgnoreCase("css"))
				{
					elem = D8.findElement(By.cssSelector(strObjpath));
				}
			}
		}
		catch (Exception e)
		{
			Update_Report("failed", e);
			System.out.println(e.toString());
			elem = null;
		}
	}

	public static int ifContidionSkipper(String strifConditionStatus)throws Exception
	{
		try 
		{
			String strKeyword;
			int intLogicStartRow, intLogicEndRow, intIfEndConditionCount, intIfConditionCount;
			String strKeyWord;
			intIfConditionCount = 1;
			intIfEndConditionCount = 0;

			if (strifConditionStatus.equalsIgnoreCase("false")) 
			{
				intLogicStartRow = j;

				do 
				{
					j = j + 1;
					strKeyword = TScsheet.getCell(1, j).getContents();
					System.out.println(strKeyword);

					if (strKeyword.equalsIgnoreCase("Condition")) 
					{
						intIfConditionCount = intIfConditionCount + 1;
					}

					if (strKeyword.equalsIgnoreCase("Endcondition")) 
					{
						intIfEndConditionCount = intIfEndConditionCount + 1;

						if (intIfConditionCount == intIfEndConditionCount) 
						{
							j = j + 1;
							break;
						}
					}

				} 
				while (true);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return j;
	}


	public String Func_IfCondition(String strConditionArgs) throws Exception 
	{
		int iFlag = 1;
		String str[] = strConditionArgs.split(";");
		String value1 = str[0];
		String value2 = str[2];
		String strOperation = str[1];
		strOperation = strOperation.toLowerCase().trim();

		switch (strOperation.toLowerCase()) 
		{
			case "equals":
				if (value1.substring(0, 1).equalsIgnoreCase("#"))
				{
					value1 = map.get(value1.substring(1, (value1.length())));
					System.out.println("Variable used in condition statement has value: "+ value1);


					if (value1.trim().equalsIgnoreCase(value2.trim())) 
					{
						iFlag = 0;
					}
				} 
				else if (value1.trim().equalsIgnoreCase(value2.trim())) 
				{
					iFlag = 0;
				}



				break;

			case "notequals":
				if (value1.substring(0, 1).equalsIgnoreCase("#")) 
				{
					value1 = map.get(value1.substring(1, (value1.length())));
					System.out.println("Variable used in condition statement has values: "+ value1);


					if (value1.trim().equalsIgnoreCase(value2.trim())) 
					{
						iFlag = 0;
					}
				}
				else if (!value1.trim().equals(value2.trim()))
				{
					iFlag = 0;
				}
				break;
			
			case "greaterthan":
				if (isInteger(value1) && isInteger(value2)) 
				{
					if (Integer.parseInt(value1) > Integer.parseInt(value2)) 
					{
						iFlag = 0;
					}
				} 
				else 
				{
				// Report

				}
				break;
			case "lessthan":
				if (isInteger(value1) && isInteger(value2))
				{
					if (Integer.parseInt(value1) < Integer.parseInt(value2))
					{
						iFlag = 0;
					}
				} 
				else 
				{
					// Report

				}
				break;
			default:
				Update_Report("missing");

		}

		if (iFlag == 0) 
		{
			return "true";
		}
		else
		{
			return "false";
		}

	}

	public void arrayresize()
	{
		if (loopstart.length <= loopsize)
		{
			loopstart = Arrays.copyOf(loopstart, loopstart.length + 1);
			loopend = Arrays.copyOf(loopend, loopend.length + 1);
			loopcnt = Arrays.copyOf(loopcnt, loopcnt.length + 1);
			dtrownumloop = Arrays.copyOf(dtrownumloop, dtrownumloop.length + 1);
			loopcount = Arrays.copyOf(loopcount, loopcount.length + 1);
		}
	}

	public void bcellAction(String scriptName) throws Exception 
	{
		try
		{
			switch (ActionVal.toLowerCase()) 
			{
				case "loop":
					startrow = j;
					//dtrownum = 1;  // --Old----
					//--New----
					String[] LpFrmTo = cCellData.split(";");
					cCellData = LpFrmTo[1].toString();
					dtrownum=Integer.parseInt(LpFrmTo[0]);
					//--New----
					loopsize = loopsize + 1;
					if (loopsize >= 1) //--Old----
					{
						arrayresize();

					}
					loopflag = 1;
					loopcount[loopsize] = Integer.parseInt(cCellData); //--Old---
					loopstart[loopsize] = j;  
					loopcnt[loopsize] = 0;
					dtrownumloop[loopsize] = dtrownum; // 
					//Update_Report("loop : " + "Start of loop : " + (loopsize+1));//--Old--
					Update_Report("loop : " + "Start of loop from data table Row no. : " + (dtrownum));//--New--
					Update_Report("executed");
					break;
				case "endloop":
					loopcnt[loopsize] = loopcnt[loopsize] + 1;
					loopnum = loopnum + 1;
					if (loopcnt[loopsize] == loopcount[loopsize])
					{
						Update_Report("loop" + " End of Loop : " + (dtrownum)
							+ " : Loop count : " + loopcnt[loopsize]);
						loopsize = loopsize - 1;
						if (loopsize >= 0)
							dtrownum = dtrownumloop[loopsize];
					else
					{
						dtrownum = 1;
						loopflag = 0;
					}
					Update_Report("executed");
				} else {
					j = loopstart[loopsize];
					dtrownum = dtrownum + 1;
					dtrownumloop[loopsize] = dtrownum;
					Update_Report("loop" + " End of Loop : " + (loopsize + 1)
							+ " : Loop count : " + loopcnt[loopsize]);
				}
				rowcnt = 1;
				break;
			case "launchapp":
				D8.get(cCellData);
				Update_Report("executed");
				break;

			case "wait":
				Thread.sleep(Long.parseLong(cCellData));
				Update_Report("executed");
				break;
			case "switchtoframe":
				String[] frames= cCellData.split(";");
				String frmtype=frames[0].toString();
				String frmId=frames[1].toString();
				try{
				if (frmtype.trim().equalsIgnoreCase("defaultContent")){
					D8.switchTo().defaultContent();
					D8.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}else if(frmtype.trim().equalsIgnoreCase("name")){
					D8.switchTo().frame(frmId);
					D8.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}else if(frmtype.trim().equalsIgnoreCase("id")){		
					D8.switchTo().frame(frmId.indexOf(frmId));
					D8.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}else{
					D8.switchTo().frame("");
					D8.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}
				Update_Report("executed");
				}catch(Exception e){
					APPICATION_LOGS.debug("Frame not found: "+e);
					Update_Report("executed");
				}
				break;
			case "switchtowin":
				String[] win= cCellData.split(";");
				String wintype=win[0].toString();
				String winid=win[1].toString();
				try{
				if (wintype.trim().equalsIgnoreCase("main")){
					D8.switchTo().window("");
				}else if(wintype.trim().equalsIgnoreCase("name")){
					D8.switchTo().window(winid);
				}else if(wintype.trim().equalsIgnoreCase("id")){		
					D8.switchTo().window(winid);
				}else{
					D8.switchTo().window("");
				}
				}catch(Exception e){
					APPICATION_LOGS.debug("Window not found: "+e);
				}
				break;
			case "upload":
				try{
					Func_Upload_System_Files();
					Update_Report("executed");
				}catch(Exception e){
					APPICATION_LOGS.debug("Uploading Failed: "+e);
					Update_Report("failed");
				}
				break;
			case "popupcheck":                 //Rahim -- Add for verify pop Alert messages
				try {
					Func_PopUpCheck();
					Update_Report("executed");
				}catch(Exception e) {
					APPICATION_LOGS.debug("Pop-up not found : "+e);
					System.out.println("No Pop-up Alert click on control button");
					Update_Report("failed");
				}
				break;
			case "savedialog":
				//Runtime rt = Runtime.getRuntime();
				//Process p = rt.exec("D://AutoITScript/FileDown.exe");
				try{
					Func_save_dialog();
					Update_Report("executed");
				}catch(Exception e){
					System.out.println(e);
					Update_Report("failed");
				}
				break;
				
			case "condition":
				String strConditionStatus = Func_IfCondition(cCellData);
				if (strConditionStatus.equalsIgnoreCase("false")) {
					j = ifContidionSkipper(strConditionStatus);
					j = j + 1;
					System.out.println(j);
				}
				Update_Report("executed");
				break;

			case "endcondition":
				Update_Report("executed");
				break;
				
			case "callfunction":

				try {
					func_InvokeFunction(cCellData, dCellData);
				} catch (Exception e) {
					Update_Report("userdefined");
				}
				break;
				
			case "callaction":
				exeStatus = "Pass";		
			if (cCellData.contains("xls")) {
				callscriptPath = cCellData;//TestScript + scriptName;
				TScname = scriptName;
				FileInputStream fs4 = null;
				WorkbookSettings ws4 = null;
				try {
					fs4 = new FileInputStream(new File(callscriptPath));
					ws4 = new WorkbookSettings();
					ws4.setLocale(new Locale("en", "EN"));
					
					Workbook callTScworkbook = Workbook.getWorkbook(fs4, ws4);
					Sheet callTScsheet = callTScworkbook.getSheet(0);
					callTScrowcount = callTScsheet.getRows();
						
					int introwcnt = 0;
					int introwcntStore = j;
					Update_Report("executed");
					j = j + 1;
					Update_Report("callactionstart");					
					introwcnt = 0;
					int jloop;
					
					for (jloop = 0; jloop < callTScrowcount; jloop++) 
					{
						System.out.println("callTScrowcount"+callTScrowcount);
						introwcnt = introwcnt + 1;
						j = jloop;
						String callTSvalidate = "r";
						if (((callTScsheet.getCell(0, jloop).getContents()).equalsIgnoreCase(callTSvalidate) == true))
						{
							Action = callTScsheet.getCell(1, jloop).getContents();
							cCellData = callTScsheet.getCell(2, jloop).getContents();
							dCellData = callTScsheet.getCell(3, jloop).getContents();
							String ORPath = ObjectRepository;
							System.out.println("ORPath"+ORPath);
/*							FileInputStream fs2 = null;
							WorkbookSettings ws2 = null;*/

							try 
							{
								ActionVal = Action.toLowerCase();
								iflag = 0;
							}
							catch (Exception e) 

							{
								fail("Excel file of Open2Test is not correct."); //--rahim
								System.out.print(e);
							}
							bcellAction(scriptName);
							jloop = j;
						}	
					}
					Update_Report("callactionend");
					j = introwcntStore;	
					}	
					 catch (FileNotFoundException FNF1)
					{
						 Update_Report("callactionfnf");	
					}					
				}
					else
				{	
					Update_Report("callactionff");
				}
				break;					
				
			case "screencaptureoption":
				String[] sco = cCellData.split(";");

				for (int s = 0; s < sco.length; s++) {
					if (sco[s].equalsIgnoreCase("perform")) {
						captureperform = true;
					}
					if (sco[s].equalsIgnoreCase("storevalue")) {
						capturestorevalue = true;
					}
					if (sco[s].equalsIgnoreCase("check")) {
						capturecheckvalue = true;
					}
				}
				Update_Report("executed");
				break;
			case "importdata":
				// Runtime rt = Runtime.getRuntime();
				// Process p = rt.exec("D://AutoITScript/FileDown.exe");
				String xcelpath = cCellData;
				FileInputStream fs3 = null;
				WorkbookSettings ws3 = null;
				fs3 = new FileInputStream(new File(xcelpath));
				ws3 = new WorkbookSettings();
				ws3.setLocale(new Locale("en", "EN"));
				Workbook DTworkbook = Workbook.getWorkbook(fs3, ws3);
				DTsheet = DTworkbook.getSheet(dCellData); // 0 
				int DTrowcount = DTsheet.getRows();
				String DTName;
				Update_Report("executed");
				break;

			case "screencapture":
				screenshot(loopnum, TScrowcount, TScname);
				Update_Report("executed");
				break;
			case "context"://Updated on 16.12.2013 for page support
				String windowType = null;
				try 
				{
					dCellData.toString();
					if (dCellData.contains(";")) 
					{
						if(dCellData.endsWith(";"))
						{
								windowType=dCellData.toString();
								ObjectSetVal = dCellData.toString();		
						}
						else
						{
							dCellDataVal = dCellData.split(";");
							windowType=dCellDataVal[0];
							ObjectSetVal = dCellDataVal[1];
							if (ObjectSetVal.substring(0, 1).equalsIgnoreCase("#")) 
							{
								if(map.get(ObjectSetVal.substring(1,(ObjectSetVal.length())))!=null)
								{
									ObjectSetVal = map.get(ObjectSetVal.substring(1,(ObjectSetVal.length())));
								}
								else
								{
									ObjectSetVal="";
								}
							} 
							
						}
					}
					else 
					{
						windowType=dCellData.toString();
						ObjectSetVal = dCellData.toString();
					}
					if(windowType.equalsIgnoreCase("page") || windowType.equalsIgnoreCase("page;") )
					{
							int windowNums=0;
							int windowItr=0;
							parentWindowHandle = D8.getWindowHandle(); // save the current window handle.
							//System.out.println(parentWindowHandle);
							WebDriver newWindow = null;
							Set<String> al = new HashSet<String>();
							al = D8.getWindowHandles();
							windowNums=al.size(); // get the number of window handles
							//System.out.println(windowNums);
							Iterator<String> windowIterator = al.iterator();
							if(D8.getTitle().toString().equalsIgnoreCase(ObjectSetVal)== true)
							{
									Update_Report("executed");
							}
							else
							{
								if(!((ObjectSetVal.equalsIgnoreCase("page")||(ObjectSetVal.equalsIgnoreCase("page;")))||(ObjectSetVal.toString()=="")))
								{
									//System.out.println("I am Here");
									if(D8.getTitle().toString().equalsIgnoreCase(ObjectSetVal)== false)
									{
										//System.out.println("I am Here1");
										for(windowItr=0;windowItr<windowNums;windowItr++)
										{
											String windowHandle = windowIterator.next();
											//System.out.println(windowHandle);
											newWindow = D8.switchTo().window(windowHandle);
											//System.out.println(newWindow.getTitle().toString());
											//System.out.println(newWindow.getTitle());
											//System.out.println(ObjectSetVal);
											
											if (newWindow.getTitle().toString().equalsIgnoreCase(ObjectSetVal)) 
											{
												windowFound=1;
												Update_Report("executed",windowType,ObjectSetVal);
												break;
												
											}
											//parentWindowHandle = D8.getWindowHandle();												
										}
										if(windowFound!=1)
										{
											
											Update_Report("NoWindowFound",windowType,ObjectSetVal);
										}
									}
								}				
								else
								{
									if (windowNums==1)
									{
										//System.out.println("executed");
										Update_Report("executed");
									}
									//parentWindowHandle = D8.getWindowHandle();	
									else
									{
										int winItr1=0;
										String windowHandle=null;
										
										while(winItr1!=windowNums)
										{
											windowHandle = windowIterator.next();
											System.out.println(windowHandle);
											newWindow = D8.switchTo().window(windowHandle);
										//	windowHandle=newWindow.getWindowHandle();
										//	System.out.println(newWindow.getTitle().toString());
										//	System.out.println(parentWindowHandle.toString());
											if(parentWindowHandle.equalsIgnoreCase(windowHandle))
											{
											
												if(winItr1!=windowNums-1)
												{
													windowHandle = windowIterator.next();
													D8.switchTo().window(windowHandle);
													Update_Report("executed");
													windowFound=1;
													break;
												}
												else
												
												{
													Iterator<String> windowIterator1 = al.iterator();
													windowHandle = windowIterator1.next();
													D8.switchTo().window(windowHandle);
													Update_Report("executed");
													windowFound=1;
													break;	
												}
											}
											
											winItr1++;
										}
										if(windowFound!=1)
										{
											Update_Report("NoWindowFound");
										}
										
									}
								}
								
							}
					//if (cCellData.equalsIgnoreCase("parent window"))
						//D8.switchTo().window(parentWindowHandle);
					//Update_Report("executed");
					}
					if((windowType.equalsIgnoreCase("dialog") || windowType.equalsIgnoreCase("dialog;")) )
					{
						//parentWindowHandle = D8.getWindowHandle(); 
						D8.switchTo().alert();
						Update_Report("executed");
						//dialogSwitch.wait();																		
					}
				}
				catch (Exception e)
				{
					Update_Report("failed", e);
				}
				break;
			case "check":
				Func_StoreCheck();
				break;
			case "storevalue":
				Func_StoreCheck();
				break;
				
			case "download":

				cCellObjName = "";// Updated on 16.12.2013 for page support
				cCellObjType = "";// Updated on 16.12.2013 for page support
				dCellDataVal = null;

				if (cCellData.contains(";")) // Updated on 16.12.2013 for page
												// and Dialog Support
				{
					if (cCellData.endsWith(";")) {
						cCellObjType = cCellData;
						cCellObjName = cCellData;
					} else {
						cCellDataVal = cCellData.split(";");
						cCellObjType = cCellDataVal[0];
						cCellObjName = cCellDataVal[1];
					}
				}
				else {
					cCellObjType = cCellData;
					cCellObjName = cCellData;
				}
				ObjectSet = dCellData.toString();

				if (ObjectSetVal.contains("dt_"))
					DTcolumncount = DTsheet.getColumns();
				if (!(cCellObjType.equalsIgnoreCase("page")
						|| cCellObjType.equalsIgnoreCase("page;")
						|| cCellObjType.equalsIgnoreCase("dialog")
						|| cCellObjType.equalsIgnoreCase("dialog;")
						|| cCellObjType.equalsIgnoreCase("DownloadDialog") || cCellObjType
							.equalsIgnoreCase("uploadDialog"))) // //Updated on
																// 16.12.2013
																// for
																// supporting
																// page and
																// dialog
				{
					for (int k = 0; k < ORrowcount; k++) {
						// String ORName = ORsheet.getCell(1, k).getContents();

						if (((ORsheet.getCell(1, k).getContents())
								.equalsIgnoreCase(cCellObjName) == true)) {
							String[] ORcellData = new String[3];
							ORcellData = (ORsheet.getCell(4, k).getContents())
									.split("=");
							ORvalname = ORcellData[0];
							ORvalue = ORsheet.getCell(4, k).getContents()
									.substring(ORcellData[0].length() + 1);
							k = ORrowcount + 1;
						}
					}
				}
				try {
					// String[] cCellDataValCh = cCellData.split(";");
					// String objectType = cCellDataValCh[0];
					readAttributeforPerform();
					Func_FindObj(ORvalname, ORvalue);
					if (elem == null) {
						return;
					} else {
						if (ObjectSet == "") {
							Update_Report("filePathNotFound2");
						} else {
							try {

								System.out.println(ObjectSet);

								ObjectSet1 = ObjectSet.split("\\\\");
							} catch (Exception e2) {

								System.out.println(e2);
							}
							for (int i = 0; i < ObjectSet1.length - 1; i++) {
								ObjectSet2 = ObjectSet2 + ObjectSet1[i] + "\\";

							}
							if (new File(ObjectSet2.toString()).exists()) {

								doUploadDownload("download");

							} else {
								Update_Report("filePathNotFound1");

							}
							ObjectSet2 = "";
							ObjectSet1 = null;
						}
					}
				} catch (Exception e) {

					System.out.println(e);
				}
				break;
	
				
	
			case "perform":
				
				System.out.println("Perform : enter into perform");

				cCellObjName="";//Updated on 16.12.2013 for page support
				cCellObjType="";//Updated on 16.12.2013 for page support
				dCellDataVal = null;

				if (cCellData.contains(";")) // Updated on 16.12.2013 for page and Dialog Support
				{
					if (cCellData.endsWith(";")) 
					{
						cCellObjType=cCellData;
						cCellObjName=cCellData;
					}
					else
					{
						cCellDataVal = cCellData.split(";");
						cCellObjType=cCellDataVal[0];
						cCellObjName=cCellDataVal[1];
					}
				}

				else
				{
					cCellObjType=cCellData;
					cCellObjName=cCellData;
				}
				dCellData.toString();

				if (dCellData.contains(":")) 
				{
					if(!dCellData.endsWith(":"))
					{
						dCellDataVal = dCellData.split(":");
						ObjectSet = dCellDataVal[0].toLowerCase();
						ObjectSetVal = dCellDataVal[1];

						if(dCellDataVal.length>2) ////Updated on 16.12.2013 for TextElement support -Text Element Might have contained more than two:
						{
							for(int dCellvalcount=2;dCellvalcount<dCellDataVal.length;dCellvalcount++)
							{
								if(ObjectSetVal.startsWith("dt_") || ObjectSetVal.startsWith("#"))
									
								{
									Update_Report("tooManyArguments");
									break;
								}
								else
								{
									ObjectSetVal = ObjectSetVal+":"+dCellDataVal[dCellvalcount];
								}
							}
						}
					}
					else
					{
						ObjectSet=dCellData.replace(":", "");
						ObjectSetVal="";
					}
				} 
				else 
				{
					ObjectSet = dCellData.toString();
				}
				DTcolumncount = 0;
				if (ObjectSetVal.contains("dt_"))
					DTcolumncount = DTsheet.getColumns();
				if(!(cCellObjType.equalsIgnoreCase("page") 
						||cCellObjType.equalsIgnoreCase("page;")
						||cCellObjType.equalsIgnoreCase("dialog") 
						||cCellObjType.equalsIgnoreCase("dialog;")
						|| cCellObjType.equalsIgnoreCase("DownloadDialog") || cCellObjType
						.equalsIgnoreCase("uploadDialog")))// //Updated on
													// 16.12.2013
													// for
													// supporting
													// page and
													// dialog
				{	
					
					//Instead of for loop write query for get xapth values from access data base			
					get_locater_frm_OR(cCellObjName);			
		
				}
				//if(dCellDataVal.length>2 && (cCellObjType=="listbox") && (ObjectSetVal.startsWith("dt_")||ObjectSetVal.startsWith("dt_"))) 
				//{
				//	Update_Report("toomanyarguments");
				//}
				//else
				//{
					dCellAction();
					
					
				//}
				// End of Objectset Switch
				//Update_Report("executed");
			}// End of Actval Switch
		} /*
		 * catch (UnhandledAlertException e) {
		 * 
		 * for (String id : D8.getWindowHandles()) {
		 * System.out.println("WindowHandle: " + D8.switchTo().window(id));
		 * 
		 * } System.out.println(e); System.out .println(
		 * "Because of specification of SeleniumWebDriver, downloading may be failed."
		 * ); System.out .println(
		 * "Please confirm the report file and screenshot about test result.");
		 * }

		 */catch (Exception ex) 
		 {
			Update_Report("failed", ex);
			System.out.println(ex);
			System.out.println("------Error Information : Open2Test-------");
			System.out.println("Current Script:" + scriptName);
			System.out.println("Current ScriptPath:" + TestScript);
			System.out
					.println("Using ObjectRepositoryPath:" + ObjectRepository);
			System.out.println("Current Keyword:" + Action);
			System.out.println("Current ObjectDetails:" + cCellData);
			System.out.println("Current ObjectDetailsPath:" + ORvalue);
			System.out.println("Current Action:" + dCellData);
			System.out.println("------Error Information : Open2Test-------");
			
			strcaptureerrormessage = "Error:"+ex.getMessage()+"ObjectDetailsPath:"+ORvalue;
			func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);;
			
			//fail("Cannot test normally by Open2Test.");
			//return;
		}
	}
	private static void Func_save_dialog () throws Exception{
		String[] File = cCellData.split(";");
		String FilePath = File[1].toString();
		String WinName = File[2].toString();
		Thread.sleep(2000);	
		Runtime rt = Runtime.getRuntime();
		new ProcessBuilder(CONFIG.getProperty("AutoitSaveDlgexe"),
				FilePath, WinName).start();	
	}
	private static void Func_Upload_System_Files() throws Exception {
		String[] File = cCellData.split(";");
		String FilePath = File[0].toString();
		String WinName = File[1].toString();
		Thread.sleep(2000);		
		new ProcessBuilder(CONFIG.getProperty("AutoitFileUpldexe"),
			FilePath, WinName).start();
	}
	private static void Func_PopUpCheck() throws Exception {
		Alert a = D8.switchTo().alert();
		String popmsg = a.getText();
		System.out.println("Pop Up message : "+popmsg );
		a.accept();
		String[] ExpecAlert = cCellData.split(";");
		String expcAlert = ExpecAlert[1].toLowerCase();
		
		if (expcAlert.contains("dt_")) {
			String ObjectSetValtableheader[] = expcAlert
					.split("_");
			System.out.println("Pop Up message _dt : "+popmsg );
			int column = 0;
			String Searchtext = ObjectSetValtableheader[1];
			
			for (column = 0; column < DTcolumncount; column++) 
			{
				if (Searchtext.equalsIgnoreCase(DTsheet.getCell(column,0).getContents()) == true)
				{
					expcAlert = DTsheet.getCell(column,dtrownum).getContents();			
					System.out.println("Pop Up message expcAlert : "+popmsg );
					if (popmsg.trim().equalsIgnoreCase(expcAlert.trim())){	
						System.out.println("equal case : "+popmsg );
						dCellData = "Actval:-> "+popmsg;
						Update_Report("executed");
					}else{
						System.out.println("else case : "+popmsg );
						dCellData = "Actval:-> "+popmsg;
						Update_Report("failed");
					}
					iflag = 1;
				}
				if (iflag == 0) {
					ORvalname = "exit";
				}
			}
		}else{
			if (popmsg.trim().equalsIgnoreCase(expcAlert.trim())){	
				dCellData = "Actval:-> "+popmsg;
				Update_Report("executed");
			}else{
				dCellData = "Actval:-> "+popmsg;
				Update_Report("failed");
			}
		}
	}

	public void readAttributeforPerform() throws Exception {
		
		try {
			if (ObjectSetVal.length() > 0)

			{
			////Function was updated on 16.12.2013 for supporting page, dialog and textelement
				if(ObjectSetVal.trim().equalsIgnoreCase("user")){
					Func_InputBox("User Input");
					ObjectSetVal=userInput;
					System.out.println("user" +ObjectSetVal);
				}
				
			    else if (ObjectSetVal.substring(0, 1).equalsIgnoreCase("#")) 
				{

						if(map.get(ObjectSetVal.substring(1,(ObjectSetVal.length())))!=null)
						{
							ObjectSetVal = map.get(ObjectSetVal.substring(1,(ObjectSetVal.length())));
							System.out.println(ObjectSetVal);
						}
						else
						{
							ObjectSetVal="";
						}

				} 
				else if (ObjectSetVal.contains("dt_"))
				{

						String ObjectSetValtableheader[] = ObjectSetVal.split("_");
						int column = 0;
						String Searchtext = ObjectSetValtableheader[1];
						
						for (column = 0; column < DTcolumncount; column++) 
						{
							if (Searchtext.equalsIgnoreCase(DTsheet.getCell(column,0).getContents()) == true)
							{
								ObjectSetVal = DTsheet.getCell(column, dtrownum).getContents();					
								if(ObjectSetVal.length()==0)
								{
									ObjectSetVal="";
								}
													
							}

							iflag = 1;

						}

						if (iflag == 0) 
						{
							ORvalname = "exit";
						}
					
					else
					{
						Update_Report("toomanyarguments");
					}
				}
					
			}
		}
		catch (Exception e) 
		{
			Update_Report("failed", e);
		}

	}
	public static void get_locater_frm_OR(String Match_obj)
	
    {

        // variables
        Connection connection_or = null;
        Statement statement_or   = null;
        ResultSet resultSet_or   = null;

        // Step 1: Loading or registering Oracle JDBC driver class
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS AccObjectPathess JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            String msAccDB = ORPath; //D:\\selenium\\OR\\OR.accdb
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
            //Step 2.A: Create and get connection using DriverManager class
            connection_or = DriverManager.getConnection(dbURL); 
            //Step 2.B: Creating JDBC Statement 
            statement_or = connection_or.createStatement();
            //Step 2.C: Executing SQL & retrieve data into ResultSet
            resultSet_or = statement_or.executeQuery("SELECT * FROM ObjectReposit where ObjectName = '"+Match_obj+"'");
            
 /*           resultSet_or = statement_or.executeQuery("SELECT ObjectPath FROM ObjectReposit where ObjectName = '"+Match_obj+"'");    
            String objpath[] = resultSet_or.getString(1).split("=");
            System.out.println(objpath[0]);
            System.out.println(objpath[1]);
            ORvalname = objpath[0].trim();
            ORvalue = resultSet_or.getString(1).substring(objpath[0].trim().length() + 1);//objpath[1].trim();
            System.out.println("ORvalue:"+ ORvalue);*/
            
           while(resultSet_or.next()) {
                System.out.println(resultSet_or.getInt(1) + "\t" + 
                        resultSet_or.getString(2) + "\t" + 
                        resultSet_or.getString(3) + "\t" +
                        resultSet_or.getString(4) + "\t" +
                        resultSet_or.getString(5));
                String objpath[] = resultSet_or.getString(5).split("=");
                System.out.println(objpath[0]);
                System.out.println(objpath[1]);
                ORvalname = objpath[0].trim();
                ORvalue = resultSet_or.getString(5).substring(objpath[0].trim().length() + 1);//objpath[1].trim();
                System.out.println("ORvalue:"+ ORvalue);                  
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {

            // Step 3: Closing database connection
            try {
                if(null != connection_or) {

                    // cleanup resources, once after processing
                    resultSet_or.close();
                    statement_or.close();
                    // and then finally close connection
                    connection_or.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }
	
	public static void Sent_Mail() throws MessagingException{	
		final String username = CONFIG.getProperty("email_username");
	    final String password = CONFIG.getProperty("email_password");
	    String host = "smtp.gmail.com";
	    String from = CONFIG.getProperty("mail_From");
	    String toAddress = CONFIG.getProperty("mail_To");
	    String BCC=CONFIG.getProperty("mail_BCC");
	    String CC=CONFIG.getProperty("mail_CC");
	    	
	        String filename = htmlname1;
	        // Get system properties
	        Properties props = System.getProperties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtps.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
	        //Session session = Session.getInstance(props, null);

		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });

	        
	        //-----------
	        StringBuilder message1 = new StringBuilder();
	        //message1.append("Teast Suite"\r\n");
	        //message1.append("Lic : " +  strLicNo +"\r\n");
	        message1.append("\r\n");
	        
	        message1.append("Sub: " + "Automated test execution summary report"   +"\r\n");
	        message1.append("\r\n");
	        message1.append("\r\n");
	        message1.append( "Here attaching test execution summary report."   +"\r\n");
	        message1.append( "Test summary report containing test case results & test scripts status."   +"\r\n");
	        message1.append( "Attached excel containing two sheets Test execution summary report & consolidated test status." +"\r\n");
	        message1.append("\r\n");
	        message1.append("\r\n");
	        message1.append( "Please revert if you need any more clarifications." +"\r\n");
	        message1.append("\r\n");
	      //  message1.append( "Note: The file of plans along with supporting documents will be accepted only after the payment of necessary fees" +"\r\n");
	        message1.append("\r\n");
	        message1.append("\r\n");
	        message1.append("\r\n");
	        message1.append( "With Regards,"   +"\r\n");
	        message1.append( "Abrahim"   +"\r\n");
	        message1.append( "Automation Test"   +"\r\n");
	        message1.append( "Ahmdabad"   +"\r\n");
		    
	        MimeMessage message = new MimeMessage(session);

	        message.setFrom(new InternetAddress(from));

	        message.setRecipients(Message.RecipientType.TO, toAddress);
	        
	        if (!BCC.equals("")){
	        	message.setRecipients(Message.RecipientType.BCC, BCC);
	        }
	        if (!CC.equals("")){
	        	message.setRecipients(Message.RecipientType.CC, CC);
	        }
	        if (!CONFIG.getProperty("mail_Subject").equals("")){
	        	message.setSubject(CONFIG.getProperty("mail_Subject"));
	        }

	        BodyPart messageBodyPart = new MimeBodyPart();

	        messageBodyPart.setText(message1.toString());

	        Multipart multipart = new MimeMultipart();

	        multipart.addBodyPart(messageBodyPart);

	        messageBodyPart = new MimeBodyPart();

	        DataSource source = new FileDataSource(filename);

	        messageBodyPart.setDataHandler(new DataHandler(source));

	        messageBodyPart.setFileName("Test Summary"+reporttime);

	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        try {
	            Transport tr = session.getTransport("smtps");
	            tr.connect(host, from, password);
	            tr.sendMessage(message, message.getAllRecipients());
	            System.out.println("Mail Sent Successfully");
	            tr.close();

	        } catch (SendFailedException sfe) {

	            System.out.println(sfe);
	        }
	}
	
	public void dCellAction() throws Exception
	{

		if(!(cCellObjType.equalsIgnoreCase("page") 
				||cCellObjType.equalsIgnoreCase("page;")
				||cCellObjType.equalsIgnoreCase("dialog") 
				||cCellObjType.equalsIgnoreCase("dialog;")
				||cCellObjType.equalsIgnoreCase("downloaddialog")
				||cCellObjType.equalsIgnoreCase("downloaddialog;")
				||cCellObjType.equalsIgnoreCase("uploaddialog") || cCellObjType
					.equalsIgnoreCase("uploaddialog;")))//))//Updated on 16.12.2013 for page and dialog support	
		{
			try
			{
			    String[] cCellDataValCh = cCellData.split(";");
				String objectType = cCellDataValCh[0];
				
				readAttributeforPerform();
				Func_FindObj(ORvalname, ORvalue);
				if (elem == null) 
				{
					return;
				}
				else
				{
					switch (ObjectSet.toLowerCase())
					{

					case "set":
						    System.out.println("elem "+elem);
							elem.clear();
							StringBuffer inputvalue = new StringBuffer();
							inputvalue.append(ObjectSetVal);
							((RemoteWebDriver) D8).executeScript(
								"arguments[0].value=arguments[0].value + '"
										+ inputvalue.toString() + "';", elem);
							Update_Report("executed",ObjectSet,ObjectSetVal);
							if (captureperform == true)
							{
								screenshot(loopnum, TScrowcount, TScname);
							}
							break;
					case "input":						
						//Func_FindObj(ORvalname, ORvalue);
						System.out.println("input "+ObjectSetVal);
						elem.clear();
						elem.sendKeys(ObjectSetVal);
						Update_Report("executed");
						if (captureperform == true) {
							screenshot(loopnum, TScrowcount, TScname);
						}
						break;	
						
					case "uploadfile":
						
						System.out.println("FilePath"+cCellObjName+ObjectSetVal);
						String Filepath = cCellObjName+ObjectSetVal;
/*						String[] File = cCellData.split(";");
						String FilePath = File[0].toString();
						String WinName = File[1].toString();
						Thread.sleep(2000);	*/	
						new ProcessBuilder(CONFIG.getProperty("AutoitFileUpldexe"),
								Filepath, cCellObjType).start();		
						
						break;
						
					case "listselect":
							int foundCount=0;
							System.out.println(ObjectSetVal);
							String[] listvalues = ObjectSetVal.split(":");			
							List<WebElement> listboxitems = elem.findElements(By
								.tagName("option"));
							Select chooseoptn = new Select(elem);
							chooseoptn.deselectAll();
							//System.out.println(listvalues.length);
							//System.out.println(listvalues.length);
							for (WebElement opt : listboxitems)
							{ 
								for (int i = 0; i < listvalues.length; i++) 
								{
									if (opt.getText().equalsIgnoreCase(listvalues[i])) 
									{
										chooseoptn.selectByVisibleText(opt.getText());
										foundCount=foundCount+1;
									}

								}
							}
							if(foundCount==0 &&ObjectSetVal.contains(""))
							
							{
								Update_Report("NoBlankAvailable");	
							}
							else
							{
								Update_Report("executed",ObjectSet,ObjectSetVal);
							}
							
							if (captureperform == true) 
							{
								screenshot(loopnum, TScrowcount, TScname);
							}

						break;

					case "select":
						if(ObjectSetVal!="")
						{
							new Select(elem).selectByVisibleText(ObjectSetVal);
							Update_Report("executed",ObjectSet,ObjectSetVal);
						}

						else
						{
							if (new Select(elem).getOptions().toString().contains("")==true)
							{
								try
								{
									new Select(elem).selectByVisibleText("");
									Update_Report("executed",ObjectSet,ObjectSetVal);
								}
								catch(Exception e)
								{
									Update_Report("NoBlankAvailable");
								}
							}
							else
							{
								Update_Report("NoBlankAvailable");
							}
						}
						//Updated on 16.12.2013 for Report with actual values
						if (captureperform == true) 
						{
							screenshot(loopnum, TScrowcount, TScname);
						}

						break;

					case "check":
						if (elem.isSelected() && dCellDataVal[1].equalsIgnoreCase("on")) // Rahim
						{

						} 
						else if (elem.isSelected()
								|| dCellDataVal[1].equalsIgnoreCase("On"))
						{
							elem.click();
						}

						Update_Report("executed");  //----Rahim ---
						//Update_Report("executed",ObjectSet,ObjectSetVal);
						if (captureperform == true) {
							screenshot(loopnum, TScrowcount, TScname);
						}
						break;
						
					case "checked":					
						if (ObjectSetVal.equalsIgnoreCase("on")) // Rahim
						{
							elem.click();
						} 
						Update_Report("executed",ObjectSet,ObjectSetVal);
						if (captureperform == true) {
							screenshot(loopnum, TScrowcount, TScname);
						}
						break;

					case "click":

						elem.click();
						Update_Report("executed");
						if (captureperform == true)
						{
							screenshot(loopnum, TScrowcount, TScname);
						}
						break;
						
					case "clicked":
						
						if (ObjectSetVal.equalsIgnoreCase("Y")) // Rahim
						{
							elem.click();
						} 
						Update_Report("executed",ObjectSet,ObjectSetVal);
						if (captureperform == true) {
							screenshot(loopnum, TScrowcount, TScname);
						}
						break;
						
					case "hover":
						JavascriptExecutor js = (JavascriptExecutor) D8;
						String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
						js.executeScript(mouseOverScript, elem);
						Update_Report("executed");
						break;

					case "altclick":
						JavascriptExecutor executor = (JavascriptExecutor) D8;
						executor.executeScript("arguments[0].click();", elem);
						Update_Report("executed");
						break;
					case "enter":
						elem.sendKeys(org.openqa.selenium.Keys.ENTER);
						Update_Report("executed");
						if (captureperform == true) {
							screenshot(loopnum, TScrowcount, TScname);
						}
						break;				
					case "setdate":
						Robot robot1 = new Robot();
						ScreenshotTypeFlag = 1;
						String calstring = cCellObjName.toLowerCase();
						if (cCellObjType.equalsIgnoreCase("calendar")
								&& calstring.startsWith("cal_")) {
							try {
								String[] datearray = ObjectSetVal.split("-");
								mm = datearray[0];
								dd = datearray[1];
								yyyy = datearray[2];
								if (Integer.parseInt(mm) > 12
										|| Integer.parseInt(mm) < 1
										|| Integer.parseInt(yyyy) < 1000
										|| Integer.parseInt(yyyy) > 2999
										|| Integer.parseInt(yyyy) < 1700
										|| ((Integer.parseInt(dd) > 30) && (Integer
												.parseInt(dd) == 2
												|| Integer.parseInt(dd) == 4
												|| Integer.parseInt(dd) == 6
												|| Integer.parseInt(dd) == 9 || Integer
												.parseInt(dd) == 11))
										|| (Integer.parseInt(dd) > 28
												&& Integer.parseInt(mm) == 2 && (Integer
												.parseInt(yyyy) % 4 != 0))) {
									Update_Report("invaliddate1");
								} else {
									selectDate(mm, dd, yyyy);
								}

							} catch (Exception e) {
								Update_Report("invaliddate1");
								robot1.keyPress(KeyEvent.VK_ESCAPE);
								robot1.keyRelease(KeyEvent.VK_ESCAPE);
							}
						} else {
							Update_Report("calendaraction");
						}
						break;	
						
						

					}
				}				
			}
			catch (Exception e) 
			{
				System.out.println(e.toString() );
				Update_Report("failed", e);
				strcaptureerrormessage = "Error:"+e.getMessage();
				func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);;
			}
			}
			else 
			{
				try
				{
				switch (ObjectSet.toLowerCase())
				{
/*					For Future Implementation: For some buttons, it is found that elem.click is not working. In such a case sendKeys may be helpful
				    case "enter":
					Func_FindObj(ORvalname, ORvalue);
					elem.sendKeys(org.openqa.selenium.Keys.ENTER);
					System.out.println("clicked!");
					Update_Report("executed");

					if (captureperform == true) 
					{
						screenshot(loopnum, TScrowcount, TScname);
					}
				break;				
*/
				case "ok"://Updated on 16.12.2013 for dialog support

					if(cCellObjType.equalsIgnoreCase("dialog")||cCellObjType.equalsIgnoreCase("dialog;"))
					{
						dialogSwitch=D8.switchTo().alert();
						dialogSwitch.accept();
						Update_Report("executed");
					}
					if (captureperform == true)
					{
						screenshot(loopnum, TScrowcount, TScname);
					}
					
					break;	
				case "cancel"://Updated on 16.12.2013 for dialog support
										
					if(cCellObjType.equalsIgnoreCase("dialog")||cCellObjType.equalsIgnoreCase("dialog;"))
					{
						dialogSwitch=D8.switchTo().alert();
						dialogSwitch.dismiss();
						Update_Report("executed");
					}

					if (captureperform == true)
					{
						screenshot(loopnum, TScrowcount, TScname);
					}	
					break;
					
				case "close"://Updated on 16.12.2013 for dialog and page support
					
					
						if(cCellObjType.equalsIgnoreCase("dialog")||cCellObjType.equalsIgnoreCase("dialog;"))
						{
							
							dialogSwitch=D8.switchTo().alert();
							dialogSwitch.dismiss();
							Update_Report("executed");
							if (captureperform == true)
							{
								screenshot(loopnum, TScrowcount, TScname);
							}	
							
						}
							
						else
						{
							windowFound=0;
							int windowNums=0;
							int windowItr=0;
							String currentWindowHandle = D8.getWindowHandle();
							WebDriver newWindow = null;
							Set<String> al = new HashSet<String>();
							al = D8.getWindowHandles();
							windowNums=al.size();
							Iterator<String> windowIterator = al.iterator();
							//System.out.println(cCellObjName);
							if(cCellObjName.equalsIgnoreCase("page;")||cCellObjName.equalsIgnoreCase("page"))
							{
								if(windowNums==1)
								{
									if (captureperform == true)
									{
											screenshot(loopnum, TScrowcount, TScname);
									}
									D8.close();
									Update_Report("executed");
									windowFound=1;
								}
								else						
								{
									//D8.close();
									int winItr1=0;
									String windowHandle=null;
									String tempWindowHandle=null;
									while(winItr1!=windowNums)
									{
										tempWindowHandle=windowHandle;
										windowHandle = windowIterator.next();
										System.out.println(tempWindowHandle);
										System.out.println(windowHandle);
										newWindow = D8.switchTo().window(windowHandle);
										if(currentWindowHandle.equalsIgnoreCase(windowHandle))
										{
											if(winItr1==0)
											{
												if (captureperform == true)
												{
														screenshot(loopnum, TScrowcount, TScname);
												}
												D8.close();
												windowHandle = windowIterator.next();
												D8.switchTo().window(windowHandle);
												Update_Report("executed");
												windowFound=1;
												break;
											}
											else
											{
												if (captureperform == true)
												{
														screenshot(loopnum, TScrowcount, TScname);
												}
												D8.close();
												D8.switchTo().window(tempWindowHandle);
												Update_Report("executed");
												windowFound=1;
												break;
	
											}
										}
										
											winItr1++;
									}
								}
							}
							else
							{
								if(windowNums==1)
								{
									if(D8.getTitle().toString().equalsIgnoreCase(ObjectSetVal)== true )
									{
										if (captureperform == true)
										{
												screenshot(loopnum, TScrowcount, TScname);
										}
										D8.close();
										Update_Report("executed");
										windowFound=1;
									}

								}
								else
								{
									if(cCellObjType.equalsIgnoreCase("page") && D8.getTitle().equalsIgnoreCase(cCellObjName)== false)
									{
										for(windowItr=0;windowItr<windowNums;windowItr++)
										{
											windowHandle = windowIterator.next();
											newWindow = D8.switchTo().window(windowHandle);
											if (newWindow.getTitle().equalsIgnoreCase(cCellObjName))
											{
												if (captureperform == true)
												{
														screenshot(loopnum, TScrowcount, TScname);
												}
												newWindow.close();
												Update_Report("executed");
												//D8.close();
												D8.switchTo().window(currentWindowHandle);
												System.out.println(D8.getTitle().toString());
												windowFound=1;
												break;
											}	
								
										}

									}
									else 
									{
										if(cCellObjType.equalsIgnoreCase("page") && D8.getTitle().toString().equalsIgnoreCase(cCellObjName)== true)
										{
											//D8.close();
											int winItr1=0;
											String windowHandle=null;
											String tempWindowHandle=null;
											while(winItr1!=windowNums)
											{
												tempWindowHandle=windowHandle;
												windowHandle = windowIterator.next();
												System.out.println(tempWindowHandle);
												System.out.println(windowHandle);
												newWindow = D8.switchTo().window(windowHandle);
												if(currentWindowHandle.equalsIgnoreCase(windowHandle))
												{
													if(winItr1==0)
													{
														if (captureperform == true)
														{
																screenshot(loopnum, TScrowcount, TScname);
														}	
														D8.close();
														windowHandle = windowIterator.next();
														D8.switchTo().window(windowHandle);
														Update_Report("executed");
														windowFound=1;
														break;
													}
													else
													{
														D8.close();
														D8.switchTo().window(tempWindowHandle);
														Update_Report("executed");
														windowFound=1;
														break;
			
													}
												}
												
													winItr1++;
											}	
										}
									}
								}
							}
							if(windowFound!=1)
							{
								Update_Report("NoWindowFound");
							}
						}
						break;
				}
			}			
/*							else 
							{
								newWindow=D8;
								newWindow.close();
								if(windowIterator.hasNext())
								{
									windowHandle = windowIterator.next();
									D8.switchTo().window(windowHandle);
								}
							}*/
						//	}
					//	}
				//	}
			//}
				catch (NoAlertPresentException e)
				{
					
				}
			}	
	}
	
public static void selectprevious_date() {
		
        Calendar getdate = Calendar.getInstance();
        String dayPattern = "dd";
        SimpleDateFormat formatter = new SimpleDateFormat(dayPattern);
        String dayBefore = formatter.format(getdate.getTime());
        System.out.println("Privious date : " + dayBefore);
        getdate.add(Calendar.DAY_OF_MONTH, -1);
        String prevDay = formatter.format(getdate.getTime());
        //System.out.println("Date after minus one day : " + dateAfter); 
        //str_fldrName = prevDay.toLowerCase();
        System.out.println("Previous Day : "+prevDay);
	
/*        DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
        Date date2 = new Date();
        String today = dateFormat2.format(date2);
        String prevday = today-"1";
        find the calendar*/
        
        WebElement dateWidget = D8.findElement(By.className("datepicker_table"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));          
        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns)
        {
           if (cell.getText().equals(prevDay))
           {
              cell.click();
              break;
           }
        }	
	}
		
	private static void selectJQueryDate(String date) throws InterruptedException {   
			D8.switchTo().defaultContent();
			D8.switchTo().frame("centerFrame");
			D8.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
			D8.switchTo().frame("mainFrame");
			D8.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
			WebDriverWait wait = new WebDriverWait(D8, 10);
	  	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("datepicker_table"))); //datepicker_calendar
	  		WebElement table = D8.findElement(By.className("datepicker_table")); 
	  		System.out.println("JQuery Calendar Dates");
	  		
	  		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
	  				for (WebElement row : tableRows) {
	  			List<WebElement> cells = row.findElements(By.xpath("td"));
	  			
	  			for (WebElement cell : cells) {
	  				if (cell.getText().equals(date)) {
	  					D8.findElement(By.linkText(date)).click();
	  					Thread.sleep(1000);
	  				}
	  			}
	  		}
	  	}
	
	private void doUploadDownload(String action1) throws Exception {
		// Robot robot = new Robot();
		if (BrowserName.equalsIgnoreCase("ff")) {
			switch (action1) {
			case "upload":
				try {

					Thread.sleep(2000);
					Runtime.getRuntime().exec(
							execpath + " 2 upload " + cCellData + " "
									+ BrowserName.toLowerCase());
					Update_Report("executed");
				} catch (IOException e) {

					// TODO Auto-generated catch block
					System.out.println(e);

				}
				break;

			case "closeupload":
				try {

					Runtime.getRuntime().exec(
							execpath + " 2 closeupload " + cCellData + " "
									+ BrowserName.toLowerCase());
					Update_Report("executed");

				} catch (IOException e) {

					// TODO Auto-generated catch block
					System.out.println(e);

				}
				break;
			case "abortupload":
				try {

					Runtime.getRuntime().exec(
							execpath + " 2 closeupload " + "abort" + " "
									+ BrowserName.toLowerCase());

				} catch (IOException e) {

					// TODO Auto-generated catch block
					System.out.println(e);

				}
				break;

			case "cancelupload":
				try {

					Runtime.getRuntime().exec(
							execpath + " 2 cancelupload " + cCellData + " "
									+ BrowserName.toLowerCase());
					Update_Report("executed");
				} catch (IOException e) {

					// TODO Auto-generated catch block
					System.out.println(e);

				}
				break;

			case "download":
				try {

					Runtime.getRuntime().exec(
							execpath + " 2 download " + ObjectSet + " "
									+ BrowserName.toLowerCase() + " "
									+ elem.getAttribute("href"));
					Thread.sleep(4000);
					Update_Report("executed");
				} catch (IOException e) {

					e.printStackTrace();

				}
				break;

			default:
				System.out.println("Action not supported");
				break;
			}
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			switch (action1) {
			case "upload":
				if (Integer.parseInt(browserver) != 8) {
					try {

						Runtime.getRuntime().exec(
								execpath + " 2 upload " + cCellData + " "
										+ BrowserName.toLowerCase());
						Update_Report("executed");
					} catch (IOException e) {

						// TODO Auto-generated catch block
						System.out.println(e);

					}
					
				} else {
					elem.sendKeys(cCellData);
				}
				break;
				
			case "closeupload":
				try {

					Runtime.getRuntime().exec(
							execpath + " 2 closeupload " + cCellData + " "
									+ BrowserName.toLowerCase());
					Update_Report("executed");

				} catch (IOException e) {

					// TODO Auto-generated catch block
					System.out.println(e);

				}
				break;

			case "cancelupload":
				try {

					Runtime.getRuntime().exec(
							execpath + " 2 cancelupload " + cCellData + " "
									+ BrowserName.toLowerCase());
					Update_Report("executed");
				} catch (IOException e) {

					// TODO Auto-generated catch block
					System.out.println(e);

				}
				break;

			case "download":

				try {
					Runtime.getRuntime().exec(
							execpath + " 2 download " + ObjectSet + " "
									+ BrowserName.toLowerCase() + " "
									+ elem.getAttribute("href"));
					Update_Report("executed");
				} catch (IOException e) {

					e.printStackTrace();

				}
				break;

			}

		}

		if (captureperform == true) {
			screenshot(loopnum, TScrowcount, TScname);
		}
		// TODO Auto-generated method stub

	}

	
	public void selectDate(String mm2, String dd2, String yyyy2)
			throws Exception {
		String dateClass = null;
		int objectfound = 0;
		int monthnum1 = 0;
		String usedTitleMonth = null;
		String usedTitleYear = null;
		String usedTitletag = null;
		WebElement prevMonth = null;
		WebElement nextMonth = null;
		WebElement titleYear = null;
		WebElement daytoClick = null;
		int titleYearnum = 0;
		String titleMonthString = "";
		WebElement titleMonth = null;
		String datePickerType = "";
		String locatorNext = "";
		String locatorPrev = "";
		String outerHTMLCalendar = "";
		outerHTMLCalendar = elem.getAttribute("outerHTML");
		elem.click();
		int setmm = Integer.parseInt(mm2);
		int setyyyy = Integer.parseInt(yyyy2);
		int setdd = Integer.parseInt(dd2);
		WebElement titleDefault = null;
		String titleDefaultText;
		// List<WebElement> titlebootYearTags;
		List<WebElement> realCategoryDeciders = new ArrayList<WebElement>();
		// int titlebootYearNum;
		Robot robot1 = new Robot();
		int isDateNotSelected = 0;
		int isDateSelected = 0;

		if (outerHTMLCalendar.toLowerCase().contains("datepicker")) {
			datePickerType = "jquery";
		} else if (outerHTMLCalendar.toLowerCase().contains("type=")
				&& outerHTMLCalendar.toLowerCase().contains("date")) {
			datePickerType = "html5";
		} else {
			datePickerType = "boot";
		}

		switch (setmm) {

		case 1:
			monthpart = "Jan";
			monthpartjap = "1月";
			break;
		case 2:
			monthpart = "Feb";
			monthpartjap = "2月";
			break;
		case 3:
			monthpart = "Mar";
			monthpartjap = "3月";
			break;
		case 4:
			monthpart = "Apr";
			monthpartjap = "4月";
			break;
		case 5:
			monthpart = "May";
			monthpartjap = "5月";
			break;
		case 6:
			monthpart = "Jun";
			monthpartjap = "6月";
			break;
		case 7:
			monthpart = "Jul";
			monthpartjap = "7月";
			break;
		case 8:
			monthpart = "Aug";
			monthpartjap = "8月";
			break;
		case 9:
			monthpart = "Sep";
			monthpartjap = "9月";
			break;
		case 10:
			monthpart = "Oct";
			monthpartjap = "10月";
			break;
		case 11:
			monthpart = "Nov";
			monthpartjap = "11月";
			break;
		case 12:
			monthpart = "Dec";
			monthpartjap = "12月";
			break;
		default:
			Update_Report("invalidmonth");
			break;
		}
		int titleLength;
		switch (datePickerType) {

		case "jquery":
			if (!(lastSelecteddateJQ == setdd && lastSelectedmonthJQ == setmm && lastSelectedyearJQ == setyyyy)) {
				for (String strPrevMonth : setObj.envprevMonth1) {
					try {
						prevMonth = D8
								.findElementByXPath("//a[contains(@class,'"
										+ strPrevMonth + "')]");
						locatorPrev = prevMonth.getAttribute("class")
								.toString();
						objectfound = 1;
						break;
					} catch (Exception e) {
						continue;
					}
				}
				if (objectfound == 0) {
					Update_Report("prevmonth");
					break;
				} else {
					objectfound = 0;
				}
				for (String strNextMonth : setObj.envnextMonth1) {
					try {
						nextMonth = D8
								.findElementByXPath("//a[contains(@class,'"
										+ strNextMonth + "')]");
						locatorNext = nextMonth.getAttribute("class")
								.toString();
						objectfound = 1;
						break;
					} catch (Exception e) {
						continue;
					}
				}
				if (objectfound == 0) {
					Update_Report("nextmonth");
					break;
				} else {
					objectfound = 0;
				}
				for (String strtitleMonth : setObj.envtitleMonth) {
					try {
						titleMonth = D8
								.findElementByXPath("//span[contains(@class,'"
										+ strtitleMonth + "')]");
						titleMonthString = titleMonth.getText();
						usedTitleMonth = strtitleMonth;
						usedTitletag = "span";
						objectfound = 1;
						break;
					} catch (Exception e) {
						try {
							titleMonth = D8
									.findElementByXPath("//select[contains(@class,'"
											+ strtitleMonth + "')]");
							titleMonthString = new Select(titleMonth)
									.getFirstSelectedOption().getText()
									.toString();
							usedTitleMonth = strtitleMonth;
							usedTitletag = "select";
							objectfound = 1;
							break;
						} catch (Exception e4) {

						}
						continue;
					}

				}
				if (objectfound == 0) {
					Update_Report("titlemonth");
					break;
				} else {
					objectfound = 0;
				}
				for (String strtitleYear : setObj.envtitleYear) {
					try {
						titleYear = D8
								.findElementByXPath("//span[contains(@class,'"
										+ strtitleYear + "')]");
						titleYearnum = Integer.parseInt(titleYear.getText());
						usedTitleYear = strtitleYear;
						usedTitletag = "span";
						objectfound = 1;
						break;
					} catch (Exception e) {
						try {
							titleYear = D8
									.findElementByXPath("//select[contains(@class,'"
											+ strtitleYear + "')]");
							titleYearnum = Integer.parseInt(new Select(
									titleYear).getFirstSelectedOption()
									.getText());
							usedTitleYear = strtitleYear;
							usedTitletag = "select";
							objectfound = 1;

							break;
						} catch (Exception e5) {

						}
						continue;
					}
				}
				if (objectfound == 0) {
					Update_Report("titleyear");
					break;
				} else {
					objectfound = 0;
				}
				switch (titleMonthString.toLowerCase()) {

				case "jan":
					monthnum1 = 1;
					break;
				case "1月":
					monthnum1 = 1;
					break;
				case "january":
					monthnum1 = 1;
					break;
				case "feb":
					monthnum1 = 2;
					break;
				case "2月":
					monthnum1 = 2;
					break;
				case "february":
					monthnum1 = 2;
					break;
				case "mar":
					monthnum1 = 3;
					break;
				case "3月":
					monthnum1 = 3;
					break;
				case "march":
					monthnum1 = 3;
					break;
				case "apr":
					monthnum1 = 4;
					break;
				case "4月":
					monthnum1 = 4;
					break;
				case "april":
					monthnum1 = 4;
					break;
				case "may":
					monthnum1 = 5;
					break;
				case "5月":
					monthnum1 = 5;
					break;
				case "june":
					monthnum1 = 6;
					break;
				case "jun":
					monthnum1 = 6;
					break;
				case "6月":
					monthnum1 = 6;
					break;
				case "july":
					monthnum1 = 7;
					break;
				case "jul":
					monthnum1 = 7;
					break;
				case "7月":
					monthnum1 = 7;
					break;
				case "aug":
					monthnum1 = 8;
					break;
				case "august":
					monthnum1 = 8;
					break;
				case "8月":
					monthnum1 = 8;
					break;
				case "sep":
					monthnum1 = 9;
					break;
				case "september":
					monthnum1 = 9;
					break;
				case "9月":
					monthnum1 = 9;
					break;
				case "oct":
					monthnum1 = 10;
					break;
				case "october":
					monthnum1 = 10;
					break;
				case "10月":
					monthnum1 = 10;
					break;
				case "nov":
					monthnum1 = 11;
					break;
				case "november":
					monthnum1 = 11;
					break;
				case "11月":
					monthnum1 = 11;
					break;
				case "dec":
					monthnum1 = 12;
					break;
				case "december":
					monthnum1 = 12;
					break;
				case "12月":
					monthnum1 = 12;
					break;
				default:
					Update_Report("monthnotidentified");
					break;
				}

				if (setyyyy > titleYearnum && setmm > monthnum1) {
					try {
						do {
							nextMonth.click();
							monthnum1++;
							if (monthnum1 == 13)
								monthnum1 = 1;
							nextMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorNext + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}

						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				} else if (setyyyy < titleYearnum && setmm < monthnum1) {

					try {
						do {
							prevMonth.click();
							monthnum1--;
							if (monthnum1 == 0)
								monthnum1 = 12;
							prevMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorPrev + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}
						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				}

				else if (setyyyy == titleYearnum && setmm < monthnum1) {
					try {
						do {
							prevMonth.click();
							monthnum1--;
							if (monthnum1 == 0)
								monthnum1 = 12;
							prevMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorPrev + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}
						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				} else if (setyyyy == titleYearnum && setmm > monthnum1) {
					try {
						do {
							nextMonth.click();
							monthnum1++;
							if (monthnum1 == 13)
								monthnum1 = 1;
							nextMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorNext + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}
						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				}

				else if (setyyyy > titleYearnum && setmm == monthnum1) {
					try {
						do {
							nextMonth.click();
							monthnum1++;
							if (monthnum1 == 13)
								monthnum1 = 1;
							nextMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorNext + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}
						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				} else if (setyyyy < titleYearnum && setmm == monthnum1) {
					try {
						do {
							prevMonth.click();
							monthnum1--;
							if (monthnum1 == 0)
								monthnum1 = 12;
							prevMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorPrev + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}

						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				} else if (setyyyy > titleYearnum && setmm < monthnum1) {
					try {
						do {
							nextMonth.click();
							monthnum1++;
							if (monthnum1 == 13)
								monthnum1 = 1;
							nextMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorNext + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}
						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				} else if (setyyyy < titleYearnum && setmm > monthnum1) {
					try {
						do {
							prevMonth.click();
							monthnum1--;
							if (monthnum1 == 0)
								monthnum1 = 12;
							prevMonth = D8
									.findElementByXPath("//a[contains(@class,'"
											+ locatorPrev + "')]");
							titleMonth = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleMonth + "')]");
							titleYear = D8.findElementByXPath("//"
									+ usedTitletag + "[contains(@class,'"
									+ usedTitleYear + "')]");
							if (usedTitletag == "span") {
								titleMonthString = titleMonth.getText();
								titleYearnum = Integer.parseInt(titleYear
										.getText());
							} else if (usedTitletag == "select") {

								titleMonthString = new Select(titleMonth)
										.getFirstSelectedOption().getText()
										.toString();
								titleYearnum = Integer.parseInt(new Select(
										titleYear).getFirstSelectedOption()
										.getText());
							}
						} while (!((titleMonthString.toLowerCase().contains(
								monthpart.toLowerCase()) || titleMonthString
								.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
					} catch (Exception e) {
						isDateNotSelected = 1;
					}
				}
				if (isDateNotSelected == 0) {
					if (setyyyy == titleYearnum && setmm == monthnum1) {

						try {

							List<WebElement> daystoClick = D8
									.findElementsByXPath("//a[contains(@class,'"
											+ locatorPrev
											+ "')]"
											+ "/following::a[contains(text(),'"
											+ setdd + "')]");

							List<WebElement> categoryDeciders = D8
									.findElementsByXPath("//a[contains(@class,'"
											+ locatorPrev
											+ "')]"
											+ "/following::a[contains(text(),'"
											+ 15 + "')]");

							for (WebElement categoryDecider : categoryDeciders) {
								if (categoryDecider.getAttribute("href")
										.endsWith("#")
										&& categoryDecider.getText().equals(
												"15")) {
									realCategoryDeciders.add(categoryDecider);
									dateClass = categoryDecider
											.getAttribute("class");

								}
							}

							for (int i2 = 0; i2 < daystoClick.size(); i2++) {
								// Date date = new Date();
								if (today == setdd
										&& Integer.parseInt(daystoClick.get(i2)
												.getText()) == setdd
										&& daystoClick.get(i2)
												.getAttribute("href")
												.endsWith("#")) {

									daytoClick = daystoClick.get(i2);
									daytoClick.click();
									lastSelecteddateJQ = setdd;
									lastSelectedmonthJQ = setmm;
									lastSelectedyearJQ = setyyyy;
									isDateSelected = 1;
									Update_Report("executed", ObjectSet,
											ObjectSetVal);
									break;
								} else if (Integer.parseInt(daystoClick.get(i2)
										.getText()) == setdd
										&& (daystoClick.get(i2)
												.getAttribute("class")
												.equalsIgnoreCase(dateClass) || (daystoClick
												.get(i2).getAttribute("class")
												.equalsIgnoreCase(selectedDateClass))
												&& daystoClick.get(i2)
														.getAttribute("href")
														.endsWith("#"))) {
									daytoClick = daystoClick.get(i2);
									daytoClick.click();
									lastSelecteddateJQ = setdd;
									lastSelectedmonthJQ = setmm;
									lastSelectedyearJQ = setyyyy;
									isDateSelected = 1;
									selectedDateClass = daytoClick
											.getAttribute("class");
									Update_Report("executed", ObjectSet,
											ObjectSetVal);
									break;
								}
							}

						} catch (Exception e1) {
							isDateNotSelected = 1;

						}

					}
					// }
					if (captureperform == true) {
						screenshot(loopnum, TScrowcount, TScname);
					}
					if (isDateSelected == 0) {

						Update_Report("invaliddate");
						robot1.keyPress(KeyEvent.VK_ESCAPE);
						robot1.keyRelease(KeyEvent.VK_ESCAPE);
					} else {
						isDateSelected = 0;
					}

				} else {
					isDateNotSelected = 0;
					Update_Report("invaliddate");
					robot1.keyPress(KeyEvent.VK_ESCAPE);
					robot1.keyRelease(KeyEvent.VK_ESCAPE);
				}
			} else {
				Update_Report("executed", ObjectSet, ObjectSetVal);
				robot1.keyPress(KeyEvent.VK_ESCAPE);
				robot1.keyRelease(KeyEvent.VK_ESCAPE);
				if (captureperform == true) {
					screenshot(loopnum, TScrowcount, TScname);
				}
			}

			break;

		case "boot":

			for (String strPrevMonth : setObj.envprevMonth1) {
				try {
					prevMonth = D8.findElementByXPath("//th[contains(@class,'"
							+ strPrevMonth + "')]");
					locatorPrev = strPrevMonth;
					objectfound = 1;
					break;
				} catch (Exception e) {
					continue;
				}
			}
			if (objectfound == 0) {
				Update_Report("prevmonth");
				break;
			} else {
				objectfound = 0;
			}

			for (String strNextMonth : setObj.envnextMonth1) {
				try {
					nextMonth = D8.findElementByXPath("//th[contains(@class,'"
							+ strNextMonth + "')]");
					locatorNext = strNextMonth;
					objectfound = 1;
					break;
				} catch (Exception e) {
					continue;
				}
			}
			if (objectfound == 0) {
				Update_Report("nextmonth");
				break;
			} else {
				objectfound = 0;
			}

			try {
				titleDefault = D8.findElementByXPath("//th[contains(@class,'"
						+ "switch" + "')]");

			}

			catch (Exception e) {
				Update_Report("titledefault");
				break;
			}
			titleDefaultText = titleDefault.getText().trim();
			titleLength = titleDefaultText.length();
			titleYearnum = Integer.parseInt(titleDefaultText
					.substring(titleLength - 4));
			titleMonthString = titleDefaultText.substring(0, titleLength - 5)
					.trim();
			switch (titleMonthString.toLowerCase()) {

			case "jan":
				monthnum1 = 1;
				break;
			case "1月":
				monthnum1 = 1;
				break;
			case "january":
				monthnum1 = 1;
				break;
			case "feb":
				monthnum1 = 2;
				break;
			case "2月":
				monthnum1 = 2;
				break;
			case "february":
				monthnum1 = 2;
				break;
			case "mar":
				monthnum1 = 3;
				break;
			case "3月":
				monthnum1 = 3;
				break;
			case "march":
				monthnum1 = 3;
				break;
			case "apr":
				monthnum1 = 4;
				break;
			case "4月":
				monthnum1 = 4;
				break;
			case "april":
				monthnum1 = 4;
				break;
			case "may":
				monthnum1 = 5;
				break;
			case "5月":
				monthnum1 = 5;
				break;
			case "june":
				monthnum1 = 6;
				break;
			case "jun":
				monthnum1 = 6;
				break;
			case "6月":
				monthnum1 = 6;
				break;
			case "july":
				monthnum1 = 7;
				break;
			case "jul":
				monthnum1 = 7;
				break;
			case "7月":
				monthnum1 = 7;
				break;
			case "aug":
				monthnum1 = 8;
				break;
			case "august":
				monthnum1 = 8;
				break;
			case "8月":
				monthnum1 = 8;
				break;
			case "sep":
				monthnum1 = 9;
				break;
			case "september":
				monthnum1 = 9;
				break;
			case "9月":
				monthnum1 = 9;
				break;
			case "oct":
				monthnum1 = 10;
				break;
			case "october":
				monthnum1 = 10;
				break;
			case "10月":
				monthnum1 = 10;
				break;
			case "nov":
				monthnum1 = 11;
				break;
			case "november":
				monthnum1 = 11;
				break;
			case "11月":
				monthnum1 = 11;
				break;
			case "dec":
				monthnum1 = 12;
				break;
			case "december":
				monthnum1 = 12;
				break;
			case "12月":
				monthnum1 = 12;
				break;
			default:
				Update_Report("monthnotidentified");
				break;
			}
			try {
				nextMonth = D8.findElementByXPath("//th[contains(@class,'"
						+ locatorNext + "')]");
			} catch (Exception e) {
				Update_Report("nextmonth");
				break;
			}
			try {
				prevMonth = D8.findElementByXPath("//th[contains(@class,'"
						+ locatorPrev + "')]");
			} catch (Exception e) {
				Update_Report("prevmonth");
				break;
			}
			if (setyyyy > titleYearnum && setmm > monthnum1) {
				try {
					do {

						nextMonth.click();
						monthnum1++;
						if (monthnum1 == 13)
							monthnum1 = 1;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();

					}

					while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			} else if (setyyyy < titleYearnum && setmm < monthnum1) {
				try {
					do {

						prevMonth.click();
						monthnum1--;
						if (monthnum1 == 0)
							monthnum1 = 12;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();
					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			}

			else if (setyyyy == titleYearnum && setmm < monthnum1) {
				try {
					do {
						prevMonth.click();
						monthnum1--;
						if (monthnum1 == 0)
							monthnum1 = 12;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();
					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			} else if (setyyyy == titleYearnum && setmm > monthnum1) {
				try {
					do {
						nextMonth.click();
						monthnum1++;
						if (monthnum1 == 13)
							monthnum1 = 1;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();
					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}

			}

			else if (setyyyy > titleYearnum && setmm == monthnum1) {
				try {
					do {
						nextMonth.click();
						monthnum1++;
						if (monthnum1 == 13)
							monthnum1 = 1;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();
					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			} else if (setyyyy < titleYearnum && setmm == monthnum1) {
				try {
					do {
						prevMonth.click();
						monthnum1--;
						if (monthnum1 == 0)
							monthnum1 = 12;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();

					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			} else if (setyyyy > titleYearnum && setmm < monthnum1) {
				try {
					do {
						nextMonth.click();
						monthnum1++;
						if (monthnum1 == 13)
							monthnum1 = 1;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();
					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			} else if (setyyyy < titleYearnum && setmm > monthnum1) {
				try {
					do {
						prevMonth.click();
						monthnum1--;
						if (monthnum1 == 0)
							monthnum1 = 12;
						titleDefault = D8
								.findElementByXPath("//th[contains(@class,'"
										+ "switch" + "')]");
						titleDefaultText = titleDefault.getText().trim();
						titleLength = titleDefaultText.length();
						titleYearnum = Integer.parseInt(titleDefaultText
								.substring(titleLength - 4));
						titleMonthString = titleDefaultText.substring(0,
								titleLength - 5).trim();
					} while (!((titleMonthString.toLowerCase().contains(
							monthpart.toLowerCase()) || titleMonthString
							.toLowerCase().contains(monthpartjap)) && (setyyyy == titleYearnum)));
				} catch (Exception e) {
					Update_Report("invaliddate");
					break;
				}
			}
			if (setyyyy == titleYearnum && setmm == monthnum1) {
				try {
					List<WebElement> daystoClick = D8
							.findElementsByXPath("//td[contains(text(),'"
									+ setdd + "')]");

					if (daystoClick.size() == 1) {
						daytoClick = daystoClick.get(0);
						daytoClick.click();
						Update_Report("executed", ObjectSet, ObjectSetVal);
					} else if (daystoClick.size() > 1) {
						if (setdd <= 7) {
							for (int i2 = 0; i2 < daystoClick.size(); i2++) {
								if (Integer.parseInt(daystoClick.get(i2)
										.getText()) == setdd) {
									daytoClick = daystoClick.get(i2);
									daytoClick.click();
									Update_Report("executed", ObjectSet,
											ObjectSetVal);
									break;
								}
							}
							// daytoClick = daystoClick.get(0);

						} else {
							for (int i2 = daystoClick.size() - 1; i2 >= 0; i2--) {

								if (Integer.parseInt(daystoClick.get(i2)
										.getText()) == setdd) {
									daytoClick = daystoClick.get(i2);
									daytoClick.click();
									Update_Report("executed", ObjectSet,
											ObjectSetVal);
									break;
								}
							}

						}
					} else {
						Update_Report("invaliddate");
						break;
					}

				} catch (Exception ex1) {
					try {
						List<WebElement> daystoClick =D8
								.findElementsByXPath("//span[contains(text(),'"
										+ setdd + "')]");
						if (daystoClick.size() == 1) {
							daytoClick = daystoClick.get(0);
							daytoClick.click();
							Update_Report("executed", ObjectSet, ObjectSetVal);
						} else if (daystoClick.size() > 1) {
							if (setdd <= 7) {
								for (int i2 = 0; i2 < daystoClick.size(); i2++) {
									if (Integer.parseInt(daystoClick.get(i2)
											.getText()) == setdd) {
										daytoClick = daystoClick.get(i2);
										daytoClick.click();
										Update_Report("executed", ObjectSet,
												ObjectSetVal);
										break;
									}
								}
								// daytoClick = daystoClick.get(0);
							} else {
								for (int i2 = daystoClick.size() - 1; i2 >= 0; i2--) {
									if (Integer.parseInt(daystoClick.get(i2)
											.getText()) == setdd) {
										daytoClick = daystoClick.get(i2);
										daytoClick.click();
										Update_Report("executed", ObjectSet,
												ObjectSetVal);
										break;
									}
								}
							}
						} else {
							Update_Report("invaliddate");
						}

						Update_Report("executed", ObjectSet, ObjectSetVal);
					}

					catch (Exception e) {
						Update_Report("invaliddate");
					}
				}

			}
			if (captureperform == true) {
				screenshot(loopnum, TScrowcount, TScname);
			}
			elem.click();

			break;

		default:
			System.out.println("Notdefined");
			break;
		}
	}
	
	
    public static void readLogExcel()
    {
    try{
    	if (!new File(ReportsPath+"\\TestExecutionLogs.xls").exists())
    	{
    		try {
    		    String fileName = ReportsPath+"\\TestExecutionLogs.xls";
    		    wwbCopy = Workbook.createWorkbook(new File(fileName));
    		    wwbCopy.createSheet("Sheet1", 0);
    		    //wwbCopy.createSheet("Sheet2", 1);
    		    //wwbCopy.createSheet("Sheet3", 2);
    		    wwbCopy.write();
    		    wwbCopy.close(); 		    
    		    logsheet=true;
    		} catch (WriteException e) {
    			System.out.println("Create Log Excel: "+ e.getMessage());
    		}
    	}	
    	wbook = Workbook.getWorkbook(new File(ReportsPath+"\\TestExecutionLogs.xls"));
    	wwbCopy = Workbook.createWorkbook(new File(ReportsPath+"\\TestExecutionLogs.xls"), wbook);
    	shSheet = wwbCopy.getSheet(0);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
    
    public static void setValueIntoCell(String strSuiteName,String strExeTime,String strlogpath,String strData) throws WriteException
    {  
    	//s.Func_execution_logs(SuiteName,exeTimeStamp,"Executed",htmlname1);
    	
    	WritableFont HeaderFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
    	HeaderFont.setColour(Colour.BLACK);
    	HeaderFont.setBoldStyle(WritableFont.BOLD);
    	//HeaderFont.
    	//HeaderFont.setBoldStyle(set);
    	WritableCellFormat headfont = new WritableCellFormat(HeaderFont);
    	headfont.setAlignment(Alignment.CENTRE);
    	
    	
    	WritableFont boldGreenFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD); 	
    	boldGreenFont.setColour(Colour.GREEN);
    	boldGreenFont.setBoldStyle(WritableFont.NO_BOLD);
    	WritableCellFormat passfont = new WritableCellFormat(boldGreenFont);
    	passfont.setAlignment(Alignment.CENTRE);
    	
    	WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD); 	
    	boldRedFont.setColour(Colour.RED);
    	boldRedFont.setBoldStyle(WritableFont.NO_BOLD);
    	WritableCellFormat fset = new WritableCellFormat(boldRedFont);
    	fset.setWrap(true);
    	fset.setAlignment(Alignment.CENTRE);
    	
    	WritableFont normalRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD); 	
    	normalRedFont.setColour(Colour.BLACK);
    	normalRedFont.setBoldStyle(WritableFont.NO_BOLD);
    	WritableCellFormat normalfont = new WritableCellFormat(normalRedFont);
    	normalfont.setAlignment(Alignment.CENTRE);
    	
	    WritableFont fslc=new WritableFont(WritableFont.ARIAL, 8, WritableFont.NO_BOLD);
	    fslc.setColour(Colour.DARK_BLUE);
	    fslc.setUnderlineStyle(UnderlineStyle.DOUBLE);

        WritableCellFormat link=new WritableCellFormat(fslc);
        link.setBackground(Colour.GREY_25_PERCENT, Pattern.SOLID);
        link.setAlignment(jxl.format.Alignment.CENTRE);
        link.setWrap(false);
        link.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,
	    jxl.format.Colour.WHITE);
        link.setWrap(false);
		     //------------------------------------------------------------------------------
	    WritableCellFormat htmllink = new WritableCellFormat(link);

    	
        WritableSheet wshTemp = wwbCopy.getSheet(0);
        
    	wshTemp.setColumnView(0, 60);
    	wshTemp.setColumnView(1, 24);
    	wshTemp.setColumnView(2, 20);
    	wshTemp.setColumnView(3, 38);
    	
        if (!logsheet==true)
        {
        	   int iRowNumber = wshTemp.getRows();
              // Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
               Label labTemp1 = new Label(0, iRowNumber, strSuiteName, normalfont); 
               Label labTemp2 = new Label(1, iRowNumber, strExeTime, normalfont); 
               if (strData.equalsIgnoreCase("pass"))
               {
            	    labTemp3 = new Label(2, iRowNumber, strData, passfont); 
          	  		f = new Formula(3,iRowNumber,"HYPERLINK(\""+strlogpath+"\","+"\"Test Summary\")",htmllink);         // creating formula for moving on to web throught hyperlinks using Formula class
           	  		//wshTemp.addCell(f);	
               }else if (strData.equalsIgnoreCase("fail"))
               {
            	   labTemp3 = new Label(2, iRowNumber, strData, fset); 
            	   labTemp4 = new Label(3, iRowNumber, strlogpath, fset);
               }
                             
               try {
                   wshTemp.addCell(labTemp1);
                   wshTemp.addCell(labTemp2);
                   wshTemp.addCell(labTemp3);
                   if (strData.equalsIgnoreCase("pass"))
                   {
                	 wshTemp.addCell(f);
                   }else
                   {
                	 wshTemp.addCell(labTemp4);   
                   }
              
                   } 
                   	   catch (Exception e) 
                   {
                       e.printStackTrace();
                   }	
        }else
        {
            //Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
            Label labname1 = new Label(0, 0, "Test Suites",headfont); 
            Label labname2 = new Label(1, 0, "Execution date time",headfont); 
            Label labname3 = new Label(2, 0, "Execution Status",headfont);
            Label labname4 = new Label(3, 0, "Reports",headfont);
            // Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
            Label labTemp1 = new Label(0, 1, strSuiteName,normalfont); 
            Label labTemp2 = new Label(1, 1, strExeTime,normalfont);
            if (strData.equalsIgnoreCase("pass"))
            {
            	 labTemp3 = new Label(2, 1, strData,passfont);
       	  		 f = new Formula(3,1,"HYPERLINK(\""+strlogpath+"\","+"\"Test Summary\")",htmllink);  
            	
            }else if(strData.equalsIgnoreCase("fail"))
            {
            	 labTemp3 = new Label(2, 1, strData,fset);
            	 labTemp4 = new Label(3, 1, strlogpath, fset);
            }
            
            Label labTemp4 = new Label(3, 1, strlogpath,normalfont);
            try {
                wshTemp.addCell(labname1);
                wshTemp.addCell(labname2);
                wshTemp.addCell(labname3);
                wshTemp.addCell(labname4);
                wshTemp.addCell(labTemp1);
                wshTemp.addCell(labTemp2);
                wshTemp.addCell(labTemp3);
                if (strData.equalsIgnoreCase("pass"))
                {
                	wshTemp.addCell(f);
                }else
                {
                	wshTemp.addCell(labTemp4);
                }
                
                } 
                	catch (Exception e) 
                {
                    e.printStackTrace();
                }	
        }  
    }
    
	public static void func_InvokeFunction(String functionName,
			String argumentlist) {
		Object[] argument_list = null;
		int checkNULL = 0;
		int CheckONE = 0;
		Class[] parameterTypes = null;
		// 2016-03-23 callfunction no argument Support
		//if (argumentlist == "") {
		if (argumentlist.isEmpty()) {
			checkNULL = 1;

		} else if (argumentlist.contains(":")) {
			argument_list = argumentlist.split(":");
		} else {
			CheckONE = 1;

		}
		String function_name = functionName;
		try {
			Seleniumwd_v_d s1 = new Seleniumwd_v_d();
			Method[] declaredMethods = Seleniumwd_v_d.class.getDeclaredMethods();
			for (Method m : declaredMethods) {
				System.out.println(m.getName());
				if (checkNULL != 1) {
					parameterTypes = m.getParameterTypes();
				}
				if (checkNULL == 0) {
					if ((m.getName()).equals(function_name)) {
						if (parameterTypes.length > 1) {
							if (parameterTypes.length == argument_list.length) {
								try {
									m.invoke(s1, argument_list);
									Update_Report("executed");
								} catch (Exception e) {
									Update_Report("userdefined");
								}
							}
							break;
						} else if ((m.getName()).equals(function_name)
								&& CheckONE == 1 && parameterTypes.length == 1) {

							try {
								m.invoke(s1, argumentlist);
								Update_Report("executed");
							} catch (Exception e) {
								Update_Report("userdefined");
							}

							break;
						}
					}
				} else if (m.getName().equals(function_name) && checkNULL == 1) {
					try {
						m.invoke(s1);
						Update_Report("executed");
					} catch (Exception e) {
						Update_Report("userdefined");
					}
					break;
				}

			}

		} catch (Exception e) {
			System.out.println(e);
			//LOGGER.log(Level.SEVERE, " Exception Occured in func_InvokeFunction- " +e.getMessage()); 
		}
	}
    
    
    public static void closeLogFile()
    {
        try {
            //Closing the writable work book
            wwbCopy.write();
            wwbCopy.close();
            //Closing the original work book
            wbook.close();
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }
  
    public static void Func_ExcutionLogs(String srtfinalstatus) throws WriteException
    {
    	readLogExcel();
    	if (srtfinalstatus.equalsIgnoreCase("error"))
    	{
    		setValueIntoCell(SuiteName,initialexeTimeStamp,strcaptureerrormessage,"Fail");
    	}else {
    		setValueIntoCell(SuiteName,initialexeTimeStamp,htmlname1,"Pass");
    	}    	
    	closeLogFile();	
    	//func_updateLog("error",SuiteName,initialexeTimeStamp,strcaptureerrormessage);
    } 
    
public static void func_updateLog(String srtfinalstatus, String Tst_sut, String Extn_date, String Extn_sts)
{
    // variables
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    // Step 1: Loading or registering Oracle JDBC driver class
    try {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    }
    catch(ClassNotFoundException cnfex) {

        System.out.println("Problem in loading or "
                + "registering MS Access JDBC driver");
        cnfex.printStackTrace();
    }
    // Step 2: Opening database connection
    try {

        String msAccDB = CONFIG.getProperty("ExecutionLog");
        String dbURL = "jdbc:ucanaccess://" + msAccDB; 

        // Step 2.A: Create and get connection using DriverManager class
        connection = DriverManager.getConnection(dbURL); 

        // Step 2.B: Creating JDBC Statement 
        statement = connection.createStatement();

        // Step 2.C: Executing SQL & retrieve data into ResultSet
        //resultSet = statement.executeQuery("SELECT * FROM Execution_Logs");
    	if (srtfinalstatus.equalsIgnoreCase("error"))
    	{
    		statement.executeUpdate("INSERT into Execution_Logs(Test_Suites,Execution_Date,Execution_Report,Execution_Status) VALUES('"+Tst_sut+"','"+Extn_date+"','"+Extn_sts+"','Fail')");
    	}else
    	{
    		statement.executeUpdate("INSERT into Execution_Logs(Test_Suites,Execution_Date,Execution_Report,Execution_Status) VALUES('"+Tst_sut+"','"+Extn_date+"','"+Extn_sts+"','Pass')");
    	}
        //System.out.println("ID\tTest_suite\t\t\texecution_date\tExecution_status\tReport");
        //System.out.println("==\t================\t===\t=======");

    }
    catch(SQLException sqlex){
        sqlex.printStackTrace();
    }
    finally {

        // Step 3: Closing database connection
        try {
            if(null != connection) {

                // cleanup resources, once after processing
                // resultSet.close();
                statement.close();

                // and then finally close connection
                connection.close();
            }
        }
        catch (Exception sqlex) {
            sqlex.printStackTrace();
        }
    }
	}
	public static boolean isInteger(String input) 
	{
		try
		{
			Integer.parseInt(input);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
}
