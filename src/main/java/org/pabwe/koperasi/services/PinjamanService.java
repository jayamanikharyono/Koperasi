package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.User;


public interface PinjamanService 
{
	public void save(User user);
	public List<User> findAllUser();
	User findById(int id);
	User edit(User user);
	void deleteById(int id);
}
