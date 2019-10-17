package oes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public login() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");//请求获取用户名username的值
        String password = request.getParameter("password");//请求获取密码password的值
        String DBURL = "jdbc:mysql://localhost:3306/oes";//数据库mysql的地址
        String DBName = "root";
        String DBPwd = "123456";

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");//加载mysql驱动
                conn = DriverManager.getConnection(DBURL,DBName,DBPwd);//连接数据库
                st = conn.prepareStatement("SELETE*FROM oes.user WHERE username = ?");
                st.setString(1, username);
                //st = conn.createStatement();//创建Statement对象
                String sql="SELECT*FROM user WHERE username='"+username+"' and password='"+password+"'";//sql语句，搜索这个username和password在数据库是否存在
                rs = st.executeQuery(sql);//运行sql语句，并把得到的结果放入结果集ResultSet中
                if(rs.next()){
                    request.setAttribute("username",username);//设置一个username，将后面username其内容赋值给前面一个username，以便下一个页面使用
                    request.getRequestDispatcher("login_success.jsp").forward(request,response);//跳转到页面login_success.jsp
                }else{
                    request.setAttribute("error", "用户名或密码错误！！！");//设置一个error，将后面的字赋给这个error，以便下一个跳转页面的使用，request的作用域有限
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            //5：close释放资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
