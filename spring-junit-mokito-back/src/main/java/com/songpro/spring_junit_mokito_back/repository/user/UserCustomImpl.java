package com.songpro.spring_junit_mokito_back.repository.user;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.songpro.spring_junit_mokito_back.dto.QUserDto;
import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.entity.User;
import lombok.RequiredArgsConstructor;

import static com.songpro.spring_junit_mokito_back.entity.QUser.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UserCustomImpl implements UserCustom {
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * @description QueryDSL Test
     * @author SongPro
     * @return List<User>
     */
    @Override
    public List<User> getUsers(){
        return jpaQueryFactory
                .select(user)
                .from(user)
                .fetch();
    }

    /**
     * @description SimpleProjection Test
     * @author SongPro
     * @return List<String>
     */
    @Override
    public List<String> getSimpleProjection(){
        return jpaQueryFactory
                .select(user.userName)
                .from(user)
                .fetch();
    }

    /**
     * @description TupleProjection Test
     * @author SongPro
     * @return List<Map<String, Object>>
     */
    @Override
    public List<Map<String, Object>> getTupleProjection(){
        List<Tuple> data = jpaQueryFactory
                .select(
                        user.userId,
                        user.userName
                )
                .from(user)
                .fetch();

        List<Map<String, Object>> result = new ArrayList<>();
        for(Tuple tuple : data){
            Map<String, Object> row = new HashMap<>();
            row.put("userId", tuple.get(user.userId));
            row.put("userName", tuple.get(user.userName));

            result.add(row);
        }

        return result;
    }

    /**
     * @description DTO의 생성자 기반 매핑
     * @author SongPro
     * @return List<UserDto>
     */
    @Override
    public List<UserDto> getConstructorProjection(){
        return jpaQueryFactory
                .select(
                        Projections.constructor(
                                UserDto.class,
                                user.userId,
                                user.userName
                        )
                ).from(user)
                .fetch();
    }

    /**
     * @description DTO의 기본 생성자를 사용하고 setter를 통해 값을 설정
     * @author SongPro
     * @return List<UserDto>
     */
    @Override
    public List<UserDto> getBeanProjection(){
        return jpaQueryFactory
                .select(
                        Projections.bean(
                                UserDto.class,
                                user.userId,
                                user.userName
                        )
                )
                .from(user)
                .fetch();
    }

    /**
     * @description 필드 이름이 DTO와 정확히 일치하는 속성과 매핑, bean과 다른점은 setter가 필요 없다.
     * @author SongPro
     * @return List<UserDto>
     */
    @Override
    public List<UserDto> getFieldProjection(){
        return jpaQueryFactory
                .select(
                        Projections.fields(
                                UserDto.class,
                                user.userName
                        )
                ).from(user)
                .fetch();
    }

    /**
     * @description DTO Query Projection 매핑
     * @author SongPro
     * @return List<UserDto>
     */
    public List<UserDto> getQueryProjection(){
        return jpaQueryFactory
                .select(
                        new QUserDto(
                                user.userId,
                                user.userName
                        )
                )
                .from(user)
                .fetch();
    }
}
