package com.hcyshmily.tx;

public interface BookShopDao {

    /**
     * 根据书号获取书的单价
     * @param isbn 书号
     * @return
     */
    public int findBookPriceByIsbn(String isbn);

    /**
     * 更新书的库存, 使书号对应的库存 -1
     * @param isbn 书号
     */
    public void updateBookStock(String isbn);

    /**
     * 更新用户的账户余额
     * @param username 用户名,
     * @param price 减少的价格
     */
    public void updateUserAccount(String username, int price);
}
