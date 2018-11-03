class User {
    var name = "Turbo"
    set(value){
        field = value.trim().capitalize()
    }
    var occupation = "Dog"
    var age = 3
    var hungry = true
    var ready = false

    fun makeFull(){
        this.hungry = false
    }

    fun setReady(){
        this.ready = true
    }
}