package me.panpf.tool4a.sample

import android.os.Bundle
import com.google.gson.Gson
import me.panpf.tool4a.sample.fragment.CheckAdapterSampleFragment
import me.panpf.tool4a.sample.fragment.EntryFragment
import me.panpf.tool4a.sample.fragment.EntryFragment.EntryItem
import java.util.*

@BindContentView(R.layout.activity_main)
class MainActivity : MyActivity() {

    override fun onInitViews(savedInstanceState: Bundle?) {

    }

    override fun onInitData(savedInstanceState: Bundle?) {
        val fragment = EntryFragment()
        val bundle = Bundle()
        bundle.putString(EntryFragment.PARAM_STRING_JSON_ENTRY_ITEM, Gson().toJson(generateMainEntryItem()))
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_content, fragment)
        transaction.commitAllowingStateLoss()
    }

    override fun onLoadData(savedInstanceState: Bundle?) {

    }

    private fun generateMainEntryItem(): EntryItem {
        val entryItems = ArrayList<EntryItem>()

        entryItems.add(generateAppEntry())
        entryItems.add(generateContentEntry())
        entryItems.add(generateContentPmEntry())
        entryItems.add(generateContentResEntry())
        entryItems.add(generateGraphicsEntry())
        entryItems.add(generateGraphicsDrawableEntry())
        entryItems.add(generateHardwareEntry())
        entryItems.add(generateHardwareCameraEntry())
        entryItems.add(generateNetEntry())
        entryItems.add(generateOsEntry())
        entryItems.add(generateOsStorageEntry())
        entryItems.add(generatePreferenceEntry())
        entryItems.add(generateProviderEntry())
        entryItems.add(generateUtilEntry())
        entryItems.add(generateViewEntry())
        entryItems.add(generateViewAnimationEntry())
        entryItems.add(generateViewInputmethodEntry())
        entryItems.add(generateWebkitEntry())
        entryItems.add(generateWidgetEntry())

        return EntryItem(resources.getString(R.string.app_name), null, entryItems)
    }

    private fun generateAppEntry(): EntryItem {
        val appItems = ArrayList<EntryItem>()
        appItems.add(EntryItem("DialogUtils", null))
        appItems.add(EntryItem("DownloadManagerUtils", null))
        appItems.add(EntryItem("FragmentBuilder", null))
        appItems.add(EntryItem("FragmentListPagerAdapter", null))
        appItems.add(EntryItem("FragmentUtils", null))
        appItems.add(EntryItem("MessageDialogFragment", null))
        appItems.add(EntryItem("ProgressDialogFragment", null))
        appItems.add(EntryItem("SimpleFragmentPagerAdapter", null))
        appItems.add(EntryItem("SimpleFragmentStatePagerAdapter", null))
        return EntryItem("app", EntryFragment::class.java, appItems)
    }

    private fun generateContentEntry(): EntryItem {
        val contentItems = ArrayList<EntryItem>()
        contentItems.add(EntryItem("BroadcastUtils", null))
        contentItems.add(EntryItem("ContentUtils", null))
        contentItems.add(EntryItem("FileUtils", null))
        contentItems.add(EntryItem("IntentUtils", null))
        contentItems.add(EntryItem("LaunchAppReceiver", null))
        contentItems.add(EntryItem("UriUtils", null))
        return EntryItem("content", EntryFragment::class.java, contentItems)
    }

    private fun generateContentPmEntry(): EntryItem {
        val contentPmItems = ArrayList<EntryItem>()
        contentPmItems.add(EntryItem("VersionManager", null))
        return EntryItem("content.pm", EntryFragment::class.java, contentPmItems)
    }

    private fun generateContentResEntry(): EntryItem {
        val contentResItems = ArrayList<EntryItem>()
        contentResItems.add(EntryItem("AssetUtils", null))
        contentResItems.add(EntryItem("DimenUtils", null))
        return EntryItem("content.res", EntryFragment::class.java, contentResItems)
    }

    private fun generateGraphicsEntry(): EntryItem {
        val graphicsItems = ArrayList<EntryItem>()
        graphicsItems.add(EntryItem("BitmapDecoder", null))
        graphicsItems.add(EntryItem("BitmapUtils", null))
        graphicsItems.add(EntryItem("Colors", null))
        graphicsItems.add(EntryItem("ImageProcessor", null))
        graphicsItems.add(EntryItem("RectUtils", null))
        graphicsItems.add(EntryItem("TextUtils", null))
        return EntryItem("graphics", EntryFragment::class.java, graphicsItems)
    }

    private fun generateGraphicsDrawableEntry(): EntryItem {
        val graphicsDrawableItems = ArrayList<EntryItem>()
        graphicsDrawableItems.add(EntryItem("DrawableLevelController", null))
        return EntryItem("graphics.drawable", EntryFragment::class.java, graphicsDrawableItems)

    }

    private fun generateHardwareEntry(): EntryItem {
        val hardwareItems = ArrayList<EntryItem>()
        hardwareItems.add(EntryItem("DeviceUtils", null))
        return EntryItem("hardware", EntryFragment::class.java, hardwareItems)
    }

    private fun generateHardwareCameraEntry(): EntryItem {
        val hardwareCameraItems = ArrayList<EntryItem>()
        hardwareCameraItems.add(EntryItem("BasePreviewAndPictureSizeCalculator", null))
        hardwareCameraItems.add(EntryItem("BestPreviewSizeCalculator", null))
        hardwareCameraItems.add(EntryItem("CameraManager", null))
        hardwareCameraItems.add(EntryItem("CameraUtils", null))
        hardwareCameraItems.add(EntryItem("LoopFocusManager", null))
        return EntryItem("hardware.camera", EntryFragment::class.java, hardwareCameraItems)
    }

    private fun generateNetEntry(): EntryItem {
        val netItems = ArrayList<EntryItem>()
        netItems.add(EntryItem("NetworkUtils", null))
        return EntryItem("net", EntryFragment::class.java, netItems)
    }

    private fun generateOsEntry(): EntryItem {
        val osItems = ArrayList<EntryItem>()
        osItems.add(EntryItem("OSUtils", null))
        osItems.add(EntryItem("SDCardUtils", null))
        osItems.add(EntryItem("StatFsCompat", null))
        return EntryItem("os", EntryFragment::class.java, osItems)
    }

    private fun generateOsStorageEntry(): EntryItem {
        val osItems = ArrayList<EntryItem>()
        osItems.add(EntryItem("StorageUtils", null))
        return EntryItem("os.storage", EntryFragment::class.java, osItems)
    }

    private fun generatePreferenceEntry(): EntryItem {
        val preferenceItems = ArrayList<EntryItem>()
        preferenceItems.add(EntryItem("PreferencesUtils", null))
        return EntryItem("preference", EntryFragment::class.java, preferenceItems)
    }

    private fun generateProviderEntry(): EntryItem {
        val providerItems = ArrayList<EntryItem>()
        providerItems.add(EntryItem("PhoneUtils", null))
        providerItems.add(EntryItem("SettingsUtils", null))
        return EntryItem("provider", EntryFragment::class.java, providerItems)
    }

    private fun generateUtilEntry(): EntryItem {
        val utilItems = ArrayList<EntryItem>()
        utilItems.add(EntryItem("ALog", null))
        utilItems.add(EntryItem("Countdown", null))
        utilItems.add(EntryItem("DoubleClickExitDetector", null))
        utilItems.add(EntryItem("InputVerifyUtils", null))
        utilItems.add(EntryItem("LoopTimer", null))
        utilItems.add(EntryItem("MessageDigestUtils", null))
        utilItems.add(EntryItem("OtherUtils", null))
        utilItems.add(EntryItem("RebootThreadExceptionHandler", null))
        return EntryItem("util", EntryFragment::class.java, utilItems)
    }

    private fun generateViewEntry(): EntryItem {
        val viewItems = ArrayList<EntryItem>()
        viewItems.add(EntryItem("ViewListPagerAdapter", null))
        viewItems.add(EntryItem("ViewRefreshHandler", null))
        viewItems.add(EntryItem("ViewUtils", null))
        viewItems.add(EntryItem("WindowUtils", null))
        return EntryItem("view", EntryFragment::class.java, viewItems)
    }

    private fun generateViewAnimationEntry(): EntryItem {
        val viewanimationItems = ArrayList<EntryItem>()
        viewanimationItems.add(EntryItem("AnimationUtils", null))
        viewanimationItems.add(EntryItem("ViewAnimationUtils", null))
        return EntryItem("view.animation", EntryFragment::class.java, viewanimationItems)

    }

    private fun generateViewInputmethodEntry(): EntryItem {
        val viewInputmethodItems = ArrayList<EntryItem>()
        viewInputmethodItems.add(EntryItem("InputMethodUtils", null))
        return EntryItem("view.inputmethod", EntryFragment::class.java, viewInputmethodItems)
    }

    private fun generateWebkitEntry(): EntryItem {
        val webkitItems = ArrayList<EntryItem>()
        webkitItems.add(EntryItem("WebViewManager", null))
        return EntryItem("webkit", EntryFragment::class.java, webkitItems)
    }

    private fun generateWidgetEntry(): EntryItem {
        val widgetItems = ArrayList<EntryItem>()
        widgetItems.add(EntryItem("CheckAdapter", CheckAdapterSampleFragment::class.java))
        widgetItems.add(EntryItem("DepthPageTransformer", null))
        widgetItems.add(EntryItem("NestedGridView", null))
        widgetItems.add(EntryItem("NestedListView", null))
        widgetItems.add(EntryItem("ToastUtils", null))
        widgetItems.add(EntryItem("ViewAdapter", null))
        widgetItems.add(EntryItem("ZoomOutPageTransformer", null))
        return EntryItem("widget", EntryFragment::class.java, widgetItems)
    }
}
