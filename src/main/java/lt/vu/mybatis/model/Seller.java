package lt.vu.mybatis.model;

public class Seller {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SELLER.ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SELLER.NAME
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SELLER.ID
     *
     * @return the value of PUBLIC.SELLER.ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SELLER.ID
     *
     * @param id the value for PUBLIC.SELLER.ID
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SELLER.NAME
     *
     * @return the value of PUBLIC.SELLER.NAME
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SELLER.NAME
     *
     * @param name the value for PUBLIC.SELLER.NAME
     *
     * @mbg.generated Fri Mar 11 18:29:34 EET 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}