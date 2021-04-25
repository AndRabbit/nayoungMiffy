# androidSemina28
spot 28th android semina :fire: :computer:

### 안드로이드 2차과제 [2020.04.25]

![image](https://user-images.githubusercontent.com/48551119/115991100-da257c80-a601-11eb-99bb-6df08e4e386a.png)

**1. HomeActivity**

     private fun setAdapter(){
        val repositoryListAdapter = RepositoryListAdapter()

        binding.repositoryRecyclerView.adapter = repositoryListAdapter

        repositoryListAdapter.repositoryList.addAll(
            listOf(Repository("android 28 semina sopt", "28기 솝트 안드로이드 파트 정규 세미나 활동을 기록하기 위한 레포지터리이다.","kotlin"),
                Repository("healingfeeling", "덕성여자대학교 4학년 졸업작품 활동을 기록하기 위한 레포지터리이다.","java"))
        )
        repositoryListAdapter.notifyDataSetChanged()
    }

➡️ recyclerapdater 세팅해주기 

 <TextView
        android:id="@+id/repoTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="레포지토리이름"
        android:layout_marginTop="8dp"
        android:maxLines="1"
        android:ellipsize="end"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


    <TextView
        android:id="@+id/repoDetail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="12dp"
        android:maxLines="1"
        android:ellipsize="end"
        android:text="레포지토리설명"
        app:layout_constraintStart_toStartOf="@+id/repoTitle"
        app:layout_constraintTop_toBottomOf="@+id/repoTitle" />
➡️ 레포지터리 이름과 설명이 긴 경우 maxlines 와 ellipsize를 사용해 ... 으로 표시 



      private fun setListeners(){
              binding.userInfoBtn.setOnClickListener {
                  startActivity(Intent(this,UserInfoActivity::class.java))
              }
      
          }

➡️ more 버튼 클릭시 fragment가 있는 userinfoactivity로 이동 
![image](https://user-images.githubusercontent.com/48551119/115991125-04773a00-a602-11eb-9c53-8955b2abf088.png)


