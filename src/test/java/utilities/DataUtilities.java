package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtilities {
	
	String propertyFilePath = "C:\\Users\\kavya\\Selenium-Workspace\\VTiger\\src\\test\\resources\\datas\\vtigerdata.properties";
	String excelFilePath = "C:\\Users\\kavya\\Selenium-Workspace\\VTiger\\src\\test\\resources\\datas\\Selenium_Testing.xlsx";
	
	public void setDataToPropertyFile(String key, String value) {
		
		try {
			
			//specify the path by creating the object for FIS
			FileInputStream fis = new FileInputStream(propertyFilePath);
			
			//create object for property class
			Properties properties = new Properties();
			
			//load file into property object
			properties.load(fis);
			
			//set data
			properties.setProperty(key, value);
			
			//create object FOS
			FileOutputStream fos = new FileOutputStream(propertyFilePath);
			
			//store data
			properties.store(fos, "Data Stored Succussfully");
			
		}catch (Exception e) {
			System.out.println("Unable to store data into property file");
		}
	}
	
	public String getDataFromPropertyFile(String property) {
		
		String value = "";
		try {
			
			//Specify path
			FileInputStream fis = new FileInputStream(propertyFilePath);
			
			//create object file for properties
			Properties properties = new Properties();
			
			//load file to object
			properties.load(fis);
			
			//get property
			value = properties.getProperty(property);
		}catch (Exception e) {
			
			System.out.println("Uable to get the properties");
		}
		
		return value;
	}
	
	public void removeDataFromPropertyFile(String property){
		
		try {
		//Specify path
		FileInputStream fis = new FileInputStream(propertyFilePath);
		
		//create an object for property
		Properties properties = new Properties();
		
		//load file
		properties.load(fis);
		
		//remove property
		properties.remove(property);
		
		//create an object for fout
		FileOutputStream fout = new FileOutputStream(propertyFilePath);
		
		//store the property
		properties.store(fout, "Property Deleted succussfully");
		
		//print the msg
		System.out.println("Deleted succussfuly");
		
		}catch (Exception e) {
			
			System.out.println("Unable to remove data from property file");
		}
	}
	
	public void setDataToExcel(String sheet, int row,int cell, String data) {
		try {
			//Specify path
			FileInputStream fis = new FileInputStream(excelFilePath);
			
			//create workbook
			Workbook wb = WorkbookFactory.create(fis);
			
			//getsheet, create row, create cell, create cell value
			wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(data);
			
			//create object for fout
			FileOutputStream fot = new FileOutputStream(excelFilePath);
			
			//write inside file
			wb.write(fot);
		}
		catch (Exception e) {
			System.out.println("Unable to get data from Excel");
		}
	}
	
	public String getDataFromExcel(String sheet, int row, int cell) {
		String value = "";
		try {
			//Specify path
			FileInputStream fis = new FileInputStream(excelFilePath);
			
			//create workbook
			Workbook wb = WorkbookFactory.create(fis);
			
			//getvalue from excel
			value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			
		}catch (Exception e) {
			System.out.println("Unable to get data from Excel");
		}
		return value;
	}
	
	public void setDataToDatabase(String query) {
		
		try {
			//get usn, psw, url of jdbc from excel
			String jdbcurl = getDataFromPropertyFile("jdbcurl");
			String jdbcusername = getDataFromPropertyFile("jdbcun");
			String jdbcpassword = getDataFromPropertyFile("jdbcpsw");
			
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			Connection conn = DriverManager.getConnection(jdbcurl,jdbcusername,jdbcpassword);
			
			//create statement and execute
			conn.createStatement().execute(query);
			
			//print succuss
			System.out.println("Data Entered Succusfully");
		
		}catch (Exception e) {
			System.out.println("Unable to setdata ");
		}
	}
	
	public ArrayList<Object[]> getDataFromDatabase(String query) {
		
		ArrayList<Object[]> al = new ArrayList<Object[]>();
		try {
			
			//get usn, psw, url of jdbc from excel
			String jdbcurl = getDataFromPropertyFile("jdbcurl");
			String jdbcusername = getDataFromPropertyFile("jdbcun");
			String jdbcpassword = getDataFromPropertyFile("jdbcpsw");
			
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			Connection conn = DriverManager.getConnection(jdbcurl,jdbcusername,jdbcpassword);
			
			//create statement and execute
			ResultSet rs = conn.createStatement().executeQuery(query);
			
			while(rs.next()) {
				int columnCount = rs.getMetaData().getColumnCount();
				String[] rowData = new String[columnCount];
				
				for(int i=1;i<=columnCount;i++) {
					rowData[i-1] = rs.getString(i);
				}
				al.add(rowData);
			}
		}catch (Exception e) {
			System.out.println("Unable to get data");
		}
		return al;
	}
	
}
