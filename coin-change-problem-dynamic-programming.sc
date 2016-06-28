//Coin Change is the problem of finding the number of ways of making changes for a particular amount of cents.

def calculateCoinChange(coins: List[Int], amount: Int): Int = {
  val solution = Array.ofDim[Int](coins.length + 1, amount + 1)

  for (i <- 0 to coins.length) {
    solution(i)(0) = 1
  }

  for (i <- 1 to amount) {
    solution(0)(i) = 0
  }

  for (i <- 1 to coins.length) {
    for (j <- 1 to amount) {
      if (coins(i - 1) <= j) {
        solution(i)(j) = solution(i - 1)(j) + solution(i)(j - coins(i - 1))

      } else {
        solution(i)(j) = solution(i - 1)(j)
      }
    }
  }

  solution(coins.length)(amount)

}
