# Fix ViewPager2 IllegalStateException

The application is crashing with `java.lang.IllegalStateException: Pages must fill the whole ViewPager2 (use match_parent)`. This occurs when the root view of a page in `ViewPager2` does not have both width and height set to `match_parent`.

## Proposed Changes

### [app](file:///Users/senai/AndroidStudioProjects/EpicGmes/app)

#### [MODIFY] [ImageAdapter.kt](file:///Users/senai/AndroidStudioProjects/EpicGmes/app/src/main/java/com/example/epicgmes/ImageAdapter.kt)

I will refactor the `ImageAdapter` to inflate the existing `item_carousel.xml` layout instead of creating the UI programmatically. `item_carousel.xml` already has `android:layout_width="match_parent"` and `android:layout_height="match_parent"` set on its root element, which is the required configuration for `ViewPager2` pages.

Using layout inflation is the recommended approach as it ensures that `LayoutParams` are correctly initialized by the `LayoutInflater` relative to the parent `RecyclerView`.

## Verification Plan

### Manual Verification
- Deploy the app and navigate to the screen containing the `ViewPager2` (MainActivity).
- Verify that the `ViewPager2` now displays the images and prices without crashing.
- Check that the pages correctly fill the `ViewPager2` area defined in `activity_main.xml`.
