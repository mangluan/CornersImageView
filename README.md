# CornersImageView
CornersImageView是一个使用简单的圆角图片框架，可以帮你快速完成图片圆角化

### 效果预览
|<img src="http://a1.qpic.cn/psc?/V10bozPB3t8zC6/3iaZn8AhmTxjScWTf.nxUx1JjGDxV8y5WIPw7amQcxFdg4QiIy1JAQuPAXHaCzJs1j0idCc62B6FGucHJkzMag!!/c&ek=1&kp=1&pt=0&bo=BwJUAQcCVAEDEDU!&tl=1&vuin=508342550&tm=1588384800&sce=60-2-2&rf=0-0"  width="300px" >|<img src="http://a1.qpic.cn/psc?/V10bozPB3t8zC6/3iaZn8AhmTxjScWTf.nxUwZlLjoTS16zbEY5NmP1pLO6*lYj.i.BOTQ9efGSZ1BsGhWtC*wopNiWnYrb82GqAg!!/c&ek=1&kp=1&pt=0&bo=AgJhAQICYQEDEDU!&tl=1&vuin=508342550&tm=1588384800&sce=60-2-2&rf=0-0"  width="300px" >|
|---|---|
|<img src="http://a1.qpic.cn/psc?/V10bozPB3t8zC6/3iaZn8AhmTxjScWTf.nxU9JKua.nimgV6ths*Inb0WOQHMfyOH.bjgingutuHCBfazJcitzC.GzWqUkIEhIeOQ!!/c&ek=1&kp=1&pt=0&bo=1gFMAdYBTAEDEDU!&tl=1&vuin=508342550&tm=1588384800&sce=60-2-2&rf=0-0"  width="300px" >|<img src="http://a1.qpic.cn/psc?/V10bozPB3t8zC6/3iaZn8AhmTxjScWTf.nxU8DO86lvhuWKlSWYhDRhqwrCZogfreOj5dD58KEe4h*KJHXQyDypwqVpRGfftBRM2g!!/c&ek=1&kp=1&pt=0&bo=oQFUAaEBVAEDEDU!&tl=1&vuin=508342550&tm=1588384800&sce=60-2-2&rf=0-0"  width="300px" >|
### 特点
* 继承自AppCompatImageView
* 支持圆角、圆形ImageView显示

### 基本用法
**Step 1. 添加JitPack仓库**
在项目根目录下的 `build.gradle` 中添加仓库:
``` gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
**Step 2. 添加项目依赖**
``` gradle
dependencies {
    implementation 'com.mangluan:CornersImageView:1.0.0'
}
```
**Step 3. 在布局文件中添加CornersImageView**
```
 <com.mangluan.library.CornersImageView
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:scaleType="centerCrop"
    android:src="@mipmap/test"
    app:radius="15dp" />
```
### 支持的属性、方法
|属性名|含义|默认值|对应方法
|---|---|---|---|
|radius|全局圆角弧度|0dp|setRadius()
|bottomLeftRadius|左下角圆角弧度|0dp|setBottomLeftRadius()
|bottomRightRadius|右下角圆角弧度|0dp|setBottomRightRadius()
|topRightRadius|右上角圆角弧度|0dp|setTopRightRadius()
|topLeftRadius|左上角圆角弧度|0dp|setTopLeftRadius()

### 其它

**构造函数**
```
// 全局圆角
public CornersImageView(Context context, float radius) {}
```
```
// 四个角的圆角
public CornersImageView(Context context, float bottomLeftRadius,
             float bottomRightRadius, float topRightRadius, float topLeftRadius) {}
 ```
 ##
后期会根据需要添加其他的功能，意见反馈邮箱：508342550@qq.com
