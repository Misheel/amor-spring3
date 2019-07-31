package mn.amor.amor.modules.menuCategory;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MenuCategoryMapper {
	
	@Select("select * from menu_category")
	List<MenuCategory> findAll();
	
	@Select("select * from menu_category where id=#{id}")
	MenuCategory findById(@Param("id")Integer id);		
	
	@Select("select * from menu_category where name=#{name}")
	MenuCategory findByName(@Param("name")String name);
	
	@Insert("insert into menu_category values(null, #{name}, 'ENABLED')")
	void save(MenuCategoryForm form);
	
	@Update("update menu_category set name=#{name} where id=#{id}")
	void update(@Param("id")Integer id, MenuCategoryForm form);
	
	@Update("update menu_category set status='DELETED' where id=#{id}")
	void delete(@Param("id")Integer id);

}
