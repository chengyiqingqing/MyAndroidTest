#自定义View

###自定义View的简单步骤归纳

（1）先在res -> values -> attrs.xml创建自己view所需要的属性。

（2）在创建自己的自定义View类的步骤
```
    （1）创建构造方法（含有自定义属性的两个构造参数）
    （2）在类中创建对应的属性字段
    （3）通过context.obtainStyledAttributes(attrs, R.styleable.xxx)获得typeArray;
        然后，通过typedArray.getString(R.styleable.TopBar_textTitle)获得xml里设置的属性。
    （4）initView();initListener();

```
