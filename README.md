
#### 更改应用内全局字体大小控件

## 样式截图

![demo](https://github.com/YassKnight/ChangeFontScale/blob/master/resourceFile/c82y2-8crq9.gif)

## 快速使用

Gradle


```
maven库(建议使用)
dependencies{
    //e.g. 'com.github.YassKnight:changefontscale:1.0.0'
  implementation 'com.github.YassKnight:changefontscale:${LATEST_VERSION}'
}
```

```
    <com.yknight.fontsizeview.FontSizeView
        android:id="@+id/font_size_view"
        android:layout_width="match_parent"
        android:layout_height="90dp"
        android:background="@color/white"
        android:textSize="16sp"
        app:circleRadius="11dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:lineColor="@color/color_7f7f7f"
        app:standerSize="16"
        app:totalCount="4"
        tools:layout_editor_absoluteX="-40dp" />
```


## 问题
* 如果你发现了BUG或有任何建议，欢迎到 [Github Issues](https://github.com/YassKnight/ChangeFontScale/issues) 提出你的问题或者建议

## 许可证

```
Copyright 2020 [yknight]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

