package com.eggip.howmybatisplusworks.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eggip.howmybatisplusworks.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}