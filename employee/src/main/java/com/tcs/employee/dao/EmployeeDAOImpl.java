package com.tcs.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.employee.model.Employee;
import com.tcs.employee.utils.DBUtils;

//@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	DBUtils dbUtils;
	
//	private EmployeeDAOImpl()
//	{
//	}
//	
//	private static EmployeeDAO dao;
//	
//	public static EmployeeDAO getInstance()
//	{
//		if(dao == null)
//			{
//				dao = new EmployeeDAOImpl();
//				return dao;
//			}
//			return dao;
//	}
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertEmployee = "insert into EMPLOYEE(id,organizationId,departmentId,name,age,position) values(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertEmployee);
			preparedStatement.setInt(1,  employee.getId());
			preparedStatement.setInt(2, employee.getOrganizationId());
			preparedStatement.setInt(3, employee.getDepartmentId());
			preparedStatement.setString(4, employee.getName());
			preparedStatement.setInt(5, employee.getAge());
			preparedStatement.setString(6, employee.getPosition());
		    
			result = preparedStatement.executeUpdate();
			
			if(result > 0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				return "Failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try
			{
				connection.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "Failed";
		}
		finally
		{
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;

        try {
            String sql = "UPDATE EMPLOYEE set organizationId=?, departmentId=? , name=?, age=?, position=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,employee.getOrganizationId());
            preparedStatement.setInt(2,employee.getDepartmentId());
            preparedStatement.setString(3,employee.getName());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.setInt(6,employee.getId());
            result = preparedStatement.executeUpdate();
            if (result>0)
            {
                connection.commit();
                return "success";
            }
            else {
                return "fail";
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return "fail";
        }
        finally {
        	dbUtils.closeConnection(connection);
        }
    }

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int resultSet = 0;
		int result = 0;
		try {
			String query = "delete from EMPLOYEE where id=?";
		 preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeUpdate();		
			if (result>0)
			{
				connection.commit();
				
				return "success";
			}
			else {
			
				connection.commit();
				return "success";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		String query = "select * from EMPLOYEE where id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setOrganizationId(resultSet.getInt("organizationId"));
				employee.setDepartmentId(resultSet.getInt("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try
			{
				connection.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		finally
		{
			dbUtils.closeConnection(connection);
		}
		return Optional.of(employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
	
		try {
			String query = "SELECT * FROM EMPLOYEE";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		
			while (resultSet.next())
			{
				int id = resultSet.getInt(1);
				int OrganizationId = resultSet.getInt(2);
				int DepartmentId = resultSet.getInt(3);
				String Name = resultSet.getString(4);
				int Age = resultSet.getInt(5);
				String Position = resultSet.getString(6);
							
				employee = new Employee();
				employee.setId(resultSet.getInt("Id"));
				employee.setOrganizationId(resultSet.getInt("organizationId"));
				employee.setDepartmentId(resultSet.getInt("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				
				System.out.println("id: " +resultSet.getInt(1));
				System.out.println("organizationId: " +resultSet.getInt(2));
				System.out.println("departmentId: " +resultSet.getInt(3));
				System.out.println("Name: " +resultSet.getString(4));
				System.out.println("Age: " +resultSet.getInt(5));
				System.out.println("Position: " +resultSet.getString(6));
			}	
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			dbUtils.closeConnection(connection);
		}		
		return Optional.empty();
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		String query = "select * from EMPLOYEE where organizationId=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int Id = resultSet.getInt(1);
				int OrganizationId = resultSet.getInt(2);
				int DepartmentId = resultSet.getInt(3);
				String Name = resultSet.getString(4);
				int Age = resultSet.getInt(5);
				String Position = resultSet.getString(6);
				
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setOrganizationId(resultSet.getInt("organizationId"));
				employee.setDepartmentId(resultSet.getInt("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				
				System.out.println("id: " +resultSet.getInt(1));
				System.out.println("organizationId: " +resultSet.getInt(2));
				System.out.println("departmentId: " +resultSet.getInt(3));
				System.out.println("Name: " +resultSet.getString(4));
				System.out.println("Age: " +resultSet.getInt(5));
				System.out.println("Position: " +resultSet.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try
			{
				connection.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		finally
		{
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

}
