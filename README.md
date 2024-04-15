Step 1: Add Dependency to Project level grade

```bash
implementation ("com.github.TheLogicalBanya:Gamification:v0.1.4")
```

Step 2: Add maven Repository under dependencyResolutionManagement

```bash
setting.dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Step 3: Add Component to XML

```bash
<com.thelogicalbanya.gamification.WebViewGamification
    android:id="@+id/web_view_gamification"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

Step 4   :   Add in Activity Class: (ex: on the click of button) <br/><br/>

Required Parameters List: (* Required Parameter) <br/>
Parameter Description

```bash
clientID* Provided by The Logical Banya.
key* Authentication key, provided by The Logical Banya.
userID* A unique identifier for the user.
username* First Name of the user
keyString* Secret Key, provided by The Logical Banya.
baseUrl* Base URL, provided by The Logical Banya.
utm_param1 Optional Parameter
utm_param2 Optional Parameter
utm_param3 Optional Parameter
utm_param4 Optional Parameter
```

```bash
val gamification: WebViewGamification = 
findViewById(R.id.web_view_gamification)

gamification.init(
clientID = "<clientID_provided_by_TLB>", 
key = "<key_provided_by_TLB>", 
userID = "<Unique_Identifier_Of_User>", 
username = "<Firstname_Of_User>", 
keyString = "<Secret_key_provided_by_TLB>", 
baseUrl = "<BASE_URL_provided_by_TLB>", 
utm_param1 = "<Optional_Parameter1>", 
utm_param2 = "<Optional_Parameter2>", 
utm_param3 = "<Optional_Parameter3>", 
utm_param4 = "<Optional_Parameter4>"
)
```

Below code for back button support.

```bash
override fun onBackPressed() {
        if (!webViewGemification?.onBackPressed()!!) {
            super.onBackPressed()
        }
    }
```

Version Information: <br/><br/>
Android: 33, 34<br/>
Level Version: 0.1.4
