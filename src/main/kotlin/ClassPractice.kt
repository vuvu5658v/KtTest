package org.example

// 주 생성자는 class옆에 생성
// 코틀린은 기본적으로 final 이므로, open키워드를 통하여 상속가능한 구조로 변경한다.
open class Human constructor(var name : String = "default값"){

    // 부 생성자는 주 생성자를 상속받는다. this키워드 사용
    constructor(name: String, age : Int) : this(name)

    // 객체 생성시 실행할 코드 블록
    init {

    }

    // 메서드
    fun eatingCake(){
        println("케이크 냠냠")
    }

    // override 허용시 마찬가지로 open키워드를 사용한다.
    open fun singASong(){
        println("lalalala")
    }
}

class Korean : Human(){

    override fun singASong() {
        // super 키워드는 동일하다.
        super.singASong()
        println("라라라")
    }


}

class ClassPractice {

    fun main(){
        // 객체 생성시 new 키워드는 사용하지 않는다.
        val human = Human()
        var korean = Korean()
        korean.singASong()
    }

}