package org.pabwe.koperasi.services;

import java.util.List;

import org.pabwe.koperasi.models.User;
import org.pabwe.koperasi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public User edit(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}
	
	@Override
	public User login(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		List<User>  listUser= userRepository.findAll();
		for(User user : listUser)
		{
			if((user.getUsername().equals(username)) && (user.getPassword().equals(password)))
			{
				return user;
			}
		}
		System.out.println("null");
		return null;
	}
}
