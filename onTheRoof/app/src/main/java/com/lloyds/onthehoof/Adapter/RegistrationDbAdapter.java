package com.lloyds.onthehoof.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.lloyds.onthehoof.database.DatabaseHelper;

/**
 * Created by Ange on 19/05/15.
 */
public class RegistrationDbAdapter {

    private static final String DATABASE_TABLE = "Customers";
    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_CUSTOMER_NUM = "customer_num";
    public static final String KEY_SORT_CODE = "sort_code";
    public static final String KEY_ACC_NUM = "acc_num";

    SQLiteDatabase myDb;
    Context myContext;
    DatabaseHelper mDbHelper;

    public RegistrationDbAdapter(Context context)	{
        this.myContext = context;
    }

    public RegistrationDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(myContext);
        myDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close()	{
        mDbHelper.close();
    }

    public long registerWithSrtCode(String sort_code, String acc_num)	{
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_SORT_CODE, sort_code);
        initialValues.put(KEY_ACC_NUM, acc_num);

        return myDb.insert(DATABASE_TABLE, null, initialValues);
    }

    /*
    public long registerWithCustNum(String cust_Num)	{
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_SORT_CODE, cust_Num);

        return myDb.insert(DATABASE_TABLE, null, initialValues);
    } */

    public boolean Login(String sort_code, String acc_num) throws SQLException	{
        Cursor mCursor = myDb.rawQuery("SELECT * FROM " + DATABASE_TABLE +
                " WHERE sort_code=? AND acc_num=?", new String[]{sort_code,acc_num});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }
}
