package org.example

import java.util.*
import kotlin.collections.ArrayList

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    println(add(4,5))
    stringTemplate()

    chkNumber(1)
    chkNumber(5)

    forAndWhile()

    val human = Human()
    var korean = Korean()
    korean.singASong()
}
// 1. 함수
// 리턴타입이 없으면 생략가능
fun printSomeThing(){
    println("test")
}

// 리턴타입이 있으면 명시
// 변수명 : 타입으로 명시한다.
fun add(a : Int, b: Int) : Int {
    return a+b
}

// 2. val vs var 차이
// val -> value     : 변하지 않는 값
// var -> variable  : 변하는 변수
fun valvsvar(){
    val a : Int = 10
    var b : Int = 9
    // a = 100  << val은 재정의 할 수 없다는 에러 발생

    b = 100 // << 변수이므로 값 변경 가능
}


// 3. String template
fun stringTemplate() {
    val name = "이상희"
    val lst = "입니다."
    println("내 이름은 ${name + lst}")
}

// 4. 주석
// 한줄 주석

/*
여러줄
*/

/**
 * 여러줄 주석
 */

// 5. 조건식
fun maxNum(a : Int, b : Int) : Int{

    if(a > b){
        return a
    }else{
        return b
    }

}

// 3항 연산자와 유사하게도 작성가능
fun maxNum2(a : Int, b : Int): Int = if(a>b) a else b

fun chkNumber(score : Int){
    when(score) {
        0 -> println("0 입니다.")
        1 -> println("1 입니다.")
        2,3-> println("2거나 3입니다.")
        // 일반 구문일경우 else는 생략가능
        else-> println("범위 밖입니다.")
    }

    // 변수에 바로 할당도 가능.
    var b:Int = when(score) {
        0 -> 0
        1 -> 1
        2,3-> 3
        else-> -1
    }

    // 범위는 .. 으로 지정 가능
    when(score){
        in 90..100 -> println("A학점")
        in 10..80 -> println("F학점")
    }

}

// 6. Expression vs Statement 차이점
// 실행을 하여서 값을 반환하면 Expression
// 처리를 위한 구문이면 Statement
// 코틀린의 모든 함수는 Expression

// 7. Array vs List
// Array는 크기가 고정이다.

// List
// 1. 수정불가능한 List, 2. 수정가능한 리스트
fun array(){
    val array = arrayOf(1,2,3)
    val list : List<Int> = listOf(1,2,3)

    val array2:Array<Any> = arrayOf(1, "d", 3.4f)

    // array는 변경 가능
    array[0] = 3

    // list 는 값 가져오기만 가능, 수정 불가능
    var getListItem = list.get(0)

    // 새로운 객체로 할당하는 경우가 아니면 val 사용 권장
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)


}

// 8. 반복문, for while
fun forAndWhile(){
    val students : ArrayList<String> = arrayListOf("A", "B", "C", "D")

    for(name in students){
        println("name : $name")
    }

    for((index, name) in students.withIndex()){
        println("${index + 1} 번째 학생 $name")
    }

    var sum : Int = 0

    // step 증감 값 지정
    for(i : Int in 1..10 step 2){
        sum += i
    }

    // until 10을 포함하지 않음
    for(i : Int in 1 until 10){

    }

    // downTo 큰수부터 아래로
    for(i : Int in 10 downTo 1){

    }

    // while 은 똑같다
    var index = 0
    while(index < 10){
        index++
    }

    println(sum)

}

// 9. Nullable / NonNull
fun nullCheck(){
    var name : String = "이상희"

    // type에 ?를 붙여주면 null이 가능한 타입으로
    var nullName : String? = null

    var nameUpperCase : String = name.uppercase()

    // js와 유사하게 null인지 체크 후 함수를 호출할 경우 ?를 사용한다.
    var nullNameUpperCase : String? = nullName?.uppercase()

    var lastName : String? = null

    // ?: 엘비스 연산자를 사용하면 오라클 NVL과 유사하게 NULL이 아닐경우 값사용, NULL일경우 ?:뒤의 값을 사용한다.
    var fullName : String = name + " " + (lastName?:"NO last Name")

    // !! NUll 가능한 타입이지만, 컴파일오류를 내지않고 개발자판단에 절대 Null이 사용되지 않을 경우 명시할때 사용
    var mustNotNull : String? = ""
    var strNotNull : String = mustNotNull!!

    // let null이 아닌경우에만 let 블럭 안의 구문을 실행해라라는 의미
    val email : String? = "vuvu5658@coway.com"
    email?.let {
        println("my email is $email")
    }

}

// 10. Lamda
// 람다식은 value처럼 쓸수 있는 익명의 함수?
// 1) 메소드의 파라미터로 활용가능
// 2) 리턴값으로 활용가능

// 기본 구문 구성
// val lamdatName : Type = {arguments -> codeBlock}

val square : (Int) -> (Int) = {number -> number*number}
val nameAge : (String, Int) -> String = {name : String, age : Int ->
    "my name is $name age is $age"
}

// 마지막 line이 리턴값으로 활용됨
// 확장 함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun useExtend(){
    val strA = "A said"
    val strB = "B said"

    // String을 확장하였으므로, String타입의 구문에서 활용 가능하다.
    strA.pizzaIsGreat()
    // A said Pizza is the best!

    strB.pizzaIsGreat()
    // B said Pizza is the best!

}

fun extendString(name : String, age : Int) : String {
    // it 은 파라미터가 1개일때 가리킴
    val introduceMyself : String.(Int) -> String = { "I am $this and $it years old" }
    return name.introduceMyself(age)
}

// 람다의 Return 값

// 파라미터는 여러개가 올수 있으므로, ()로 묶어서 표현해준다.
// 리턴타입은 한개이므로 생략가능.
// 무조건 리턴을 해야하므로, when을 사용시 else가 무조건 필요하다.
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 방법

// 파라미터로 활용시 람다의 입력 파라미터, 반환파라미터를 명시하여 활용한다.
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{
    return lamda(123.123)
}