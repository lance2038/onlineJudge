package com.haiyan.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    private final String USERNAME = "root";
    private final String PWD = "admin";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;
    private java.sql.PreparedStatement preparedStatement;
    private ResultSet resultset;
    private String URL = "jdbc:mysql://localhost:3306/mydb";

    public JDBCUtils() {
        try {
            Class.forName(DRIVER);
            System.out.println("注册驱动成功");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // 定义获得数据库的链接

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return connection;
    }

    /**
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public boolean updateByPrepareStatement(String sql, List<Object> params)
            throws SQLException {
        boolean flag = false;
        int result = -1;// 受影响的行数
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        result = preparedStatement.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }

    /**
     * 查询返回单条记录
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public Map<String, Object> findSimpleResult(String sql, List<Object> params)
            throws SQLException {
        Map<String, Object> map = new HashMap<String, Object>();
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultset = preparedStatement.executeQuery();// 返回查询结果
        ResultSetMetaData metaData = resultset.getMetaData();
        int col_len = metaData.getColumnCount();
        while (resultset.next()) {
            for (int i = 0; i < col_len; i++) {
                String col_name = metaData.getColumnName(i + 1);
                Object col_values = resultset.getObject(col_name);
                if (col_values == null) {
                    col_values = "";
                }
                map.put(col_name, col_values);
            }
        }
        return map;
    }

    /**
     * 查找多条记录
     *
     * @return
     */

    public List<Map<String, Object>> findMoreResultString(String sql,
                                                          List<Object> params) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultset = preparedStatement.executeQuery();// 返回查询结果
        ResultSetMetaData metaData = resultset.getMetaData();
        int col_len = metaData.getColumnCount();
        while (resultset.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < col_len; i++) {
                String col_name = metaData.getColumnName(i + 1);
                Object col_values = resultset.getObject(col_name);
                if (col_values == null) {
                    col_values = "";
                }
                map.put(col_name, col_values);
            }

            list.add(map);
        }

        return list;
    }

    // 利用反射机制

    /**
     * 通过反射机制访问数据库
     *
     * @param sql
     * @param params
     * @param cls
     * @return
     * @throws SQLException
     * @throws Exception
     * @throws IllegalAccessException
     */
    public <T> List<T> findMore(String sql, List<Object> params, Class<T> cls)
            throws SQLException, Exception {
        List<T> list = new ArrayList<T>();
        int index = 1;
        Object resultObject = null;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultset = preparedStatement.executeQuery();// 返回查询结果
        ResultSetMetaData metaData = resultset.getMetaData();
        int col_len = metaData.getColumnCount();
        while (resultset.next()) {
            resultObject = cls.newInstance();
            for (int i = 0; i < col_len; i++) {
                String col_name = metaData.getColumnName(i + 1);
                Object col_values = resultset.getObject(col_name);
                if (col_values == null) {
                    col_values = "";
                }
                Field field = cls.getDeclaredField(col_name);
                field.setAccessible(true);
                field.set(resultObject, col_values);
            }
            list.add((T) resultObject);
        }

        return list;
    }

    /**
     * 关闭数据库连接
     */
    public void releaseConnection() {

        if (resultset != null)
            try {
                resultset.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if (preparedStatement != null)
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    /**
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils();
        jdbcUtils.getConnection();


        /*
         * String sql = "insert into userinfo(username,pwd) values (?,?)";
         * List<Object> params = new ArrayList<Object>(); params.add("admin");
         * params.add("admin"); boolean flag =
         * jdbcUtils.updateByPrepareStatement(sql, params);
         * System.out.println(flag);
         */
        String sql = "select * from userinfo where id=?";
        String sql1 = "select * from userinfo";
        List<Object> params = new ArrayList<Object>();
		/*params.add(1);
		Map map = jdbcUtils.findSimpleResult(sql, params);

		try {
			List list = jdbcUtils.findMoreResultString(sql1, null);
			System.out.println(map);
			System.out.println(list);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConnection();
		}*/
        try {
            System.out.println("---fsdfas");
            List<Map> userlist = jdbcUtils.findMore(sql1, null, Map.class);
            System.out.println("---" + userlist);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.releaseConnection();
        }
    }
}

