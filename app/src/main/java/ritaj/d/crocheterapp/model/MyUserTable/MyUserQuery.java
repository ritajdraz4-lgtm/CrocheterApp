package ritaj.d.crocheterapp.model.MyUserTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface MyUserQuery {
    //استخراج جميع المستعملين
    @Query("SELECT * FROM MyUser")
    LiveData<List<MyUser>> getAll();
    // استخراج مستعمل حسب رقم المميز لهid
    @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
    List<MyUser> loadAllByIds(int[] userIds);
    //هل المستعمل موجود حسب الايميل وكلمة السر
    @Query("SELECT * FROM MyUser WHERE email = :myEmail AND passw = :myPassw LIMIT 1")
    MyUser checkEmailPassw(String myEmail, String myPassw);
    //فحص هل الايميل موجود من قبل
    @Query("SELECT * FROM MyUser WHERE email = :myEmail LIMIT 1")
    MyUser checkEmail(String myEmail);
    @Insert
// اضافة مستعمل او مجموعة مستعملين
    void insertAll(MyUser... users);
    @Delete
// حذف
    void delete(MyUser... users);
    //حذف حسب الرقم المميز id
    @Query("DELETE FROM MyUser WHERE keyid = :id")
    void deleteById(int id);
    @Insert//اضافة مستعمل واحد
    void insert(MyUser myUser);
    @Update//تعديل مستعمل او قائمة مستعملين
    void update(MyUser...values);
    @Query("SELECT * FROM MyUser WHERE keyid = :userId")
    LiveData<List<MyUser>> getUsersByUserId(long userId);
    @Query("SELECT * FROM MyUser WHERE keyid = :keyId")
    LiveData<List<MyUser>> getUsersByKeyId(long keyId);
    @Query("SELECT * FROM MyUser WHERE full_Name = :fullName")
    LiveData<MyUser> getUsersByfullName(String fullName);
    @Query("SELECT * FROM MyUser WHERE email = :email")
    LiveData<List<MyUser>> getUsersByemail(String email);
    @Query("SELECT * FROM MyUser WHERE phone = :phone")
    LiveData<List<MyUser>> getUsersByphone(String phone);
    @Query("SELECT * FROM MyUser WHERE passw = :passw")
    LiveData<List<MyUser>> getUserBypassw(String passw);

    @Query("DELETE FROM MyUser WHERE keyid = :keyId")
    void deleteUserById(long keyId);


    @Query("UPDATE MyUser SET full_Name = :fullname, email = :email, phone = :phone, passw = :passw WHERE keyid = :keyId")
    void updateUser(long keyId, String fullname, String email, String phone, String passw);

    @Query("SELECT * FROM MyUser WHERE keyid = :keyId AND full_Name = :fullname")
    LiveData<List<MyUser>> getUsersByKeyIdAndfullname(long keyId, String fullname);
}







