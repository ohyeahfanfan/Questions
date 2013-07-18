package Database;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PhysicalPlan {
	/*
	 * select tenants.tenant_name
	 * ,apartments.unit_number 
	 *	from tenants 
	 *	inner join apt_tenants on tenants.tenant_id = apt_tenants.tenant_id 
	 *	inner join apartments on apt_tenants.apt_id = apartments.apt_id 
	 *              outFile(t6)
	 *	               |
	 *				JoinOp(t5)
	 *		     q3/        \q4
	 *	       JoinOp(t3)  selectFile(t4)
	 *       q1/     \q2
	 *selectFile(t1) selectFile(t2)
	 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Record> q1 = new ArrayBlockingQueue<Record>(5);
		BlockingQueue<Record> q2 = new ArrayBlockingQueue<Record>(5);
		BlockingQueue<Record> q3 = new ArrayBlockingQueue<Record>(5);
		BlockingQueue<Record> q4 = new ArrayBlockingQueue<Record>(5);
		BlockingQueue<Record> q5 = new ArrayBlockingQueue<Record>(5);
		SelectFile apartments = new SelectFile("apartments", q1);
		SelectFile apts_tenants = new SelectFile("apt_tenants", q2);
		JoinOp firstJoin = new JoinOp(q3, q1, q2, "apt_id", "apt_id",apartments, apts_tenants);
		SelectFile tenants = new SelectFile("tenants", q4);
		JoinOp secondJoin = new JoinOp(q5,q3,q4,"tenant_id", "tenant_id", firstJoin, tenants);
		OutputFile outFile = new OutputFile(q5, secondJoin);
		Thread t1 = new Thread(apartments);
		Thread t2 = new Thread(apts_tenants);
		Thread t3 = new Thread(firstJoin);
		Thread t4 = new Thread(tenants);
		Thread t5 = new Thread(secondJoin);
		Thread t6 = new Thread(outFile);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}

}
