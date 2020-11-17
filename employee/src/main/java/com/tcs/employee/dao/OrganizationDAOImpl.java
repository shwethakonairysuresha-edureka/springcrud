package com.tcs.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.employee.model.Department;
import com.tcs.employee.model.Organization;
import com.tcs.employee.utils.DBUtils;

//@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
	
	@Autowired
	DBUtils dbUtils;
	
//	private OrganizationDAOImpl()
//	{
//	}
//	
//	private static OrganizationDAO dao;
//	
//	public static OrganizationDAO getInstance()
//	{
//		if(dao == null)
//			{
//				dao = new OrganizationDAOImpl();
//				return dao;
//			}
//			return dao;
//	}

	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertEmployee = "insert into ORGANIZATION(id,name,address) values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertEmployee);
			preparedStatement.setInt(1,  organization.getId());
			preparedStatement.setString(2, organization.getName());
			preparedStatement.setString(3, organization.getAddress());
		    
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
	public String updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;

        try {
            String sql = "UPDATE ORGANIZATION set name=?, address=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,organization.getName());
            preparedStatement.setString(2,organization.getAddress());
            preparedStatement.setInt(3,organization.getId());
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
	public String deleteOrganization(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int resultSet = 0;
		int result = 0;
		try {
			String query = "delete from ORGANIZATION where id=?";
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
	public Optional<Organization> findById(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		String query = "select * from ORGANIZATION where id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				organization = new Organization();
				organization.setId(resultSet.getInt("id"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));
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
		return Optional.of(organization);
	}

	@Override
	public Optional<List<Organization>> getOrganization() {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Organization organization = null;
	
		try {
			String query = "SELECT * FROM ORGANIZATION";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		
			while (resultSet.next())
			{
				int id = resultSet.getInt(1);
				String Name = resultSet.getString(2);
				String Address = resultSet.getString(3);
							
				organization = new Organization();
				organization.setId(resultSet.getInt("Id"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));

				System.out.println("id: " +resultSet.getInt(1));
				System.out.println("name: " +resultSet.getString(2));
				System.out.println("address: " +resultSet.getString(3));
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
	public Optional<List<Organization>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		String query = "select * from ORGANIZATION where id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int Id = resultSet.getInt(1);
				String Name = resultSet.getString(2);
				String Address = resultSet.getString(3);
				
				organization = new Organization();
				organization.setId(resultSet.getInt("id"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));
				
				System.out.println("id: " +resultSet.getInt(1));
				System.out.println("Name: " +resultSet.getString(2));
				System.out.println("Address: " +resultSet.getString(3));
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
