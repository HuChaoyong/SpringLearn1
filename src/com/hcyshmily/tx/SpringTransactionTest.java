package com.hcyshmily.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService;

    {
        ctx = new ClassPathXmlApplicationContext("tx.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 200);
    }

    @Test
    public void testBookShopDaoUpdateBookStock() {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoFindBookPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }
}
