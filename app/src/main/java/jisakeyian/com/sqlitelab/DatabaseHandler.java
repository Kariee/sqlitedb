package jisakeyian.com.sqlitelab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ian James on 2017/11/01.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHandler";

    //db version
    private static final int DATABASE_VERSION =1;

    //db name
    private static final String DATABASE_NAME ="contactsManager";

    private static final String TABLE_CONTACTS ="contacts";
    private static final String TABLE_STUDENTS ="students";


    //contacts table
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone_Num";

    //students table
    //private static final String KEY_STUDENT_ADM = "admno";
    private static final String KEY_STUDENT_NAME = "S_name";
    private static final String KEY_STUDENT_COURSE ="S_course";

    private static final  String CREATE_CONTACTS_TABLE= "CREATE TABLE "+ TABLE_CONTACTS + "("+KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PHONE +" TEXT" + ")";
    private static final   String CREATE_STUDENTS_TABLE ="CREATE TABLE "+ TABLE_STUDENTS + "("+KEY_ID +" INTEGER PRIMARY KEY,"+ KEY_STUDENT_NAME +" TEXT,"+KEY_STUDENT_COURSE+ " TEXT" +")";



    public DatabaseHandler(Context context ) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_STUDENTS_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" +TABLE_CONTACTS );
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_STUDENTS );


        onCreate(db);
    }

    public  void addContacts(Contacts contacts){
        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contacts.getName());
        values.put(KEY_PHONE,contacts.getPhone());

        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }
    public Contacts getContacts(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] {
                KEY_ID, KEY_NAME, KEY_PHONE}, KEY_ID + "=?", new String[] {
                String. valueOf(id)} , null, null,null,null);

        if (cursor != null)
            cursor.moveToFirst();
        Contacts contacts = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
        return contacts;
    }


    public List<Contacts>getAllContacts(){
        List<Contacts> contactsList = new ArrayList<Contacts>();
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                Contacts contacts = new Contacts();
                contacts.setID(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhone(cursor.getString(2));

                contactsList.add( contacts);

            }while (cursor.moveToNext());
        }
        return contactsList;
    }
    public  int getContactsCount(){

        String countQuery="SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
    public  int updateContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PHONE, contacts.getPhone());

        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", new String[] { String.valueOf(contacts.getID())});
    }

    public void deleteContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?", new String[] { String.valueOf(contacts.getID())});
        db.close();
    }


    public  void addStudents(Students students){
        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_STUDENT_ADM, students.getId());
        values.put(KEY_STUDENT_NAME,students.getSName());
        values.put(KEY_STUDENT_COURSE,students.getCourse());

        db.insert(TABLE_STUDENTS,null,values);
        db.close();
    }
    public Students getStudents(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_STUDENTS, new String[] {
                KEY_ID, KEY_STUDENT_NAME, KEY_STUDENT_COURSE}, KEY_ID + "=?", new String[] {
                String. valueOf(id)} , null, null,null,null);

        if (cursor != null)
            cursor.moveToFirst();
        Students students = new Students(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
        return students;
    }


    public List<Students>getAllStudents(){
        List<Students> studentsList = new ArrayList<Students>();
        String selectQuery = "SELECT * FROM " + TABLE_STUDENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                Students students = new Students();
                students.setId(Integer.parseInt(cursor.getString(0)));
                students.setName(cursor.getString(1));
                students.setCourse(cursor.getString(2));

                studentsList.add( students);

            }while (cursor.moveToNext());
        }
        return studentsList;
    }
    public  int getStudentCount(){

        String countQuery="SELECT * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
    public  int UpdateStudents(Students students){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_STUDENT_ADM, students.getId());
        values.put(KEY_NAME, students.getSName());
        values.put(KEY_STUDENT_COURSE, students.getCourse());

        return db.update(TABLE_STUDENTS, values, KEY_ID + " = ?", new String[] { String.valueOf(students.getID())});
    }

    public void deleteStudent(Students students){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENTS, KEY_ID + " = ?", new String[] { String.valueOf(students.getID())});
        db.close();
    }
}

