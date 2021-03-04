package com.asjm.lib.helper;

/**
 * code helper
 *
 * @author howard
 * @version v0.1
 */
public class CodeHelper {

    /**
     * start activity demo.<p>
     * <h>显式：</h>
     * Intent intent = new Intent(this, SecondActivity.class);
     * startActivity(intent);
     * Intent intent = new Intent();
     * intent.setClass(this, SecondActivity.class);
     * startActivity(intent);
     * <p>
     * Intent intent = new Intent();
     * intent.setClass(this, SecondActivity.class);
     * //或者intent.setClassName(this, "com.example.app.SecondActivity");
     * //或者intent.setClassName(this.getPackageName(),"com.example.app.SecondActivity");
     * startActivity(intent);
     *
     * <h>隐式：</h>
     * <activity
     * android:name="com.example.app.SecondActivity">
     * <intent-filter>
     * <action android:name="mark"/>
     * <category android:name="android.intent.category.DEFAULT"/>
     * </intent-filter>
     * </activity>
     * Intent intent = new Intent();
     * intent.setAction("mark");
     * startActivity(intent);
     */
    public static void startActivity() {

    }

    /**
     * Intent对象大致包括7大属性.<p>
     * Action（动作）、Data（数据）、Category（类别）、
     * Type（数据类型）、Component（组件）、Extra（扩展信息）、Flag（标志位）
     */
    public static class Intent {

        /**
         * Action：用来表现意图的行动.<p>
         * 一个字符串变量，可以用来指定Intent要执行的动作类别，常见action：<p>
         * activity:<p>
         * ACTION_MAIN	表示程序入口
         * ACTION_VIEW	自动以最合适的方式显示Data
         * ACTION_EDIT	提供可以编辑的
         * ACTION_PICK	选择一个一条Data，并且返回它
         * ACTION_DAIL	显示Data指向的号码在拨号界面Dailer上
         * ACTION_CALL	拨打Data指向的号码
         * ACTION_SEND	发送Data到指定的地方
         * ACTION_SENDTO	发送多组Data到指定的地方
         * ACTION_RUN	运行Data，不管Data是什么
         * ACTION_SEARCH	执行搜索
         * ACTION_WEB_SEARCH	执行网上搜索
         * ACRION_SYNC	执同步一个Data
         * ACTION_INSERT	添加一个空的项到容器中
         * <p>
         * broadcast:<p>
         * ACTION_TIME_TICK	当前时间改变，并即时发送时间，只能通过系统发送。调用格式"android.intent.action.TIME_TICK"
         * ACTION_TIME_CHENGED	设置时间。调用格式"android.intent.action.TIME_SET"
         * <p>
         */
        public static class Action {

        }

        /**
         *
         */
        public static class Data {

        }

        /**
         * 指示系统如何启动一个Activity.<p>
         * 可以通过setFlag或者addFlag设置。
         * <p>
         * FLAG_ACTIVITY_CLEAR_TOP	相当于SingleTask 只允许一个实例，若已经存在则移除其上的其他activity并调用onNewIntent
         * FLAGE_ACTIVITY_SINGLE_TOP	相当于SingleTop 允许多个实例，当在栈顶时调用onNewIntent
         * FLAG_ACTIVITY_NEW_TASK	类似于SingleInstance 只有一个实例，并且这个实例独立运行在一个task中，这个task只有这个实例，不允许有别的Activity存在。
         * FLAG_ACTIVITY_NO_HISTORY	当离开该Activity后，该Activity将被从任务栈中移除
         * <p>
         */
        public static class Flag {

        }

        /**
         * 1:调用拨号程序<p>
         * 调用拨打电话，给10010拨打电话
         * Uri uri = Uri.parse("tel:10010");
         * Intent intent = new Intent(Intent.ACTION_DIAL, uri);
         * startActivity(intent);
         * <p>
         * 2:发送短信<p>
         * 给10010发送内容为“Hello”的短信
         * Uri uri = Uri.parse("smsto:10010");
         * Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
         * intent.putExtra("sms_body", "Hello");
         * startActivity(intent);
         * <p>
         * 3:通过浏览器打开网页<p>
         * 打开百度主页
         * Uri uri = Uri.parse("https://www.baidu.com");
         * Intent intent = new Intent(Intent.ACTION_VIEW, uri);
         * startActivity(intent);
         * <p>
         * 4:播放多媒体<p>
         * Intent intent = new Intent(Intent.ACTION_VIEW);
         * Uri uri = Uri.parse("file:///sdcard/foo.mp3");
         * intent.setDataAndType(uri, "audio/mp3");
         * startActivity(intent);
         * <p>
         * 5:选择图片<p>
         * Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
         * intent.setType("image/*");
         * startActivityForResult(intent, 2);
         * <p>
         * 6:拍照<p>
         * // 打开拍照程序
         * Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         * startActivityForResult(intent, 1);
         * <p>
         * 7:获取并剪切图片<p>
         * Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
         * intent.setType("image/*");
         * intent.putExtra("crop", "true"); // 开启剪切
         * intent.putExtra("aspectX", 1); // 剪切的宽高比为1：2
         * intent.putExtra("aspectY", 2);
         * intent.putExtra("outputX", 20); // 保存图片的宽和高
         * intent.putExtra("outputY", 40);
         * intent.putExtra("output", Uri.fromFile(new File("/mnt/sdcard/temp"))); // 保存路径
         * intent.putExtra("outputFormat", "JPEG");// 返回格式
         * startActivityForResult(intent, 0);
         * <p>
         * 8:打开手机应用市场，直接进入该程序的详细页面
         * Uri uri = Uri.parse("market://details?id=" + packageName);
         * Intent intent = new Intent(Intent.ACTION_VIEW, uri);
         * startActivity(intent);
         * <p>
         * 9:安装程序
         * String fileName = Environment.getExternalStorageDirectory() + "/myApp.apk";
         * Intent intent = new Intent(Intent.ACTION_VIEW);
         * intent.setDataAndType(Uri.fromFile(new File(fileName)),
         * "application/vnd.android.package-archive");
         * startActivity(intent);
         *
         *
         *
         */
        public static class Demo {

        }


    }

}
