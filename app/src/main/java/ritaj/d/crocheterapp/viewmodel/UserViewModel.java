package ritaj.d.crocheterapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ritaj.d.crocheterapp.model.MyUserTable.MyUser;
import ritaj.d.crocheterapp.repositories.UserRepository;

/**
 * نموذج عرض المستخدمين (UserViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بالمستخدمين (MyUser) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes) مثل دوران الشاشة،
 * ويتعامل مع {@link ritaj.d.crocheterapp.repositories.UserRepository} لتنفيذ العمليات المختلفة.
 */
public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final LiveData<List<MyUser>> allUsers;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (UserRepository) وجلب قائمة جميع المستخدمين الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllTasks();
    }

    /**
     * جلب جميع المستخدمين كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع المستخدمين محدثة تلقائياً.
     */
    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    /**
     * جلب مستخدم محدد بناءً على معرفه الفريد (User ID).
     *
     * @param keyId معرف المستخدم الفريد.
     * @return كائن المستخدم المطلوب.
     */
    public LiveData<List<MyUser>> getUserByKeyId(long keyId) {
        return repository.getTasksByUserId(keyId);
    }

    /**
     * جلب مستخدم محدد بناءً على الاسم الكامل.
     *
     * @param fullName الاسم الكامل للمستخدم.
     * @return كائن المستخدم المطلوب.
     */
    public LiveData<MyUser> getUserByFullName(String fullName) {
        return repository.getUserById(fullName);
    }

    /**
     * البحث عن المستخدمين الذين تتطابق إيميلاتهم مع النص المدخل.
     *
     * @param email الإيميل المراد البحث عنه.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByEmail(String email) {
        return repository.getTasksByTitle(email);
    }

    /**
     * البحث عن المستخدمين الذين تتطابق أرقام هواتفهم مع النص المدخل.
     *
     * @param phone رقم الهاتف المراد البحث عنه.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByPhone(String phone) {
        return repository.getTasksByDescription(phone);
    }

    /**
     * البحث عن المستخدمين الذين تتطابق كلمات مرورهم مع النص المدخل.
     *
     * @param passw كلمة المرور المراد البحث عنها.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByPassword(String passw) {
        return repository.getTasksByPriority(passw);
    }

    /**
     * جلب المستخدمين الذين يتطابق معرفهم مع اسم معين.
     *
     * @param keyId معرف المستخدم.
     * @param fullName الاسم الكامل للبحث.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByKeyIdAndFullName(long keyId, String fullName) {
        return repository.getTasksByUserIdAndTitle(keyId, fullName);
    }

    /**
     * إدراج مستخدم أو عدة مستخدمين جدد عبر المستودع.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insert(MyUser... users) {
        repository.insert(users);
    }

    /**
     * تحديث مستخدم أو عدة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد تحديثهم.
     */
    public void update(MyUser... users) {
        repository.update(users);
    }

    /**
     * تحديث بيانات مستخدم محدد (الاسم، الإيميل، الهاتف، وكلمة المرور) باستخدام معرف المستخدم.
     *
     * @param keyId    معرف المستخدم المراد تعديله.
     * @param fullName الاسم الكامل الجديد.
     * @param email    الإيميل الجديد.
     * @param phone    رقم الهاتف الجديد.
     * @param passw    كلمة المرور الجديدة.
     */
    public void updateUser(long keyId, String fullName, String email, String phone, String passw) {
        repository.updateTask(keyId, fullName, email, phone, passw);
    }

    /**
     * حذف مستخدم أو عدة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void delete(MyUser... users) {
        repository.delete(users);
    }

    /**
     * حذف مستخدم محدد باستخدام معرفه الفريد (User ID).
     *
     * @param keyId معرف المستخدم المراد حذفه.
     */
    public void deleteUserById(long keyId) {
        repository.deleteTaskById(keyId);
    }
}
