package com.hcyshmily.tx;

import java.util.List;

public interface Cashier {

    public void checkout(String username, List<String> isbns);
}
