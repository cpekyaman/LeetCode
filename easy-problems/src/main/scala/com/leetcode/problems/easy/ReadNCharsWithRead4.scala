package com.leetcode.problems.easy

object ReadNCharsWithRead4 {

  private var file: String = ""
  private var filePos: Int = 0

  def read(buf: Array[Char], n: Int): Int = {
    if(n == 0) {
      return 0
    }

    var readPos = 0
    var cnt = 4
    val tempBuf = Array.ofDim[Char](4)
    while(readPos < n && cnt == 4) {
      cnt = read4(tempBuf)
      val len = Integer.min(cnt, n - readPos)
      Array.copy(tempBuf, 0, buf, readPos, len)
      readPos += len
    }
    println(buf.mkString(""))
    readPos
  }

  private def read4(buf4: Array[Char]): Int = {
    val chars = file.substring(filePos, Integer.min(filePos + 4, file.length))
    filePos = Integer.min(filePos + 4, file.length)
    val charArray = chars.toCharArray
    Array.copy(charArray, 0, buf4, 0, charArray.length)
    charArray.length
  }

  def setFile(f: String): Unit = {
    this.file = f
    this.filePos = 0
  }
}
