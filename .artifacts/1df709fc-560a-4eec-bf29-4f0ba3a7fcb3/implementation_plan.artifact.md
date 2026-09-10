# Implementation Plan - Project Analysis and Error Correction

I have performed a thorough analysis of the project codebase and found two major underlying issues that need correction:

1. **ViewPager2 Crash (`IllegalStateException`)**:
   - **Problem**: `ImageAdapter.kt` constructs the item layouts programmatically. When doing so, the root `LinearLayout`'s layout parameters can be overridden or incorrectly converted by `RecyclerView`, causing `ViewPager2` to throw the "Pages must fill the whole ViewPager2" error.
   - **Solution**: Refactor `ImageAdapter.kt` to inflate the existing `item_carousel.xml` using `LayoutInflater`. This is the standard Android practice and guarantees the correct `RecyclerView.LayoutParams` are generated with `match_parent` width and height.

2. **Missing Permissions in Manifest**:
   - **Problem**: `MainActivity4.java` utilizes Google Play Services Location APIs (`ACCESS_FINE_LOCATION` and `ACCESS_COARSE_LOCATION`) and a `WebView` for maps, but none of these permissions are declared in `AndroidManifest.xml`. This causes runtime failures or denies access instantly.
   - **Solution**: Add `<uses-permission>` tags for `ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`, and `INTERNET` into `AndroidManifest.xml`.

---

## Proposed Changes

### [app]

#### [MODIFY] [ImageAdapter.kt](file:///Users/senai/AndroidStudioProjects/EpicGmes/app/src/main/java/com/example/epicgmes/ImageAdapter.kt)
- Update `onCreateViewHolder` to inflate `R.layout.item_carousel`.
- Extract `imageView` and `textViewPreco` using `findViewById` from the inflated view.

#### [MODIFY] [AndroidManifest.xml](file:///Users/senai/AndroidStudioProjects/EpicGmes/app/src/main/AndroidManifest.xml)
- Add required permissions above the `<application>` tag:
  - `android.permission.ACCESS_FINE_LOCATION`
  - `android.permission.ACCESS_COARSE_LOCATION`
  - `android.permission.INTERNET`

---

## Verification Plan

### Automated Tests
- Run `gradlew compileDebugJavaWithJavac compileDebugKotlin` to ensure no syntax/compilation issues.

### Manual Verification
- Deploy the app to a device/emulator.
- Verify `MainActivity` loads and scrolls the game carousel without crashing.
- Verify `MainActivity4` can successfully request and receive location permissions and load the map webview.
