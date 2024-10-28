package pt1

enum class StatusEnum(var nomeCompleto: String) {
    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("Concluída")
}

// Enum serve para limitar as opções do usuário
// para que tenhamos um maior controle
// sobre o que ele pode fazer dentro da nossa aplicação
// Para evitar possíveis erros