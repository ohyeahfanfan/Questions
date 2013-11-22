package Database;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;

public class OutputFile extends OpNode implements Runnable{
	private final BlockingQueue<Record> in;
	String fileName = "result";
	OutputFile(BlockingQueue<Record> in, OpNode left){
		this.in = in;
		this.left = left;
	}
	public void run(){
		try {
		File file = new File("result.tbl");
		if(!file.exists()) {
			file.createNewFile();
		} 
		FileOutputStream oFile = new FileOutputStream(file, false); 
		DataOutputStream out =  new DataOutputStream(oFile);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(out));
		while(true){
			try{
				Record r = in.take();
				//the thread will stop here, if condition is satisfied
				if(r.type == RECORD_TYPE.POISON) break;
				br.write(r.toString());
				br.newLine();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		br.close();
	   }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
