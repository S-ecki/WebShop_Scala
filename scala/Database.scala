class Database() extends Warenkorb {

  private var storedItems = Array[StoreItem]()


  def delete(id: Int): Array[StoreItem] = {
    val itemToDelete: Option[StoreItem] = storedItems.find(s => s.id == id)    //type is option - could be found or not

    itemToDelete match {    //if found log delete, if not found throw error
      case Some(itemFound) => itemFound.logAction("gelöscht", itemFound.name)
      case None => println("Id " + id + " nicht gefunden")  //change to throw
    }

    storedItems = storedItems.filter(s => s.id != id)   //delete item from array
    storedItems
  }


  def search(name: String): Array[StoreItem] = {
    val searchList = storedItems.filter(s => s.name == name)  //Array of every item with fitting name

    if(searchList.isEmpty) println("name " + name + " nicht gefunden")  //change to throw

    for(searchItem <- searchList){    //log all found items
        searchItem.logAction("gefunden", name)
    }
    searchList
  }

  def store(item: StoreItem): Array[StoreItem] = {
    storedItems = storedItems :+ item
    item.logAction("gespeicher", item.name)
    storedItems
  }

  def sumUp(): Int = {
    val sum = storedItems.reduceLeft[Int]((sum, si) => sum + si.value)
    sum
  }

}
