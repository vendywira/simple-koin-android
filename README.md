# Simple implementation dependency injection use KOIN

Koin is dependency injection library base on kotlin. 
Very simple to implement on android project. 
you just need add some code to your code like below :

* create AppModule 
```kotlin
val appModule = module {
    single { Gson() } // will generate when bootstrapping application
    factory { MainPresenter(androidContext(), get()) } // will generate when used
}
```

* create AppComponent
```kotlin
val appComponent = listOf(appModule)
```

* create main class to load our created modules
```kotlin
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)
    }
}
```

* and the last we must add single line code to manifest
```xml
<application
    android:name=".MainApp"
    ...
```


* how to use dependencies? 
```kotlin
val presenter: MainPresenter by inject() 
// will automatically generate because we have define MainPresenter factory on AppModule before.
```

## License
The MIT License (MIT)

Copyright (c) 2018 I Wayan Vendy Wiranatha

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

