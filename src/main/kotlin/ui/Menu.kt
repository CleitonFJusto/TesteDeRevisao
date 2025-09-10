package ui

import crud.cadastrarCaixa
import crud.editarCaixa
import crud.excluirCaixa
import crud.listarCaixas

fun menu() {
    do {
        println("1 - Cadastrar Caixa D' Água")
        println("2 - Editar Caixa D' Água")
        println("3 - Listar Caixa D' Água")
        println("4 - Excluir Caixa D' Água")
        println("5 - Sair")

        val opcao = readln().toInt()

        when(opcao){
            0-> println("Falo otario!")
            1-> cadastrarCaixa(0)//Sempre que for cadastrar uma caixa nova o ID será 0
            2-> editarCaixa()
            3-> listarCaixas()
            4-> excluirCaixa()
            else -> println("Opção invalida!")
        }
    }while (opcao != 0)
}