package ritaj.d.crocheterapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ritaj.d.crocheterapp.model.AppDataBase;
import ritaj.d.crocheterapp.model.MyTaskTable.MyTask;
import ritaj.d.crocheterapp.model.MyTaskTable.MyTaskQuery;
import ritaj.d.crocheterapp.model.MyUserTable.MyUser;
import ritaj.d.crocheterapp.model.MyUserTable.MyUserQuery;
/* مستودع المهام (MyTask) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المهام (TaskRepository).
        * يقوم بفصل قاعدة بيانات
* Room  و {@link MyTaskQuery}
        * عن بقية أجزاء التطبيق (ViewModels).
        */

public class TaskRespository {
    private  MyTaskQuery taskQuery;//واجهة الاستعلامات
    private  LiveData<List<MyTask>> allTasks;//مبنى معطيات يحوي جميع المهام المستخرجة


    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public TaskRespository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        taskQuery = db.getMyTaskQuery();
        allTasks = (LiveData<List<MyTask>>) taskQuery.getAllTasks();
    }
    /**
     *LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع المهام المحدثة تلقائياً.
     */
    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }


    /**
     * جلب المهام المرتبطة بمعرف مستخدم معين (User ID).
     *
     * @param userId معرف المستخدم المراد جلب مهامه.
     * @return قائمة المهام الخاصة بالمستخدم المحدد.
     */
    public LiveData<List<MyTask>> getTasksByUserId(long userId) {
        return taskQuery.getTasksByUserId(userId);


    }
    /**
     * جلب مهمة معينة بناءً على معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة الفريد.
     * @return كائن المهمة المطلوب.
     */
    public LiveData<MyTask> getTaskById(long taskId) {

        return taskQuery.getTaskById(taskId);
    }


    /**
     * البحث عن المهام التي تتطابق عناوينها مع النص المدخل.
     *
     * @param title النص أو الكلمة المراد البحث عنها في العنوان.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByTitle(String title) {
        return taskQuery.getTasksByTitle(title);
    }


    /**
     * البحث عن المهام التي تتطابق أوصافها مع النص المدخل.
     *
     * @param description النص أو الكلمة المراد البحث عنها في الوصف.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByDescription(String description) {
        return taskQuery.getTasksByDescription(description);
    }


    /**
     * جلب المهام المفلترة حسب مستوى الأولوية.
     *
     * @param priority مستوى الأولوية المطلوب.
     * @return قائمة المهام ذات الأولوية المحددة.
     */
    public LiveData<List<MyTask>> getTasksByPriority(int priority) {
        return taskQuery.getTasksByPriority(priority);
    }


    /**
     * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين.
     *
     * @param userId معرف المستخدم.
     * @param title  عنوان المهمة للبحث.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title) {
        return taskQuery.getTasksByUserIdAndTitle(userId, title);
    }


    /**
     * إدراج مهمة أو عدة مهمات جديدة في قاعدة البيانات.
     *
     * @param tasks المهام المراد إضافتها.
     */
    public void insert(MyTask... tasks) {
        taskQuery.insert(tasks);
    }


    /**
     * تحديث مهمة أو عدة مهمات في قاعدة البيانات.
     *
     * @param tasks المهام المراد تعديلها.
     */
    public void update(MyTask... tasks) {
        taskQuery.update(tasks);
    }


    /**
     * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
     * @param myTask المهمة التي نريد تحديثها
     */
    public void updateTask(MyTask myTask)
    {

        taskQuery.updateTask(myTask);
    }


    /**
     * حذف مهمة أو عدة مهمات من قاعدة البيانات.
     *
     * @param tasks المهام المراد حذفها.
     */
    public void delete(MyTask... tasks) {
        taskQuery.delete(tasks);
    }


    /**
     * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة المراد حذفها.
     */
    public void deleteTaskById(long taskId) {

        taskQuery.deleteTaskById(taskId);

    }

    public class userRespository { private MyUserQuery userQuery;//واجهة الاستعلامات
        private LiveData<List<MyUser>> allUsers;//مبنى معطيات يحوي جميع المهلام المستخرجة


        /**
         * منشئ الكلاس (Constructor).
         * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
         *
         * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
         */
        public void TaskRespository(Application application) {
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
}






