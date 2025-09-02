package crud

import java.sql.Connection
import java.sql.DriverManager

class EntidadeJDBC(
    val usuario : String,
    val url : String,
    val senha : String
) {
    fun conectarComBanco () : Connection? {

        //Quando precisa fazer algo que possa falhar
        try {
            val coneccao : Connection =
                //cada banco tem o seu driver
                DriverManager.getConnection(
                    //quando a Classe instanciada os atributos abaixo terão valores
                    this.url, this.usuario, this.senha
                )
            println("Conectou!")
            return coneccao

        }catch (erro : Exception){
            println(erro.printStackTrace())
        }
        return null
    }
}