package com.songpro.spring_junit_mokito_back.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.songpro.spring_junit_mokito_back.entity.User;
import lombok.RequiredArgsConstructor;

import static com.songpro.spring_junit_mokito_back.entity.QUser.user;
import java.util.List;

@RequiredArgsConstructor
public class UserCustomImpl implements UserCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> getUsers(){
        return jpaQueryFactory
                .select(user)
                .from(user)
                .fetch();
    }
}
