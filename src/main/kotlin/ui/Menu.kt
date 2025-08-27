package ui

fun menu() {
    do {
        println("1 - Cadastrar Caixa D' Água")
        println("2 - Editar Caixa D' Água")
        println("3 - Listar Caixa D' Água")
        println("4 - Excluir Caixa D' Água")
        println("5 - Sair")

        val opcao = readln().toInt()

        when(opcao){
            1-> println("Cadastrando caixa...")
            2-> println("Editando caixa...")
            3-> println("Listar caixas...")
            4-> println("Excluindo caixa...")
            else -> println("Opção invalida!")
        }
    }while (opcao != 0)
}