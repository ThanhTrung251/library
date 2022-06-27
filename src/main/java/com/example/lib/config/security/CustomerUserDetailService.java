package com.example.lib.config.security;

import com.example.lib.model.entity.Member;
import com.example.lib.model.entity.Role;
import com.example.lib.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Member> listMember = memberRepository.findMembersByName(username);
        if (listMember.size() > 0) {
            Member member = listMember.get(0);
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Role role : member.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            UserDetails userDetails = new User(member.getName(), member.getPassword(), authorities);
            return userDetails;
        } else {
            new UsernameNotFoundException("Login fail !");
        }
        return null;
    }
}
