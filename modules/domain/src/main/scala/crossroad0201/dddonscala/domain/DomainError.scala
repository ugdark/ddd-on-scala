package crossroad0201.dddonscala.domain

trait DomainError {
  protected val stackTrace = {
    val traces = Thread.currentThread().getStackTrace
    traces.drop(traces.lastIndexWhere(t => t.getClassName == getClass.getName) + 1)
  }

  override def toString = {
    s"""${getClass.getName}
       |${stackTrace.map(s => s"  at $s").mkString("\n")}
    """.stripMargin
  }
}
