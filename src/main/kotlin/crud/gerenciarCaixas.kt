package crud

import classes.CaixaDAgua
import enumeradores.Material
import java.sql.Connection

fun criarTabelaCaixa (){
    val conectar = EntidadeJDBC(
        url = "jdbc:postgresql://localhost:5433/postgres",
        usuario = "postgres",
        senha = "root"
    )

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
    /*
    val material : Material,
    val capacidade : Double,
    val altura : Double,
    val largura : Double,
    val profundidade : Double,
    val blablablabla : String,
     */
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

    CaixaDAgua(
        material = material,
        capacidade = litros,
        blablablabla = bla,
        altura = alt,
        profundida = prof,
        largura = larg
    )

}

fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}