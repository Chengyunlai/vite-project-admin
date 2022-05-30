package top.chengyunlai.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.chengyunlai.base.pojo.User;

import java.util.List;
public interface UserMapper {
    @Select("select * from user")
    public List<User> selectAll();
}
