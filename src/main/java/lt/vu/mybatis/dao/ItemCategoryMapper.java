package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.ItemCategory;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ItemCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM_CATEGORY
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    int insert(ItemCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM_CATEGORY
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    List<ItemCategory> selectAll();
}