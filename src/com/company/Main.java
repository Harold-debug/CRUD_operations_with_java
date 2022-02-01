package com.company;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        CRUDOperations db = new CRUDOperations();
        Connection conn = db.connect_to_db("student", "postgres", "galactic");
      /*  db.createTable(conn, "student");
        db.insert_row(conn,"student","harold","geumtchengh@gmail.com","degree");
        db.insert_row(conn,"student","kellydien","awasum@gmail.com","hnd");
        db.insert_row(conn,"student","debora","debora@gmail.com","degree");
        db.insert_row(conn,"student","hariata","hariata@gmail.com","diploma");*/

//        db.update_name(conn,"student","debora","mark");
//        db.search_by_name(conn,"student","harold");
//        db.search_by_id(conn,"student",2);
//        db.delete_row_by_name(conn,"student","harold");
       /* db.delete_row_by_id(conn,"student",1);
        db.delete_row_by_id(conn,"student",2);

        db.delete_row_by_id(conn,"student",3);

        db.delete_row_by_id(conn,"student",4);*/

        db.read_data(conn,"student");
//        db.delete_table(conn,"student");
    }
}
