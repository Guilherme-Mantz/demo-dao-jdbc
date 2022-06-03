package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> list = new ArrayList<>();
		
		System.out.println("\n=== Test 1: Department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== Test 2: Department findAll ===");
		list = departmentDao.findAll();
		
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: Department Insert ===");
		Department newDep = new Department(null, "games");
		departmentDao.insert(newDep);
		
		System.out.println("Inserted! new id = " + newDep.getId());
		
		System.out.println("\n=== Test 5: Department Update ===");
		department = departmentDao.findById(6);
		department.setName("kids");
		departmentDao.update(department);
		
		System.out.println("Updated");
		
		System.out.println("\n=== Test 6: Department Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		System.out.println("Deleted");
		
		sc.close();
	}

}
