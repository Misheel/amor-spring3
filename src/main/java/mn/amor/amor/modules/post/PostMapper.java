package mn.amor.amor.modules.post;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PostMapper {
	
	@Select("select * from post where status='ENABLED'")
	List<Post> findAll();
	
	@Select("select * from post where id=#{id}")
	Post findById(@Param("id")Integer id);			
	
	@Insert("insert into post values(null, #{name}, #{content}, sysdate(), 'ENABLED')")
	void save(Post form);
	
	@Update("update post set name=#{name}, content=#{content} where id=#{id}")
	void update(Post form);
	
	@Update("update post set status='DELETED' where id=#{id}")
	void delete(@Param("id")Integer id);

}
