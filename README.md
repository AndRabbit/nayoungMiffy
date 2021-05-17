# androidSemina28
spot 28th android semina :fire: :computer:

### 안드로이드 3차과제 [2020.05.16]

**1. PostMan 테스트 사진**

   ![image](https://user-images.githubusercontent.com/48551119/118397996-9c13f980-b691-11eb-9cca-edf7ff33f58a.png)

    - 로그인 테스트 사진 

   ![image](https://user-images.githubusercontent.com/48551119/118398014-b221ba00-b691-11eb-855a-72a49a20159e.png)
    
    - 회원가입 테스트 사진

**2. 회원가입 완료 + 로그인 완료 구현 gif**

    interface SoptService {
        @POST("/login/signin")
            fun postLogin(
                @Body body: RequestLogin
            ):Call<ResponseLogin>

        @POST("/login/signup")
        fun postSignUp(
            @Body body: RequestSignUp
        ):Call<ResponseSignUp>

    }


- 인터페이스 구현 
![image](https://user-images.githubusercontent.com/48551119/118398719-dd59d880-b694-11eb-8e31-d3e5e89a191a.png)

- 로그인 완료 토스트 메시지 띄우기

      val loginBody=  RequestLogin(email= binding.editTextTextPersonName.text.toString(),password = binding.editTextTextPassword.text.toString())
                           val call: Call<ResponseLogin> = ServiceCreator.soptService.postLogin(loginBody)

                           call.enqueue(object :
                               Callback<ResponseLogin> {
                               override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                                   if(response.isSuccessful){
                                       Log.d("soptlogin","로그인 성공")
                                       Toast.makeText(this@SignInActivity,
                                           response.body()?.data?.user_nickname,Toast.LENGTH_SHORT).show()
                                       startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                                   }

                               }

                               override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

                               }
                       })

![image](https://user-images.githubusercontent.com/48551119/118398732-ec408b00-b694-11eb-852d-e3f6c27de677.png)

- 회원가입 완료 토스트 메시지 띄우기

![image](https://user-images.githubusercontent.com/48551119/118398749-fcf10100-b694-11eb-993b-da0f3d2d7c46.png)


**3. 과제를 통해 배운 내용 & 개발자로 성장한 내용**
  회원가입과 로그인 하는 장면을 gif 로 올리기 위해서 직접 동영상으로 찍어 준비했는데 용량이 너무 커서 100mb 이상이 되면 리드미에 올릴 수 없다는 사실을 알게 되었다.... (그래서 toast 로 올림 )
 싱글톤 패턴을 학교 전공시간에 이론으로만 배웠었는데 그때는 이게 어떻게 사용 되는지 감이 하나도 안왔었는데 이번 기회에 직접 실습에 적용해 보니 배운 점이 많았다. 





