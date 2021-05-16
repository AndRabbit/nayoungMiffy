# androidSemina28
spot 28th android semina :fire: :computer:

### 안드로이드 3차과제 [2020.05.16]

**1. PostMan 테스트 사진**

/Users/annayoung/Downloads/IMG_0875.PNG
    

- registerForAcivityResult 함수를 이용해서 callback을 등록해 준다.
- 결과를 받기 위해 startActivityForResult함수를 넣어 준다.
- it 로 받아온 값을 어떻게 이용할지 정의 해준다.

      binding.signUpText.setOnClickListener {
            signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))

        }
        
정의해준 함수를 launch함수로 시작시켜 준다.


      binding.signUpButton.setOnClickListener {
            if (binding.nameEdit.text.isNotEmpty() && binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPassword.text.isNotEmpty()) {
                val intent = Intent()
                intent.putExtra("name", binding.nameEdit.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()

            } else {
                Toast.makeText(this, "빈 칸이 있는지 확인해 주세요!", Toast.LENGTH_SHORT).show()
            }
        }`

setResult함수에 result_ok 와 data를 넣어서 넘겨준다.

**2. 생명주기를 호출하고 액티비티를 호출하면**

![image](https://user-images.githubusercontent.com/48551119/114300856-14b8f080-9afd-11eb-81e8-a50ea28339f4.png)

**3. 배운점**

예전에는 startactivityforresult 함수를 이용해서 액티비티간의 데이터를 전달해 주었는데 이번에 세미나를 통해서 resultforactivityresult를 이용해서 데이터를 주고받는 사실을 배우게 되었다. 또한 findviewId를 이용하여 view를 참조하는 대신에 viewbinding을 써서 id 값을 참조하는 방법을 새로 배웠는데 앞으로는 더 나아가 databinding을 이용해서 코드를 짜보고 싶다는 생각이 들었다 . 또한 이번 과제에서는 나름 mvvm 패턴을 이용해서 코드를 짜보려고 노력했는데 이게 맞는건지 잘 모르겠다...ㅎㅎ ACC의 viewmodel 과 mvvm의 viewmodel이 다르다는 얘기를 들었는데 정확히 둘이 어떻게 다른지 더 알고 싶다.

