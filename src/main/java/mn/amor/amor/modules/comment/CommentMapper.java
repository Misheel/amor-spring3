package mn.amor.amor.modules.comment;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentMapper {
		
	@Select("select * from comment where postId = #{postId} and status = 'ENABLED' and parentId is null order by created desc")
	List<Comment> findAllByPostId(@Param("postId")Integer postId);
	
	@Select("select * from comment where parentId = #{parentId} and status = 'ENABLED' order by created desc")
	List<Comment> findAllByParentId(@Param("parentId")Integer parentId);
	
	@Select("select * from comment where id=#{id}")
	Comment findById(@Param("id")Integer id);		
	
	@Insert("insert into comment values(null, #{postId}, null, #{name}, #{comment}, #{ip}, sysdate(), 'ENABLED')")
	void save(Comment menu);
	
	@Insert("insert into comment values(null, #{postId}, #{parentId}, #{name}, #{comment}, #{ip}, sysdate(), 'ENABLED')")
	void saveChild(Comment menu);
			
	@Update("update comment set status='DELETED' where id=#{id}")
	void delete(@Param("id")Integer id);

}
