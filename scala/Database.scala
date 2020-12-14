class Database() extends Warenkorb {

  private var storedItems = Array[StoreItem]()    //saves StoreItems


  def delete(id: Int): Array[StoreItem] = {
    val itemToDelete: Option[StoreItem] = storedItems.find(si => si.id == id)    //search items with id, type is option - could be found or not

    itemToDelete match {    //if found log delete, if not print error
      case Some(itemFound) => itemFound.logAction("gelöscht", itemFound.name)   //itemfound is just a arbitrary name - in this case its of type StoreItem
      case None => println("Id " + id + " nicht gefunden")    //itemToDelete is empty
    }

    storedItems = storedItems.filter(si => si.id != id)   //create new array without deleted item
    storedItems
  }


  def search(name: String): Array[StoreItem] = {
    val searchList = storedItems.filter(si => si.name == name)  //Array of every item with fitting name

    if(searchList.isEmpty) println("name " + name + " nicht gefunden")

    searchList.foreach(s => s.logAction("gefunden", name))
    searchList
  }

  def store(item: StoreItem): Array[StoreItem] = {
    if(storedItems.exists(si => si.id == item.id))  println("Item bereits vorhanden")   //keeps ids unique
    else{
      storedItems = storedItems :+ item   //append item to array
      item.logAction("gespeichert", item.name)
    }
    storedItems
  }

  def sumUp(): Int = {
    val valArray = storedItems.map(si => si.value)    //Array of values from stored items
    valArray.reduce((a,b) => a + b)         //sum up those values
  }

}