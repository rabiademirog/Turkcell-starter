package com.turkcell.spring.starter.service;

import com.turkcell.spring.starter.entity.User;
import com.turkcell.spring.starter.repository.UserRepository;
import com.turkcell.spring.starter.util.exception.type.BusinessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        bCryptPasswordEncoder = new BCryptPasswordEncoder(); //TODO: Bean olarak ekle.
    }

    //TODO: Refactor entity to dto.
    @Override
    public void add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
    }

    @Override
    public boolean login(User user) {
        User dbUser = userRepository.findById(user.getId()).orElseThrow(() -> new BusinessException("User Not Found"));

        return bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword());
    }
}
