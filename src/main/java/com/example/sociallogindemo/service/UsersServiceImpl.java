package com.example.sociallogindemo.service;

import com.example.sociallogindemo.entity.AuthProvider;
import com.example.sociallogindemo.entity.Users;
import com.example.sociallogindemo.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl {

    UsersRepository userRepo;

    //Create
    public Users createUser(Users user) {
        return userRepo.save(user);
    }

    //Read
    public List<Users> findAllUsers() {
        return userRepo.findAll();
    }

    public Users findByUserId(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Users findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    //Update
    public Users updateUser (Users user){
        Users existingUser = findByUserId(user.getUserId());
        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAuthProvider(user.getAuthProvider());
        return userRepo.save(existingUser);
    }

    //Delete
    public String deleteUser (int userId){
        Users userDelete = findByUserId(userId);
        userRepo.delete(userDelete);
        return "User deleted: " +userDelete.getUserName();
    }

    public void createUserAfterOAuthLoginSuccess(String email, String userName) {
        Users user =new Users();
        user.setUserName(userName);
        user.setEmail(email);
        userRepo.save(user);
    }

    public void updateUserAfterOAuthLoginSuccess(String email, String userName) {
        Users existingUser = findByUserName(userName);
        existingUser.setEmail(email);
        userRepo.save(existingUser);
    }
}
