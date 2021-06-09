# androidSemina28
spot 28th android semina :fire: :computer:

### 안드로이드 4차과제 [2020.06.09]

**1.  Lv7-7 Activity에, 어떻게 처리했는지 정리 **



    if(MySharedPreferences.getUserId(this).isNullOrBlank()
            || MySharedPreferences.getUserPass(this).isNullOrBlank()) {
            setListeners()
            observeData()
        }
        else { // SharedPreferences 안에 값이 저장되어 있을 때 -> MainActivity로 이동
            Toast.makeText(this, "${MySharedPreferences.getUserId(this)}님 자동 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

- signinActivity 구현

** Lv7-2 SharedPreference 어떻게 코드를 정리했는지 코드 첨부**

    object MySharedPreferences {
        private val MY_ACCOUNT : String = "account"
    
        fun setUserId(context: Context, input: String) {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.putString("MY_ID", input)
            editor.apply()
        }
    
        fun getUserId(context: Context): String {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            return prefs.getString("MY_ID", "").toString()
        }
    
        fun setUserPass(context: Context, input: String) {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.putString("MY_PASS", input)
            editor.apply()
        }
    
        fun getUserPass(context: Context): String {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            return prefs.getString("MY_PASS", "").toString()
        }
    
        fun clearUser(context: Context) {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.clear()
            editor.apply()
        }
    }

- mySharedPreferences 구현 

**과제를 통해 배운내용 or 개발자로 성장한 내용!**

처음에는 단지 자동로그인 기능도 서버에서 연결하여 구현하는 줄만 알고 시간도 많이 걸리고 생각보다 귀찮은 작업이 될 것 같았는데 이렇게 안드로이드 내에있는 키-값 데이터 저장기능을 수행해주는 SharedPreferences를 사용해 쉽고 간편하게 자동로그인을 구현할 수 있다는 사실을 알았다..!!
다음번에는 자동로그인말고도 또 어떤 부분을 활용할 수 있는지 더 알아봐야겠다.

>  SharedPreferences 객체는 키-값 쌍이 포함된 파일을 가리키며 키-값 쌍을 읽고 쓸 수 있는 간단한 메서드를 제공합니다. 각 SharedPreferences 파일은 프레임워크에서 관리하며 비공개이거나 공유일 수 있습니다.




