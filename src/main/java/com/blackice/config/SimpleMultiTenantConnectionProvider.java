package com.blackice.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.apache.commons.dbcp2.BasicDataSource;

public class SimpleMultiTenantConnectionProvider implements MultiTenantConnectionProvider{

	@Override
	public boolean isUnwrappableAs(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		System.out.println("*************** getAnyConnection");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql://localhost:3306/gcd_master");
		return ds.getConnection();
	}

	@Override
	public Connection getConnection(String arg0) throws SQLException {
		System.out.println("*************** getAnyConnection");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("blackinc_admin");
		ds.setPassword("Blackice@2014");
		ds.setUrl("jdbc:mysql://localhost:3306/gcd_master");
		return ds.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseConnection(String arg0, Connection arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
