package com.hcyshmily.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    // xml中无法使用 tx命名空间 ,所有的 @Transactional 事务注解都无法测试和使用

    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn: isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
