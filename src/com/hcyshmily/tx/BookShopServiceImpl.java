package com.hcyshmily.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;


    // 添加事务注解

    /**
     *  添加事务注解以后,就会把整个处理过程当成一个事务, 如果其中任何一个报错,就会回滚
     *  propagation 指定事务的行为, 即当前事务方法被另外一个事务方法调用时,如何使用事务
     *  默认值是 REQUIRED, 即使用调用方法的事务
     *  REQUIRES_NEW使用自己的行为,自己的事务,即使用被调用方法的事务, 调用方法的事务会被暂停
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void purchase(String username, String isbn) {
        // 1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        // 2. 更新书的库存
        bookShopDao.updateBookStock(isbn);

        // 3. 更新用户的余额
        bookShopDao.updateUserAccount(username, price);
    }
}
