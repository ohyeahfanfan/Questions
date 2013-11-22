package Database;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
/*
 * An implementation of Select File Node 
 * 
 *   	 file
 *      SelectFile
 *   	  | out
 *    
 */
public class SelectFile extends OpNode implements Runnable {
	private final BlockingQueue<Record> out;
	String fileName = null;
	SelectFile(String fileName, BlockingQueue<Record> out){
		this.out = out;
		this.fileName = fileName;
	}
	public void run(){
		try {
			// Open the file that is the first
			// command line parameter
			String colNames = "";
			FileInputStream fstream = new FileInputStream(fileName + ".tbl");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i = 0;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				if (i == 0) {
					colNames = strLine;
				}else{
					Record record = new Record(colNames, strLine);
					out.put(record);
				}
				i++;
			}
			//Close the input stream
			in.close();
			//Tell consumer, this is the end of stream
			out.put(new Record(RECORD_TYPE.POISON));
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	
}
