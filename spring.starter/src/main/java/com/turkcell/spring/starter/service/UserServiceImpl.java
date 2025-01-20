package com.turkcell.spring.starter.service;

import com.turkcell.spring.starter.dto.user.LoginDto;
import com.turkcell.spring.starter.entity.User;
import com.turkcell.spring.starter.repository.UserRepository;
import com.turkcell.spring.starter.util.exception.type.BusinessException;
import com.turkcell.spring.starter.util.jwt.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        bCryptPasswordEncoder = new BCryptPasswordEncoder(); //TODO: Bean olarak ekle.
    }

    //TODO: Refactor entity to dto.
    @Override
    public void add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
    }


    @Override
    public String login(LoginDto loginDto) {
        User dbUser = userRepository
                .findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new BusinessException("Invalid or wrong credentials."));

        boolean isPasswordCorrect= bCryptPasswordEncoder
                .matches(loginDto.getPassword(), dbUser.getPassword());

        if(!isPasswordCorrect){
            throw new BusinessException("Invalid or wrong credentials.");
        }

        return this.jwtService.generateToken(dbUser.getUsername());

    }
}
