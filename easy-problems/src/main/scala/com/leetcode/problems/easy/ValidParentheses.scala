package com.leetcode.problems.easy

object ValidParentheses {
  def isValid(s: String): Boolean = {
    if(s.isEmpty) return true
    if(s.length % 2 != 0) return false

    var stack = List[Char]()

    for (c <- s) {
      c match {
        case '{' | '(' | '[' => stack = c :: stack
        case '}' | ')' | ']' =>
          if (stack.isEmpty) {
            return false
          } else {
            if(c == '}' && stack.head != '{') {
              return false
            } else if(c == ']' && stack.head != '[') {
              return false
            } else if(c == ')' && stack.head != '(') {
              return false
            } else {
              stack = stack.tail
            }
          }
      }
    }

    stack.isEmpty
  }
}
