package duke.hbase.cm.tdg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;

public class HbaseTableGenerator{
	private static final String PROJECT_HOME = System.getenv("PROJECT_HOME");	
	private String dataDir = PROJECT_HOME;
	
	private String xmlFile = null;
	private String sqlFile = null;
	private String csvFile = null;
	private String hdfsDir = "/tdg";
	
	public void setXmlFile(String fileName){
		this.xmlFile = PROJECT_HOME + "/" + fileName;
	}
    public void setSqlFile(String fileName){
    	this.sqlFile = PROJECT_HOME + "/" + fileName;
    }
    public void setCsvFile(String fileName){
    	this.csvFile = PROJECT_HOME + "/" + fileName;
    }
    
	public void generate(ArrayList<Table> tableList){	
		//create sql file
		SqlBuilder sqlBuilder = new SqlBuilder();
		sqlBuilder.setOutFile(sqlFile);
		sqlBuilder.createSqlFile(tableList);
		
		//create xml file
	    XmlBuilder builder = new XmlBuilder();
	 	builder.setOutFile(xmlFile);	 
	    builder.createXmlFile(tableList);
	    
	    //generate csv data using pdgf
	    PdgfDataGenerator pdgf = new PdgfDataGenerator();
     	pdgf.setInFile(xmlFile);
   	    pdgf.generate( );
   	    
	    //copy csv data from local to hdfs

        try {
    	    HdfsCopier hdfsCopier = new HdfsCopier();
            hdfsCopier.copyFromLocal(csvFile,hdfsDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //load table into Hbase
        HbaseLoader hLoader = new HbaseLoader();
        hLoader.createTableInHbase(sqlFile);
        hLoader.loadTableInHbase(tableList,"/tdg/csvdir/"); 
	               
	}

    public static void main(String[] agrs){
        ArrayList<Table> tableList = new ArrayList<Table>();
		
		//generate table 1
		Column id = new Column("ID", " ", "INTEGER", 10, true, true);
		Column userName = new Column("UserName"," ","VARCHAR",10,false,true);		
		Column address = new Column("Address", "f","VARCHAR", 10,false,false);
		Column accBal = new Column("AccBal","f","DECIMAL",10,false,false);
		Column comment = new Column("Comment", "f","VARCHAR", 10,false,false);
		
		ArrayList<Column> rowkey = new ArrayList<Column>();
		ArrayList<Column> columns = new ArrayList<Column>();
		rowkey.add(id);
		rowkey.add(userName);
        
		columns.add(address);
		columns.add(accBal);
		columns.add(comment);
	       
		Table table1 = new Table("Z",100,rowkey,columns) ;
		
		tableList.add(table1);
		
//		//generate table 2
//		Column ip = new Column("IP", " ", "INTEGER", 10, true, true);
//		Column message = new Column("Message", "f","VARCHAR", 10, false,false);
//		
//		ArrayList<Column> rowkey2 = new ArrayList<Column>();
//		ArrayList<Column> columns2 = new ArrayList<Column>();
//        
//		rowkey2.add(ip);  
//		columns2.add(message);     
//		Table table2 = new Table("X",20,rowkey2,columns2) ;
//		
//		//add table to tableList
//		tableList.add(table1);
//		tableList.add(table2);
	       


        long startTime = System.currentTimeMillis(); 
        HbaseTableGenerator generator = new HbaseTableGenerator();
        generator.generate(tableList);
    	long endTime = System.currentTimeMillis();
        System.out.println("Total time used: " + (endTime - startTime)/1e3 + " seconds");
   }
} 

