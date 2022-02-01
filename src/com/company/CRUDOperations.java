package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDOperations {
    public Connection connect_to_db(String dbname, String user, String password){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/"+dbname,
                            user, password);

            if(conn != null){
                System.out.println("connection succesfull");
            } else{
                System.out.println("connection failed");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query="create table "+table_name+"(id SERIAL,name varchar(200),email varchar(200), level varchar(200),primary key(id));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn,String table_name,String name, String email, String level){
        Statement statement;
        try {
            String query=String.format("insert into %s(name,email, level) values('%s','%s','%s');",table_name,name,email,level);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("email")+" ");
                System.out.println(rs.getString("level"));

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void update_name(Connection conn,String table_name, String old_name,String new_name){
        Statement statement;
        try {
            String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_name(Connection conn, String table_name,String name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s where name= '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("email")+ " ");
                System.out.print(rs.getString("level"));


            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_id(Connection conn, String table_name,int id){
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s where id= %s",table_name,id);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("email")+ " ");
                System.out.print(rs.getString("level"));


            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_name(Connection conn,String table_name, String name){
        Statement statement;
        try{
            String query=String.format("delete from %s where name='%s'",table_name,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_id(Connection conn,String table_name, int id){
        Statement statement;
        try{
            String query=String.format("delete from %s where id= %s",table_name,id);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try {
            String query= String.format("drop table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
