package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener{appendOnExpression("1",true)}
        two.setOnClickListener{appendOnExpression("2",true)}
        three.setOnClickListener{appendOnExpression("3",true)}
        four.setOnClickListener{appendOnExpression("4",true)}
        five.setOnClickListener{appendOnExpression("5",true)}
        six.setOnClickListener{appendOnExpression("6",true)}
        seven.setOnClickListener{appendOnExpression("7",true)}
        eight.setOnClickListener{appendOnExpression("8",true)}
        nine.setOnClickListener{appendOnExpression("9",true)}
        zero.setOnClickListener{appendOnExpression("0",true)}

        plus.setOnClickListener{
            if (expression.text.substring(expression.text.length - 1, expression.text.length) == "*" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "/" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "+" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "-" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "." ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "(" ){
                return@setOnClickListener
            }

            appendOnExpression("+",true)}
        minus.setOnClickListener{
            if (expression.text.substring(expression.text.length - 1, expression.text.length) == "*" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "/" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "+" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "-" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "." ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "(" ){
                return@setOnClickListener
            }

            appendOnExpression("-",true)}
        multiply.setOnClickListener{

            if (expression.text.substring(expression.text.length - 1, expression.text.length) == "*" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "/" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "+" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "-" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "." ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "(" ){
                return@setOnClickListener
            }
            appendOnExpression("*",true)}
        division.setOnClickListener{

            if (expression.text.substring(expression.text.length - 1, expression.text.length) == "*" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "/" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "+" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "-" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "."  ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "(" ) {
                return@setOnClickListener
            }
            appendOnExpression("/",true)}
        dot.setOnClickListener{
            if (expression.text.substring(expression.text.length - 1, expression.text.length) == "*" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "/" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "+" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "-" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "." ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "(" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == ")" ) {
                return@setOnClickListener
            }
            appendOnExpression(".",true)}
        open.setOnClickListener{appendOnExpression("(",true)}
        close.setOnClickListener{
            if(expression.text.substring(expression.text.length - 1, expression.text.length) == "*" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "/" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "+" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "-" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "." ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == "(" ||
                expression.text.substring(expression.text.length - 1, expression.text.length) == ")"){
                return@setOnClickListener
            }
            appendOnExpression(")",true)}
        clear.setOnClickListener{
            expression.text = ""
            result.text = ""
        }

        equal.setOnClickListener{
            try{
                val exp = ExpressionBuilder(expression.text.toString()).build()
                val res = exp.evaluate()
                val longRes = res.toLong()
                if(res == longRes.toDouble())
                    result.text = longRes.toString()
                else
                    result.text = res.toString()
            }catch(e:Exception){
                Log.d("Exception","message : "+e.message)
            }
        }

        erase.setOnClickListener{
            val string = expression.text.toString()
            if(string.isNotEmpty()){
                expression.text = string.substring(0,string.length-1)
            }
            result.text = ""
        }

    }
    fun appendOnExpression(string: String, canClear: Boolean){
        if(result.text.isNotEmpty()){
            expression.text = ""
        }
        if(canClear){
            result.text = ""
            expression.append(string) //출력창에 string 붙혀주기
        }else{
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }



}