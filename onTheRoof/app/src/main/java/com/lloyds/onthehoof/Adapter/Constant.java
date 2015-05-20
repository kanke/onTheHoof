package com.lloyds.onthehoof.Adapter;

/**
 * Created by Ange on 19/05/15.
 */
public class Constant {

    public static final String DATABASE_NAME = "customersDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_1 = "Customers";
    public static final String CUSTOMER_NUM = "Customer Number";
    public static final String SORT_CODE = "sort_code";
    public static final String ACC_NUM = "acc_num";
    public static final String ROW_ID = "_id";
    public static final String DATABASE_CREATE = "CREATE TABLE if not exists " + TABLE_1 +
            "( " + ROW_ID + " integer primary key autoincrement, " +
            SORT_CODE + " text not null, " +
            ACC_NUM + " text not null);";
    /*public static final String DATABASE_CREATE2 = "CREATE TABLE " + TABLE_1 +
            "( " + ROW_ID + " integer primary key autoincrement, " +
            CUSTOMER_NUM + " text);"; */

    public static final String[] CUSTOMERS = {
            CUSTOMER_NUM, SORT_CODE, ACC_NUM, ROW_ID };
    public static final int customer1 = 1;
    public static final int customer2 = 2;

}
