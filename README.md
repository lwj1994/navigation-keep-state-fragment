
[![](https://jitpack.io/v/lwj1994/navigation-keep-state-fragment.svg)](https://jitpack.io/#lwj1994/navigation-keep-state-fragment)


因为 google 的 navigation 使用 `FragmenManager.replace()` 来切换 fragment 导致上一个 fragment 会销毁，返回时重走 `onCreateView` 等生命周期，用户体验极差。

* 使用 `add/hide fragment` 代替 `replace`，并且在转场动画结束时，对上个页面进行 `hide`，避免多个 `Fragment` 的过度绘制
* 优化了转场动画，内部使用 `IdeHandler` 自定义实现了 `fragment` 的转场动画。
* 内部使用 `setMaxLifecycle` 对`hide`  状态的 Fragment 重置生命周期为 `onPause`

## 使用方法

### 1. 在项目根目录的 build.gradle 添加 maven 仓库
```
allprojects {
    repositories {
			maven { url 'https://jitpack.io' }
    }
}
```

### 2.在项目的 build.gradle 添加依赖
```
// 将谷歌原生的 "androidx.navigation:navigation-fragment:navigation" 注释掉换成下面的依赖
implementation 'com.github.lwj1994:navigation-keep-state-fragment:${latestVersion}'


// 如果依赖了 navigation-fragment-ktx 使用的时候需要把谷歌的 `androidx.navigation.fragment` 包名的代码剔除。
implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"){
        exclude group: 'androidx.navigation'
}
```

