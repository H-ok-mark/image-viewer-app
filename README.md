# 黄奕城和他的小伙伴

一个使用 **Kotlin + Jetpack Compose** 编写的 Android 图片查看应用。

## 功能

- 全屏显示图片（隐藏系统状态栏与导航栏）
- 左右滑动翻页（`HorizontalPager`）
- 内置一张示例圆形图片
- 适配不同尺寸屏幕

## 项目结构

- `build.gradle.kts`：根项目配置
- `app/build.gradle.kts`：App 模块构建配置
- `app/src/main/AndroidManifest.xml`：应用清单
- `app/src/main/java/com/example/imageviewer/MainActivity.kt`：入口 Activity
- `app/src/main/java/com/example/imageviewer/ImageViewerScreen.kt`：Compose 图片页面
- `app/src/main/res/values/strings.xml`：字符串资源
- `app/src/main/res/values/colors.xml`：颜色资源
- `app/src/main/res/drawable/sample_circle_image.xml`：示例圆形图片
- `gradle/wrapper/gradle-wrapper.properties`：Gradle Wrapper 配置

## 如何添加更多图片

1. 将图片文件复制到：`app/src/main/res/drawable/`
2. 建议文件名只用小写字母、数字、下划线（例如 `friend_01.png`）
3. 在 `ImageViewerScreen.kt` 的 `imageList` 中追加资源：

```kotlin
val imageList = listOf(
    R.drawable.sample_circle_image,
    R.drawable.friend_01,
    R.drawable.friend_02,
)
```

## 本地编译命令

```bash
./gradlew :app:assembleDebug
```

编译成功后 APK 默认输出路径：

`app/build/outputs/apk/debug/app-debug.apk`

## 在 GitHub Codespaces 中编译 APK（详细中文步骤）

1. 打开仓库主页，点击 **Code** -> **Codespaces** -> **Create codespace on main**
2. 等待 Codespace 启动完成
3. 在终端执行：

```bash
./gradlew :app:assembleDebug
```

4. 编译完成后，打开左侧文件树并下载：

`app/build/outputs/apk/debug/app-debug.apk`

## 说明

当前项目已内置 1 张示例圆形图片，后续可直接按上述方式扩展成多图滑动浏览。
