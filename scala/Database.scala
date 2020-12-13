class Database() extends Warenkorb {

  private var storedItems = Array[StoreItem]()    //saves StoreItems


  def delete(id: Int): Array[StoreItem] = {
    val itemToDelete: Option[StoreItem] = storedItems.find(s => s.id == id)    //type is option - could be found or not

    itemToDelete match {    //if found log delete, if not found throw error
      case Some(itemFound) => itemFound.logAction("gelöscht", itemFound.name)   //itemfound is just a arbitrary name - in this case its of type StoreItem
      case None => println("Id " + id + " nicht gefunden")    //itemToDelete is empty
    }

    storedItems = storedItems.filter(s => s.id != id)   //create new array without deleted item
    storedItems
  }


  def search(name: String): Array[StoreItem] = {
    val searchList = storedItems.filter(s => s.name == name)  //Array of every item with fitting name

    if(searchList.isEmpty) println("name " + name + " nicht gefunden")

    for(searchItem <- searchList){    //log all found items
        searchItem.logAction("gefunden", name)
    }
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
    val sum = valArray.reduce((a,b) => a + b)         //sum up those values
    sum
  }

}