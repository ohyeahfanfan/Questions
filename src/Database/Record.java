package Database;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
enum RECORD_TYPE {
   REGULAR, POISON 
}
public class Record {
	private Hashtable<String, String> tuple = new Hashtable<String,String>();
	private String colNames = null;
	public final RECORD_TYPE type; 
	public Record(String names, String values){
		type = RECORD_TYPE.REGULAR;
		String[] nameArr = names.split(",");
		String[] valArr = values.split(",");
		if(nameArr.length != valArr.length){
			return;
		}
		for(int i = 0; i < nameArr.length; i++){
			tuple.put(nameArr[i].trim(),valArr[i].trim());
		}
		colNames = names;	
	}
	public Record(RECORD_TYPE type){
		this.type = type;
	}
	public Record(){
		type = RECORD_TYPE.REGULAR;
	}
	public Record(Hashtable<String,String> tb){
		this.tuple = tb;
		type = RECORD_TYPE.REGULAR;
	}
	public String getColNames(){
		String names = "";
		//String vals = "";
		Iterator<Entry<String, String>> it = tuple.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, String> pairs = it.next();
	        names += pairs.getKey() + ",";
	        //vals += pairs.getValue()+ ",";
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	   return names;
	}
	public static Record createRecordByMerge(Record left, Record right){
		Hashtable<String, String> tb = new Hashtable<String, String>();
		tb.putAll(left.getTuple());
		tb.putAll(right.getTuple());
		return new Record(tb);
	}
	public String toString(){
		String names = "";
		String vals = "";
		Iterator<Entry<String, String>> it = tuple.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, String> pairs = it.next();
	        names += pairs.getKey() + ",";
	        vals += pairs.getValue()+ ",";
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	    //colNames = names;
	    return vals;
	}
	public Hashtable<String, String> getTuple(){
		return this.tuple;
	}
	public void setTuple( Hashtable<String, String> tuple){
		this.tuple = tuple;
	}
	
	
}
