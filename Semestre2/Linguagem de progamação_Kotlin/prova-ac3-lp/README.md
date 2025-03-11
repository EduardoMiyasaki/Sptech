# 🏥 Desafio Kotlin: Gestão de Profissionais de Saúde e Seus Atendimentos com Interfaces de Especialização

## 🌟 Contexto

Você foi desafiado a criar um sistema de **gestão de profissionais de saúde**, incluindo médicos e enfermeiros. A ideia é modelar diferentes tipos de profissionais, cada um com suas responsabilidades e especializações. Além disso, vamos aplicar conceitos de **herança**, **interfaces** e **validações** para garantir que o sistema seja flexível e eficiente.

---

## 📜 Requisitos

### 1. Classe Abstrata `ProfissionalSaude`

**Atributos**:
- `nome: String - private set`  (Nome do profissional de saúde)
- `nivelExperiencia: Int - private set`  (Nível de experiência do profissional)

**Métodos Abstratos**:
- `realizarAtendimento(): String`  (Método que posteriormente será implementado para realizar um atendimento e retornar um texto descritivo)
- `detalhar(): String`  (Método que posteriormente será implementado implementado para retornar detalhes sobre o profissional de saúde)

**Método Concreto**:
- `verificarStatus(): String`  
  Retorna exatamente a frase:  
  `"Profissional [nome] tem nível de experiência [nivelExperiencia]."`

**Validações (métodos set)**:
- O `nome` deve ter pelo menos 3 caracteres.
- O `nivelExperiencia` deve ser um número positivo (maior que 0).

---

### 2. Interface `Especialista`

**Métodos da Interface**:
- `especialidade(): String`  (Método que retornará ao ser implementado a especialidade do profissional)
- `tratarPaciente(): String`  (Método que retornará ao ser implementado uma descrição do tratamento realizado pelo profissional)

---

### 3. Classe `Medico` (herda de `ProfissionalSaude` e implementa `Especialista`)

**Atributos Adicionais**:
- `crm: String - private set`  (Registro do CRM do médico)
- `areaEspecialidade: String - private set`  (Área de especialidade do médico)

**Validações (métodos set)**:
- O `crm` deve conter exatamente 6 caracteres alfanuméricos.
- O `areaEspecialidade` deve ter no mínimo 5 caracteres.

**Implementações dos Métodos Abstratos**:
- `realizarAtendimento(): String`  
  Retorna exatamente:  
  `"O médico [nome], especialista em [areaEspecialidade], CRM [crm], realizou um atendimento com sucesso."`
- `detalhar(): String`  
  Retorna exatamente:  
  `"Médico [nome] com CRM [crm], especialista em [areaEspecialidade], e nível de experiência [nivelExperiencia]."`

**Implementações da Interface `Especialista`**:
- `especialidade(): String`  
  Retorna exatamente:  
  `"Especialidade médica: [areaEspecialidade]."`
- `tratarPaciente(): String`  
  Retorna exatamente:  
  `"O médico [nome], especialista em [areaEspecialidade], tratou o paciente utilizando seus conhecimentos."`

---

### 4. Classe `Enfermeiro` (herda de `ProfissionalSaude` e implementa `Especialista`)

**Atributos Adicionais**:
- `registroEstagio: String - private set`  (Número de registro de estágio do enfermeiro)

**Validações (métodos set)**:
- O `registroEstagio` deve conter exatamente 8 caracteres alfanuméricos.

**Implementações dos Métodos Abstratos**:
- `realizarAtendimento(): String`  
  Retorna exatamente:  
  `"O enfermeiro [nome], registro de estágio [registroEstagio], realizou um atendimento básico com cuidado."`
- `detalhar(): String`  
  Retorna exatamente:  
  `"Enfermeiro [nome] com registro de estágio [registroEstagio] e nível de experiência [nivelExperiencia]."`

**Implementações da Interface `Especialista`**:
- `especialidade(): String`  
  Retorna exatamente:  
  `"Especialidade de enfermagem: Auxiliar."`
- `tratarPaciente(): String`  
  Retorna exatamente:  
  `"O enfermeiro [nome] realizou o tratamento do paciente com técnicas de enfermagem especializadas."`

---

### 5. Classe `Administrador` (herda de `ProfissionalSaude`)

**Atributos Adicionais**:
- `nivelSupervisao: Int - private set`  (Nível de supervisão do administrador)

**Validações (métodos set)**:
- O `nivelSupervisao` deve ser um número positivo (maior que 0).

**Implementações dos Métodos Abstratos**:
- `realizarAtendimento(): String`  
  Retorna exatamente:  
  `"O administrador [nome] supervisionou um atendimento no nível [nivelSupervisao]."`
- `detalhar(): String`  
  Retorna exatamente:  
  `"Administrador [nome] com nível de supervisão [nivelSupervisao] e nível de experiência [nivelExperiencia]."`

---

### 6. Validações e Considerações

- As classes `Medico`, `Enfermeiro` e `Administrador` devem implementar os métodos `realizarAtendimento()` e `detalhar()`.
- A interface `Especialista` deve ser implementada nas classes `Medico` e `Enfermeiro`.
- As validações de atributos, como `nome`, `crm`, `registroEstagio`, `nivelExperiencia` e `areaEspecialidade`, devem ser cuidadosamente implementadas.

---

## 🎉 Boa sorte, desenvolvedor(a)! Mostre sua habilidade em criar um sistema robusto de gestão de profissionais de saúde com Kotlin!
