class StoreItem(anumber: Int, aname: String, avalue: Int) extends Logger with Artikel {

  def logAction(actionName: String, name: String): Unit = println(name + " " + actionName +".")

  var id: Int = anumber
  var name: String = aname
  var value: Int = avalue
}
