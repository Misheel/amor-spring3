package mn.amor.amor.modules.staticText;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StaticTextMapper {
	
	@Select("select * from static_text")
	List<StaticText> findAll();
	
	@Select("select * from static_text where id=#{id}")
	StaticText findById(@Param("id")Integer id);		
	
	@Select("select * from static_text where name=#{name}")
	StaticText findByName(@Param("name")String name);
	
	@Insert("insert into static_text values(null, #{name}, null)")
	void save(StaticText form);
	
	@Update("update static_text set text=#{text} where id=#{id}")
	void update(StaticText form);
	
	@Delete("delete from static_text where id=#{id}")
	void delete(@Param("id")Integer id);

}
