class stack(var top:Int = -1,var bottom:Int = 0){
	var storage:Array<String>?=null
	init{
		println("The stack is just created.")
	}
	fun clear(){
		//print("\u001b[H\u001b[2J")
		ProcessBuilder("powershell", "-Command", "Clear-Host").inheritIO().start().waitFor()
	}
	fun create(size:Int){
		storage = Array(size){""}
	}
	fun createWrapper(){
		clear()
		var size:Int? = null
		while(size==null){
			println("input the element size you want : ")
			size = readln().toIntOrNull()
			// can implement a way to cancel after 3 fail
			// but then ill have to implement what happens if fails
			// now being lazy
		}
		if (size!=null){
			create(size)
		}
		
	}
	fun push(item:String):Int{
		val tmp:Array<String>? = storage
		if(tmp!=null && top==-1){
			tmp[0] = item
			top++
			return 0
		}else{
			if(tmp != null && top+1 <= tmp.size-1 ){
				tmp[top+1] = item
				top++
				return 0
			}else{
				return -1
			}
			return -1
		}
		
	}
	fun pushWrapper(){
		clear()
		println("input msg u wanna store : ")
		val msg = readln()
		val out = push(msg)
		if(out==-1){
			println("failed to push")
		}else{
			println("pushed [${msg}] --> pos ${top-1}")
		}
	}
	fun pop():Int{
		val tmp:Array<String>? = storage
		if(top==-1){
			return -1
		}else{
			if(tmp!=null) tmp[top]=""
			top--
			return 0
		}
	}
	fun popWrapper(){
		clear()
		val out = pop()	
		if(out==-1){
			println("failed to pop")
		}else{
			println("popped --> index ${top+1}")
		}
	}
	fun isEmpty(){
		clear()
		if(top==-1)println("the stack is empty")else println("the stack is not empty")
	}
	fun isFull(){
		clear()
		val tmp:Array<String>? = storage
		if(tmp!=null && top==tmp.size-1)println("the stack is full") else println("stack is not full")
	}
	fun display(){
		val copyStorage:Array<String>? = storage
		if (copyStorage == null){
			print("<stack is not created yet>")
		}else{
			if(top!=-1){
				print("[ ")
				for(i in 0..top){
					print(copyStorage[i])
					if (i < top){print(", ")}
				}
				print(" ]")
			}else{
				print("<the stack is empty>")
			}
		}
		println("")
	}

	fun menu(){
		var opt:String = ""
		while(true){
			display()
			println("-------------------")
			println("0. create")
			println("1. push")
			println("2. pop")
			println("3. isEmpty ?")
			println("4. isFull ?")
			println("x. exit")
			println("-------------------")
			print("Choice : ")
			opt = readln()

			when(opt){
				"0" -> createWrapper()
				"1" -> pushWrapper()
				"2" -> popWrapper()
				"3" -> isEmpty()
				"4" -> isFull()
				"x" -> break
				else -> println("wrong option !!\ntry valid option 0 to 4")
			}
		}
	}
	fun run(){
		menu()
	}
}

fun main(){
	var a = stack()
	a.run()
}