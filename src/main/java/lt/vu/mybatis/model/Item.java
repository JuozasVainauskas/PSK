package lt.vu.mybatis.model;

public class Item {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ITEM.ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ITEM.NAME
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ITEM.SELLER_ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    private Integer sellerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ITEM.ID
     *
     * @return the value of PUBLIC.ITEM.ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ITEM.ID
     *
     * @param id the value for PUBLIC.ITEM.ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ITEM.NAME
     *
     * @return the value of PUBLIC.ITEM.NAME
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ITEM.NAME
     *
     * @param name the value for PUBLIC.ITEM.NAME
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ITEM.SELLER_ID
     *
     * @return the value of PUBLIC.ITEM.SELLER_ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ITEM.SELLER_ID
     *
     * @param sellerId the value for PUBLIC.ITEM.SELLER_ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}