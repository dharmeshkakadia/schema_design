package duke.hbase.cm.tdg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//read training data from scanTD.txt, 
//split it into train_data.txt and test_data.txt for cost model
//call cost model, to compute the estimetated_latency
//compute the mean square error 
public class ErrorEstimator {
	//compute the total number of lines in inputFile
	public int numOfLines(String inputFile){
		BufferedReader br  = null;
		int numOfLines = 0;
		try {		   			
            br = new BufferedReader(new FileReader(inputFile));
            //the total number of lines in inputFile
            
 			while ( br.readLine() != null) {
 				numOfLines++;		
 			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
 			if (br != null) {
 				try {
 					br.close();
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 			}
 		}	
		return numOfLines;		
	}
    //randomly split input file into percent : (1-percent) 
	public void splitFile(String inputFile, double percent){		   
			BufferedReader br  = null;
			FileWriter tdWriter = null;
 			FileWriter testWriter = null;	
			String line = "";
		    String seperator = "\t";  		           	 
 		try {		   			
            br = new BufferedReader(new FileReader(inputFile));
            //the total number of lines in inputFile
            int numOfLines = this.numOfLines(inputFile);
            int trainLines = (int) Math.floor(percent * numOfLines);
 			//generate a list containing percent * numOfLines distinct random number 
            
 			List<Integer> trainDataIndex = kOutofN(trainLines,numOfLines);
 			System.out.println(trainLines + " out of " +
 			        numOfLines + " are selected as the training data.");
            
            tdWriter = new FileWriter("scan_train_data.txt");
            testWriter = new FileWriter("scan_test_data.txt"); 	
            int lineNumber = 1;
 			while ((line = br.readLine()) != null) {
 			
 				if (trainDataIndex.contains(lineNumber)){
 					tdWriter.append(line);
 					tdWriter.append("\n");
 				    tdWriter.flush();
 				}
 				else{
 					String[] s = line.split(seperator);
 					StringBuilder builder = new StringBuilder();
 					for(int i=1; i<s.length;i++){
 					   builder.append(s[i]);
 					   if(i<s.length-1)
 						   builder.append(seperator);				
 					}
 					builder.append("\n");
 					testWriter.append(builder.toString());
 					testWriter.flush();
 				}	
 				lineNumber++;
 			}
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			if (br != null) {
 				try {
 					br.close();
					 tdWriter.close();
 					 testWriter.close();
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 			}
 		}		
  }
		
	//return k distinct random number from 1 to N
	public List<Integer> kOutofN(int k, int N){
		List<Integer> index = new ArrayList<Integer>();
		for(int i=0;i<N;i++){
			index.add(i+1);
		}
		Collections.shuffle(index);			 
		List<Integer> resList = index.subList(0, k);
		for(int a:index)
		  System.out.print(a + ", ");
	    System.out.println("");
	 	for(int a:resList)
			 System.out.print(a + ", ");
	 	System.out.println("");
		return resList;	
	}

	public static void main(String[] args){
		ErrorEstimator es = new ErrorEstimator();
//		es.kOutofN(5, 10);
		es.splitFile("/home/hadoop/git/schema_design/scanTD.txt",0.7);	
    }
		

}