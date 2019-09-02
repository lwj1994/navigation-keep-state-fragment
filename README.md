

[ ![Download](https://api.bintray.com/packages/wenchieh/maven/navigation/images/download.svg) ](https://bintray.com/wenchieh/maven/navigation/_latestVersion)


因为 google 的 navigation 使用 `FragmenManager.replace()` 来切换 fragment 导致上一个 fragment 会销毁，返回时重走 `onCreate` 等生命周期，用户体验极差。

这里 copy 了  `androidx.navigation.fragment` 下的代码，修改了一行代码。

```
        if(mFragmentManager.getFragments().size() > 0){
            ft.hide(mFragmentManager.getFragments().get(mFragmentManager.getFragments().size() - 1));
            ft.add(mContainerId, frag);
        }else {
            ft.replace(mContainerId, frag);
        }

        //        ft.replace(mContainerId, frag);
```

```
implementation 'com.lwjlol.navigation:keep-fragmentstate:0.0.1'
```

使用的时候需要把谷歌的 `androidx.navigation.fragment` 包名的代码剔除。