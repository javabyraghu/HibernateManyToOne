package in.nit.test;

import org.hibernate.Session;

import in.nit.model.Dept;
import in.nit.model.Employee;
import in.nit.util.HibernateUtil;

public class TestGet {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			Employee e=ses.get(Employee.class, 201);
			//Do not print complete object > may result Stack Overflow Error
			System.out.println(e.getEmpName());
			System.out.println(e.getDeptOb().getDeptCode());
			//--result must be same from two sides.. then valid bi-directional
			Dept d=ses.get(Dept.class, 440);
			System.out.println(d.getDeptCode());
			System.out.println(d.getEmps().get(0).getEmpName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
