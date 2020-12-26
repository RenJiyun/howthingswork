package com.example.howmultipledatasourceworks.mapper.db1;

import com.example.howmultipledatasourceworks.model.db1.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectById(@Param("id") long id);

    @Select("select * from user")
    Cursor<User> scanAllUser();
}
