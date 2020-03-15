package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Dept;
import in.nit.model.Employee;
import in.nit.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Dept d1=new Dept(440,"DEV", "SAME");
			
			Employee e1=new Employee(201, "AA", 33.50, d1);
			Employee e2=new Employee(202, "AB", 44.50, d1);
			Employee e3=new Employee(203, "BA", 55.50, d1);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
