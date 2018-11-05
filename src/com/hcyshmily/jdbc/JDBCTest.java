package com.hcyshmily.jdbc;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    {
        ctx = new ClassPathXmlApplicationContext("jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = ctx.getBean(EmployeeDao.class);
        departmentDao = ctx.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    /**
     * 这个可以为参数取名字, 如果参数较多, 核对 ? 是件很麻烦的事情, 所以,用这种方法避免了排查的时候去核对,一目了然, 便于维护
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "insert into employees(last_name, email, dept_id) values(:ln,:email,:deptid)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ln", "FF");
        paramMap.put("email", "FF@173.com");
        paramMap.put("deptid", "2");
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 如果把具名参数的名字,改成好类对象的属性一致的话, 那么,就可以使用
     * .update(sql, parameterSource); 方法, 进行更新操作,
     *  1. SQL语句中的参数名和类的属性一直!
     *  2. 使用 SqlParameterSource 的  BeanPropertySqlParameterSource 实现类, 作为参数
     */
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "insert into employees(last_name, email, dept_id) values(:last_name,:email,:deptId)";

        Employee employee = new Employee();
        employee.setLast_name("XYZ");
        employee.setEmail("xyz@sina.com");
        employee.setdeptId(3);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }


    @Test
    public void testDepartmentDao() {
        System.out.println(departmentDao.get(1));
    }

    @Test
    public void testEmployeeDao() {
        System.out.println(employeeDao.get(2));
    }

    /**
     *  执行 insert, update, delete
     */
    @Test
    public void testUpdate() {
        String sql = "update employees set last_name= ? where id = ?";
        jdbcTemplate.update(sql, "Jack", 5);
    }


    /**
     * 从数据库中获取一条记录, 实际得到对应的一个对象
     *  注意: 是使用  queryForObject 方法,
     *  1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
     *  2. 使用SQL中列的别名完成列名和类的属性名的映射, 例如: last_name lastName
     *  3. 不支持级联属性, JdbcTemplate 到底是一个 JDBC的一个小工具,而不是 ORM框架
     */
    @Test
    public void testQueryForObject() {
        String sql = "select id, last_name, email, dept_id from employees where id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);

        System.out.println(employee);
    }


    /**
     * 查到实体类的集合
     */
    @Test
    public void testQueryForList() {
        String sql = "select id, last_name, email, dept_id from employees where id < 3";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper);

        System.out.println(employees);
    }


    /**
     * 获取单个列的值, 或做同级查询
     */
    @Test
    public void testQueryForObject2() {
        String sql = "select count(id) from employees";
        long count = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println("统计计数结果: " + count);
    }

    /**
     * 执行批量更新 : 批量 insert, update, delete
     *  最后一个参数是 Object[] 的 List 类型, 因为修改一条记录需要一个 Object的数组,
     *  多条就需要多个 Object的数组.
     */
    @Test
    public void testBathchUpdate() {
        String sql = "insert into employees(last_name, email, dept_id) values (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA", "aa@173.com", 1});
        batchArgs.add(new Object[]{"BB", "bb@173.com", 2});
        batchArgs.add(new Object[]{"CC", "cc@173.com", 3});
        batchArgs.add(new Object[]{"DD", "dd@173.com", 3});
        batchArgs.add(new Object[]{"EE", "ee@173.com", 2});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }


    /**
     * 连接测试
     * @throws SQLException
     */
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
