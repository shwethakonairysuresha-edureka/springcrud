package com.tcs.employee.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employee.dao.OrganizationDAO;
import com.tcs.employee.dao.OrganizationDAOImpl;
import com.tcs.employee.model.Organization;

public class OrganizationServiceImpl implements OrganizationService {
	
	private OrganizationServiceImpl()
	{
	}
	
	private static OrganizationService dao;
	
	public static OrganizationService getInstance()
	{
		if(dao == null)
		{
			dao = new OrganizationServiceImpl();
			return dao;
		}
		return dao;
	}
	
	OrganizationDAO organizationDao = OrganizationDAOImpl.getInstance();

	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return organizationDao.addOrganization(organization);
	}

	@Override
	public String updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return organizationDao.updateOrganization(organization);
	}

	@Override
	public String deleteOrganization(int id) {
		// TODO Auto-generated method stub
		return organizationDao.deleteOrganization(id);
	}

	@Override
	public Optional<Organization> findById(int id) {
		// TODO Auto-generated method stub
		return organizationDao.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganization() {
		// TODO Auto-generated method stub
		return organizationDao.getOrganization();
	}

	@Override
	public Optional<List<Organization>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		return organizationDao.findByOrganizationId(id);
	}

}
