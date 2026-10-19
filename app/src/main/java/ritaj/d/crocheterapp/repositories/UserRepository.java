package ritaj.d.crocheterapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ritaj.d.crocheterapp.model.AppDataBase;
import ritaj.d.crocheterapp.model.MyTaskTable.MyTask;
import ritaj.d.crocheterapp.model.MyTaskTable.MyTaskQuery;
import ritaj.d.crocheterapp.model.MyUserTable.MyUser;
import ritaj.d.crocheterapp.model.MyUserTable.MyUserQuery;
public class UserRepository{
    private MyUserQuery userQuery;//واجهة الاستعلامات
        private LiveData<List<MyUser>> allUsers;//مبنى معطيات يحوي جميع المهلام المستخرجة



/**
 * منشئ الكلاس (Constructor).
 * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
 *
 * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
 */
public UserRepository(Application application) {
    AppDataBase db = AppDataBase.getDB(application);
    userQuery = db.getMyUserQuery();
    allUsers = MyUserQuery.getAllUsers();
}
/**
 *LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
 *
 * @return قائمة بجميع المهام المحدثة تلقائياً.
 */
public LiveData<List<MyUser>> getAllTasks() {
    return allUsers;
}


/**
 * جلب المهام المرتبطة بمعرف مستخدم معين (User ID).
 *
 * @param keyId معرف المستخدم المراد جلب مهامه.
 * @return قائمة المهام الخاصة بالمستخدم المحدد.
 */
public LiveData<List<MyUser>> getTasksByUserId(long keyId) {
    return userQuery.getUsersByKeyId(keyId);

}
/**
 * جلب مهمة معينة بناءً على معرفها الفريد (Task ID).
 *
 * @param fullName معرف المهمة الفريد.
 * @return كائن المهمة المطلوب.
 */
public LiveData<MyUser> getUserById(String fullName) {
    return userQuery.getUsersByfullName(fullName);
}


/**
 * البحث عن المهام التي تتطابق عناوينها مع النص المدخل.
 *
 * @param email النص أو الكلمة المراد البحث عنها في العنوان.
 * @return قائمة المهام المطابقة.
 */
public LiveData<List<MyUser>> getTasksByTitle(String email) {
    return userQuery.getUsersByemail(email);
}


/**
 * البحث عن المهام التي تتطابق أوصافها مع النص المدخل.
 *
 * @param phone النص أو الكلمة المراد البحث عنها في الوصف.
 * @return قائمة المهام المطابقة.
 */
public LiveData<List<MyUser>> getTasksByDescription( String phone) {
    return userQuery.getUsersByphone(phone);
}


/**
 * جلب المهام المفلترة حسب مستوى الأولوية.
 *
 * @param passw مستوى الأولوية المطلوب.
 * @return قائمة المهام ذات الأولوية المحددة.
 */
public LiveData<List<MyUser>> getTasksByPriority(String passw) {
    return userQuery.getUserBypassw(passw);
}


/**
 * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
 *
 * @param
 */
/**
 * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين.
 public void updateTask(MyTask myTask)
 {

 taskQuery.updateTask(myTask);
 }
 */

public LiveData<List<MyUser>> getTasksByUserIdAndTitle(long keyId, String fullname) {
    return userQuery.getUsersByKeyIdAndfullname(keyId, fullname);
}


/**
 * إدراج مهمة أو عدة مهمات جديدة في قاعدة البيانات.
 *
 * @param users المهام المراد إضافتها.
 */
public void insert(MyUser... users) {

    userQuery.insert(users);
}


/**
 * تحديث مهمة أو عدة مهمات في قاعدة البيانات.
 *
 * @param users المهام المراد تحديثها.
 */
public void update(MyUser... users) {

    userQuery.update(users);
}


/**
 * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
 *
 * @param keyId      معرف المهمة المراد تعديلها.
 * @param fullname       العنوان الجديد.
 * @param email الوصف الجديد.
 * @param phone    الأولوية الجديدة.
 * @param passw
 */
public void updateTask(long keyId, String fullname, String email, String phone, String passw) {
    userQuery.updateUser(keyId, fullname, email, phone, passw);
}


/**
 * حذف مهمة أو عدة مهمات من قاعدة البيانات.
 *
 * @param users المهام المراد حذفها.
 */
public void delete(MyUser... users) {
    userQuery.delete(users);
}


/**
 * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
 *
 * @param keyId معرف المهمة المراد حذفها.
 */
public void deleteTaskById(long keyId) {

    userQuery.deleteUserById(keyId);
}

}




