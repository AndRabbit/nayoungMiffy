# androidSemina28
spot 28th android semina :fire: :computer:

### 안드로이드 1차과제 [2020.04.11]

**1. 화면전환 후 데이터를 가져온 로직 정리**

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        // 데이터를 받아서 할 일이 들어가는 칸! 과제에선 여기까지만 만들어주세요
        if (it.resultCode == RESULT_OK) {
            Toast.makeText(this,it.data?.getStringExtra("name"),Toast.LENGTH_LONG).show()

        }

    }
    

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

