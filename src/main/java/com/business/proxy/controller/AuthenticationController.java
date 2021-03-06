package com.business.proxy.controller;

import com.business.proxy.dto.AuthTokenDto;
import com.business.proxy.dto.AuthenticationRequestDto;
import com.business.proxy.model.User;
import com.business.proxy.service.UserService;
import com.business.proxy.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */

@RestController
@RequestMapping("/token")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequestDto requestDto) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getName(), requestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(requestDto.getName());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthTokenDto(user.getName(), token));
    }
}