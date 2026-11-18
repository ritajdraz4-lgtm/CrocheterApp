package ritaj.d.crocheterapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ritaj.d.crocheterapp.model.MyCrochetTable.Hook;
import ritaj.d.crocheterapp.model.MyCrochetTable.pattern;
import ritaj.d.crocheterapp.model.MyCrochetTable.Yarn;
import ritaj.d.crocheterapp.repositories.CrochetRepository;

/**
 * نموذج عرض أدوات الحياكة (CrochetViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بأدوات الحياكة (Hook, Yarn, Pattern) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes) مثل دوران الشاشة،
 * ويتعامل مع {@link ritaj.d.crocheterapp.repositories.CrochetRepository} لتنفيذ العمليات المختلفة.
 */
public class CrochetViewModel extends AndroidViewModel {
    private final CrochetRepository repository;
    private final LiveData<List<Hook>> allHooks;
    private final LiveData<List<Yarn>> allYarns;
    private final LiveData<List<pattern>> allPatterns;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (CrochetRepository) وجلب القوائم الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public CrochetViewModel(@NonNull Application application) {
        super(application);
        repository = new CrochetRepository(application);
        allHooks = repository.getAllHooks();
        allYarns = repository.getAllYarns();
        allPatterns = repository.getAllPatterns();
    }

    // ========== عمليات السنانير (Hooks) ==========

    /**
     * جلب جميع السنانير كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع السنانير محدثة تلقائياً.
     */
    public LiveData<List<Hook>> getAllHooks() {
        return allHooks;
    }

    /**
     * إضافة سنارة جديدة.
     *
     * @param hook السنارة المراد إضافتها.
     */
    public void insertHook(Hook hook) {
        repository.insertHook(hook);
    }

    /**
     * تعديل سنارة موجودة.
     *
     * @param hook السنارة المراد تعديلها.
     */
    public void updateHook(Hook hook) {
        repository.updateHook(hook);
    }

    /**
     * حذف سنارة.
     *
     * @param hook السنارة المراد حذفها.
     */
    public void deleteHook(Hook hook) {
        repository.deleteHook(hook);
    }

    /**
     * جلب السنانير حسب الحجم.
     *
     * @param size حجم السنارة.
     * @return قائمة السنانير بالحجم المحدد.
     */
    public LiveData<List<Hook>> getHooksBySize(String size) {
        return repository.getHooksBySize(size);
    }

    // ========== عمليات الخيوط (Yarns) ==========

    /**
     * جلب جميع الخيوط كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع الخيوط محدثة تلقائياً.
     */
    public LiveData<List<Yarn>> getAllYarns() {
        return allYarns;
    }

    /**
     * إضافة خيط جديد.
     *
     * @param yarn الخيط المراد إضافته.
     */
    public void insertYarn(Yarn yarn) {
        repository.insertYarn(yarn);
    }

    /**
     * تعديل خيط موجود.
     *
     * @param yarn الخيط المراد تعديله.
     */
    public void updateYarn(Yarn yarn) {
        repository.updateYarn(yarn);
    }

    /**
     * حذف خيط.
     *
     * @param yarn الخيط المراد حذفه.
     */
    public void deleteYarn(Yarn yarn) {
        repository.deleteYarn(yarn);
    }

    /**
     * جلب الخيوط حسب اللون.
     *
     * @param color لون الخيط.
     * @return قائمة الخيوط باللون المحدد.
     */
    public LiveData<List<Yarn>> getYarnsByColor(String color) {
        return repository.getYarnsByColor(color);
    }

    /**
     * جلب الخيوط حسب النوع.
     *
     * @param type نوع الخيط (قطن، صوف، أكريليك).
     * @return قائمة الخيوط بالنوع المحدد.
     */
    public LiveData<List<Yarn>> getYarnsByType(String type) {
        return repository.getYarnsByType(type);
    }

    /**
     * تحديث عدد الكباكيب لخيط معين.
     *
     * @param yarnId معرف الخيط.
     * @param newCount العدد الجديد للكباكيب.
     */
    public void updateSkeinCount(int yarnId, int newCount) {
        repository.updateSkeinCount(yarnId, newCount);
    }

    // ========== عمليات الباترونات (Patterns) ==========

    /**
     * جلب جميع الباترونات كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع الباترونات محدثة تلقائياً.
     */
    public LiveData<List<pattern>> getAllPatterns() {
        return allPatterns;
    }

    /**
     * إضافة باترون جديد.
     *
     * @param pattern الباترون المراد إضافته.
     */
    public void insertPattern(pattern pattern) {
        repository.insertPattern(pattern);
    }

    /**
     * تعديل باترون موجود.
     *
     * @param pattern الباترون المراد تعديله.
     */
    public void updatePattern(pattern pattern) {
        repository.updatePattern(pattern);
    }

    /**
     * حذف باترون.
     *
     * @param pattern الباترون المراد حذفه.
     */
    public void deletePattern(pattern pattern) {
        repository.deletePattern(pattern);
    }

    /**
     * جلب الباترونات حسب الموضوع (مدرسة، شتاء، صيف، هدايا).
     *
     * @param topic الموضوع المطلوب.
     * @return قائمة الباترونات بالموضوع المحدد.
     */
    public LiveData<List<pattern>> getPatternsByTopic(String topic) {
        return repository.getPatternsByTopic(topic);
    }

    /**
     * جلب الباترونات حسب مستوى الصعوبة.
     *
     * @param difficultyLevel مستوى الصعوبة (مبتدئ، متوسط، متقدم).
     * @return قائمة الباترونات بمستوى الصعوبة المحدد.
     */
    public LiveData<List<pattern>> getPatternsByDifficulty(String difficultyLevel) {
        return repository.getPatternsByDifficulty(difficultyLevel);
    }

    /**
     * البحث العام في الباترونات (بالاسم أو الوصف).
     *
     * @param searchTerm كلمة البحث.
     * @return قائمة الباترونات المطابقة.
     */
    public LiveData<List<pattern>> searchPatterns(String searchTerm) {
        return repository.searchPatterns(searchTerm);
    }

    // ========== دوال منطقية متقدمة ==========

    /**
     * جلب الباترونات المناسبة للخيط المتوفر عند المستخدم.
     * تعتمد على نوع الخيط، وزنه، وعدد الكباكيب المتوفرة.
     *
     * @param yarnType نوع الخيط المتوفر.
     * @param yarnWeight وزن الخيط المتوفر.
     * @param availableSkeins عدد الكباكيب المتوفرة.
     * @return قائمة الباترونات المناسبة.
     */
    public LiveData<List<pattern>> getPatternsBasedOnMyYarn(String yarnType, String yarnWeight, int availableSkeins) {
        return repository.getPatternsBasedOnMyYarn(yarnType, yarnWeight, availableSkeins);
    }

    /**
     * جلب الباترونات المناسبة للخيط المتوفر مع مراعاة اللون أيضاً.
     *
     * @param yarnType نوع الخيط المتوفر.
     * @param yarnWeight وزن الخيط المتوفر.
     * @param availableSkeins عدد الكباكيب المتوفرة.
     * @param color اللون المتوفر.
     * @return قائمة الباترونات المناسبة.
     */
    public LiveData<List<pattern>> getPatternsBasedOnMyYarnWithColor(String yarnType, String yarnWeight, int availableSkeins, String color) {
        return repository.getPatternsBasedOnMyYarnWithColor(yarnType, yarnWeight, availableSkeins, color);
    }

    /**
     * اقتراح مشروع حياكة بناءً على المخزون المتوفر.
     * هذه الدالة تجمع المعلومات من الخيوط والسنانير وتقترح باترونات مناسبة.
     *
     * @return قائمة الباترونات المقترحة.
     */
    public LiveData<List<pattern>> suggestProject() {
        return repository.suggestProject();
    }
}
