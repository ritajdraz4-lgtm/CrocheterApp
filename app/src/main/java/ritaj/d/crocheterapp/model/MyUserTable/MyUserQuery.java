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
    static LiveData<List<MyUser>> getAllUsers() {
    } //استخراج جميع المستعملين
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAll();
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
    void delete(MyUser user);
    //حذف حسب الرقم المميز id
    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);
    @Insert//اضافة مستعمل واحد
    void insert(MyUser myUser);
    @Update//تعديل مستعمل او قائمة مستعملين
    void update(MyUser...values);

    LiveData<List<MyUser>> getUsersByUserId(long userId);

    LiveData<List<MyUser>> getUsersByKeyId(long keyId);

    LiveData<MyUser> getUsersByfullName(String fullName);

    LiveData<List<MyUser>> getUsersByemail(String email);

    LiveData<List<MyUser>> getUsersByphone(String phone);

    LiveData<List<MyUser>> getUserBypassw(String passw);
}







