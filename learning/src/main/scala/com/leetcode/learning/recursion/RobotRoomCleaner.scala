package com.leetcode.learning.recursion

object RobotRoomCleaner {
  private val visited = scala.collection.mutable.Set[Cell]()

  def cleanRoom(robot: Robot): Unit = {
    visited.clear()
    navigate(robot, Cell(0,0), Up)
  }

  private def navigate(robot: Robot, cell: Cell, dir: Direction): Unit = {
    visited.add(cell)
    robot.clean()

    var newDir: Direction = dir
    // trying four different directions to move in clockwise order
    (1 to 4).foreach{ _ =>
      newDir = clockwise(robot, newDir)
      val newCell = cell.move(newDir.x, newDir.y)
      if(! visited.contains(newCell) && robot.move()) {
        navigate(robot, newCell, newDir)
        // resetting the robot to its original cell and direction
        goBack(robot)
      }
    }
  }

  private def goBack(robot: Robot): Unit = {
    robot.turnRight()
    robot.turnRight()
    robot.move()
    robot.turnLeft()
    robot.turnLeft()
  }

  private case class Cell(row: Int, col: Int) {
    def move(x: Int, y: Int): Cell = Cell(row+y, col+x)
  }

  private def clockwise(robot: Robot, dir: Direction): Direction = {
    robot.turnRight()

    dir match {
      case Up => Right
      case Right => Down
      case Down => Left
      case Left => Up
    }
  }

  private sealed abstract class Direction(val x: Int, val y: Int)
  private case object Up extends Direction(0, -1)
  private case object Right extends Direction(1, 0)
  private case object Down extends Direction(0, 1)
  private case object Left extends Direction(-1, 0)

  private class Robot {
     // Returns true if the cell in front is open and robot moves into the cell.
     // Returns false if the cell in front is blocked and robot stays in the current cell.
     def move(): Boolean = {
       true
     }

     // Robot will stay in the same cell after calling turnLeft/turnRight.
     // Each turn will be 90 degrees.
     def turnLeft(): Unit = {}
     def turnRight(): Unit = {}

     // Clean the current cell.
     def clean(): Unit = {}
  }
}
