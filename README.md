
[ ![Download](https://api.bintray.com/packages/wenchieh/maven/navigation/images/download.svg?version=2.3.2) ](https://bintray.com/wenchieh/maven/navigation/2.3.2/link)


因为 google 的 navigation 使用 `FragmenManager.replace()` 来切换 fragment 导致上一个 fragment 会销毁，返回时重走 `onCreate` 等生命周期，用户体验极差。

这里 copy 了  `androidx.navigation.fragment` 下的代码，修改了一行代码。

```
        if(mFragmentManager.getFragments().size() > 0){
            // 先隐藏
            ft.hide(mFragmentManager.getFragments().get(mFragmentManager.getFragments().size() - 1));
            // 再显示新的 fragment
            ft.add(mContainerId, frag);
        }else {
            ft.replace(mContainerId, frag);
        }

        //        ft.replace(mContainerId, frag);
```


## 使用方法

### 1. 在项目根目录的 build.gradle 添加 maven 仓库
```
allprojects {
    repositories {
        maven {
            url 'https://dl.bintray.com/wenchieh/maven'
        }
    }
}
```

### 2.在项目的 build.gradle 添加依赖
```
// 将谷歌原生的 "androidx.navigation:navigation-fragment:navigation" 注释掉换成下面的依赖
implementation 'com.lwjlol:navigation-fragment:2.3.2'

// 如果依赖了 navigation-fragment-ktx 使用的时候需要把谷歌的 `androidx.navigation.fragment` 包名的代码剔除。
implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"){
        exclude group: 'androidx.navigation'
}
```

