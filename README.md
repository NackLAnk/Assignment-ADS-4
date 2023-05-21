# [![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=MyHashTable)](https://git.io/typing-svg)
* This is a simple implementation of a hash table data structure in Java. The hash table is implemented using separate chaining to handle collisions between elements that are hashed to the same bucket.
### Methods
`int size()`
Returns the number of elements in the hash table.

`boolean isEmpty()`
Returns true if the hash table is empty, false otherwise.

`V get(K key)`
Returns the value associated with the specified key in the hash table, or null if the key is not found.

`void put(K key, V value)`
Associates the specified value with the specified key in the hash table.

`boolean contains(K key)`
Returns true if the hash table contains the specified key, false otherwise.

`boolean containsValue(V value)`
Returns true if the hash table contains the specified value, false otherwise.

`K getKey(V value)`
Returns the key associated with the specified value in the hash table, or null if the value is not found.

`int getBucketSize(int index)`
Returns the number of elements in the bucket at the specified index.

`void clear()`
Removes all elements from the hash table.
### Usage
* The `MyHashTable` class can be used to store key-value pairs, where the key is of type K and the value is of type `V`. The `MyHashTable` constructor takes an optional initial capacity and load factor as parameters. If these parameters are not specified, the default values of 16 for the initial capacity and 0.75 for the load factor are used.

```java
MyHashTable<String, Integer> table = new MyHashTable<>();
table.put("John", 30);
table.put("Jane", 25);
table.put("Bob", 40);
```
The `put()` method adds a new key-value pair to the hash table. If a key that already exists in the hash table is passed to `put()`, the old value is replaced with the new value.

```java
int johnsAge = table.get("John"); // 30
```
The `get()` method retrieves the value associated with a given key. If the key is not found in the hash table, `get()` returns null.

```java
boolean containsJane = table.containsValue(25); // true
```
The `containsValue()` method returns a boolean value indicating whether the given value is present in the hash table.

```java
int numElementsInBucket = table.getBucketSize(0);
```
The `getBucketSize()` method returns the number of elements in the bucket with the given index.

```java
K johnsKey = table.getKey(30);
```
The `getKey()` method returns the key associated with the given value in the hash table.

```java
table.clear();
```
The `clear()` method removes all key-value pairs from the hash table.

# [![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=MyTestingClass)](https://git.io/typing-svg)
### Methods
`MyTestingClass(int id, String name)`
Constructor that creates a new instance of MyTestingClass with the specified id and name.

`int getId()`
Returns the id field of the object.

`String getName()`
Returns the name field of the object.

`void setId(int id)`
Sets the id field of the object to the specified value.

`void setName(String name)`
Sets the name field of the object to the specified value.

`int hashCode()`
Generates a hash code for the object. This method is used by hash table implementations to determine the bucket where the object should be stored.

### Usage
To use MyTestingClass, simply create a new instance of the class with the desired id and name values. You can then use the object in hash table implementations or other testing scenarios.

```java
MyTestingClass obj = new MyTestingClass(1, "Test Object");
int hashCode = obj.hashCode();
System.out.println("Hash code for object: " + hashCode);
```
This would output the following:
```java
Hash code for object: 123456789
```
