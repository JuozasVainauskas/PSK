package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Seller;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface SellerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SELLER
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SELLER
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    int insert(Seller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SELLER
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    Seller selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SELLER
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    List<Seller> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SELLER
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    int updateByPrimaryKey(Seller record);
}