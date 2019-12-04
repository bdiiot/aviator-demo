package com.bdiiot.aviator.scala.main

import java.util

import com.googlecode.aviator.AviatorEvaluator

object MainScala {
  def main(args: Array[String]): Unit = {
    var expression: String = "((1 != 1) || (2 == 2)) && 3 == 3"
    System.out.println(AviatorEvaluator.execute(expression))
    // true

    val yourName: String = "World!"
    var env: util.Map[String, AnyRef] = new util.HashMap[String, AnyRef]
    env.put("yourName", yourName)
    System.out.println(AviatorEvaluator.execute("'Hello ' + yourName", env))
    // Hello World!

    System.out.println(AviatorEvaluator.exec("'Hello ' + yourName", yourName))
    // Hello World!

    expression = "status == 0 && user_id != 10646 && order_id != 10648"
    val compiledExp = AviatorEvaluator.compile(expression)
    env = new util.HashMap[String, AnyRef]
    env.put("status", Integer.valueOf(0))
    env.put("user_id", Integer.valueOf(10000))
    env.put("order_id", Integer.valueOf(10000))
    System.out.println(compiledExp.execute(env))
    // true
  }
}
