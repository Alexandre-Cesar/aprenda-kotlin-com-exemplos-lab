enum class Nivel(val duracao: Int) { BASICO(30), INTERMEDIARIO(60), DIFICIL(90) 

}

data class Usuario(val nome: String){
}

data class ConteudoEducacional(val nome: String, var duracao : Int){
    
    fun mudarDificuldade(nivel : Nivel, ){
        if(nivel.duracao > duracao){
            println("nivel de $nome foi aumentado")
            duracao = nivel.duracao 
        }
        if(nivel.duracao < duracao){
           println("nivel de $nome foi reduzido")
           duracao = nivel.duracao
        }else{
            println("o nivel de $nome continua o mesmo")
        }
       
    }


}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun inscricao(usuario: Usuario){
        inscritos.add(usuario)
    }

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscricao(usuario)
            println("Aluno ${usuario.nome} foi matriculado em $nome")
        } else {
            println("Aluno ${usuario.nome} já está matriculado em $nome")
        }
    }
    fun verMaterias(){
        println("\nas máterias de $nome:")
        conteudos.forEach{
           print("|${it.nome}")
        }
        print("|")
    }
    fun verUsuarios(){
        println("\nUsuários inscritos:")        
        inscritos.forEach{
           print("|${it.nome}")
            
        }
        print("|")
    }
    
}

fun main() {
    

    var josh = Usuario(nome = "Josh")
    var doly = Usuario(nome = "Doly")
    var ed = Usuario(nome = "ed")
    
    var materias = mutableListOf<ConteudoEducacional>()  
    val matematica = ConteudoEducacional("matematica", Nivel.BASICO.duracao)
    val ingles = ConteudoEducacional("ingles", Nivel.INTERMEDIARIO.duracao)
    val logica = ConteudoEducacional("logica", Nivel.DIFICIL.duracao)
    
    materias.add(matematica)
    materias.add(ingles)
    materias.add(logica)
    
    materias[1].mudarDificuldade(Nivel.DIFICIL)
    
    val prog = Formacao("programação", materias)
    prog.matricular(josh)
    prog.matricular(josh)
    prog.matricular(ed)
    prog.matricular(doly)
    prog.verMaterias()
    prog.verUsuarios()
    
}