# PhysicBasedAnimation
An exercise of SpringAnimation from Nick Butcher's [Gist](https://gist.github.com/nickbutcher/7fdce476aaa589680cdd626d78e3149d)

## Futher Reading

Android Support Library 26 中的 `PhysicBasedAnimation` 在机制上一定意义借鉴了 Facebook Rebound，理解弹性动画系统，有必要借鉴各个端的优秀范例，掌握 DHO 、 RK4 等核心算法。

### Android:

[android.support.animation](https://developer.android.com/reference/android/support/animation/package-summary.html)

官方 API，注意学习 Fling 动画、DHO 体系对于 Android **VelocityTracker** 的运用

[Facebook Rebound](http://facebook.github.io/rebound/)

学习其中的 **状态机**、 **Spring主类中核心弹性函数** 、 **动画引擎的接口设置** 、**以及配置窗口**

[android-SpringAnimator](https://github.com/unixzii/android-SpringAnimator)

对于 FramerJS 的 RK4动画器 和 DHO动画器 的翻译，注意 **动画刷新机制** 和原生的不同

[Springy_Facebook_Rebound](https://github.com/SalmanZach/Springy_Facebook_Rebound)

学习其如何将 Rebound 的改版 DHO函数 应用到安卓原生动画器中，并结合 **插值器** 使用

[mocos-controlator](https://github.com/marcioapaiva/mocos-controlator)

学习龙格库塔(RK4)插值器的编写

### iOS：

[pop](https://github.com/facebook/pop)

pop 可以改变任意property 的思路

[Your Spring Animations Are Bad](https://medium.com/@flyosity/your-spring-animations-are-bad-and-it-s-probably-apple-s-fault-784932e51733)

文章介绍了一些流行的 iOS 动画库

### Java：

[Real World Physics in Swing ](http://jroller.com/gfx/entry/real_world_physics_in_swing) 翻译版本可以参考[DropInMotion-Rebuild](https://github.com/MartinRGB/DropInMotion-Rebuild)

思考 数学算式、属性监听构建插值器的方法，理解 DHO 算式,它是如何利用时间比例，为弹性加入了时间控制。

### CoffeScript

[Frame](https://github.com/koenbok/Framer/tree/master/framer/Animators)

可以稍微学习一下 Framer 中动画器的构建

### JavaScript

[The Spring Factory](https://medium.com/analytic-animations/the-spring-factory-4c3d988e7129)

丝毫不懂 JS，备用

### 核心算式函数：

[Damping Harmonic Oscillator - Wiki](https://en.wikipedia.org/wiki/Harmonic_oscillator)

[Runge–Kutta methods - Wiki](https://en.wikipedia.org/wiki/Runge%E2%80%93Kutta_methods)

[Euler’s Method and Runge-Kutta RK4](http://www.intmath.com/blog/mathematics/eulers-method-runge-kutta-rk4-10117)

