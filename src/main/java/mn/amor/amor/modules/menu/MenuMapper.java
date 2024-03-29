package mn.amor.amor.modules.menu;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MenuMapper {
	
	@Select("select * from menu left join menu_category on menu.categoryId = menu_category.id where menu.status='ENABLED' and menu.parentId is null  and menu_category.name = #{categoryName} order by menu.ordering")
	List<Menu> findAllByCategoryName(@Param("categoryName")String categoryName);
	
	@Select("select * from menu where categoryId = #{categoryId} and status = 'ENABLED' and parentId is null order by ordering")
	List<Menu> findAllByCategoryId(@Param("categoryId")Integer categoryId);
	
	@Select("select * from menu where parentId = #{parentId} and status = 'ENABLED' order by ordering")
	List<Menu> findAllByParentId(@Param("parentId")Integer parentId);
	
	@Select("select * from menu where id=#{id}")
	Menu findById(@Param("id")Integer id);		
	
	@Insert("insert into menu values(null, #{categoryId}, #{name}, #{link}, #{target}, #{hasChildren}, #{parentId}, #{ordering}, #{status})")
	void save(Menu menu);
	
	@Update("update menu set name=#{name}, link=#{link}, target=#{target}, hasChildren=#{hasChildren} where id=#{id}")
	void update(Menu menu);
	
	@Update("update menu set ordering=#{ordering} where id=#{id}")
	void changeOrdering(@Param("id")Integer id, @Param("ordering")Integer ordering);
	
	@Update("update menu set status='DELETED' where id=#{id}")
	void delete(@Param("id")Integer id);

}
