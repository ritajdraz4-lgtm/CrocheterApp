package ritaj.d.crocheterapp.repositories;

public class CrochetRepository {
    private final MyTaskQuery taskQuery;//واجهة الاستعلامات
    private final LiveData<List<MyTask>> allTasks;//مبنى معطيات يحوي جميع المهلام المستخرجة


    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public TaskRepository(Application application) {
        AppDataBase db = AppDataBase.getDb(application);
        taskQuery = db.myTaskQuery();
        allTasks = taskQuery.getAllTasks();
    }

    /**
     * LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
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




 }
