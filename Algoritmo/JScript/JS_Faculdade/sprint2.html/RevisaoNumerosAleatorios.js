
var listaSorte = [];

var listaDado1 = [];
var listaDado2 = [];

var listaNumerosVencedores = [];

var saldo = 0;
var PartidasGanhas = 0;
var PartidasPerdidas = 0;


function Cadastrar() {
    var numero = input_numero.value;

    var indice = listaSorte.indexOf(numero);

    if (numero == '') {

        alert('Informe seu número da sorte');
    }
    else if (numero < 2 || numero > 12) {

        alert("O número da sorte deve ser inteiro e entre 2 e 12.")
    }
    else if (listaSorte.length == 3) {

        alert('Você já escolheu 3 números da sorte');
    }
    else if (indice != -1) {

        alert('Você já escolheu esse número como número da sorte');
    }
    else if (indice == -1 && listaSorte.length < 3) {

        listaSorte.push(numero);
    }

    console.log(listaSorte);
    input_numero.value = '';
}



function jogar() {

    var texto = "";

    valorAposta = Number(input_valor.value);
    var numero = Number(input_numero.value);

    var rodadas = Math.random();
    var rodadasFixa = rodadas.toFixed(1);
    rodadasFixa = rodadasFixa * 10 + 10;

    if (rodadasFixa >= 10) {
        alert("Número de rodadas que você ira jogar " + rodadasFixa);
    }
    else {
        alert("Número inválido aperte o botão novamente")
    }

    for (let index = 1; index <= rodadasFixa; index++) {

        var Dado1 = Math.random();
        var Dado1Fixo = Dado1.toFixed(1);
        Dado1Fixo = Dado1Fixo * 5 + 1;
        restoDado1 = Dado1Fixo % 1

        if (restoDado1 > 0) {
            Dado1Fixo = Number.parseInt(Dado1Fixo);
            listaDado1.push(Dado1Fixo);
        }

        var Dado2 = Math.random();
        var Dado2Fixo = Dado2.toFixed(1);
        Dado2Fixo = Dado2Fixo * 5 + 1;
        restoDado2 = Dado2Fixo % 1

        if (restoDado2 > 0) {
            Dado2Fixo = Number.parseInt(Dado2Fixo);
            listaDado2.push(Dado2Fixo);
        }

        var totalDado = Dado1Fixo + Dado2Fixo;

        listaNumerosVencedores.push(totalDado);

        if (totalDado == listaSorte[0]) {
            saldo = saldo + valorAposta * 5;
            PartidasGanhas++;
            
            div_mensagem.innerHTML += `<br><h3 style ="color:white">O valor do primeiro dado sorteado foi ${Dado1Fixo} o valor do segundo dado foi ${Dado2Fixo} e Você ganhou!</h3>`;
            
        }
        else if (totalDado == listaSorte[1]) {
            saldo = saldo + valorAposta * 5;
            PartidasGanhas++;
            
            div_mensagem.innerHTML += `<br><h3 style ="color:white">O valor do primeiro dado sorteado foi ${Dado1Fixo} o valor do segundo dado foi ${Dado2Fixo} e Você ganhou!</h3>`;

        }
        else if (totalDado == listaSorte[2]) {
            saldo = saldo + valorAposta * 5;
            PartidasGanhas++;
            
            div_mensagem.innerHTML += `<br><h3 style ="color:white">O valor do primeiro dado sorteado foi ${Dado1Fixo} o valor do segundo dado foi ${Dado2Fixo} e Você ganhou!</h3>`;

        } else if (totalDado != listaSorte) {
            saldo = saldo - valorAposta;
            PartidasPerdidas++;
            
            div_mensagem.innerHTML += `<br><h3 style ="color:white">O valor do primeiro dado sorteado foi ${Dado1Fixo} o valor do segundo dado foi ${Dado2Fixo} e Você PERDEU!</h3>`;
        }

    }
    if (saldo > 0) {

        texto += `<br><h1 style ="color:white">Parabéns vocêa conseguiu ganhar R$ ${saldo} <br> Número de rodadas vencidas ${PartidasGanhas}<br>Número de rodadas perdidas ${PartidasPerdidas} </h1>`;
    } else if (saldo == 0) {
        texto += `<br><h1 style ="color:white"> EMPATE Isso é incrível a probabilidade disso acontecer é bem baixa!!!!</h1>`;
    } else {
        texto += `<br><h1 style ="color:white">Pague o que me deve ${saldo}<br> Número de rodadas vencidas ${PartidasGanhas}<br>Número de rodadas perdidas ${PartidasPerdidas}</h1>`;
    }
    div_mensagem.innerHTML += texto;
}

function Pesquisar(){

    var de = input_deRodada.value;
    var ate = input_ateRodada.value;


    if (de == '' || ate == '') {

        alert('Informe o intervalo de partidas que deseja ver');

    } else if (de > ate || de <= 0) {

        alert('Informe um intervalo válido');
    } 
    else {
        // div_mensagem.innerHTML = "";

    for (let i = de - 1; i <= ate - 1 ; i++) {

        div_msg.innerHTML += `<br>Rodada: ${i + 1}<br>
        Dado 1 :${listaDado1[i]}<br>
        Dado 2 :${listaDado2[i]}<br>
        Soma dos dados: ${listaNumerosVencedores[i]}<br>`;
        
    }
}
}

function PesquisarDado(){
    
    var numeroPesquisa = Number(input_NumeroPesquisa.value);

    if (numeroPesquisa == '' || numeroPesquisa < 1 || numeroPesquisa > 6) {
        alert('Informe um valor válido para o dado');
   
    }
     else {
        div_msg.innerHTML = '';
        for (var ind = 0; ind < listaDado1.length; ind++) {

            if (listaDado1[ind] == numeroPesquisa || listaDado2[ind] == numeroPesquisa) {
                div_msg.innerHTML += `<br>Rodada ${ind + 1} <br>
                Primeiro dado: ${listaDado1[ind]}<br>
                Segundo dado: ${listaDado2[ind]}<br>
                Soma: ${listaNumerosVencedores[ind]}<br>
                <br>`;
            }
        }
    }

    if (div_msg.innerHTML == '') {
        alert('Esse número não foi sorteado em nenhuma rodada.');
    }

    input_pesquisa.value = '';
}
