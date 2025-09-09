package crud

import classes.CaixaDAgua
import enumeradores.Material
import java.sql.Connection
import java.sql.ResultSet

val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5433/postgres",
    usuario = "postgres",
    senha = "root"
)

fun criarTabelaCaixa (){


    //Coloque o nome da tabela o mesmo nome da entidade
    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua" +
            " (id serial NOT NULL PRIMARY KEY," +
            " material varchar(255)," +
            " capacidade float," +
            " altura float," +
            " largura float," +
            " profundidade float," +
            " blablablabla varchar (255)" +
            ")"
    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)//Se retornar false ou 1, deu certo!!!!!!!!!!!!!!!!!!!!!!!!!

    banco.close()//Encera a conexão

}

fun cadastrarCaixa(){

    println("Escolha o material da Caixa D' Água")
    println("1 - Plástico")
    println("2 - PVC")
    val opcao = readln().toInt()
    var material : Material
    when(opcao){
        1-> material = Material.PLASTICO
        2-> material = Material.PVC
        else -> material = Material.PLASTICO
    }
    println("Capacidade da Caixa em Litros:")
    val litros = readln().toDouble()

    println("Altura da caixa:")
    val alt = readln().toDouble()

    println("Largura da caixa:")
    val larg = readln().toDouble()

    println("Profundidade da caixa")
    val prof = readln().toDouble()

    println("Blabalblabalbl")
    val bla = readln()


   val c = CaixaDAgua(
        material = material,
        capacidade = litros,
        blablablabla = bla,
        altura = alt,
        profundida = prof,
        largura = larg
    )
   val banco =  conectar.conectarComBanco()!!.prepareStatement(

        "INSERT INTO CaixaDAgua" +
            " (material, capacidade, altura, largura, profundidade, blablablabla)" +
        " VALUES (?, ?, ?, ?, ?, ?)"
    )
       banco.setString(1,c.material.name,)
       banco.setDouble(2,c.capacidade!!)//Atributos nulos devem ser seguidos com !!
       banco.setDouble(3,c.altura)
       banco.setDouble(4,c.largura)
       banco.setDouble(5,c.profundida)
       banco.setString(6,c.blablablabla)

       banco.executeUpdate()//Isso fara um COMMIT no banco (:

       banco.close()//Fecha a transação do banco oxes

}

fun editarCaixa(){

}

fun listarCaixas(){
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    val resultados : ResultSet = banco!!.createStatement().executeQuery(sql)
    while (resultados.next()){
        //Para cada consulta, use o nome que está no BANCO (pgadmin)
        println("------------------------------------")
        println("Id: ${resultados.getString("id")}")
        println("Material: ${resultados.getString("material")}")
        println("Capacidade: ${resultados.getString("capacidade")}")
        println("Altura: ${resultados.getString("altura")}")
        println("Largura: ${resultados.getString("largura")}")
        println("Profundidade: ${resultados.getString("profundidade")}")
        println("Blablablabla: ${resultados.getString("blablablabla")}")
    }

}

fun excluirCaixa(){
    println("Digite o ID que deseja excluir")
    val id = readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1,id)
    val retorno = resultados.executeQuery()
    while (retorno.next()){
        println("------------------------------------")
        println("Id: ${retorno.getString("id")}")
        println("Material: ${retorno.getString("material")}")
        println("Capacidade: ${retorno.getString("capacidade")}")
        println("Altura: ${retorno.getString("altura")}")
        println("Largura: ${retorno.getString("largura")}")
        println("Profundidade: ${retorno.getString("profundidade")}")
        println("Blablablabla: ${retorno.getString("blablablabla")}")
    }

    println("Tem certeza que deseja excluir esse registro????")
    val resposta = readln().lowercase()
    when(resposta){
        "sim"->{
            val deletar = banco.prepareStatement("DELETE FROM CaixaDAgua WHERE id = ?")
                deletar.setInt(1, id)//Diz qual é o valor do 1 valor
                deletar.executeUpdate()//Manda a instrução para ser executada
        }else -> {
            println("Não entendi, fodase")
        }
    }

}