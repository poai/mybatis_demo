package cn.com.zjf.model1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.com.zjf.model.User;
public interface UserMapper {
	@Select("select * from user where id=#{id}")
	public User get(Integer id);
	@Select("select * from user")
	public List<User> getAll();
	@Insert("insert into user(name,sex) values(#{name},#{sex})")
	public void save(User user);
	@Update("update user set name=#{name},sex=#{sex} where id=#{id} ")
	public void update(User user);
	@Delete("delete from user where id=#{id}")
	public void delete(Integer id);
}
