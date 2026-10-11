package ritaj.d.crocheterapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ritaj.d.crocheterapp.model.AppDataBase;
import ritaj.d.crocheterapp.model.MyUserTable.MyUser;
import ritaj.d.crocheterapp.model.MyUserTable.MyUserQuery;

public class UserRespository {
        private MyUserQuery userQuery;//واجهة الاستعلامات
        private LiveData<List<MyUser>> allUsers;//مبنى معطيات يحوي جميع المهلام المستخرجة


        /**
         * منشئ الكلاس (Constructor).
         * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
         *
         * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
         */
        public UserRespository(Application application) {
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
}

/**
 * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
 *
 * @param
public void updateUser(MyUser myUser) {
    userQuery.updateTask(myUser);
}






/**
 * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين.
public void updateTask(MyTask myTask)
{

taskQuery.updateTask(myTask);
}




