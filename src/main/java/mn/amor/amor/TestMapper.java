package mn.amor.amor;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
		
	
	@Select("select count(*) from menu")
	Integer toolAngilal();
		

}
